/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import logica.Cochera;
import logica.Fachada;
import logica.Parking;
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
        //cochera.agregarObservador(this);
        Fachada.getInstancia().agregarObservador(this);
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        System.out.println(origen);
        if (evento.equals(Fachada.Eventos.cambioListaEstadias)) {
            actualizarContadorEstadias();
        }else if(evento.equals(Fachada.Eventos.cambioTotalFacturado)){
            actualizarTotalFacturado();
        }else if(evento.equals(Fachada.Eventos.cambioEstadoParking)){
            listarParkings();
        }
    }

    private void actualizarContadorEstadias() {
        vista.MostrarTotalEstadias(Fachada.getInstancia().obtenerTotalEstadias());
    }

    private void actualizarTotalFacturado() {
        vista.mostrarTotalFacturado(Fachada.getInstancia().obtenerTotalFacturado());
    }
    private void listarParkings(){
        vista.listarParkings(Fachada.getInstancia().getListaParkings());
    }
    public Parking obtenerParking(String nombre){
        //si parking tira excepcion, hacer un vista.MostrarMensajeError();
        return Fachada.getInstancia().obtenerParking(nombre);
    }

}
