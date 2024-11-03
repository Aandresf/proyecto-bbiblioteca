/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.vista.VUtils;

import biblioteca.controlador.*;
import biblioteca.modelo.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author arnal
 */
public class VFuncionesPrestamos {

    public void mostrarPrestamos(JTable tabla){
        // Asiganmos el modelo a la tabla
        tabla.setModel(new CPrestamos().mostarVistaPrestamos());
        // obtenemos el modelo de las columnas de la tabla
        TableColumnModel modeloColumnas = tabla.getColumnModel();
        // Ocultamos la primera, segunda y tercera columna de la vista, pero siguen en el modelo
        modeloColumnas.removeColumn(modeloColumnas.getColumn(0));
        modeloColumnas.removeColumn(modeloColumnas.getColumn(0));
        modeloColumnas.removeColumn(modeloColumnas.getColumn(0));
    }

    public void filtrarTabla(JTable tabla, String busqueda1, String busqueda2, String sede) {
        // Creamos el TableRowSorter y asiganamos a la tabla
        TableRowSorter<TableModel> filtro = new TableRowSorter<>(tabla.getModel());
        tabla.setRowSorter(filtro);

        // creamos una lista con los filtros
        List<RowFilter<Object, Object>> filtros = new ArrayList<>();

        // Agregamos el primer filtro
        if (busqueda1.trim().length() > 0) { filtros.add(RowFilter.regexFilter("(?i)" + busqueda1)); }

        // Agregamos el segundo filtro
        if (busqueda2.trim().length() > 0) { filtros.add(RowFilter.regexFilter("(?i)" + busqueda2)); }
        
        // Agregamos el segundo filtro
        if (!sede.equals("TODAS")) { filtros.add(RowFilter.regexFilter("(?i)" + sede)); }

        // Combinamos los filtros y los asignamos.
        RowFilter<Object, Object> filtroCompuesto = RowFilter.andFilter(filtros);
        filtro.setRowFilter(filtroCompuesto);
    }

    public void recepcionarPrestamo(JTable tabla){
        
    // ESTADOS PRESTAMOS: 1 - EN CURSO 2 - FINALIZADO 3 - SANCIONADO
    int idPrestamo = -1; // Variable con el id del prestamo a recepcionar

    // ESTADOS INVENTARIO: 1 - DISPONIBLE 2 - NO DISPONIBLE 3 - MANTENIMINETO 4 - INACTIVO
    int idLibro = -1; // Variable con el id del libro a actualizar

    // Fecha actual
    LocalDate fechaDevolucion = LocalDate.now();
    LocalDate fechaEstimada;

    int estado = -1;

    
    // verificamos que haya un registro seleccionado
    if (tabla.getSelectedRow() != -1){ 
         
         // obtenemos los Id y la fecha estimada del modelo de la tabla, los convertimos a String
         idPrestamo = Integer.parseInt(tabla.getModel().getValueAt(tabla.convertRowIndexToModel(tabla.getSelectedRow()), 0).toString());
         
         fechaEstimada = LocalDate.parse( // Obtenemos la fecha en String y se convierte a tipo localDate
         tabla.getModel().getValueAt(tabla.convertRowIndexToModel(tabla.getSelectedRow()), 1).toString(),
         DateTimeFormatter.ofPattern("yyyy-MM-dd")
         );
         
         idLibro = Integer.parseInt(tabla.getModel().getValueAt(tabla.convertRowIndexToModel(tabla.getSelectedRow()), 2).toString());
         
         // Asignamos el estado dependiendo si la fecha de entrega es menor o mayor a la estimada
         if (fechaDevolucion.isAfter(fechaEstimada)){estado = 3;} else {estado = 2;}
         
    }
    
    if (idPrestamo>=0 && idLibro>=0) {
        JOptionPane.showMessageDialog(tabla,
        
            "Prestamo: " + idPrestamo + " recepcionado \n"+
            new CPrestamos().recepcionarPrestamo(idPrestamo, // se convierte la fecha de localDate a String
                                                fechaDevolucion.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                                                estado) + " registros afectados. \n "+

            "Inventario: " + idLibro + " actualizado \n"+
            new CPrestamos().actualizarInventario(idLibro, 1) + " registros afectados. \n");

    } else {
        JOptionPane.showMessageDialog(tabla, "Seleccione el Prestamo a Recepcionar.");
    }
    
    }

    public void crearPrestamo(JLabel inventario, JLabel usuario, JLabel info){
        if (!inventario.getText().isBlank() && !usuario.getText().isBlank()){
            new CPrestamos().registrarPrestamo(Integer.parseInt(inventario.getText()), Integer.parseInt(usuario.getText()));
            JOptionPane.showMessageDialog(inventario, "PRESTAMO CREADO");
        } else { info.setText("INGRESE UN USUARIO Y LIBRO VALIDO"); }
    }

    public void eliminarPrestamo(JTable tabla){
        
        int idPrestamo = -1; // Variable con el id del prestamo a recepcioeliminar
        String estadoPrestamo = ""; // Variable con el estado del prestamo a eliminar
    
        int idLibro = -1; // Variable con el id del libro a actualizar    
        
        // verificamos que haya un registro seleccionado
        if (tabla.getSelectedRow() != -1){ 
             
             // obtenemos los Id y el estado del modelo de la tabla, los convertimos a String
             idPrestamo = Integer.parseInt(tabla.getModel().getValueAt(tabla.convertRowIndexToModel(tabla.getSelectedRow()), 0).toString());
             
             idLibro = Integer.parseInt(tabla.getModel().getValueAt(tabla.convertRowIndexToModel(tabla.getSelectedRow()), 2).toString());

             estadoPrestamo = tabla.getModel().getValueAt(tabla.convertRowIndexToModel(tabla.getSelectedRow()), 8).toString();
                          
        }

        if (idPrestamo>=0 && idLibro>=0) {

            if(estadoPrestamo.equals("EN CURSO")){
                // Actualizamos el estado del libro a disponible y sobreescribimos la variable para enviar el mensaje
                estadoPrestamo = "Inventario: " + idLibro + " restablecido \n" +
                     new CPrestamos().actualizarInventario(idLibro, 1) + " registros afectados. \n";
                    } else estadoPrestamo = "";
            
            JOptionPane.showMessageDialog(tabla, "Prestamo: " + idPrestamo + " Eliminado \n"+
                new CPrestamos().eliminarPrestamo(idPrestamo) + " registros afectados. \n " + estadoPrestamo);
    
        } else {
            JOptionPane.showMessageDialog(tabla, "Seleccione el Prestamo a Eliminar.");
        }
        
        }

    public void limpiar(JTextField txt1,
                        JTextField txt2,
                        JTextField txt3,
                        JTextField txt4,
                        JTextField txt5,
                        JTextField txt6,
                        JLabel lbl1,
                        JLabel lbl2,
                        JLabel lbl3,
                        JLabel lbl4
                        ){
        
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
        txt5.setText("");
        txt6.setText("");

        lbl1.setText("");
        lbl2.setText("");
        lbl3.setText("");
        lbl4.setText("");

    }

    // se ejecuta al presionar el boton de buscar en el formCrearPrestamo
        public void buscarCedula(JTextField txt1, // textbox con el usuario a buscar
        JTextField txt2,
        JTextField txt3,
        JTextField txt4,
        JTextField txt5,
        JTextField txt6,
        JLabel lbl1,
        JLabel lbl2,
        JLabel lbl3,
        JLabel lbl4
        ){

        MVistaUsuarios user = new CUsuarios().obtenerUsuarioCampo("CEDULA", txt1.getText());

            if (!(user == null)){

                txt1.setText("");
                txt2.setText(String.valueOf(user.getCedula()));
                txt3.setText(user.getNombre());
                txt4.setText(user.getCategoria());
                txt5.setText(user.getCarrera());
                txt6.setText(user.getUltimoPrestamo());
        
                lbl1.setText(String.valueOf(user.getId()));
                lbl2.setText("");
                lbl3.setText("");

            } else {
                lbl3.setText("* USUARIO NO ENCONTRADO");
                txt1.setText("");
            }
    }

    // se ejecuta al presionar el boton de buscar en el formCrearPrestamo

     public void buscarLibro(JTextField txt1, // textbox con el usuario a buscar
     JTextField txt2,
    JTextField txt3,
    JTextField txt4,
    JTextField txt5,
    JTextField txt6,
    JLabel lbl1,
    JLabel lbl2,
    JLabel lbl3,
    JLabel lbl4
    ){

    MVistaLibros lib = new CPrestamos().obtenerLibroCampo("CODIGO", txt1.getText());

        if (!(lib == null)){

            txt1.setText("");
            txt2.setText(lib.getCodigo());
            txt3.setText(lib.getTitulo());
            txt4.setText(lib.getAutor());
            txt5.setText(lib.getCategoria());
            txt6.setText(lib.getBiblioteca() + " - " + lib.getSector());
    
            lbl1.setText(String.valueOf(lib.getId()));
            lbl2.setText("");
            lbl3.setText("");
            
        } else {
            lbl3.setText("* LIBRO NO ENCONTRADO");
            txt1.setText("");
        }
    }
    
}
