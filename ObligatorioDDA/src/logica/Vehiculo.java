/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;

import simuladortransito.Transitable;

/**
 * @author marcos
 */
public class Vehiculo implements Transitable {

    private String patente;
    private TipoVehiculo tipoVehiculo;
    private ArrayList<TipoEtiqueta> listaEtiquetas;
    private Propietario propietario;

    public Vehiculo(String patente, TipoVehiculo tipoVehiculo, ArrayList<TipoEtiqueta> listaEtiquetas, Propietario propietario) {
        this.patente = patente;
        this.tipoVehiculo = tipoVehiculo;
        this.listaEtiquetas = listaEtiquetas;
        this.propietario = propietario;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public ArrayList<TipoEtiqueta> getListaEtiquetas() {
        return listaEtiquetas;
    }

    public void setListaEtiquetas(ArrayList<TipoEtiqueta> listaEtiquetas) {
        this.listaEtiquetas = listaEtiquetas;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    @Override
    public boolean esDiscapacitado() {
        //TipoEtiqueta es abstract y polimorfica, hazlo correctamente

        for (TipoEtiqueta etiqueta : listaEtiquetas) {
            if (etiqueta instanceof TipoEtiquetaDiscapacitado) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean esElectrico() {

        for (TipoEtiqueta etiqueta : listaEtiquetas) {
            if (etiqueta instanceof TipoEtiquetaElectrico) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean esEmpleado() {

        for (TipoEtiqueta etiqueta : listaEtiquetas) {
            if (etiqueta instanceof TipoEtiquetaEmpleado) {
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return patente + ", tipoVehiculo=" + tipoVehiculo + ", listaEtiquetas=" + listaEtiquetas + ", propietario=" + propietario;
    }
    
}
