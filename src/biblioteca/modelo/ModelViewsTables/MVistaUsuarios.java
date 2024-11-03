package biblioteca.modelo.ModelViewsTables;

public class MVistaUsuarios {

    private int id;
    private int cedula;
    private String nombre;
    private String categoria;
    private int idCategoria;
    private String carrera;
    private String ultimoPrestamo;

    public MVistaUsuarios() {
    }

    public MVistaUsuarios(int id, int cedula, String nombre, String categoria, int idCategoria, String carrera,
            String ultimoPrestamo) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.categoria = categoria;
        this.idCategoria = idCategoria;
        this.carrera = carrera;
        this.ultimoPrestamo = ultimoPrestamo;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getUltimoPrestamo() {
        return ultimoPrestamo;
    }

    public void setUltimoPrestamo(String ultimoPrestamo) {
        this.ultimoPrestamo = ultimoPrestamo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
