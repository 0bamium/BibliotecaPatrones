/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import model.Libro;
import iterator.CatalogIterator;
import observer.Observer;
import observer.Subject;

/**
 *
 * @author josem
 */
public class LibraryCatalog implements Subject {
    private static LibraryCatalog instancia;
    private final List<Libro> libros = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();

    // Constructor privado para el Singleton
    private LibraryCatalog() {}

    public static synchronized LibraryCatalog getInstance() {
        if (instancia == null) {
            instancia = new LibraryCatalog();
        }
        return instancia;
    }

    public void addLibro(Libro l) {
        libros.add(l);
        notifyObservers(l);
    }

    public Iterator<Libro> getIterator() {
        return new CatalogIterator(libros);
    }

    public boolean removeLibro(Libro l) {
        return libros.remove(l);
    }

    public List<Libro> getLibros() {
        return new ArrayList<>(libros);
    }

    // Métodos de Subject

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(Libro l) {
        for (Observer o : observers) {
            o.update(l);
        }
    }
}
