/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.controlador;

import biblioteca.modelo.ModelViewsTables.MVistaUsuarios;
import biblioteca.controlador.CUtils.Validaciones;
import biblioteca.modelo.*;
import biblioteca.modelo.DAO.DAOUsuarios;
import biblioteca.vista.VUsuarios;

import java.util.*;
import javax.swing.JOptionPane;
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
public final class CUsuarios {

    public VUsuarios vista;

    public CUsuarios() {}

    public CUsuarios(VUsuarios vista) {

        this.vista = vista;
        mostarVistaUsuarios();

        actions();
    }


    
    private int ingresarSemestre() {
        
        int semestre = 0;
        
        if (!vista.txtSemestre.getText().isEmpty()) {
            semestre = Integer.parseInt(vista.txtSemestre.getText());
        }
        return semestre;
    }

    private void limpiar() {
        vista.txtCedula.setText("");
        vista.txtNombre.setText("");
        vista.txtApellido.setText("");
        vista.txtTelefono.setText("");
        vista.txtCorreo.setText("");
        vista.txtSemestre.setText("");
        
        vista.cbxCarrera.setSelectedIndex(0);
        vista.cbxCategoria.setSelectedIndex(0);
        
        vista.lblId.setText("");

    }

    private void cargarCarreras() {
        vista.cbxCarrera.setModel(new CCarreras().mostrarCarreras());
    }

    private void cargarCategorias() {
        vista.cbxCategoria.setModel(new CCarreras().mostrarCategorias());
    }

    private int crearUsuario() {
        return crearUsuario(
                new MUsuarios(
                        vista.cbxCategoria.getSelectedIndex() + 1,
                        Integer.parseInt(vista.txtCedula.getText()),
                        vista.txtNombre.getText().toUpperCase(),
                        vista.txtApellido.getText().toUpperCase(),
                        vista.txtTelefono.getText(),
                        vista.txtCorreo.getText().toUpperCase(),
                        vista.cbxCarrera.getSelectedIndex() + 1,
                        ingresarSemestre(),
                        1
                )
        );
    }

    private int modificarUsuario() {
        return updateUser(
                new MUsuarios(
                        Integer.parseInt(vista.lblId.getText()),
                        vista.cbxCategoria.getSelectedIndex() + 1,
                        Integer.parseInt(vista.txtCedula.getText()),
                        vista.txtNombre.getText().toUpperCase(),
                        vista.txtApellido.getText().toUpperCase(),
                        vista.txtTelefono.getText().isBlank() ? "" : vista.txtTelefono.getText(),
                        vista.txtCorreo.getText().toUpperCase(),
                        vista.cbxCarrera.getSelectedIndex() + 1,
                        ingresarSemestre(),
                        Integer.parseInt(vista.lblEstado.getText())
                        )
        );
    }

    private void cargarFormModificar() {

        int id = -1;

        if (vista.tblUsers.getSelectedRow() != -1) {
            id = Integer.parseInt(vista.tblUsers.getModel().getValueAt(vista.tblUsers.getSelectedRow(), 0).toString());
        }

        if (id >= 0) {
            limpiar();
            vista.frameFormUsuarios.setVisible(true);
            cargarCarreras();
            cargarCategorias();
            vista.lblTitle.setText("MODIFICAR USUARIO");
            vista.txtCedula.setEnabled(false);
            vista.lblControl.setText("2");

            MUsuarios user = obtenerUsuario(id);
            vista.lblId.setText(String.valueOf(user.getId()));
            vista.lblEstado.setText(String.valueOf(user.getEstado()));
            vista.txtCedula.setText(String.valueOf(user.getCedula()));
            vista.txtNombre.setText(user.getNombre());
            vista.txtApellido.setText(user.getApellido());
            vista.txtTelefono.setText(user.getTelefono());
            vista.txtCorreo.setText(user.getCorreo());
            vista.txtSemestre.setText(String.valueOf(user.getSemestre()));

            int cat = user.getCategoria() - 1;
            int car = user.getCarrera() - 1;
            vista.cbxCategoria.setSelectedIndex(cat);
            vista.cbxCarrera.setSelectedIndex(car);

        } else {
            JOptionPane.showMessageDialog(vista.pnlUsuarioMain, "Seleccione el Usuario a modificar.");
        }

    }

    private void cargarFormCrear() {
        limpiar();
        vista.frameFormUsuarios.setVisible(true);
        cargarCarreras();
        cargarCategorias();
        vista.lblTitle.setText("CREAR USUARIO");
        vista.txtCedula.setEnabled(true);
        vista.lblControl.setText("1");
    }

    private int crearCarrera() {
        return new CCarreras().crearCarrera(new MCarrera(vista.txtCurso.getText().toUpperCase()));
    }

    private void filtrarTabla() {

        // Crear el TableRowSorter y asignarlo al JTable
        TableRowSorter<TableModel> filtro = new TableRowSorter<>(vista.tblUsers.getModel());
        vista.tblUsers.setRowSorter(filtro);

        String buscar = vista.txfSearch.getText();
        if (buscar.trim().length() == 0) {
            filtro.setRowFilter(null);
        } else {
            filtro.setRowFilter(RowFilter.regexFilter("(?i)" + buscar));
        }
    }

    public void clickBtnAceptar() {
        int control = Integer.parseInt(vista.lblControl.getText());
        
        if (control == 1) {
            if (!vista.txtCedula.getText().isBlank() && !vista.txtNombre.getText().isBlank() && !vista.txtApellido.getText().isBlank()) {
                JOptionPane.showMessageDialog(vista.pnlFormUsuario, "Usuarios registrados: " + crearUsuario());
                mostarVistaUsuarios();
                limpiar();
                vista.frameFormUsuarios.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(vista.pnlFormUsuario, "Complete los campos Cedula, Nombre y Apellidos");
            }

        } else if (control == 2) {
            JOptionPane.showMessageDialog(vista.frameFormUsuarios, "usuario " + vista.lblId.getText() + " modificado");
            modificarUsuario();
            mostarVistaUsuarios();
            limpiar();
            vista.frameFormUsuarios.setVisible(false);
        }
    }

    public void showInputCategoria() {
        if (vista.cbxCategoria.getSelectedIndex() != 1) {
            vista.lblCurso.setVisible(false);
            vista.cbxCarrera.setVisible(false);
            vista.lblAddCurso.setVisible(false);

            vista.lblSemestre.setVisible(false);
            vista.txtSemestre.setVisible(false);

        } else {
            vista.lblCurso.setVisible(true);
            vista.cbxCarrera.setVisible(true);
            vista.lblAddCurso.setVisible(true);

            vista.lblSemestre.setVisible(true);
            vista.txtSemestre.setVisible(true);

        }
    }

    public MUsuarios obtenerUsuario(int id) {
        return new DAOUsuarios().obtenerUsuario(id);
    }
    
    public MVistaUsuarios obtenerUsuarioCampo(String campo, String valor) {
        return new DAOUsuarios().obtenerUsuarioCampo(campo, valor);
    }

    public void mostrarUsuarios() {

        List<MUsuarios> usuarios = new DAOUsuarios().obtenerUsuarios();

        DefaultTableModel modelo = new DefaultTableModel();
        String[] columnas = {"ID", "CATEGORIA", "CEDULA", "NOMBRE", "APELLIDO", "TELEFONO", "CORREO", "CARRERA", "SEMESTRE", "ESTADO"};
        modelo.setColumnIdentifiers(columnas);

        for (MUsuarios user : usuarios) {
            String[] renglon = {String.valueOf(user.getId()),
                String.valueOf(user.getCategoria()),
                String.valueOf(user.getCedula()),
                user.getNombre(),
                user.getApellido(),
                user.getTelefono(),
                user.getCorreo(),
                String.valueOf(user.getCarrera()),
                String.valueOf(user.getSemestre()),
                String.valueOf(user.getEstado())};

            modelo.addRow(renglon);
        }

        vista.tblUsers.setModel(modelo);
        TableColumnModel modeloColumnas = vista.tblUsers.getColumnModel();
        modeloColumnas.removeColumn(modeloColumnas.getColumn(0));

    }
    
    public void mostarVistaUsuarios() {

        List<MVistaUsuarios> usuarios = new DAOUsuarios().obtenerVistaUsuarios();

        DefaultTableModel modelo = new DefaultTableModel();
        String[] columnas = {"ID", "CEDULA", "NOMBRE", "CATEGORIA", /*"ID CATEGORIA",*/ "CARRERA", "ULTIMO PRESTAMO"};
        modelo.setColumnIdentifiers(columnas);

        for (MVistaUsuarios user : usuarios) {
            String[] renglon = {
                String.valueOf(user.getId()),
                String.valueOf(user.getCedula()),
                user.getNombre(),
                user.getCategoria(),
                //String.valueOf(user.getIdCategoria()),
                user.getCarrera(),
                user.getUltimoPrestamo()
            };

            modelo.addRow(renglon);
        }

        vista.tblUsers.setModel(modelo);
        TableColumnModel modeloColumnas = vista.tblUsers.getColumnModel();
        modeloColumnas.removeColumn(modeloColumnas.getColumn(0));
    }
    
    public int crearUsuario(MUsuarios user) {

        return new DAOUsuarios().insertarUsuarios(user.getCategoria(),
                user.getCedula(),
                user.getNombre(),
                user.getApellido(),
                user.getTelefono(),
                user.getCorreo(),
                user.getCarrera(),
                user.getSemestre(),
                user.getEstado());
            }

    public int updateUser(MUsuarios user) {
        return new DAOUsuarios().actualizarUsuario(
                user.getId(),
                user.getCedula(),
                user.getNombre(),
                user.getApellido(),
                user.getTelefono(),
                user.getCorreo(),
                user.getCarrera(),
                user.getSemestre(),
                user.getEstado(),
                user.getCategoria());
    }

    public int elimiarUsuario(String idUsuario) {
        return new DAOUsuarios().eliminar(Integer.parseInt(idUsuario));
    }

    private void deleteUser() {
    
        if (vista.tblUsers.getSelectedRow() != -1) {
            String usuario = vista.tblUsers.getModel().getValueAt(vista.tblUsers.getSelectedRow(), 0).toString();
            JOptionPane.showMessageDialog(vista.pnlUsuarioMain, elimiarUsuario(usuario) + "usuario eliminado");
        } else {
            JOptionPane.showMessageDialog(vista.pnlUsuarioMain, "Selecciones un usuario a eliminar");
        }
    }

    public void actions() {

        vista.cbxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showInputCategoria();
            }
        });
        
        vista.fromCreateCurso.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                mostarVistaUsuarios();
            }
        });

        vista.btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vista.frameFormUsuarios.setVisible(false);
                mostarVistaUsuarios();
                limpiar();
            }
        });

        vista.btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickBtnAceptar();
            }
        });

        vista.btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limpiar();
            }
        });

        vista.btnCrearUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cargarFormCrear();
            }
        });

        vista.btnEditarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cargarFormModificar();
            }
        });
        
        vista.btnEliminarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteUser();
                mostarVistaUsuarios();
            }
        });

        vista.btnAceptarCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int result = crearCarrera();
                if (result > 0) {
                    cargarCarreras();
                    vista.txtCurso.setText("");
                    vista.fromCreateCurso.setVisible(false);
                }
            }
        });

        vista.btnLimpiarCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vista.txtCurso.setText("");
            }
        });

        vista.btnEliminarCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vista.fromCreateCurso.setVisible(false);
            }
        });

        vista.lblAddCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vista.txtCurso.setText("");
                vista.fromCreateCurso.setVisible(true);
            }
        });

        vista.txtCurso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ((AbstractDocument) vista.txtCurso.getDocument()).setDocumentFilter(new Validaciones.filtroLetras());
            }
        });

        vista.txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ((AbstractDocument) vista.txtNombre.getDocument()).setDocumentFilter(new Validaciones.filtroLetras());
            }
        });

        vista.txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ((AbstractDocument) vista.txtApellido.getDocument()).setDocumentFilter(new Validaciones.filtroLetras());
            }
        });

        vista.txtSemestre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ((AbstractDocument) vista.txtSemestre.getDocument()).setDocumentFilter(new Validaciones.filtroNumerico());
            }
        });

        vista.txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ((AbstractDocument) vista.txtTelefono.getDocument()).setDocumentFilter(new Validaciones.filtroNumerico());
            }
        });

        vista.txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ((AbstractDocument) vista.txtCedula.getDocument()).setDocumentFilter(new Validaciones.filtroNumerico());
            }
        });

        vista.txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if (new Validaciones().validarCorreo(vista.txtCorreo.getText())) {
                    vista.lblInfoCorreo.setVisible(false);
                    vista.btnAceptar.setVisible(true);
                } else {
                    vista.lblInfoCorreo.setVisible(true);
                    vista.btnAceptar.setVisible(false);
                }
            }
        });

        vista.txfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ((AbstractDocument) vista.txfSearch.getDocument()).setDocumentFilter(new Validaciones.filtroAlphaNumerico());
                filtrarTabla();
            }
        });

    }

}
