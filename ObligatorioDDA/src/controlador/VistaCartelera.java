/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.Map.Entry;
import logica.Tarifa;

/**
 *
 * @author marcos
 */
public interface VistaCartelera {
    
    public void listarTipoVehiculo(ArrayList<Tarifa> listaTarifas);
    public void listarEtiquetas(ArrayList<Entry<String, Integer>> lista, int cantidadCocherasLibres);
    
}
