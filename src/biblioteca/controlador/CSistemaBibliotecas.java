/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.controlador;

import biblioteca.vista.*;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author arnal
 */
@SuppressWarnings("unchecked")
public class CSistemaBibliotecas {
    public SistemaBibliotecas vista = new SistemaBibliotecas();
    

    
    
    public CSistemaBibliotecas() {
        
        vista.cbxSedes.setModel(new CCarreras().getSedes());

        actions();
        btnSelected(vista.dashboard, vista.btnMenuDashboard, "/img/ligth/iconDashboard.png");
    }

    // accion realizada si cambio la sede seleccionada.
    public void filterSede(){
        String sedeSeleccionada = vista.cbxSedes.getSelectedItem().toString();
        int indiceSeleccionado = vista.cbxSedes.getSelectedIndex();

        // si el panel de prestamo es visible, asigna la sede a los filtros de tabla.
        if(vista.prestamos.isShowing()){

            vista.controladorPrestamos.sede = sedeSeleccionada;
            vista.controladorPrestamos.filterStatePrestamo();

        }

        if(vista.libros.isShowing()){

        }

        if(vista.sedes.isShowing()){
            vista.controladorSedes.sede = sedeSeleccionada;
            vista.controladorSedes.filterStateSector();

            vista.controladorSedes.disableFucntionSedes();
        }

    }

    // establece el estilo correspondiente al boton despues de retirar el mouse
    private void btnExited(JPanel panel, JLabel btn, String ico, String icoSelected){
        //System.out.println(panel.getClass() + " mostrado " + panel.isShowing());
        if(panel.isShowing()){
            btn.setBackground(new java.awt.Color(0, 32, 96));
            btn.setIcon(new javax.swing.ImageIcon(getClass().getResource(icoSelected)));
            btn.setForeground(Color.WHITE);
        }else{
            btn.setBackground(new java.awt.Color(230,255,255));
            btn.setIcon(new javax.swing.ImageIcon(getClass().getResource(ico)));
            btn.setForeground(Color.BLACK);
        }
    }

    // hace visible el panel y asigna un estilo al boton
    private void btnSelected(JPanel panel, JLabel btn, String ico){

        //System.out.println("Panel " + panel.getClass() + " visible");
        panel.setVisible(true);

        btn.setBackground(new java.awt.Color(0, 32, 96));
        btn.setIcon(new javax.swing.ImageIcon(getClass().getResource(ico)));
        btn.setForeground(Color.WHITE);
    }

    // oculta el panel y restablece el estilo del boton
    private void btnDefault(JPanel panel, JLabel btn, String ico){
        //System.out.println("Panel " + panel.getClass() + " oculto");
        panel.setVisible(false);

        btn.setBackground(new java.awt.Color(230,255,255));
        btn.setIcon(new javax.swing.ImageIcon(getClass().getResource(ico)));
        btn.setForeground(Color.BLACK);
    }
    
    // estilos para el menu cuando el mouse esta sobre el
    private void btnHover(JLabel btn, String ico){
        btn.setBackground(new java.awt.Color(46, 144, 232));
        btn.setIcon(new javax.swing.ImageIcon(getClass().getResource(ico)));
        btn.setForeground(Color.WHITE);
    }

    // Asigna el estilo y realiza la accion correspondiente a cada btn seleccionado.
    private void actionBtnsMenu(JLabel btnSelected){
        
        // oculto el combobox de seleccion de sede si selecciona el modulo reportes o el de usuario
        if(vista.btnMenuUsuarios.equals(btnSelected) || vista.btnMenuReportes.equals(btnSelected)){
            vista.lblSede.setVisible(false); vista.cbxSedes.setVisible(false);
        } else { // Muestra el combobox de seleccion de sede si selecciona otro modulo
            vista.lblSede.setVisible(true); vista.cbxSedes.setVisible(true);
        }


        if(vista.btnMenuDashboard.equals(btnSelected)){
            btnSelected(vista.dashboard, vista.btnMenuDashboard, "/img/ligth/iconDashboard.png");
        } else {
            btnDefault(vista.dashboard, vista.btnMenuDashboard, "/img/iconDashboard.png");
        }
        
        if(vista.btnMenuPrestamos.equals(btnSelected)){
            btnSelected(vista.prestamos, vista.btnMenuPrestamos, "/img/ligth/iconTime.png");
        } else{
            btnDefault(vista.prestamos, vista.btnMenuPrestamos, "/img/iconTime.png");
        }
        
        if(vista.btnMenuLibros.equals(btnSelected)){
            btnSelected(vista.libros, vista.btnMenuLibros, "/img/ligth/iconBooks.png");
        } else{
            btnDefault(vista.libros, vista.btnMenuLibros, "/img/iconBooks.png");
        }

        if(vista.btnMenuUsuarios.equals(btnSelected)){
            btnSelected(vista.usuarios, vista.btnMenuUsuarios, "/img/ligth/iconUsers.png");
        } else{
            btnDefault(vista.usuarios, vista.btnMenuUsuarios, "/img/iconUsers.png");
        }
        
        if(vista.btnMenuSedes.equals(btnSelected)){
            btnSelected(vista.sedes, vista.btnMenuSedes, "/img/ligth/iconPlace.png");
        } else{
            btnDefault(vista.sedes, vista.btnMenuSedes, "/img/iconPlace.png");
        }
        
        if(vista.btnMenuReportes.equals(btnSelected)){
            btnSelected(vista.reportes, vista.btnMenuReportes, "/img/ligth/iconAnalytics.png");
        } else{
            btnDefault(vista.reportes, vista.btnMenuReportes, "/img/iconAnalytics.png");
        }
        
        // ejecutamos la accion correspondiente a la sede seleccionada para ese panel
        filterSede();

    }




    //Agrega todas las funcionalidades a la interfaz
    private void actions(){

        // funcionalidad para el combobox de sedes
        vista.cbxSedes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterSede();
            }
        });

        // funcionalidad del logo
        vista.lblLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vista.lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconLogoHover.png")));
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vista.lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconLogo.png")));
            }
        });

        // asignaciones de funcionalidad de los botones del menu ⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️
        vista.btnMenuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.exit(0);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vista.btnMenuSalir.setBackground(new java.awt.Color(217, 39, 46));
                vista.btnMenuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ligth/iconExit.png")));
                vista.btnMenuSalir.setForeground(Color.WHITE);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vista.btnMenuSalir.setBackground(new java.awt.Color(230,255,255));
                vista.btnMenuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconExit.png")));
                vista.btnMenuSalir.setForeground(Color.BLACK);
            }
        });

        vista.btnMenuDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actionBtnsMenu(vista.btnMenuDashboard);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHover(vista.btnMenuDashboard, "/img/ligth/iconDashboard.png");
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExited(vista.dashboard, vista.btnMenuDashboard, "/img/iconDashboard.png", "/img/ligth/iconDashboard.png");
            }
        });

        vista.btnMenuPrestamos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actionBtnsMenu(vista.btnMenuPrestamos);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHover(vista.btnMenuPrestamos, "/img/ligth/iconTime.png");
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExited(vista.prestamos, vista.btnMenuPrestamos, "/img/iconTime.png", "/img/ligth/iconTime.png");
            }
        });

        vista.btnMenuLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actionBtnsMenu(vista.btnMenuLibros);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHover(vista.btnMenuLibros, "/img/ligth/iconBooks.png");
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExited(vista.libros, vista.btnMenuLibros, "/img/iconBooks.png", "/img/ligth/iconBooks.png");
            }
        });

        vista.btnMenuUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actionBtnsMenu(vista.btnMenuUsuarios);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHover(vista.btnMenuUsuarios, "/img/ligth/iconUsers.png");
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExited(vista.usuarios, vista.btnMenuUsuarios, "/img/iconUsers.png", "/img/ligth/iconUsers.png");
            }
        });

        vista.btnMenuSedes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actionBtnsMenu(vista.btnMenuSedes);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHover(vista.btnMenuSedes, "/img/ligth/iconPlace.png");
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExited(vista.sedes, vista.btnMenuSedes, "/img/iconPlace.png", "/img/ligth/iconPlace.png");
            }
        });

        vista.btnMenuReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actionBtnsMenu(vista.btnMenuReportes);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHover(vista.btnMenuReportes, "/img/ligth/iconAnalytics.png");
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExited(vista.reportes, vista.btnMenuReportes, "/img/iconAnalytics.png", "/img/ligth/iconAnalytics.png");
            }
        });

    }

    
    
}
