/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adapter;

import model.Libro;
import adapter.LegacyPrinter;
import adapter.Printer;

/**
 * 
 * @author josem
 */
public class LegacyPrinterAdapter implements Printer {
    private LegacyPrinter legacy = new LegacyPrinter();

    @Override
    public void print(Libro l) {
        legacy.printLegacy(l);
    }
}
