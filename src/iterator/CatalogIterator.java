/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iterator;

import java.util.Iterator;
import java.util.List;
import model.Libro;

/**
 * Iterator concreto para recorrer la lista de Libros.
 */
public class CatalogIterator implements Iterator<Libro> {
    private final List<Libro> libros;
    private int index = 0;

    public CatalogIterator(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public boolean hasNext() {
        return index < libros.size();
    }

    @Override
    public Libro next() {
        return libros.get(index++);
    }
}

