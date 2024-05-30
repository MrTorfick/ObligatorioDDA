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

    public double calcularMonto() {
        this.fechaSalida = new Date();
        double tiempo = fechaSalida.getTime() - fechaEntrada.getTime();
        double tiempoEstadia = tiempo / 1000;
        double precioBaseVehiculo = cochera.obtenerCostoPorTipoVehiculo(vehiculo.getTipoVehiculo());
        double totalMultas = verificarMultas(precioBaseVehiculo * tiempoEstadia, tiempoEstadia);
        double total = (precioBaseVehiculo * tiempoEstadia * cochera.obtenerDemandaParking()) + totalMultas;
        if (totalMultas > 0) {
            System.out.println("Genero multas");
        }
        System.out.println("Costo sin factor de demanda:" + total);
        return total;

        //return cochera.getParking().obtenerCostoPorTipoDeVehiculo(vehiculo.getTipoVehiculo()) * segundos;
    }

    private double verificarMultas(double valorEstadia, double tiempoEstadia) {

        ArrayList<TipoEtiqueta> listaEtiquetasVehiculo = vehiculo.getListaEtiquetas();
        double total = 0;
        for (TipoEtiqueta tipoEtiqueta : listaEtiquetasVehiculo) {

            if (!cochera.existeEtiqueta(tipoEtiqueta.getNombre())) {
                total += tipoEtiqueta.calcularMulta(valorEstadia, tiempoEstadia);
            }
        }
        return total;
    }

}
