/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.modelo;

/**
 *
 * @author arnal
 */
public class MCarrera {

    private String carrera;
    private  int id;

    public MCarrera() {
    }

    public MCarrera(String carrera ) {
        this.carrera = carrera;
    }

    public MCarrera(int id, String carrera ) {
        this.carrera = carrera;
        this.id = id;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
