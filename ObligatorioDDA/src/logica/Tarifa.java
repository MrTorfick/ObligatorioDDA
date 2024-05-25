/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author marcos
 */
public class Tarifa {

    private double costo;
    private TipoVehiculo tipoVehiculo;

    public Tarifa(double costoFinal, TipoVehiculo tipoVehiculo) {
        this.costo = costoFinal;
        this.tipoVehiculo = tipoVehiculo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCostoFinal(double costoFinal) {
        this.costo = costoFinal;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

}
