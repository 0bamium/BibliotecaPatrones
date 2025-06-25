# BibliotecaPatrones

Un pequeño catálogo de libros en consola que demuestra la aplicación de cuatro patrones de diseño GoF y un iterador personalizado.

## Patrones implementados

- **Singleton** (`singleton.LibraryCatalog`): única instancia de catálogo de libros.  
- **Observer** (`observer.Subject`, `observer.Observer`, `observer.NuevoLibroNotifier`): notifica cuando se añade un libro.  
- **Adapter** (`adapter.Printer`, `adapter.LegacyPrinter`, `adapter.LegacyPrinterAdapter`): adapta un sistema de impresión legado a una interfaz moderna.  
- **Iterator** (`iterator.CatalogIterator`): recorre la colección de libros sin exponer su estructura interna.

## Estructura de paquetes

```
src/
├─ adapter/
│  ├─ LegacyPrinter.java
│  ├─ LegacyPrinterAdapter.java
│  └─ Printer.java
├─ app/
│  └─ MainBiblioteca.java
├─ iterator/
│  └─ CatalogIterator.java
├─ model/
│  └─ Libro.java
├─ observer/
│  ├─ NuevoLibroNotifier.java
│  ├─ Observer.java
│  └─ Subject.java
└─ singleton/
   └─ LibraryCatalog.java

```

## Requisitos

- JDK 8 o superior  
- NetBeans

## Compilar y ejecutar

1. **Importar** el proyecto en tu IDE como un proyecto Java normal.  
2. **Limpiar y compilar** (Clean & Build).  
3. **Ejecutar** la clase `app.MainBiblioteca`.  

4. En la consola, verás el siguiente menú:

   ```
   === MENU BIBLIOTECA PATRONES ===
   1. Agregar libro
   2. Listar libros
   3. Imprimir todos
   4. Modificar libro
   5. Eliminar libro
   6. Salir
   Elige una opcion:
   ```

## Uso

1. **Agregar libro**: ingresa título y autor; se notificará automáticamente.  
2. **Listar libros**: muestra todos los libros con `toString()`.  
3. **Imprimir todos**: utiliza el adaptador para llamar al método legado.  
4. **Modificar libro**: elige por número y actualiza título/autor.  
5. **Eliminar libro**: elige por número y borra del catálogo.  
6. **Salir**: termina la aplicación.

**Autor:** José Méndez
