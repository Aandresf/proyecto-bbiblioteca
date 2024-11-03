/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.controlador;

import biblioteca.modelo.*;
import biblioteca.modelo.DAO.DAOCarrera;
import biblioteca.modelo.DAO.DAOSedes;
import java.util.*;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author arnal
 */
public class CCarreras {

        public DefaultComboBoxModel mostrarCarreras(){

        List<MCarrera> carreras = new DAOCarrera().obtenerCarreras();

        DefaultComboBoxModel modelo = new DefaultComboBoxModel();

        for (MCarrera carr : carreras) {
            modelo.addElement(carr.getCarrera());
        }        
        return modelo;
    }

    public DefaultComboBoxModel mostrarCategorias(){

        List<MCategoriaUsuarios> cartegoris = new DAOCarrera().obtenerCategorias();

        DefaultComboBoxModel modelo = new DefaultComboBoxModel();

        for (MCategoriaUsuarios cat : cartegoris) {
            modelo.addElement(cat.getDescripcion());
        }        
        return modelo;
    }

    public int crearCarrera(MCarrera carr){
        return new DAOCarrera().insertarCarrera(carr.getCarrera());
    }

    public DefaultComboBoxModel getSedes(){

        List<MBibliotecas> bibliotecas = new DAOSedes().readSedes();

        DefaultComboBoxModel modelo = new DefaultComboBoxModel();

        modelo.addElement("TODAS");
        for (MBibliotecas biblio : bibliotecas) {
            modelo.addElement(biblio.getDescripcion().toUpperCase());
        }

        return modelo;
    }

    
}
