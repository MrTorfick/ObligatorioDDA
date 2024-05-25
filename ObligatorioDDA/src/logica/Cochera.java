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
            if (tipoEtiqueta instanceof TipoEtiquetaEmpleo) {
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "id=" + id + ", estado=" + estado + ", listaEtiquetas=" + listaEtiquetas;
    }

    public void IngresoVehiculo(Vehiculo v) {
        Estadia e = new Estadia(new Date(), null, this, null, v, null);
        listaEstadias.add(e);
        setEstado(true);
        System.out.println("Se ingreso nuevo vehiculo");
    }

    public void EgresoVehiculo(Vehiculo v) {
        double costo = 0;
        for (Estadia estadia : listaEstadias) {
            if (estadia.getVehiculo().equals(v)) {
                costo = estadia.calcularMonto();
                setEstado(false);
            }
        }
        System.out.println("Salio el vehiculo" + "costo total: " + costo);
    }
}
