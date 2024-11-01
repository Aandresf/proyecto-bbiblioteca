/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.controlador;

import biblioteca.modelo.DAO.DAOUsuarios;
import biblioteca.modelo.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author arnal
 */
public class CUsuarios {

    public DefaultTableModel mostarUsuarios(){

        List<MUsuarios> usuarios = new DAOUsuarios().obtenerUsuarios();

        DefaultTableModel modelo = new DefaultTableModel();
        String[] columnas = {"ID","CATEGORIA","CEDULA", "NOMBRE", "APELLIDO", "TELEFONO", "CORREO", "CARRERA", "SEMESTRE", "ESTADO"};
        modelo.setColumnIdentifiers(columnas);

        for (MUsuarios user : usuarios) {
            String[] renglon = {String.valueOf(user.getId()),
                String.valueOf(user.getCategoria()),
                String.valueOf(user.getCedula()),
                user.getNombre(),
                user.getApellido(),
                user.getTelefono(),
                user.getCorreo(),
                String.valueOf(user.getCarrera()),
                String.valueOf(user.getSemestre()),
                String.valueOf(user.getEstado())};

                modelo.addRow(renglon);
        }        
        return modelo;
    }

    public MUsuarios obtenerUsuario(int id){
        return new DAOUsuarios().obtenerUsuario(id);
    }

    public MVistaUsuarios obtenerUsuarioCampo(String campo, String valor){
        return new DAOUsuarios().obtenerUsuarioCampo(campo, valor);
    }

    public DefaultTableModel mostarVistaUsuarios(){

        List<MVistaUsuarios> usuarios = new DAOUsuarios().obtenerVistaUsuarios();

        DefaultTableModel modelo = new DefaultTableModel();
        String[] columnas = {"ID", "CEDULA", "NOMBRE", "CATEGORIA", /*"ID CATEGORIA",*/ "CARRERA", "ULTIMO PRESTAMO"};
        modelo.setColumnIdentifiers(columnas);

        for (MVistaUsuarios user : usuarios) {
            String[] renglon = {
                String.valueOf(user.getId()),
                String.valueOf(user.getCedula()),
                user.getNombre(),
                user.getCategoria(),
                //String.valueOf(user.getIdCategoria()),
                user.getCarrera(),
                user.getUltimoPrestamo()
            };

                modelo.addRow(renglon);
        }

        return modelo;
    }

    public int crearUsuario(MUsuarios user){

        return new DAOUsuarios().insertarUsuarios(user.getCategoria(),
        user.getCedula(),
        user.getNombre(),
        user.getApellido(),
        user.getTelefono(),
        user.getCorreo(),
        user.getCarrera(),
        user.getSemestre(),
        user.getEstado());
    }

    public int modificarusuario(MUsuarios user){
        return new DAOUsuarios().actualizarUsuario(
            user.getId(),
            user.getCedula(),
            user.getNombre(),
            user.getApellido(),
            user.getTelefono(),
            user.getCorreo(),
            user.getCarrera(),
            user.getSemestre(),
            user.getEstado(),
            user.getCategoria());
    }

    public int elimiarUsuario(String idUsuario){
        return new DAOUsuarios().eliminar(Integer.parseInt(idUsuario));
    }

    
}
