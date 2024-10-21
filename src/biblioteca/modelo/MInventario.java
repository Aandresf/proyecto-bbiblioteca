
package biblioteca.modelo;

public class MInventario {
    private int libro;
    private int biblioteca;
    private String ubicacion;
    private  int existencia;
    private int estado;

    public MInventario() {
    }

    public MInventario(int biblioteca, int estado, int existencia, int libro, String ubicacion) {
        this.biblioteca = biblioteca;
        this.estado = estado;
        this.existencia = existencia;
        this.libro = libro;
        this.ubicacion = ubicacion;
    }

    public int getLibro() {
        return libro;
    }

    public void setLibro(int libro) {
        this.libro = libro;
    }

    public int getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(int biblioteca) {
        this.biblioteca = biblioteca;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    
}
