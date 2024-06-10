/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import observador.Observable;

/**
 * @author marcos
 */
public class SistemaParking {

    ArrayList<Parking> listaParkings = new ArrayList();

    public void agregarParking(String nombre, String direccion, ArrayList<Tarifa> listaTarifas, ArrayList<Cochera> listaCocheras) {

        Parking p = new Parking(nombre, direccion, listaTarifas, listaCocheras);
        listaParkings.add(new Parking(nombre, direccion, listaTarifas, listaCocheras));
    }

    public void agregarParking(Parking parking) {
        listaParkings.add(parking);
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

    public double obtenerTotalEstadias() {
        double total = 0;
        for (Parking p : listaParkings) {
            total += p.totalEstadias();
        }
        return total;
    }

    public double obtenerTotalFacturado() {
        double total = 0;

        for (Parking p : listaParkings) {
            total += p.totalFacturado();
        }
        return total;
    }

    public Parking obtenerParking(String nombre) throws ParkingException {
        for (Parking p : listaParkings) {

            if (p.getNombre().equals(nombre)) {
                return p;
            }
        }
        throw new ParkingException("No se encontro un parking que coincida coincida con el parking seleccionado");
    }

    public double promedioTarifaParkingsPorTipoVehiculo(String tipoVehiculo) {
        double promedio = 0;

        for (Parking p : listaParkings) {
            promedio += p.promedioTarifaTipoVehiculo(tipoVehiculo);
        }

        return promedio / listaParkings.size();

    }

}
