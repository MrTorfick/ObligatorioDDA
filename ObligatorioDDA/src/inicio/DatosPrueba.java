/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inicio;

import java.util.ArrayList;
import java.util.Random;

import logica.*;
import logica.ParkingException;
import simuladortransito.Estacionable;
import simuladortransito.Transitable;

/**
 * @author marcos
 */
public class DatosPrueba {

    static Fachada fachada = Fachada.getInstancia();

  
    public static ArrayList<Transitable> getVehiculos(int totalCocheras) {
        ArrayList<Transitable> lista = new ArrayList<>();
        Random random = new Random();

        int totalVehiculos = totalCocheras * 2;

        for (int i = 0; i < totalVehiculos; i++) {
            String nombre = "V" + (i + 1);
            String tipo = getTipoVehiculo(i);
            TipoVehiculo tipoVehiculo = new TipoVehiculo(tipo);
            int saldo = random.nextInt(111) - 10; 
            String cedula = String.format("%011d", i + 1); 
            String propietario = "Propietario " + (i + 1);
            ArrayList<Vehiculo> vehiculos = new ArrayList<>(); 
            Propietario propietarioObj = new Propietario(cedula, propietario, vehiculos, saldo);
            ArrayList<TipoEtiqueta> listaEtiquetas = getEtiquetasVehiculo(i, totalVehiculos); 
            Vehiculo vehiculo = new Vehiculo(nombre, tipoVehiculo, listaEtiquetas, propietarioObj);
            lista.add(vehiculo);
            vehiculos.add(vehiculo);
        }

        return lista;
    }

    private static ArrayList<TipoEtiqueta> getEtiquetasVehiculo(int i, int totalVehiculos) {
        ArrayList<TipoEtiqueta> listaEtiquetas = new ArrayList<>();
        if (i < totalVehiculos / 4) {
            listaEtiquetas.add(new TipoEtiquetaElectrico());
        } else if (i >= totalVehiculos / 4 && i < totalVehiculos / 2) {
            listaEtiquetas.add(new TipoEtiquetaDiscapacitado());
        } else if (i >= totalVehiculos / 2 && i < (3 * totalVehiculos) / 4) {
            listaEtiquetas.add(new TipoEtiquetaEmpleado());
            listaEtiquetas.add(new TipoEtiquetaElectrico());
        } else {
            //
        }
        return listaEtiquetas;
    }

    private static String getTipoVehiculo(int i) {
        String[] tipos = {"Motocicleta", "Standard", "Carga", "Pasajeros"};
        return tipos[i % tipos.length];
    }

    public static ArrayList<Estacionable> getCocheras() {
        ArrayList<Estacionable> lista = new ArrayList<>();
        ArrayList<Tarifa> listaTarifas1 = new ArrayList<>();
        ArrayList<Tarifa> listaTarifas2 = new ArrayList<>();
        ArrayList<Cochera> cocherasP1 = new ArrayList<>();
        ArrayList<Cochera> cocherasP2 = new ArrayList<>();

        listaTarifas1.add(new Tarifa(0.1, new TipoVehiculo("Carga")));
        listaTarifas1.add(new Tarifa(0.1, new TipoVehiculo("Standard")));
        listaTarifas1.add(new Tarifa(0.05, new TipoVehiculo("Motocicleta")));

        listaTarifas2.add(new Tarifa(0.1, new TipoVehiculo("Carga")));
        listaTarifas2.add(new Tarifa(0.1, new TipoVehiculo("Standard")));
        listaTarifas2.add(new Tarifa(0.05, new TipoVehiculo("Motocicleta")));
        listaTarifas2.add(new Tarifa(0.1, new TipoVehiculo("Pasajeros")));

        Parking p1 = new Parking("Parking1", "Direccion1", listaTarifas1);
        Parking p2 = new Parking("Parking2", "Direccion2", listaTarifas2);

        for (int i = 0; i < 75; i++) {
            ArrayList<TipoEtiqueta> listaEtiquetas = new ArrayList<>();
            if (i < 10) {
                listaEtiquetas.add(new TipoEtiquetaDiscapacitado());
            } else if (i >= 10 && i < 30) {
                listaEtiquetas.add(new TipoEtiquetaElectrico());
            } else if (i >= 30 && i < 45) {
                listaEtiquetas.add(new TipoEtiquetaEmpleado());
            } else if (i >= 45 && i < 60) {
                //
            } else {
                listaEtiquetas.add(new TipoEtiquetaDiscapacitado());
                listaEtiquetas.add(new TipoEtiquetaElectrico());
            }
            Cochera cochera = new Cochera(false, listaEtiquetas, p1);
            cocherasP1.add(cochera);
            lista.add(cochera);
        }

        for (int i = 0; i < 60; i++) {
            ArrayList<TipoEtiqueta> listaEtiquetas = new ArrayList<>();
            if (i < 15) {
                listaEtiquetas.add(new TipoEtiquetaEmpleado());
            } else if (i >= 15 && i < 35) {
                listaEtiquetas.add(new TipoEtiquetaDiscapacitado());
                listaEtiquetas.add(new TipoEtiquetaElectrico());
            } else if (i >= 35 && i < 50) {
                //
            } else {
                listaEtiquetas.add(new TipoEtiquetaEmpleado());
                listaEtiquetas.add(new TipoEtiquetaElectrico());
            }
            Cochera cochera = new Cochera(false, listaEtiquetas, p2);
            cocherasP2.add(cochera);
            lista.add(cochera);
        }

        p1.setListaCocheras(cocherasP1);
        p2.setListaCocheras(cocherasP2);

        fachada.agregarParking(p1);
        fachada.agregarParking(p2);

        return lista;
    }

    
  

}
