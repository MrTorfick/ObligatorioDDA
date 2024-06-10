/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author marcos
 */
public class Propietario {
    
    private String cedula;
    private String NombreCompleto;
    private ArrayList<Vehiculo> listaVehiculos;
    private double dineroActual;

    public Propietario(String cedula, String NombreCompleto, ArrayList<Vehiculo> listaVehiculos, double dineroActual) {
        this.cedula = cedula;
        this.NombreCompleto = NombreCompleto;
        this.listaVehiculos = listaVehiculos;
        this.dineroActual = dineroActual;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public double getDineroActual() {
        return dineroActual;
    }

    public void setDineroActual(double dineroActual) {
        this.dineroActual = dineroActual;
    }
    
    public void descontarSalario(double montoADescontar){
        setDineroActual(getDineroActual()-montoADescontar);
    }

    @Override
    public String toString() {
        return "cedula=" + cedula;
    }
    
    
    
    
    
    
    
}
