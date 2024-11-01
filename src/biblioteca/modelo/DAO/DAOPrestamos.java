/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.modelo.DAO;

import biblioteca.modelo.MUtils.Database;
import biblioteca.modelo.MVistaLibros;
import biblioteca.modelo.MVistaPrestamos;
import java.util.*;

/**
 *
 * @author arnal
 */
public class DAOPrestamos {

    // TO_DATE('', 'DD-MM-YYYY')

    /*
    public int insertarPrestamo(int libro, int usuario, String fechaPrestamo, String fechaEstimada, String fechaExtendida, String fechaDevolucion, int estado){
        String q = "INSERT INTO PRESTAMOS (LIBRO, USUARIO, FECHA_PRESTAMO, FECHA_ESTIMADA, FECHA_EXTENDIDA, FECHA_DEVOLUCION, ESTADO) VALUES ("
        + libro +","+ usuario +", "+
        "TO_DATE('"+ fechaPrestamo +"', 'DD-MM-YYYY'), " +
        "TO_DATE('"+ fechaEstimada +"', 'DD-MM-YYYY'), " + 
        "TO_DATE('"+ fechaExtendida +"', 'DD-MM-YYYY'), " + 
        "TO_DATE('"+ fechaDevolucion +"', 'DD-MM-YYYY')," + 
        estado +");";

        int i = new Database().actualizar(q);
        
        if(i>0){return i;}
        return 0;
    };
    */

    // Inserta un prestamo desde un procedimiento almacenado en la base de datos
    public boolean  insertarPrestamo(int idIventario, int idUsuario){
        String q = "CALL insertar_prestamo("+idIventario+","+idUsuario+");";

        return new Database().ejecutarProcedimiento(q);
    }

    public int actualizarPrestamo(int id, int libro, int usuario, String fechaPrestamo, String fechaEstimada, String fechaExtendida, String fechaDevolucion, int estado){
        String q = "UPDATE PRESTAMOS SET LIBRO = '"+ libro +"', "+
        "USUARIO = '"+ usuario + "'," +
        "FECHA_PRESTAMO = TO_DATE('"+ fechaPrestamo +"', 'DD-MM-YYYY'), " +
        "FECHA_ESTIMADA = TO_DATE('"+ fechaEstimada +"', 'DD-MM-YYYY'), " + 
        "FECHA_EXTENDIDA = TO_DATE('"+ fechaExtendida +"', 'DD-MM-YYYY'), " + 
        "FECHA_DEVOLUCION = TO_DATE('"+ fechaDevolucion +"', 'DD-MM-YYYY')," + 
        "ESTADO = "+ estado +" "+
        "WHERE ID = "+ id +";";

        return new Database().actualizar(q);
    };

    public int actualizarPrestamo(int id, String fechaDevolucion, int estado){
        String q = "UPDATE PRESTAMOS SET " +
        "FECHA_DEVOLUCION = TO_DATE('"+ fechaDevolucion +"', 'DD-MM-YYYY')," + 
        "ESTADO = "+ estado +" "+
        "WHERE ID = "+ id +";";

        return new Database().actualizar(q);
    };

    public List obtenerVistaPrestamos(){
        String q = "SELECT * FROM \"DETALLES PRESTAMOS\" ORDER BY \"ID PRESTAMO\" ASC;";
        List<Map> registros = new Database().ejecutar(q);
        List<MVistaPrestamos> prestamos = new ArrayList();

        for (Map registro : registros) {
            MVistaPrestamos prestamo = new MVistaPrestamos(
                (String)registro.get("CATEGORIA"),
                (String)registro.get("BIBLIOTECA"),
                (int)registro.get("CEDULA"),
                (String)registro.get("CODIGO"),
                (String)registro.get("ESTADO"),
                String.valueOf(registro.get(" FECHA ESTIMADA")),
                String.valueOf(registro.get("FECHA PRESTAMO")),
                (int)registro.get("ID BIBLIOTECA"),
                (int)registro.get("ID PRESTAMO"),
                (String)registro.get("LIBRO"),
                (String)registro.get("SECTOR"),
                (String)registro.get("USUARIO"),
                (int)registro.get("ID LIBRO"),
                String.valueOf(registro.get("FECHA DE ENTREGA"))
                );
                

            prestamos.add(prestamo);
        }

        return prestamos;
    }

    public int eliminarPrestamo(int id){
        String q = "DELETE FROM PRESTAMOS WHERE ID = "+ id +";";
        return new Database().actualizar(q);
    }

    // Pasar estos metodos a DAOLibros

    public int actualizarInventario(int id, int estado){
        String q = "UPDATE INVENTARIO SET " +
        "ESTADO = "+ estado +" "+
        "WHERE ID = "+ id +";";

        return new Database().actualizar(q);
    };

    public MVistaLibros obtenerInventarioCampo(String campo, String valorCampo){
        String q = "SELECT * FROM \"LIBROS DISPONIBLES\" WHERE \""+ campo +"\" = \'"+ valorCampo +"\';";

        List<Map> registros = new Database().ejecutar(q);
        MVistaLibros libros = null;

        for (Map registro : registros) {
            libros = new MVistaLibros(
                (int)registro.get("ID"),
                (String)registro.get("CODIGO"),
                (String)registro.get("TITULO"),
                (String)registro.get("AUTOR"),
                (String)registro.get("CATEGORIA"),
                (String)registro.get("BIBLIOTECA"),
                (String)registro.get("SECTOR"),
                (int)registro.get("ESTADO")
                );
        }

        return libros;
    }
    
}
