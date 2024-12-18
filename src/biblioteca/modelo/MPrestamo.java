
package biblioteca.modelo;

import java.sql.Date;

public class MPrestamo {
    private int id;
    private int libro;
    private int usuario;
    private Date fechaPrestamo;
    private Date fechaEstimada;
    private Date fechaExtendida;
    private Date fechaDevolucion;
    private int estado;

    public MPrestamo() {
    }

    public MPrestamo(int id, int estado, Date fechaDevolucion, Date fechaEstimada, Date fechaExtendida, Date fechaPrestamo, int libro, int usuario) {
        this.id = id;
        this.estado = estado;
        this.fechaDevolucion = fechaDevolucion;
        this.fechaEstimada = fechaEstimada;
        this.fechaExtendida = fechaExtendida;
        this.fechaPrestamo = fechaPrestamo;
        this.libro = libro;
        this.usuario = usuario;
    }

    public MPrestamo(int estado, Date fechaDevolucion, Date fechaEstimada, Date fechaExtendida, Date fechaPrestamo, int libro, int usuario) {
        this.estado = estado;
        this.fechaDevolucion = fechaDevolucion;
        this.fechaEstimada = fechaEstimada;
        this.fechaExtendida = fechaExtendida;
        this.fechaPrestamo = fechaPrestamo;
        this.libro = libro;
        this.usuario = usuario;
    }

    public int getLibro() {
        return libro;
    }

    public void setLibro(int libro) {
        this.libro = libro;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaEstimada() {
        return fechaEstimada;
    }

    public void setFechaEstimada(Date fechaEstimada) {
        this.fechaEstimada = fechaEstimada;
    }

    public Date getFechaExtendida() {
        return fechaExtendida;
    }

    public void setFechaExtendida(Date fechaExtendida) {
        this.fechaExtendida = fechaExtendida;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
