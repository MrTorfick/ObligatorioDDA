/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 * @author marcos
 */
public class TipoEtiquetaDiscapacitado extends TipoEtiqueta {

    public TipoEtiquetaDiscapacitado() {
        super("Discapacitado");
    }



    @Override
    public double calcularMulta(double valorEstadia, double tiempoEstadia) {
        return 250;
    }


}
