/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author marcos
 */
public class Fachada {

    private SistemaParking sParking = new SistemaParking();
    private SistemaAnomalia sAnomalia = new SistemaAnomalia();

    private static Fachada instancia = new Fachada();

    public static Fachada getInstancia() {
        return instancia;
    }

    private Fachada() {

    }

    public void agregarAnomalia(Estadia e, Date fecha, Anomalia.codigoError error) {
        sAnomalia.agregarAnomalia(e, fecha, error);
    }

        
    
    public void agregarParking(String nombre, String direccion, ArrayList<Tarifa> listaTarifa, ArrayList<Cochera> listaCocheras) {
        sParking.agregarParking(nombre, direccion, listaTarifa, listaCocheras);
    }

    public void agregarParking(Parking parking) {
        sParking.agregarParking(parking);
    }

    public ArrayList<Parking> getListaParkings() {
        return sParking.getListaParkings();
    }

    public ArrayList<Cochera> getCocheras() {
        return sParking.getCocheras();
    }
}
