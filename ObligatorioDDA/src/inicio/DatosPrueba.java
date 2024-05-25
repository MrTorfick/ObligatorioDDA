/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inicio;

import java.util.ArrayList;
import logica.Cochera;
import logica.Fachada;
import logica.Tarifa;
import logica.TipoEtiqueta;
import logica.TipoVehiculo;

/**
 *
 * @author marcos
 */
public class DatosPrueba {

    public static void cargar() {

        Fachada fachada = Fachada.getInstancia();

        // Crear una lista de tarifas
        ArrayList<Tarifa> listaTarifas = new ArrayList<>();
        for (int i = 0; i < 5; i++) { // Puedes ajustar el valor 5 según la cantidad de tarifas que desees
            listaTarifas.add(new Tarifa(120 + i * 10, new TipoVehiculo("Standard " + i, 120 + i * 10)));
        }

        // Crear una lista de cocheras
        ArrayList<Cochera> listaCocheras = new ArrayList<>();
        for (int i = 0; i < 3; i++) { // Puedes ajustar el valor 3 según la cantidad de cocheras que desees
            ArrayList<TipoEtiqueta> listaEtiquetas = new ArrayList<>();
            // Aquí puedes agregar etiquetas a la lista listaEtiquetas si lo deseas
            listaCocheras.add(new Cochera(false, listaEtiquetas));
        }

        // Crear una lista de parkings
        for (int i = 0; i < 2; i++) { // Puedes ajustar el valor 2 según la cantidad de parkings que desees
            String nombreParking = "Parking" + (i + 1);
            String direccionParking = "DireccionParking" + (i + 1);
            fachada.agregarParking(nombreParking, direccionParking, listaTarifas, listaCocheras);
        }

    }

}
