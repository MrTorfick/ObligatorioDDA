/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import java.util.Date;
import logica.Anomalia.codigoError;

/**
 *
 * @author marcos
 */
public class SistemaAnomalia {

    private ArrayList<Anomalia> listaAnomalias = new ArrayList();

    public SistemaAnomalia() {
    }

    public ArrayList<Anomalia> getListaAnomalias() {
        return listaAnomalias;
    }

    public void agregarAnomalia(Estadia e, Date fecha, codigoError error) {

        listaAnomalias.add(new Anomalia(e, fecha, error));

    }

}
