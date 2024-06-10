/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;
import logica.Parking;
import logica.TipoEtiquetaDiscapacitado;
import logica.TipoEtiquetaElectrico;
import logica.TipoEtiquetaEmpleado;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author marcos
 */
public class ControladorCartelera implements Observador {

    private VistaCartelera vista;
    private Parking parking;

    public ControladorCartelera(VistaCartelera vista, Parking p) {
        this.vista = vista;
        this.parking = p;
        parking.agregarObservador(this);
        cambioDisponibilidad();
        cambioListaTarifas();

    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if (evento.equals(Parking.Eventos.cambioDisponibilidad)) {
            cambioDisponibilidad();
        } else if (evento.equals(Parking.Eventos.cambioListaTarifas)) {
            cambioListaTarifas();
        }
    }

    private void cambioDisponibilidad() {
        ArrayList<Map.Entry<String, Integer>> lista = new ArrayList();
        lista.add(new AbstractMap.SimpleEntry(new TipoEtiquetaDiscapacitado().getNombre(), parking.cantidadCocherasLibresPorEtiqueta(new TipoEtiquetaDiscapacitado())));
        lista.add(new AbstractMap.SimpleEntry(new TipoEtiquetaElectrico().getNombre(), parking.cantidadCocherasLibresPorEtiqueta(new TipoEtiquetaElectrico())));
        lista.add(new AbstractMap.SimpleEntry(new TipoEtiquetaEmpleado().getNombre(), parking.cantidadCocherasLibresPorEtiqueta(new TipoEtiquetaDiscapacitado())));

        vista.limpiarListadoEtiquetas();
        vista.listarEtiquetas(lista, parking.cantidadCocherasLibres());
    }

    private void cambioListaTarifas() {
        vista.limpiarListadoTipoVehiculos();
        vista.listarTipoVehiculo(parking.getListaTarifas());
    }

    public void salir() {
        parking.quitarObservador(this);
    }

}
