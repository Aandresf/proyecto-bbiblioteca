/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.modelo.ModelViewsTables;


/**
 *
 * @author arnal
 */
public class MVistaSectores {

    private int id;
    private String nombre;
    private String biblioteca;
    private Long libros;
    private int estado;

    public MVistaSectores() {}

    public MVistaSectores(int id, String nombre, String biblioteca, Long libros, int estado) {
        this.id = id;
        this.nombre = nombre;
        this.biblioteca = biblioteca;
        this.libros = libros;
        this.estado = estado;
    }

    public MVistaSectores(String nombre, String biblioteca, Long libros, int estado) {
        this.nombre = nombre;
        this.biblioteca = biblioteca;
        this.libros = libros;
        this.estado = estado;
    }

    public MVistaSectores(int id, String nombre, String biblioteca, Long libros) {
        this.id = id;
        this.nombre = nombre;
        this.biblioteca = biblioteca;
        this.libros = libros;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(String biblioteca) {
        this.biblioteca = biblioteca;
    }

    public Long getLibros() {
        return libros;
    }

    public void setLibros(Long libros) {
        this.libros = libros;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    

    
    
}
