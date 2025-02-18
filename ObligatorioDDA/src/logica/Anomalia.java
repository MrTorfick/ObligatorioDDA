/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.Date;

/**
 *
 * @author marcos
 */
public class Anomalia {
    
    private Estadia estadia;
    private Date fecha;
    
    public enum codigoError{Houdini, Mystery, Transportador1, Transportador2};
    
    private final codigoError error;

    public Anomalia(Estadia estadia, Date fecha, codigoError error) {
        this.estadia = estadia;
        this.fecha = fecha;
        this.error = error;
    }

    public codigoError getError() {
        return error;
    }
    
    

    public Estadia getEstadia() {
        return estadia;
    }

    public void setEstadia(Estadia estadia) {
        this.estadia = estadia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    

    


}
