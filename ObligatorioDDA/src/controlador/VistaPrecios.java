/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import logica.Tarifa;

/**
 *
 * @author marcos
 */
public interface VistaPrecios {
    
    public void listarPrecios(ArrayList<Tarifa> listaTarifas);
    public void mostrarMensaje(String mensaje);
    public void limpiarPrecios();
    
}
