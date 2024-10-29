/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.controlador;

import biblioteca.modelo.DAOPrestamos;
import biblioteca.modelo.MVistaPrestamos;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author arnal
 */
public class CPrestamos {
    
    public DefaultTableModel mostarVistaPrestamos(){

        List<MVistaPrestamos> prestamos = new DAOPrestamos().obtenerVistaPrestamos();

        DefaultTableModel modelo = new DefaultTableModel();
        String[] columnas = {"ID PRESTAMO","FECHA ESTIMADA", "ID LIBRO", "CODIGO", "LIBRO", "CEDULA", "USUARIO", "CATEGORIA", "ESTADO"};
        modelo.setColumnIdentifiers(columnas);

        for (MVistaPrestamos prest : prestamos) {
            String[] renglon = {
                String.valueOf(prest.getIdPrestamo()),
                String.valueOf(prest.getFechaEstimada()),
                String.valueOf(prest.getIdLibro()),
                prest.getCodigo(),
                prest.getLibro(),
                String.valueOf(prest.getCedula()),
                prest.getUsuario(),
                prest.getCategoria(),
                prest.getEstado()
            };

                modelo.addRow(renglon);
        }

        return modelo;
    }

    public int recepcionarPrestamo(int id, String fechaDevolucion, int estado){
        return new DAOPrestamos().actualizarPrestamo(id, fechaDevolucion, estado);
    }

    public int actualizarInventario(int id, int estado){
        return new DAOPrestamos().actualizarInventario(id, estado);
    }

    public int eliminarPrestamo(int id){
        return new DAOPrestamos().eliminarPrestamo(id);
    }


    
}
