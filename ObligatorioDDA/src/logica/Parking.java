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
public class Parking {
    
    private String nombre;
    private String direccion;
    private ArrayList<Tarifa> listaTarifas;
    private ArrayList<Cochera> listaCocheras;

    public Parking(String nombre, String direccion, ArrayList<Tarifa> listaTarifas, ArrayList<Cochera> listaCocheras) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaTarifas = listaTarifas;
        this.listaCocheras = listaCocheras;
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
    
    
    
    
}
