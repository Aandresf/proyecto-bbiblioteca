
package biblioteca.modelo;

public class MLibros {
    private String titulo;
    private int autor;
    private int categoria;
    private int estado;

    public MLibros() {
    }

    public MLibros(int autor, int categoria, int estado, String titulo) {
        this.autor = autor;
        this.categoria = categoria;
        this.estado = estado;
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAutor() {
        return autor;
    }

    public void setAutor(int autor) {
        this.autor = autor;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }


}
