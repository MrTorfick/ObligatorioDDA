/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;

/**
 * @author marcos
 */
public class SistemaParking {

    ArrayList<Parking> listaParkings = new ArrayList();


    public void agregarParking(String nombre, String direccion, ArrayList<Tarifa> listaTarifas, ArrayList<Cochera> listaCocheras) {

        // Parking parking = crearParking(nombre, direccion, listaTarifas, listaCocheras);
        // listaParkings.add(parking);
        listaParkings.add(new Parking(nombre, direccion, listaTarifas, listaCocheras));
    }

    public void agregarParking(Parking parking) {
        listaParkings.add(parking);
    }

/*
    private Parking crearParking(String nombre, String direccion, List<Tarifa> listaTarifas, List<Cochera> listaCocheras) {
        Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
        Objects.requireNonNull(direccion, "La dirección no puede ser nula");
        Objects.requireNonNull(listaTarifas, "La lista de tarifas no puede ser nula");
        Objects.requireNonNull(listaCocheras, "La lista de cocheras no puede ser nula");

        return new Parking(nombre, direccion, listaTarifas, listaCocheras);
    }
*/

    public ArrayList<Parking> getListaParkings() {
        return listaParkings;
    }

    public Parking getParking(String nombre) {
        for (Parking parking : listaParkings) {
            if (parking.getNombre().equals(nombre)) {
                return parking;
            }
        }
        return null;
    }

    public ArrayList<Cochera> getCocheras() {
        ArrayList<Cochera> cocheras = new ArrayList();
        for (Parking parking : listaParkings) {
            cocheras.addAll(parking.getListaCocheras());
        }
        return cocheras;
    }
    
    //ObtenerTotalEstadias
    
    public double obtenerTotalEstadias(){
        return 0;
    }
}
