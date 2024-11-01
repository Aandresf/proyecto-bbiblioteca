/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package biblioteca.controlador;

import biblioteca.vista.SistemaBibliotecas;

/**
 *
 * @author arnal
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
                /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SistemaBibliotecas().setVisible(true);
        });
    }
    
}
