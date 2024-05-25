/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inicio;

import java.util.ArrayList;
import java.util.Random;

import logica.*;
import simuladortransito.Estacionable;
import simuladortransito.Transitable;

/**
 * @author marcos
 */
public class DatosPrueba {

    static Fachada fachada = Fachada.getInstancia();

    public static void cargar() {


        // Crear una lista de tarifas
        ArrayList<Tarifa> listaTarifas = new ArrayList<>();
        for (int i = 0; i < 5; i++) { // Puedes ajustar el valor 5 según la cantidad de tarifas que desees
            listaTarifas.add(new Tarifa(120 + i * 10, new TipoVehiculo("Standard " + i, 120 + i * 10)));
        }

        // Crear una lista de cocheras
        ArrayList<Cochera> listaCocheras = new ArrayList<>();
        for (int i = 0; i < 100; i++) { // Puedes ajustar el valor 3 según la cantidad de cocheras que desees
            ArrayList<TipoEtiqueta> listaEtiquetas = new ArrayList<>();
            // Aquí puedes agregar etiquetas a la lista listaEtiquetas si lo deseas
            listaCocheras.add(new Cochera(false, listaEtiquetas));
        }

        // Crear una lista de parkings
        for (int i = 0; i < 100; i++) { // Puedes ajustar el valor 2 según la cantidad de parkings que desees
            String nombreParking = "Parking" + (i + 1);
            String direccionParking = "DireccionParking" + (i + 1);
            fachada.agregarParking(nombreParking, direccionParking, listaTarifas, listaCocheras);
        }

    }

    /*
        public static ArrayList<Transitable> getVehiculos(int cuantos) {
            ArrayList<Transitable> lista = new ArrayList<>();
            Random random = new Random();

            // Crear lista de tipos de vehículos
            ArrayList<TipoVehiculo> tiposVehiculo = new ArrayList<>();
            tiposVehiculo.add(new TipoVehiculo("Electrico", 100));
            tiposVehiculo.add(new TipoVehiculo("Standard", 200));
            tiposVehiculo.add(new TipoVehiculo("Camion", 300));

            // Crear lista de posibles etiquetas
            ArrayList<TipoEtiqueta> posiblesEtiquetas = new ArrayList<>();
            posiblesEtiquetas.add(new TipoEtiquetaDiscapacitado());
            posiblesEtiquetas.add(new TipoEtiquetaElectrico());
            posiblesEtiquetas.add(new TipoEtiquetaEmpleo());

            for (int x = 0; x < cuantos; x++) {
                ArrayList<Vehiculo> vehiculosPropietario = new ArrayList<>();
                int numVehiculos = random.nextInt(10); // Genera un número aleatorio de vehículos para el propietario

                for (int i = 0; i < numVehiculos; i++) {
                    String patente = "Patente" + random.nextInt(1000); // Genera una patente aleatoria
                    TipoVehiculo tipoVehiculo = tiposVehiculo.get(random.nextInt(tiposVehiculo.size())); // Selecciona un tipo de vehículo aleatorio

                    // Generar etiquetas aleatorias
                    ArrayList<TipoEtiqueta> listaEtiquetas = new ArrayList<>();
                    int numEtiquetas = random.nextInt(10); // Genera un número aleatorio de etiquetas para el vehículo
                    for (int j = 0; j < numEtiquetas; j++) {
                        TipoEtiqueta etiqueta = posiblesEtiquetas.get(random.nextInt(posiblesEtiquetas.size())); // Selecciona una etiqueta aleatoria
                        listaEtiquetas.add(etiqueta);
                    }

                    Vehiculo v = new Vehiculo(patente, tipoVehiculo, listaEtiquetas, null);
                    vehiculosPropietario.add(v);
                }

                Propietario p = new Propietario("Cedula" + random.nextInt(1000), "Nombre" + random.nextInt(1000), vehiculosPropietario, 1000);
                lista.addAll(vehiculosPropietario);
            }

            return lista;
        }
    */
    public static ArrayList<Transitable> getVehiculos(int cuantos) {

        ArrayList<Transitable> lista = new ArrayList();
        ArrayList<TipoEtiqueta> listaEtiquetas = new ArrayList();
        listaEtiquetas.add(new TipoEtiquetaEmpleo());
        listaEtiquetas.add(new TipoEtiquetaDiscapacitado());
        listaEtiquetas.add(new TipoEtiquetaElectrico());
        lista.add(new Vehiculo("V1", new TipoVehiculo("Carga"), listaEtiquetas, new Propietario("11111111111", "Propietario 1", null, 1000)));
        lista.add(new Vehiculo("V2", new TipoVehiculo("Carga"), listaEtiquetas, new Propietario("22222222222", "Propietario 2", null, 1000)));
        lista.add(new Vehiculo("V3", new TipoVehiculo("Carga"), listaEtiquetas, new Propietario("33333333333", "Propietario 3", null, 1000)));

        return lista;

    }

    public static ArrayList<Estacionable> getCocheras(int cuantos) {
        ArrayList<Estacionable> lista = new ArrayList();
        ArrayList<TipoEtiqueta> listaEtiquetas = new ArrayList();
        listaEtiquetas.add(new TipoEtiquetaEmpleo());
        listaEtiquetas.add(new TipoEtiquetaDiscapacitado());
        listaEtiquetas.add(new TipoEtiquetaElectrico());
        lista.add(new Cochera(false, listaEtiquetas));
        lista.add(new Cochera(false, listaEtiquetas));
        lista.add(new Cochera(false, listaEtiquetas));

        return lista;

    }

/*
    public static ArrayList<Estacionable> getCocheras(int cuantos) {
        ArrayList<Estacionable> lista = new ArrayList<>();
        Random random = new Random();

        // Crear lista de posibles etiquetas
        ArrayList<TipoEtiqueta> posiblesEtiquetas = new ArrayList<>();
        posiblesEtiquetas.add(new TipoEtiquetaDiscapacitado());
        posiblesEtiquetas.add(new TipoEtiquetaElectrico());
        posiblesEtiquetas.add(new TipoEtiquetaEmpleo());

        for (int x = 0; x < cuantos; x++) {
            // Generar etiquetas aleatorias
            ArrayList<TipoEtiqueta> listaEtiquetas = new ArrayList<>();
            int numEtiquetas = random.nextInt(10); // Genera un número aleatorio de etiquetas para la cochera
            for (int j = 0; j < numEtiquetas; j++) {
                TipoEtiqueta etiqueta = posiblesEtiquetas.get(random.nextInt(posiblesEtiquetas.size())); // Selecciona una etiqueta aleatoria
                listaEtiquetas.add(etiqueta);
            }

            lista.add(new Cochera(false, listaEtiquetas));
        }

        return lista;
    }

 */

    public static ArrayList<Parking> getParkings() {
        return fachada.getListaParkings();
    }

}
