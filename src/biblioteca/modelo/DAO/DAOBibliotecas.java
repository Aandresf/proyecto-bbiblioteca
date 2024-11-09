/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.modelo.DAO;

import biblioteca.modelo.MBibliotecas;
import biblioteca.modelo.MUtils.Database;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author arnal
 */
public class DAOBibliotecas {
    
    public List obtenerSedes(){
        String q = "SELECT * FROM BIBLIOTECAS;";
        List<Map> registros = new Database().ejecutar(q);
        List<MBibliotecas> bibliotecas = new ArrayList();

        for (Map registro : registros) {
            MBibliotecas sede = new MBibliotecas(
                (int)registro.get("id"),
                (String)registro.get("descripcion"),
                (String)registro.get("direccion")
                );
                
                bibliotecas.add(sede);
        }

        return bibliotecas;
    }
}
