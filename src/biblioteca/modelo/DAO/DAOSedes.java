/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.modelo.DAO;

import biblioteca.modelo.*;
import biblioteca.modelo.MUtils.Database;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author arnal
 */
public class DAOSedes {
    
        public List readSedes(){

        String consulta = "SELECT * FROM BIBLIOTECAS;";
        List<Map> registros = new Database().ejecutar(consulta);

        List<MBibliotecas> bibliotecas = new ArrayList();

        for (Map registro : registros) {
            MBibliotecas biblioteca = new MBibliotecas(
                (String)registro.get("descripcion"),
                (String)registro.get("direccion")
            );

            bibliotecas.add(biblioteca);
        }

        return bibliotecas;
    };
}
