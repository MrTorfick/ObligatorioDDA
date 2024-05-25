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

        listaParkings.add(new Parking(nombre, direccion, listaTarifas, listaCocheras));
    }

    public ArrayList<Parking> getListaParkings() {
        return listaParkings;
    }

    public ArrayList<Cochera> getCocheras() {
        ArrayList<Cochera> cocheras = new ArrayList();
        for (Parking parking : listaParkings) {
            cocheras.addAll(parking.getListaCocheras());
        }
        return cocheras;
    }
}
