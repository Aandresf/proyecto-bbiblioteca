package biblioteca.modelo;

public class MUsuarios {

    private int id;

    private int categoria;
    private int cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private int carrera;
    private int semestre;
    private int estado;

    public MUsuarios() {
    }

    public MUsuarios(int categoria, int cedula, String nombre, String apellido, String telefono, String correo,
            int carrera, int semestre, int estado) {
        this.categoria = categoria;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.carrera = carrera;
        this.semestre = semestre;
        this.estado = estado;
    }

    public MUsuarios(int id, int categoria, int cedula, String nombre, String apellido, String telefono, String correo,
            int carrera, int semestre, int estado) {
        this.id = id;
        this.categoria = categoria;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.carrera = carrera;
        this.semestre = semestre;
        this.estado = estado;
    }
    
    public int getCarrera() {
        return carrera;
    }

    public void setCarrera(int carrera) {
        this.carrera = carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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
