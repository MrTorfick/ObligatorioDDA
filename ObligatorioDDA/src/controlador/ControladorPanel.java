/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import logica.Cochera;
import logica.Fachada;
import logica.Parking;
import logica.ParkingException;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author marcos
 */
public class ControladorPanel implements Observador {

    private VistaPanel vista;

    public ControladorPanel(VistaPanel vista) {
        this.vista = vista;
        Fachada.getInstancia().agregarObservador(this);
        listarParkings();
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        System.out.println(origen);
        if (evento.equals(Fachada.Eventos.cambioListaEstadias)) {
            actualizarContadorEstadias();
        } else if (evento.equals(Fachada.Eventos.cambioTotalFacturado)) {
            actualizarTotalFacturado();
        } else if (evento.equals(Fachada.Eventos.cambioEstadoParking)) {
            listarParkings();
        } else if (evento.equals(Fachada.Eventos.cambioListaAnomalias)) {
            listarAnomalias();
        }
    }

    private void actualizarContadorEstadias() {
        vista.MostrarTotalEstadias(Fachada.getInstancia().obtenerTotalEstadias());
    }

    private void actualizarTotalFacturado() {
        vista.mostrarTotalFacturado(Fachada.getInstancia().obtenerTotalFacturado());
    }

    private void listarParkings() {
        vista.limpiarListadoParkings();
        vista.listarParkings(Fachada.getInstancia().getListaParkings());
    }

    public void mostrarListaPrecios(String nombre) {

        Parking p = obtenerParking(nombre);
        vista.mostrarListaPrecios(p);

    }

    private Parking obtenerParking(String nombre) {
        try {
            Parking p = Fachada.getInstancia().obtenerParking(nombre);
            return p;
        } catch (ParkingException e) {
            vista.mostrarMensaje(e.getMessage());
        }
        return null;

    }

    private void listarAnomalias() {
        vista.listarAnomalias(Fachada.getInstancia().getListaAnomalias());
    }

    public void mostrarCartelera(String selectedParking) {
        Parking p = obtenerParking(selectedParking);
        vista.mostrarCartelera(p);
    }

    public void salir() {
        Fachada.getInstancia().quitarObservador(this);
    }

}
