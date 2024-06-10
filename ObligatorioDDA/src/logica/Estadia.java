/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import java.util.Date;

public class Estadia {

    private Date fechaEntrada;
    private Date fechaSalida;
    private Cochera cochera;
    private Tarifa tarifa;
    private Vehiculo vehiculo;
    private ArrayList<Multa> multas;
    private double costoFinal;

    public Estadia(Date fechaEntrada, Date fechaSalida, Cochera cochera, Tarifa tarifa, Vehiculo vehiculo, ArrayList<Multa> multas) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.cochera = cochera;
        this.tarifa = tarifa;
        this.vehiculo = vehiculo;
        this.multas = multas;
        this.costoFinal = 0;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Cochera getCochera() {
        return cochera;
    }

    public void setCochera(Cochera cochera) {
        this.cochera = cochera;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public ArrayList<Multa> getMultas() {
        return multas;
    }

    public void setMultas(ArrayList<Multa> multas) {
        this.multas = multas;
    }

    public double getCostoFinal() {
        return costoFinal;
    }

    public void setCostoFinal(double costoFinal) {
        this.costoFinal = costoFinal;
    }

    public double calcularMonto() {
        this.fechaSalida = new Date();
        double tiempo = fechaSalida.getTime() - fechaEntrada.getTime();
        double tiempoEstadia = tiempo / 1000;
        Tarifa t = cochera.obtenerCostoPorTipoVehiculo(vehiculo.getTipoVehiculo());
        double precioBaseVehiculo = 0;
        if (t != null) {
            precioBaseVehiculo = t.getCosto();
        }
        setTarifa(t);
        double totalMultas = verificarMultas(precioBaseVehiculo * tiempoEstadia, tiempoEstadia);
        double total = (precioBaseVehiculo * tiempoEstadia * cochera.obtenerDemandaParking()) + totalMultas;

        return total;

    }

    private double verificarMultas(double valorEstadia, double tiempoEstadia) {

        ArrayList<TipoEtiqueta> listaEtiquetasVehiculo = vehiculo.getListaEtiquetas();
        double total = 0;
        for (TipoEtiqueta tipoEtiqueta : listaEtiquetasVehiculo) {

            if (cochera.getListaEtiquetas().size() > 0 && !cochera.existeEtiqueta(tipoEtiqueta.getNombre())) {
                Multa m = new Multa(tipoEtiqueta.calcularMulta(valorEstadia, tiempoEstadia));
                total += m.getCosto();
                multas.add(m);
            }
        }
        Fachada.getInstancia().avisar(Fachada.Eventos.cambioEstadoParking);
        return total;
    }

    public void descontarSalarioPropietario(double costo) {
        vehiculo.getPropietario().descontarSalario(costo);
    }

    public double totalMultas() {
        double total = 0;

        for (Multa a : multas) {
            if (a != null) {
                total += a.getCosto();
            }

        }
        return total;
    }

}
