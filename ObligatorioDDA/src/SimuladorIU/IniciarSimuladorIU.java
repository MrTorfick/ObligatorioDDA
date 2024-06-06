/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SimuladorIU;

import java.util.ArrayList;

import inicio.DatosPrueba;
import logica.SensorParking;
import simuladortransito.Estacionable;
import simuladortransito.Transitable;
import simuladorIU.SimuladorIU;


/**
 * @author marcos
 */
public class IniciarSimuladorIU {

    public static void main(String[] args) {
        SensorParking sensor = new SensorParking();

        ArrayList<Estacionable> cocheras = DatosPrueba.getCocheras(50);
        ArrayList<Transitable> vehiculos = DatosPrueba.getVehiculos(50);
        new SimuladorIU(null, false, sensor, cocheras, vehiculos).setVisible(true);

    }


}
