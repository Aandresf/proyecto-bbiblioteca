/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.modelo.ModelViewsTables;

// import java.sql.Date;

/**
 *
 * @author arnal
 */
public class MVistaPrestamos {

    private int idPrestamo;
    private int idBiblioteca;
    private int idLibro;
    private String biblioteca;
    private String sector;
    private String libro;
    private  String codigo;
    private int cedula;
    private String usuario;
    private String categoria;
    private String fechaPrestamo;
    private String fechaEstimada;
    private String fechaDevolucion;
    private String estado;

    public MVistaPrestamos() {
    }

    public MVistaPrestamos(String biblioteca,
                            String categoria,
                            int cedula,
                            String codigo,
                            String estado,
                            String fechaEstimada,
                            String fechaPrestamo,
                            int idBiblioteca,
                            int idPrestamo,
                            String libro,
                            String sector,
                            String usuario,
                            int idLibro,
                            String fechaDevolucion) {
        this.biblioteca = biblioteca;
        this.categoria = categoria;
        this.cedula = cedula;
        this.codigo = codigo;
        this.estado = estado;
        this.fechaEstimada = fechaEstimada;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.idBiblioteca = idBiblioteca;
        this.idPrestamo = idPrestamo;
        this.libro = libro;
        this.sector = sector;
        this.idLibro = idLibro;
        this.usuario = usuario;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public int getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(int idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    public String getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(String biblioteca) {
        this.biblioteca = biblioteca;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaEstimada() {
        return fechaEstimada;
    }

    public void setFechaEstimada(String fechaEstimada) {
        this.fechaEstimada = fechaEstimada;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }



    
}
