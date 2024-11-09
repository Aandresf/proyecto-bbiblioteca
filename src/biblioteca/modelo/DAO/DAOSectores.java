/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.modelo.DAO;

import biblioteca.modelo.MUtils.Database;
import biblioteca.modelo.ModelViewsTables.MVistaSectores;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author arnal
 */
public class DAOSectores {

    public List obtenerVistaSectores(){
        String q = "SELECT * FROM \"DETALLES SECTORES\";";
        List<Map> registros = new Database().ejecutar(q);
        List<MVistaSectores> sectores = new ArrayList();

        for (Map registro : registros) {
            MVistaSectores sector = new MVistaSectores(
                (int)registro.get("ID SECTOR"),
                (String)registro.get("NOMBRE"),
                (String)registro.get("BIBLIOTECA"),
                (Long)registro.get("LIBROS")
                );
                
                sectores.add(sector);
        }

        return sectores;
    }
    
}
