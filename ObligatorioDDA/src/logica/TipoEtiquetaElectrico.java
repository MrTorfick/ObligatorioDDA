/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author marcos
 */
public class TipoEtiquetaElectrico extends TipoEtiqueta {

    public TipoEtiquetaElectrico() {
        super("Electrico");
    }




    @Override
    public double calcularMulta(double valorEstadia, double tiempoEstadia) {
        return valorEstadia * 0.5;
    }
}
