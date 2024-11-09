/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.controlador;

import biblioteca.controlador.CUtils.Validaciones;
import biblioteca.modelo.DAO.DAOBibliotecas;
import biblioteca.modelo.DAO.DAOSectores;
import biblioteca.modelo.MBibliotecas;
import biblioteca.modelo.ModelViewsTables.MVistaSectores;
import biblioteca.vista.VSedes;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JToggleButton;
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
public class CSedes {
    public VSedes vista;
    public String sede;
    
    public CSedes() {
    }

    public CSedes(VSedes vista) {
        this.vista = vista;
        this.sede = "";

        actions();
        vista.btnPnlSectores.setSelected(true);
        vista.btnPnlSedes.setSelected(false);
        vista.pnlSedes.setVisible(false);
        cargarTablaSectores();
        cargarTablaSedes();
    }

    // Metodos generales del menu Sedes

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

    public void disableFucntionSedes(){
        if(sede != "TODAS"){
            vista.btnPnlSectores.setSelected(false);
            vista.btnPnlSectores.setEnabled(false);
            vista.btnPnlSedes.setSelected(false);
            vista.btnPnlSedes.setEnabled(false);
            vista.btnPnlSedes.setVisible(false);
            vista.pnlSedes.setVisible(false);
        } else {
            vista.btnPnlSedes.setVisible(true);
            vista.btnPnlSedes.setEnabled(true);
            vista.btnPnlSectores.setEnabled(true);
            vista.btnPnlSectores.setSelected(true);
        }
    }

    public void btnSelectPanel(JToggleButton btn){
        
        if(btn.equals(vista.btnPnlSectores)){
            vista.btnPnlSectores.setSelected(true);
            vista.pnlSectores.setVisible(true);

            vista.btnPnlSedes.setSelected(false);
            vista.pnlSedes.setVisible(false);
        }

        if(btn.equals(vista.btnPnlSedes)){
            vista.btnPnlSedes.setSelected(true);
            vista.pnlSedes.setVisible(true);

            vista.pnlSectores.setVisible(false);
            vista.btnPnlSectores.setSelected(false);
        }
    }

    //Metodos del panel Sector

    public void cargarTablaSectores() {

        List<MVistaSectores> sectores = new DAOSectores().obtenerVistaSectores();

        DefaultTableModel modelo = new DefaultTableModel();
        String[] columnas = {"ID SECTOR", "NOMBRE", "BIBLIOTECAS", "LIBROS", "ESTADO"};
        modelo.setColumnIdentifiers(columnas);

        for (MVistaSectores sect : sectores) {
            String[] renglon = {
                String.valueOf(sect.getId()),
                sect.getNombre(),
                sect.getBiblioteca(),
                String.valueOf(sect.getLibros()),
                String.valueOf(sect.getEstado())
            };

            modelo.addRow(renglon);
        }

        // Asiganmos el modelo a la tabla
        vista.tblSectores.setModel(modelo);
        // obtenemos el modelo de las columnas de la tabla
        TableColumnModel modeloColumnas = vista.tblSectores.getColumnModel();
        // Ocultamos la primera y segunda columna de la vista, pero siguen en el modelo
        modeloColumnas.removeColumn(modeloColumnas.getColumn(0));
        modeloColumnas.removeColumn(modeloColumnas.getColumn(3));
    }

    public void filterStateSector(){
        // new SistemaBibliotecas().cbxSedes.getSelectedItem().toString()
        if (vista.checkEstado.isSelected()){
            filtrarTabla(vista.tblSectores,vista.txtSearchSector.getText(),"", sede);
        }else filtrarTabla(vista.tblSectores,"0", vista.txtSearchSector.getText(), sede);
    }



    //Metodos del panel Sedes

    public void cargarTablaSedes() {

        List<MBibliotecas> bibliotecas = new DAOBibliotecas().obtenerSedes();

        DefaultTableModel modelo = new DefaultTableModel();
        String[] columnas = {"ID SEDE", "NOMBRE", "DIRECCION"};
        modelo.setColumnIdentifiers(columnas);

        for (MBibliotecas sede : bibliotecas) {
            String[] renglon = {
                String.valueOf(sede.getId()),
                sede.getDescripcion(),
                sede.getDireccion()
            };

            modelo.addRow(renglon);
        }

        // Asiganmos el modelo a la tabla
        vista.tblSedes.setModel(modelo);
        // obtenemos el modelo de las columnas de la tabla
        TableColumnModel modeloColumnas = vista.tblSedes.getColumnModel();
        // Ocultamos la primera columna de la vista, pero siguen en el modelo
        modeloColumnas.removeColumn(modeloColumnas.getColumn(0));
    }

    public void filterTableSede(){
        filtrarTabla(vista.tblSedes,vista.txtFilterSede.getText(),"", sede);
    }

    //Metodo de asignacion de funciones
    private void actions(){
        // Funcionalidad de ventana emergente al formulario de crear Sector
        vista.btnFormCrearSector.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vista.formCreateSector.setLocationRelativeTo(vista);
                vista.formCreateSector.setVisible(true);
            }
        });
        vista.btnFormCrearSede.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vista.formCreateSede.setLocationRelativeTo(vista);
                vista.formCreateSede.setVisible(true);
            }
        });
        vista.btnModificarSede.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vista.formCreateSede.setLocationRelativeTo(vista);
                vista.formCreateSede.setVisible(true);
            }
        });

        vista.checkEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterStateSector();
            }
        });

        vista.txtSearchSector.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ((AbstractDocument) vista.txtSearchSector.getDocument()).setDocumentFilter(new Validaciones.filtroAlphaNumerico());
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterStateSector();
            }
        });

        vista.txtFilterSede.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ((AbstractDocument) vista.txtFilterSede.getDocument()).setDocumentFilter(new Validaciones.filtroAlphaNumerico());
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterTableSede();
            }
        });

        vista.btnPnlSectores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectPanel(vista.btnPnlSectores);
            }
        });
        vista.btnPnlSedes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectPanel(vista.btnPnlSedes);
            }
        });






    }
}
