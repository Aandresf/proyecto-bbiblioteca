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

    public void filterSede(){
        String sedeSeleccionada = vista.cbxSedes.getSelectedItem().toString();

        if(vista.prestamos.isShowing()){

            vista.controladorPrestamos.sede = sedeSeleccionada;
            vista.controladorPrestamos.filterStatePrestamo();

        }

    }

    private void btnExited(JPanel panel, JLabel btn, String ico, String icoSelected){
        System.out.println(panel.getClass() + " mostrado " + panel.isShowing());
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

    private void btnSelected(JPanel panel, JLabel btn, String ico){

        panel.setVisible(true);
        System.out.println("Panel " + panel.getClass() + " visible");

        btn.setBackground(new java.awt.Color(0, 32, 96));
        btn.setIcon(new javax.swing.ImageIcon(getClass().getResource(ico)));
        btn.setForeground(Color.WHITE);
    }

    private void btnDefault(JPanel panel, JLabel btn, String ico){
        panel.setVisible(false);
        System.out.println("Panel " + panel.getClass() + " oculto");

        btn.setBackground(new java.awt.Color(230,255,255));
        btn.setIcon(new javax.swing.ImageIcon(getClass().getResource(ico)));
        btn.setForeground(Color.BLACK);
    }

    private void btnHover(JLabel btn, String ico){
        btn.setBackground(new java.awt.Color(46, 144, 232));
        btn.setIcon(new javax.swing.ImageIcon(getClass().getResource(ico)));
        btn.setForeground(Color.WHITE);
    }





    private void actions(){

        vista.cbxSedes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterSede();
            }
        });

        vista.lblLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vista.lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconLogoHover.png")));
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vista.lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconLogo.png")));
            }
        });

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
                btnSelected(vista.dashboard, vista.btnMenuDashboard, "/img/ligth/iconDashboard.png");

                btnDefault(vista.prestamos, vista.btnMenuPrestamos, "/img/iconTime.png");
                btnDefault(vista.libros, vista.btnMenuLibros, "/img/iconBooks.png");
                btnDefault(vista.usuarios, vista.btnMenuUsuarios, "/img/iconUsers.png");
                btnDefault(vista.sedes, vista.btnMenuSedes, "/img/iconPlace.png");
                btnDefault(vista.reportes, vista.btnMenuReportes, "/img/iconAnalytics.png");
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
                btnSelected(vista.prestamos, vista.btnMenuPrestamos, "/img/ligth/iconTime.png");

                btnDefault(vista.dashboard, vista.btnMenuDashboard, "/img/iconDashboard.png");
                btnDefault(vista.libros, vista.btnMenuLibros, "/img/iconBooks.png");
                btnDefault(vista.usuarios, vista.btnMenuUsuarios, "/img/iconUsers.png");
                btnDefault(vista.sedes, vista.btnMenuSedes, "/img/iconPlace.png");
                btnDefault(vista.reportes, vista.btnMenuReportes, "/img/iconAnalytics.png");
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
                btnSelected(vista.libros, vista.btnMenuLibros, "/img/ligth/iconBooks.png");

                btnDefault(vista.prestamos, vista.btnMenuPrestamos, "/img/iconTime.png");
                btnDefault(vista.dashboard, vista.btnMenuDashboard, "/img/iconDashboard.png");
                btnDefault(vista.usuarios, vista.btnMenuUsuarios, "/img/iconUsers.png");
                btnDefault(vista.sedes, vista.btnMenuSedes, "/img/iconPlace.png");
                btnDefault(vista.reportes, vista.btnMenuReportes, "/img/iconAnalytics.png");
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
                btnSelected(vista.usuarios, vista.btnMenuUsuarios, "/img/ligth/iconUsers.png");

                btnDefault(vista.libros, vista.btnMenuLibros, "/img/iconBooks.png");
                btnDefault(vista.prestamos, vista.btnMenuPrestamos, "/img/iconTime.png");
                btnDefault(vista.dashboard, vista.btnMenuDashboard, "/img/iconDashboard.png");
                btnDefault(vista.sedes, vista.btnMenuSedes, "/img/iconPlace.png");
                btnDefault(vista.reportes, vista.btnMenuReportes, "/img/iconAnalytics.png");
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
                btnSelected(vista.sedes, vista.btnMenuSedes, "/img/ligth/iconPlace.png");

                btnDefault(vista.usuarios, vista.btnMenuUsuarios, "/img/iconUsers.png");
                btnDefault(vista.libros, vista.btnMenuLibros, "/img/iconBooks.png");
                btnDefault(vista.prestamos, vista.btnMenuPrestamos, "/img/iconTime.png");
                btnDefault(vista.dashboard, vista.btnMenuDashboard, "/img/iconDashboard.png");
                btnDefault(vista.reportes, vista.btnMenuReportes, "/img/iconAnalytics.png");
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
                btnSelected(vista.reportes, vista.btnMenuReportes, "/img/ligth/iconAnalytics.png");
                
                btnDefault(vista.sedes, vista.btnMenuSedes, "/img/iconPlace.png");
                btnDefault(vista.usuarios, vista.btnMenuUsuarios, "/img/iconUsers.png");
                btnDefault(vista.libros, vista.btnMenuLibros, "/img/iconBooks.png");
                btnDefault(vista.prestamos, vista.btnMenuPrestamos, "/img/iconTime.png");
                btnDefault(vista.dashboard, vista.btnMenuDashboard, "/img/iconDashboard.png");
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
