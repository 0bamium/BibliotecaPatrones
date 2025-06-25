/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

import model.Libro;
import observer.Observer;

/**
 *
 * @author josem
 */
public class NuevoLibroNotifier implements Observer {
    @Override
    public void update(Libro l) {
        System.out.println("¡Nuevo libro agregado: " + l.getTitulo() + "!");
    }
}
