
package biblioteca.modelo;

import java.util.*;

public class DAOUsuarios {

    public int insertarUsuarios(int categoria, int cedula, String nombre, String apellido, String telefono, String correo, int carrera, int semestre, int estado){
        String q = "INSERT INTO USUARIOS (CATEGORIA, CEDULA, NOMBRE, APELLIDO, TELEFONO, CORREO, CARRERA, SEMESTRE, ESTADO) VALUES ("
        + categoria +","+ cedula +",'"+ nombre +"','"+ apellido +"','"+ telefono +"','"+ correo +"',"+ carrera +","+ semestre +","+ estado +");";

        int i = new Database().actualizar(q);
        
        if(i>0){return i;}
        return 0;
    };

    public int actualizarUsuario(int id, int cedula, String nombre, String apellido, String telefono, String correo, int carrera, int semestre, int estado, int categoria){
        String q = "UPDATE USUARIOS SET NOMBRE = '"+ nombre
        +"', APELLIDO = '"+ apellido
        +"', CEDULA = "+ cedula
        +", TELEFONO = '"+ telefono 
        +"', CORREO = '"+ correo 
        +"', CARRERA = "+ carrera
        +", CATEGORIA = "+ categoria
        +", SEMESTRE = "+ semestre
        +", ESTADO = "+ estado 
        +" WHERE ID = "+ id +";";

        return new Database().actualizar(q);
    };

    public MUsuarios obtenerUsuario(int id){
        String q = "SELECT * FROM USUARIOS WHERE ID = "+ id +";";

        List<Map> registros = new Database().ejecutar(q);
        MUsuarios usuarios = null;

        for (Map registro : registros) {
            usuarios = new MUsuarios((int)registro.get("id"),
            (int)registro.get("categoria"),
            (int)registro.get("cedula"),
            (String)registro.get("nombre"),
            (String)registro.get("apellido"),
            (String)registro.get("telefono"),
            (String)registro.get("correo"),
            (int)registro.get("carrera"),
            (int)registro.get("semestre"),
            (int)registro.get("estado"));
        }

        return usuarios;
    }

    public List obtenerUsuarios(){
        String q = "SELECT * FROM USUARIOS;";
        List<Map> registros = new Database().ejecutar(q);
        List<MUsuarios> usuarios = new ArrayList();

        for (Map registro : registros) {
            MUsuarios usuario = new MUsuarios((int)registro.get("id"),
            (int)registro.get("categoria"),
            (int)registro.get("cedula"),
            (String)registro.get("nombre"),
            (String)registro.get("apellido"),
            (String)registro.get("telefono"),
            (String)registro.get("correo"),
            (int)registro.get("carrera"),
            (int)registro.get("semestre"),
            (int)registro.get("estado"));

            usuarios.add(usuario);
        }

        return usuarios;
    }

    public List obtenerVistaUsuarios(){
        String q = "SELECT * FROM \"DETALLES USUARIOS\";";
        List<Map> registros = new Database().ejecutar(q);
        List<MVistaUsuarios> usuarios = new ArrayList();

        for (Map registro : registros) {
            MVistaUsuarios usuario = new MVistaUsuarios(
            (int)registro.get("ID USUARIO"),
            (int)registro.get("CEDULA"),
            (String)registro.get("NOMBRE"),
            (String)registro.get("CATEGORIA"),
            (int)registro.get("ID CATEGORIA"),
            (String)registro.get("CARRERA"),
            (!registro.get("ULTIMO PRESTAMO").equals(0)) ? (String)registro.get("ULTIMO PRESTAMO") : "SIN PRESTAMO");

            usuarios.add(usuario);
        }

        return usuarios;
    }
    
    public MVistaUsuarios obtenerUsuarioCampo(String campo, String valorCampo){
        String q = "SELECT * FROM \"DETALLES USUARIOS\" WHERE \""+ campo +"\" = "+ valorCampo +";";

        List<Map> registros = new Database().ejecutar(q);
        MVistaUsuarios usuarios = null;

        for (Map registro : registros) {
            usuarios = new MVistaUsuarios(
                (int)registro.get("ID USUARIO"),
                (int)registro.get("CEDULA"),
                (String)registro.get("NOMBRE"),
                (String)registro.get("CATEGORIA"),
                (int)registro.get("ID CATEGORIA"),
                (String)registro.get("CARRERA"),
                (registro.get("ULTIMO PRESTAMO").equals(0)) ? "SIN PRESTAMO" : (String)registro.get("ULTIMO PRESTAMO")
                );
        }

        return usuarios;
    }

    public int eliminar(int id){
        String q = "DELETE FROM USUARIOS WHERE ID = "+ id +";";
        return new Database().actualizar(q);
    }
}
