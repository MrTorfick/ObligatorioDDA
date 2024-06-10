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
public class Parking extends Observable {

    private String nombre;
    private String direccion;
    private ArrayList<Tarifa> listaTarifas;
    private ArrayList<Cochera> listaCocheras;
    private Tendencia tendenciaActual;
    private double factorDemanda;

    public enum Eventos {
        cambioListaTarifas, cambioDisponibilidad
    };

    public Parking(String nombre, String direccion, ArrayList<Tarifa> listaTarifas, ArrayList<Cochera> listaCocheras) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaTarifas = listaTarifas;
        this.listaCocheras = listaCocheras;
        this.tendenciaActual = new TendenciaEstable();
        this.factorDemanda = 1;
    }

    public Parking(String nombre, String direccion, ArrayList<Tarifa> listaTarifas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaTarifas = listaTarifas;
        this.tendenciaActual = new TendenciaEstable();
        this.factorDemanda = 1;
        this.listaCocheras = new ArrayList<Cochera>();
    }

    public void validar() throws ParkingException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ParkingException("Falta el nombre");
        }
        if (direccion == null || direccion.trim().isEmpty()) {
            throw new ParkingException("Falta la direccion");
        }
        if (listaTarifas == null) {
            throw new ParkingException("Falta la lista de tarifas");
        }
        if (listaCocheras == null) {
            throw new ParkingException("Falta la lista de cocheras");
        }
    }

    public Tendencia getTendenciaActual() {
        return tendenciaActual;
    }

    public void setTendenciaActual(Tendencia tendenciaActual) {
        this.tendenciaActual = tendenciaActual;
    }

    public double getFactorDemanda() {
        return factorDemanda;
    }

    public void setFactorDemanda(double factorDemanda) {
        this.factorDemanda = factorDemanda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Tarifa> getListaTarifas() {
        return listaTarifas;
    }

    public void setListaTarifas(ArrayList<Tarifa> listaTarifas) {
        this.listaTarifas = listaTarifas;
    }

    public ArrayList<Cochera> getListaCocheras() {
        return listaCocheras;
    }

    public void setListaCocheras(ArrayList<Cochera> listaCocheras) {
        this.listaCocheras = listaCocheras;
    }

    public Tarifa obtenerCostoPorTipoDeVehiculo(TipoVehiculo tipoVehiculo) {
        for (Tarifa tarifa : listaTarifas) {
            if (tarifa.getTipoVehiculo().equals(tipoVehiculo)) {
                return tarifa;
            }
        }
        return null;
    }

    public int obtenerCantidadDeIngresosEnCocherasEnLosUltimos10Segundos() {
        int cantidad = 0;
        for (Cochera cochera : listaCocheras) {
            cantidad += cochera.obtenerCantidadDeIngresosEnLosUltimos10Segundos();
        }
        return cantidad;
    }

    public int obtenerCantidadDeEgresosEnCocherasEnLosUltimos10Segundos() {
        int cantidad = 0;
        for (Cochera cochera : listaCocheras) {
            cantidad += cochera.obtenerCantidadDeEgresosEnLosUltimos10Segundos();
        }
        return cantidad;
    }

    public int cantidadCocherasOcupadas() {
        int cantidad = 0;
        for (Cochera cochera : listaCocheras) {
            if (cochera.isEstado()) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public int cantidadCocherasLibresPorEtiqueta(TipoEtiqueta te) {

        int cantidad = 0;

        for (Cochera cochera : listaCocheras) {
            if (!cochera.isEstado() && cochera.existeEtiqueta(te.getNombre())) {
                cantidad++;
            }
        }
        return cantidad;

    }

    public int cantidadCocherasLibres() {
        int cantidad = 0;
        for (Cochera cochera : listaCocheras) {
            if (!cochera.isEstado()) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public void actualizarTendencia() {
        int ingresos = obtenerCantidadDeIngresosEnCocherasEnLosUltimos10Segundos();
        int egresos = obtenerCantidadDeEgresosEnCocherasEnLosUltimos10Segundos();
        int valorAbsoluto = Math.abs(ingresos - egresos);

        if (valorAbsoluto < listaCocheras.size() * 0.10) {
            tendenciaActual = new TendenciaEstable();
            System.out.println("Tendencia estable");
            factorDemanda = tendenciaActual.calcularFactorDemanda(factorDemanda, listaCocheras.size(), cantidadCocherasOcupadas());
        } else if (ingresos - egresos > 0) {
            tendenciaActual = new TendenciaPositiva();
            System.out.println("Tendencia positiva");
            factorDemanda = tendenciaActual.calcularFactorDemanda(factorDemanda, listaCocheras.size(), cantidadCocherasOcupadas());
        } else if (ingresos - egresos < 0 && ingresos - egresos < listaCocheras.size() * 0.10) {
            tendenciaActual = new TendenciaNegativa();
            System.out.println("Tendencia negativa");
            factorDemanda = tendenciaActual.calcularFactorDemanda(factorDemanda, listaCocheras.size(), cantidadCocherasOcupadas());
        }
        Fachada.getInstancia().avisar(Fachada.Eventos.cambioEstadoParking);
    }

    public double totalEstadias() {
        double total = 0;

        for (Cochera c : listaCocheras) {
            total += c.totalEstadias();
        }
        return total;
    }

    public double totalFacturado() {
        double total = 0;
        for (Cochera c : listaCocheras) {
            total += c.totalFacturado();
        }
        return total;
    }

    public double totalMultas() {
        double total = 0;

        for (Cochera c : listaCocheras) {
            total += c.totalFacturadoPorMultas();
        }
        return total;
    }

   
    public double promedioTarifaTipoVehiculo(String tipoVehiculo) {
        double suma = 0;
        double contador = 0;

        for (Tarifa t : listaTarifas) {
            if (t.getTipoVehiculo().getNombre().equals(tipoVehiculo)) {
                suma += t.getCosto();
                contador++;
            }
        }

        if (contador == 0) {
            return 0;
        }

        return suma / contador;

    }

    public void actualizarListaPrecios(String tipoVehiculo, String nuevoValor) throws ParkingException {

        double valor = Double.parseDouble(nuevoValor);

        if (valor < 0) {
            throw new ParkingException("Valor invalido. El precio debe ser igual o mayor a cero");
        }

        double promedioTotalParkings = Fachada.getInstancia().promedioTarifaParkingsPorTipoVehiculo(tipoVehiculo) * 2;
        if (valor >= promedioTotalParkings) {
            throw new ParkingException("“Valor demasiado alto. El sistema no permite dispersión de precios por encima del 100%. Ingrese un valor menor a: " + promedioTotalParkings);
        }

        for (Tarifa t : listaTarifas) {
            if (t.getTipoVehiculo().getNombre().equals(tipoVehiculo)) {
                t.setCostoFinal(Double.parseDouble(nuevoValor));
                avisar(Eventos.cambioListaTarifas);
                break;
            }
        }
    }

}
