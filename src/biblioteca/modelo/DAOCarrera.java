/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.modelo;

import java.util.*;

/**
 *
 * @author arnal
 */
public class DAOCarrera {

    public List obtenerCarreras(){

        String q = "SELECT * FROM CARRERAS;";
        List<Map> registros = new Database().ejecutar(q);
        List<MCarrera> carreras = new ArrayList();

        for (Map registro : registros) {
            MCarrera carrera = new MCarrera(
            (int)registro.get("id"),
            (String)registro.get("carrera"));

            carreras.add(carrera);
        }

        return carreras;
    };

    public List obtenerCategorias(){

        String q = "SELECT * FROM CATEGORIA_USUARIOS;";
        List<Map> registros = new Database().ejecutar(q);
        List<MCategoriaUsuarios> categorias = new ArrayList();

        for (Map registro : registros) {
            MCategoriaUsuarios categoria = new MCategoriaUsuarios(
            //(int)registro.get("id"),
            (String)registro.get("detalles"));

            categorias.add(categoria);
        }

        return categorias;
    };
    
}
