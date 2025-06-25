package app;

import model.Libro;
import singleton.LibraryCatalog;
import observer.NuevoLibroNotifier;
import adapter.Printer;
import adapter.LegacyPrinterAdapter;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MainBiblioteca {

    public static void main(String[] args) {
        new MainBiblioteca().start();
    }

    private final LibraryCatalog catalog;
    private final Printer printer;
    private final Scanner sc;

    public MainBiblioteca() {
        catalog = LibraryCatalog.getInstance();
        catalog.addObserver(new NuevoLibroNotifier());
        printer = new LegacyPrinterAdapter();
        sc = new Scanner(System.in);
    }

    public void start() {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            ejecutarOpcion(opcion);
        } while (opcion != 6);
        sc.close();
    }

    private void mostrarMenu() {
        System.out.println("\n=== MENU BIBLIOTECA PATRONES ===");
        System.out.println("1. Agregar libro");
        System.out.println("2. Listar libros");
        System.out.println("3. Imprimir todos");
        System.out.println("4. Modificar libro");
        System.out.println("5. Eliminar libro");
        System.out.println("6. Salir");
        System.out.print("Elige una opcion: ");
    }

    private int leerOpcion() {
        int op = sc.nextInt();
        sc.nextLine();
        return op;
    }

    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1: agregarLibro();      break;
            case 2: listarLibros();      break;
            case 3: imprimirLibros();    break;
            case 4: modificarLibro();    break;
            case 5: eliminarLibro();     break;
            case 6: System.out.println("Adios!"); break;
            default: System.out.println("Opcion invalida");
        }
    }

    private void agregarLibro() {
        System.out.print("Titulo: ");
        String t = sc.nextLine();
        System.out.print("Autor: ");
        String a = sc.nextLine();
        catalog.addLibro(new Libro(t, a));
    }

    private void listarLibros() {
        System.out.println("Libros en catalogo:");
        Iterator<Libro> it = catalog.getIterator();
        while (it.hasNext()) {
            System.out.println(" - " + it.next());
        }
    }

    private void imprimirLibros() {
        System.out.println("Imprimiendo con Adapter:");
        Iterator<Libro> it = catalog.getIterator();
        while (it.hasNext()) {
            printer.print(it.next());
        }
    }

    private void modificarLibro() {
        List<Libro> lista = catalog.getLibros();
        if (lista.isEmpty()) {
            System.out.println("No hay libros para modificar.");
            return;
        }
        System.out.println("Selecciona el libro a modificar:");
        int cuenta = 1;
        for (Libro libro : lista) {
            System.out.println(cuenta++ + ". " + libro);
        }
        System.out.print("Numero: ");
        int idx = sc.nextInt();
        sc.nextLine();
        if (idx < 1 || idx > lista.size()) {
            System.out.println("Opcion invalida.");
            return;
        }
        Libro sel = lista.get(idx - 1);
        System.out.println("Libro actual: " + sel);
        System.out.print("Nuevo titulo (enter = dejar igual): ");
        String nt = sc.nextLine();
        System.out.print("Nuevo autor (enter = dejar igual): ");
        String na = sc.nextLine();
        if (!nt.isBlank()) sel.setTitulo(nt);
        if (!na.isBlank()) sel.setAutor(na);
        System.out.println("Libro modificado: " + sel);
    }

    private void eliminarLibro() {
        List<Libro> lista = catalog.getLibros();
        if (lista.isEmpty()) {
            System.out.println("No hay libros para eliminar.");
            return;
        }
        System.out.println("Selecciona el libro a eliminar:");
        int cuenta = 1;
        for (Libro libro : lista) {
            System.out.println(cuenta++ + ". " + libro);
        }
        System.out.print("Numero: ");
        int idx = sc.nextInt();
        sc.nextLine();
        if (idx < 1 || idx > lista.size()) {
            System.out.println("Opcion invalida.");
            return;
        }
        Libro eliminado = lista.get(idx - 1);
        if (catalog.removeLibro(eliminado)) {
            System.out.println("Libro eliminado: " + eliminado.getTitulo());
        } else {
            System.out.println("Error al eliminar.");
        }
    }
}
