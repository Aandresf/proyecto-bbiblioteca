/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.controlador;

import biblioteca.controlador.CUtils.Validaciones;
import biblioteca.modelo.DAO.DAOPrestamos;
import biblioteca.modelo.ModelViewsTables.MVistaLibros;
import biblioteca.modelo.ModelViewsTables.MVistaPrestamos;
import biblioteca.modelo.ModelViewsTables.MVistaUsuarios;
import biblioteca.vista.VPrestamos;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author arnal
 */
public class CPrestamos {

    public VPrestamos vista;
    public String sede;

    public CPrestamos() {
    }

    public CPrestamos(VPrestamos vista){

        this.vista = vista;
        this.sede = "";

        actions();
        mostrarPrestamos(vista.tblPrestamos);
    }

    public DefaultTableModel mostarVistaPrestamos() {

        List<MVistaPrestamos> prestamos = new DAOPrestamos().obtenerVistaPrestamos();

        DefaultTableModel modelo = new DefaultTableModel();
        String[] columnas = {"ID PRESTAMO", "FECHA ESTIMADA", "ID LIBRO", "CODIGO", "LIBRO", "CEDULA", "USUARIO", "BIBLIOTECA", "ESTADO"};
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

    public int recepcionarPrestamo(int id, String fechaDevolucion, int estado) {
        return new DAOPrestamos().actualizarPrestamo(id, fechaDevolucion, estado);
    }

    public int actualizarInventario(int id, int estado) {
        return new DAOPrestamos().actualizarInventario(id, estado);
    }

    public boolean registrarPrestamo(int inventario, int usuario) {
        return new DAOPrestamos().insertarPrestamo(inventario, usuario);
    }

    public int eliminarPrestamo(int id) {
        return new DAOPrestamos().eliminarPrestamo(id);
    }

    // Pasar este metodo a CLibros
    public MVistaLibros obtenerLibroCampo(String campo, String valor) {
        return new DAOPrestamos().obtenerInventarioCampo(campo, valor);
    }

    public void mostrarPrestamos(JTable tabla) {
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
        if (busqueda1.trim().length() > 0) {
            filtros.add(RowFilter.regexFilter("(?i)" + busqueda1));
        }

        // Agregamos el segundo filtro
        if (busqueda2.trim().length() > 0) {
            filtros.add(RowFilter.regexFilter("(?i)" + busqueda2));
        }

        // Agregamos el segundo filtro
        if (!sede.equals("TODAS")) {
            filtros.add(RowFilter.regexFilter("(?i)" + sede));
        }

        // Combinamos los filtros y los asignamos.
        RowFilter<Object, Object> filtroCompuesto = RowFilter.andFilter(filtros);
        filtro.setRowFilter(filtroCompuesto);
    }

    public void recepcionarPrestamo(JTable tabla) {

        // ESTADOS PRESTAMOS: 1 - EN CURSO 2 - FINALIZADO 3 - SANCIONADO
        int idPrestamo = -1; // Variable con el id del prestamo a recepcionar

        // ESTADOS INVENTARIO: 1 - DISPONIBLE 2 - NO DISPONIBLE 3 - MANTENIMINETO 4 - INACTIVO
        int idLibro = -1; // Variable con el id del libro a actualizar

        // Fecha actual
        LocalDate fechaDevolucion = LocalDate.now();
        LocalDate fechaEstimada;

        int estado = -1;

        // verificamos que haya un registro seleccionado
        if (tabla.getSelectedRow() != -1) {

            // obtenemos los Id y la fecha estimada del modelo de la tabla, los convertimos a String
            idPrestamo = Integer.parseInt(tabla.getModel().getValueAt(tabla.convertRowIndexToModel(tabla.getSelectedRow()), 0).toString());

            fechaEstimada = LocalDate.parse( // Obtenemos la fecha en String y se convierte a tipo localDate
                    tabla.getModel().getValueAt(tabla.convertRowIndexToModel(tabla.getSelectedRow()), 1).toString(),
                    DateTimeFormatter.ofPattern("yyyy-MM-dd")
            );

            idLibro = Integer.parseInt(tabla.getModel().getValueAt(tabla.convertRowIndexToModel(tabla.getSelectedRow()), 2).toString());

            // Asignamos el estado dependiendo si la fecha de entrega es menor o mayor a la estimada
            if (fechaDevolucion.isAfter(fechaEstimada)) {
                estado = 3;
            } else {
                estado = 2;
            }

        }

        if (idPrestamo >= 0 && idLibro >= 0) {
            JOptionPane.showMessageDialog(tabla,
                    "Prestamo: " + idPrestamo + " recepcionado \n"
                    + new CPrestamos().recepcionarPrestamo(idPrestamo, // se convierte la fecha de localDate a String
                            fechaDevolucion.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                            estado) + " registros afectados. \n "
                    + "Inventario: " + idLibro + " actualizado \n"
                    + new CPrestamos().actualizarInventario(idLibro, 1) + " registros afectados. \n");

        } else {
            JOptionPane.showMessageDialog(tabla, "Seleccione el Prestamo a Recepcionar.");
        }

    }

    public void crearPrestamo(JLabel inventario, JLabel usuario, JLabel info) {
        if (!inventario.getText().isBlank() && !usuario.getText().isBlank()) {
            new CPrestamos().registrarPrestamo(Integer.parseInt(inventario.getText()), Integer.parseInt(usuario.getText()));
            JOptionPane.showMessageDialog(inventario, "PRESTAMO CREADO");
        } else {
            info.setText("INGRESE UN USUARIO Y LIBRO VALIDO");
        }
    }

    public void eliminarPrestamo(JTable tabla) {

        int idPrestamo = -1; // Variable con el id del prestamo a recepcioeliminar
        String estadoPrestamo = ""; // Variable con el estado del prestamo a eliminar

        int idLibro = -1; // Variable con el id del libro a actualizar    

        // verificamos que haya un registro seleccionado
        if (tabla.getSelectedRow() != -1) {

            // obtenemos los Id y el estado del modelo de la tabla, los convertimos a String
            idPrestamo = Integer.parseInt(tabla.getModel().getValueAt(tabla.convertRowIndexToModel(tabla.getSelectedRow()), 0).toString());

            idLibro = Integer.parseInt(tabla.getModel().getValueAt(tabla.convertRowIndexToModel(tabla.getSelectedRow()), 2).toString());

            estadoPrestamo = tabla.getModel().getValueAt(tabla.convertRowIndexToModel(tabla.getSelectedRow()), 8).toString();

        }

        if (idPrestamo >= 0 && idLibro >= 0) {

            if (estadoPrestamo.equals("EN CURSO")) {
                // Actualizamos el estado del libro a disponible y sobreescribimos la variable para enviar el mensaje
                estadoPrestamo = "Inventario: " + idLibro + " restablecido \n"
                        + new CPrestamos().actualizarInventario(idLibro, 1) + " registros afectados. \n";
            } else {
                estadoPrestamo = "";
            }

            JOptionPane.showMessageDialog(tabla, "Prestamo: " + idPrestamo + " Eliminado \n"
                    + new CPrestamos().eliminarPrestamo(idPrestamo) + " registros afectados. \n " + estadoPrestamo);

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
    ) {

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
    ) {

        MVistaUsuarios user = new CUsuarios().obtenerUsuarioCampo("CEDULA", txt1.getText());

        if (!(user == null)) {

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
    ) {

        MVistaLibros lib = new CPrestamos().obtenerLibroCampo("CODIGO", txt1.getText());

        if (!(lib == null)) {

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

    public void btnUserClick() {
        limpiar(vista.txtUserCedula,
                vista.txtUserCedula, 
                vista.txtUserNombre, 
                vista.txtUserCategoria, 
                vista.txtUserCurso, 
                vista.txtUserEstado, 
                vista.lblUserEstado, 
                vista.lblUserId, 
                vista.lblUserInfo, 
                vista.lblInfoFormCreatePrestamo);

        buscarCedula(vista.txtUserSearch,
                vista.txtUserCedula,
                vista.txtUserNombre,
                vista.txtUserCategoria,
                vista.txtUserCurso,
                vista.txtUserEstado,
                vista.lblUserId,
                vista.lblUserEstado,
                vista.lblUserInfo,
                vista.lblInfoFormCreatePrestamo);
    }

    public void btnLibClick(){

         limpiar(vista.txtLibCodigo, 
         vista.txtLibCodigo, 
         vista.txtLibTitulo, 
         vista.txtLibAutor, 
         vista.txtLibCategoria, 
         vista.txtLibUbicacion, 
         vista.lblLibEstado, 
         vista.lblLibId, 
         vista.lblLibInfo, 
         vista.lblInfoFormCreatePrestamo);

        buscarLibro(vista.txtLibSearch,
         vista.txtLibCodigo,
         vista.txtLibTitulo,
         vista.txtLibAutor,
         vista.txtLibCategoria,
         vista.txtLibUbicacion,
         vista.lblLibId,
         vista.lblLibEstado,
         vista.lblLibInfo,
         vista.lblInfoFormCreatePrestamo);

    }

public void cleanFormPrestamoRegister(){
    limpiar(vista.txtLibSearch, 
                vista.txtLibCodigo, 
                vista.txtLibTitulo, 
                vista.txtLibAutor, 
                vista.txtLibCategoria, 
                vista.txtLibUbicacion, 
                vista.lblLibEstado, 
                vista.lblLibId, 
                vista.lblLibInfo, 
                vista.lblInfoFormCreatePrestamo);

                limpiar(vista.txtUserSearch,
                vista.txtUserCedula, 
                vista.txtUserNombre, 
                vista.txtUserCategoria, 
                vista.txtUserCurso, 
                vista.txtUserEstado, 
                vista.lblUserEstado, 
                vista.lblUserId, 
                vista.lblUserInfo, 
                vista.lblInfoFormCreatePrestamo);
}

    public void btnCancelCreatePrestamoClick(){
                vista.formCreatePrestamo.setVisible(false);
                vista.setEnabled(true);
                cleanFormPrestamoRegister();
    }

    public void createRegisterPrestamo(){
        crearPrestamo(vista.lblLibId, vista.lblUserId, vista.lblInfoFormCreatePrestamo);
        mostrarPrestamos(vista.tblPrestamos);
        cleanFormPrestamoRegister();
    }

    public void updatePrestamo(){
        recepcionarPrestamo(vista.tblPrestamos);
        mostrarPrestamos(vista.tblPrestamos);
    }

    public void deletePrestamo(){
        eliminarPrestamo(vista.tblPrestamos);
        mostrarPrestamos(vista.tblPrestamos);
    }

    public void filterStatePrestamo(){
        // new SistemaBibliotecas().cbxSedes.getSelectedItem().toString()
        if (vista.checkEstado.isSelected()){
            filtrarTabla(vista.tblPrestamos,"EN CURSO", vista.txtSearchPrestamo.getText(), sede);
        }else filtrarTabla(vista.tblPrestamos,vista.txtSearchPrestamo.getText(),"", sede);

    }



    public void actions() {

        vista.formCreatePrestamo.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                mostrarPrestamos(vista.tblPrestamos);
            }
        });

        vista.checkEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterStatePrestamo();
            }
        });

        vista.txtUserSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ((AbstractDocument) vista.txtUserSearch.getDocument()).setDocumentFilter(new Validaciones.filtroNumerico());
            }
        });

        vista.txtLibSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ((AbstractDocument) vista.txtLibSearch.getDocument()).setDocumentFilter(new Validaciones.filtroNumerico());
            }
        });

        vista.txtSearchPrestamo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ((AbstractDocument) vista.txtSearchPrestamo.getDocument()).setDocumentFilter(new Validaciones.filtroAlphaNumerico());
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {        
                filterStatePrestamo();
            }
        });

        
        vista.btnUserSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUserClick();
            }
        });

        vista.btnLibSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLibClick();
            }
        });

        vista.btnCancelCreatePrestamo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelCreatePrestamoClick();
            }
        });

        vista.btnCleanFormPrestamo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cleanFormPrestamoRegister();
            }
        });

        vista.btnCreatePrestamo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createRegisterPrestamo();
            }
        });

        vista.btnCrearPrestamo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vista.formCreatePrestamo.setLocationRelativeTo(vista);
                vista.formCreatePrestamo.setVisible(true);
            }
        });

        vista.btnRecepcionarPrestamo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatePrestamo();
            }
        });

        vista.btnEliminarPrestamo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deletePrestamo();
            }
        });

    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

}
