/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.modelo;

/**
 *
 * @author arnal
 */
public class MCategoriaUsuarios {
    private String descripcion;
    private  int permisoExtendido;
    private int prestamoMultiple;

    public MCategoriaUsuarios() {
    }

    public MCategoriaUsuarios(String descripcion) {
        this.descripcion = descripcion;
    }

    public MCategoriaUsuarios(String descripcion, int permisoExtendido, int prestamoMultiple) {
        this.descripcion = descripcion;
        this.permisoExtendido = permisoExtendido;
        this.prestamoMultiple = prestamoMultiple;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPermisoExtendido() {
        return permisoExtendido;
    }

    public void setPermisoExtendido(int permisoExtendido) {
        this.permisoExtendido = permisoExtendido;
    }

    public int getPrestamoMultiple() {
        return prestamoMultiple;
    }

    public void setPrestamoMultiple(int prestamoMultiple) {
        this.prestamoMultiple = prestamoMultiple;
    }


}
