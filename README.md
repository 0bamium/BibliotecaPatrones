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
- Entorno que soporte compilación de línea de comandos (Terminal, PowerShell…)
-  Apache Netbeans

## Compilar y ejecutar

1. Abre una terminal en la carpeta `BibliotecaPatrones` (donde está `src`).
2. Crea el directorio de salida para las clases compiladas:

   ```bash
   mkdir -p out
   ```

3. Compila todos los archivos `.java`:

   ```bash
   javac -d out      src/app/*.java      src/adapter/*.java      src/iterator/*.java      src/model/*.java      src/observer/*.java      src/singleton/*.java
   ```

4. Ejecuta la aplicación:

   ```bash
   java -cp out app.MainBiblioteca
   ```

## Importar en NetBeans (en caso que no te funcione la primera opcion)

1. Abre NetBeans.  
2. Ve a **File > Open Project…**.  
3. Navega hasta la carpeta raíz `BibliotecaPatrones` (la que contiene la carpeta `src`).  
4. Selecciónala y haz clic en **Open Project**.  
   - Si no detecta automáticamente un proyecto Ant, elige **Java with Ant > Java Project with Existing Sources**.  
   - En “Project Name” pon `BibliotecaPatrones`.  
   - En “Sources Folder” señala `…/BibliotecaPatrones/src`.  
5. Haz **Clean & Build** (botón derecho sobre el proyecto).  
6. Ejecuta la clase `app.MainBiblioteca` (Click derecho > **Run**).

Con esto se podrá clonar/copiar la carpeta y abrirla en su propio NetBeans sin más configuración.```

## Uso

1. **Agregar libro**: ingresa título y autor; se notificará automáticamente.
2. **Listar libros**: muestra todos los libros con `toString()`.
3. **Imprimir todos**: utiliza el adaptador para llamar al método legado.
4. **Modificar libro**: elige por número y actualiza título/autor.
5. **Eliminar libro**: elige por número y borra del catálogo.
6. **Salir**: termina la aplicación.

**Autor:** José Méndez
