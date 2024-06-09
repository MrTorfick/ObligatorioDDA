/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import logica.Fachada;
import logica.Parking;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author marcos
 */
public class ControladorPrecios implements Observador {

    private VistaPrecios vista;
    private Parking parking;

    public ControladorPrecios(VistaPrecios vista, Parking p) {
        this.vista = vista;
        this.parking = p;
        parking.agregarObservador(this);
    }

    @Override
    public void actualizar(Object evento, Observable origen) {

        if (evento.equals(Parking.Eventos.cambioListaTarifas)) {
            listarPrecios();
        }
    }

    public void listarPrecios() {
        vista.listarPrecios(parking.getListaTarifas());
    }

    public void ActualizarListaPrecios(String tipoVehiculo, String nuevoValor) {
        parking.actualizarListaPrecios(tipoVehiculo, nuevoValor);
    }

}
