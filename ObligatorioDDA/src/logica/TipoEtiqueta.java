/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 * @author marcos
 */
public abstract class TipoEtiqueta {

    private String nombre;

    public TipoEtiqueta(String nombre) {
        this.nombre = nombre;
    }
    
    
 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    

    public abstract double calcularMulta(double valorEstadia, double tiempoEstadia);


    @Override
    public String toString() {
        return nombre;
    }
}
