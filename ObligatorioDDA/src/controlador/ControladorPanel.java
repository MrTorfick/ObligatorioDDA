/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import logica.Cochera;
import logica.Fachada;
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
        if(evento.equals(Fachada.Eventos.cambioListaEstadias)){
            actualizarContadorEstadias();
        }
    }

    private void actualizarContadorEstadias() {
        vista.MostrarDatos();//Pasar datos por parametro
    }

}
