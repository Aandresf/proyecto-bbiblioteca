/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.modelo;

/**
 *
 * @author arnal
 */
public class MBibliotecas {
    private String descripcion;
    private String direccion;

    public MBibliotecas() {
    }

    public MBibliotecas(String descripcion, String direccion) {
        this.descripcion = descripcion;
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


}
