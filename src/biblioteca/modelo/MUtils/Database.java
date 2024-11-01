/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.modelo.MUtils;

import java.sql.*;
import java.util.*;


/**
 *
 * @author arnal
 */
public class Database {
    
    private final String DRIVER = "org.postgresql.Driver";
    private final String URL = "jdbc:postgresql://localhost:5432/BDBIBLIOTECAS";
    private final String USER = "postgres";
    private final String PASSWORD = "1234";

    private Connection conexion;

    public Database(){
        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public int actualizar(String consulta){
        try {
            Statement st = conexion.createStatement();
            return st.executeUpdate(consulta);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  0;
    }

    public List ejecutar(String consulta){
        ResultSet rs = null;
        List resultado = new ArrayList();
        try {
            Statement st = conexion.createStatement();
            rs = st.executeQuery(consulta);
            resultado = acomodarDatos(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    private List acomodarDatos(ResultSet rs){
        List renglones = new ArrayList();
        try {
            int cantColumn = rs.getMetaData().getColumnCount();
            while(rs.next()){
                Map<String,Object> renglon = new HashMap();

                for (int i = 1; i <= cantColumn; i++) {
                    String nombreCampo = rs.getMetaData().getColumnName(i);
                    Object valor = rs.getObject(nombreCampo);
                    renglon.put(nombreCampo, valor==null?0:valor);
                }
                renglones.add(renglon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return renglones;
    }

    // Recibe el nombre del procedimiento en una cadena con el nombre y parametros
    public boolean  ejecutarProcedimiento(String q){
        try {
            CallableStatement cs = conexion.prepareCall(q);
            return cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void cerrarConexion(){
        try {
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
