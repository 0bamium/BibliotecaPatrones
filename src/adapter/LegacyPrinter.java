/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adapter;

import model.Libro;

/**
 * 
 * @author josem
 */
public class LegacyPrinter {
    public void printLegacy(Libro l) {
        System.out.println("[LEGACY] Imprimiendo: " + l.toString());
    }
}