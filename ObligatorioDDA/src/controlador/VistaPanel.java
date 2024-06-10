/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import logica.Anomalia;
import logica.Parking;

/**
 *
 * @author marcos
 */
public interface VistaPanel {

    public void MostrarTotalEstadias(double total);
    public void mostrarTotalFacturado(double total);
    public void listarParkings(ArrayList<Parking> listaParkings);
    public void listarAnomalias(ArrayList<Anomalia> listaAnomalias);
    public void mostrarMensaje(String mensaje);
    public void mostrarListaPrecios(Parking p);
    public void mostrarCartelera(Parking p);
    public void limpiarListadoParkings();

    public void limpiarListadoAnomalias();
    
    

}
