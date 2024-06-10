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

    public static void cargar() {

        /*
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

         */
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
            posiblesEtiquetas.add(new TipoEtiquetaEmpleado());

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
   public static ArrayList<Transitable> getVehiculos(int totalCocheras) {
    ArrayList<Transitable> lista = new ArrayList<>();
    Random random = new Random();

    // Crear al menos el doble de vehículos que el total de cocheras
    int totalVehiculos = totalCocheras * 2;

    for (int i = 0; i < totalVehiculos; i++) {
        String nombre = "V" + (i + 1);
        String tipo = getTipoVehiculo(i); // Obtener el tipo de vehículo alternando entre Motocicleta, Standard, Carga, Pasajeros
        TipoVehiculo tipoVehiculo = new TipoVehiculo(tipo);
        int saldo = random.nextInt(111) - 10; // Saldo entre -10 y 100
        String cedula = String.format("%011d", i + 1); // Generar cédula de 11 dígitos
        String propietario = "Propietario " + (i + 1);
        ArrayList<Vehiculo> vehiculos = new ArrayList<>(); // ArrayList de vehículos del propietario
        Propietario propietarioObj = new Propietario(cedula, propietario, vehiculos, saldo);
        ArrayList<TipoEtiqueta> listaEtiquetas = getEtiquetasVehiculo(i, totalVehiculos); // Obtener las etiquetas para el vehículo
        Vehiculo vehiculo = new Vehiculo(nombre, tipoVehiculo, listaEtiquetas, propietarioObj);
        lista.add(vehiculo);
        vehiculos.add(vehiculo); // Agregar el vehículo al ArrayList del propietario
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
        // Sin etiquetas
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

        // Tarifas para el primer parking
        listaTarifas1.add(new Tarifa(120, new TipoVehiculo("Carga", 0.1)));
        listaTarifas1.add(new Tarifa(80, new TipoVehiculo("Automovil", 0.1)));
        listaTarifas1.add(new Tarifa(60, new TipoVehiculo("Motocicleta", 0.05)));

        // Tarifas para el segundo parking
        listaTarifas2.add(new Tarifa(100, new TipoVehiculo("Carga", 0.1)));
        listaTarifas2.add(new Tarifa(70, new TipoVehiculo("Automovil", 0.1)));
        listaTarifas2.add(new Tarifa(50, new TipoVehiculo("Motocicleta", 0.05)));
        listaTarifas2.add(new Tarifa(90, new TipoVehiculo("Camioneta", 0.1)));

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
                // Sin etiquetas
            } else {
                listaEtiquetas.add(new TipoEtiquetaDiscapacitado());
                listaEtiquetas.add(new TipoEtiquetaElectrico());
            }
            lista.add(new Cochera(false, listaEtiquetas, p1));
        }

        for (int i = 0; i < 60; i++) {
            ArrayList<TipoEtiqueta> listaEtiquetas = new ArrayList<>();
            if (i < 15) {
                listaEtiquetas.add(new TipoEtiquetaEmpleado());
            } else if (i >= 15 && i < 35) {
                listaEtiquetas.add(new TipoEtiquetaDiscapacitado());
                listaEtiquetas.add(new TipoEtiquetaElectrico());
            } else if (i >= 35 && i < 50) {
                // Sin etiquetas
            } else {
                listaEtiquetas.add(new TipoEtiquetaEmpleado());
                listaEtiquetas.add(new TipoEtiquetaElectrico());
            }
            lista.add(new Cochera(false, listaEtiquetas, p2));
        }

        return lista;
    }

    public static ArrayList<Estacionable> getCocheras(int cuantos) {
        ArrayList<Estacionable> lista = new ArrayList();
        ArrayList<TipoEtiqueta> listaEtiquetas = new ArrayList();
        ArrayList<Tarifa> listaTarifas = new ArrayList<>();

        listaEtiquetas.add(new TipoEtiquetaEmpleado());
        listaEtiquetas.add(new TipoEtiquetaDiscapacitado());
        listaEtiquetas.add(new TipoEtiquetaElectrico());

        listaTarifas.add(new Tarifa(120, new TipoVehiculo("Carga", 120)));

        Parking p = new Parking("Parking1", "Direccion1", listaTarifas);

        lista.add(new Cochera(false, listaEtiquetas, p));
        lista.add(new Cochera(false, listaEtiquetas, p));
        lista.add(new Cochera(false, listaEtiquetas, p));

        // Casting de Estacionable a Cochera
        ArrayList<Cochera> listaCocheras = new ArrayList<>();
        for (Estacionable estacionable : lista) {
            listaCocheras.add((Cochera) estacionable);
        }
        p.setListaCocheras(listaCocheras);

        fachada.agregarParking(p);
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
        posiblesEtiquetas.add(new TipoEtiquetaEmpleado());

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
