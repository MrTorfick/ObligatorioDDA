/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import java.util.Date;

import simuladortransito.Estacionable;

/**
 * @author marcos
 */
public class Cochera implements Estacionable {

    private int id;
    private static int ultimoId = 0;
    private boolean estado;
    private ArrayList<Estadia> listaEstadias = new ArrayList();
    private ArrayList<TipoEtiqueta> listaEtiquetas;
    private Parking parking;

    public Cochera(boolean estado, ArrayList<TipoEtiqueta> listaEtiquetas, Parking parking) {
        id = ultimoId;
        ultimoId++;
        this.estado = estado;
        this.listaEtiquetas = listaEtiquetas;
        this.parking = parking;

    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public ArrayList<Estadia> getListaEstadias() {
        return listaEstadias;
    }

    public void setListaEstadias(ArrayList<Estadia> listaEstadias) {
        this.listaEstadias = listaEstadias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getUltimoId() {
        return ultimoId;
    }

    public static void setUltimoId(int ultimoId) {
        Cochera.ultimoId = ultimoId;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public ArrayList<TipoEtiqueta> getListaEtiquetas() {
        return listaEtiquetas;
    }

    public void setListaEtiquetas(ArrayList<TipoEtiqueta> listaEtiquetas) {
        this.listaEtiquetas = listaEtiquetas;
    }

    @Override
    public String getCodigo() {
        return "C" + id;
    }

    @Override
    public boolean esDiscapacitado() {

        for (TipoEtiqueta tipoEtiqueta : listaEtiquetas) {
            if (tipoEtiqueta instanceof TipoEtiquetaDiscapacitado) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean esElectrico() {

        for (TipoEtiqueta tipoEtiqueta : listaEtiquetas) {
            if (tipoEtiqueta instanceof TipoEtiquetaElectrico) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean esEmpleado() {

        for (TipoEtiqueta tipoEtiqueta : listaEtiquetas) {
            if (tipoEtiqueta instanceof TipoEtiquetaEmpleado) {
                return true;
            }
        }
        return false;
    }

    public boolean existeEtiqueta(String nombreEtiqueta) {

        for (TipoEtiqueta tipoEtiqueta : listaEtiquetas) {
            if (tipoEtiqueta.getNombre().equals(nombreEtiqueta)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "id=" + id + ", estado=" + estado + ", listaEtiquetas=" + listaEtiquetas;
    }

    public int obtenerCantidadDeIngresosEnLosUltimos10Segundos() {
        int cantidad = 0;
        for (Estadia estadia : listaEstadias) {
            if (estadia.getFechaEntrada() != null && estadia.getFechaEntrada().getTime() >= new Date().getTime() - 10000) {
                cantidad++;
            }
        }
        return cantidad;
    }

    private void verificarHoudini() {
        if (this.estado) {
            Estadia e = new Estadia(null, null, this, null, listaEstadias.get(listaEstadias.size() - 1).getVehiculo(), null);
            listaEstadias.add(e);
            Fachada.getInstancia().agregarAnomalia(e, new Date(), Anomalia.codigoError.Houdini);
            System.out.println("Hubo houdini");
        }
    }

    public void IngresoVehiculo(Vehiculo v) {
        verificarHoudini();
        Estadia e = new Estadia(new Date(), null, this, null, v, null);
        listaEstadias.add(e);
        parking.actualizarTendencia();
        System.out.println("Se ingreso nuevo vehiculo");
        setEstado(true);
    }

    public void EgresoVehiculo(Vehiculo v) {
        double costo = 0;
        for (Estadia estadia : listaEstadias) {
            if (estadia.getVehiculo().equals(v)) {
                costo = estadia.calcularMonto();
                setEstado(false);
                estadia.setFechaSalida(new Date());
                break;
            }
        }
        parking.actualizarTendencia();
        System.out.println("Salio el vehiculo" + "costo total: " + costo);
        setEstado(false);
    }

    public int obtenerCantidadDeEgresosEnLosUltimos10Segundos() {

        int cantidad = 0;
        for (Estadia estadia : listaEstadias) {
            if (estadia.getFechaSalida() != null && estadia.getFechaSalida().getTime() >= new Date().getTime() - 10000) {
                cantidad++;
            }
        }
        return cantidad;
    }
    
    public double obtenerCostoPorTipoVehiculo(TipoVehiculo v){
    
        return parking.obtenerCostoPorTipoDeVehiculo(v);
    }
    
    public double obtenerDemandaParking(){
        return parking.getFactorDemanda();
    }
}
