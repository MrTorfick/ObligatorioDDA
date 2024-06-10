/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inicio;

import iuGrafica.Panel;
import java.util.ArrayList;
import logica.SensorParking;
import simuladorIU.SimuladorIU;
import simuladortransito.Estacionable;
import simuladortransito.Transitable;

public class main {

    public static void main(String[] args) {

        //DatosPrueba d = new DatosPrueba();
        SensorParking sensor = new SensorParking();
        DatosPrueba.cargar();
        
        ArrayList<Estacionable> cocheras = DatosPrueba.getCocheras();
        ArrayList<Transitable> vehiculos = DatosPrueba.getVehiculos(135);
        new SimuladorIU(null, false, sensor, cocheras, vehiculos).setVisible(true);
        new Panel().setVisible(true);
        
        
    }

}
