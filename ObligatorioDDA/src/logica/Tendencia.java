package logica;

public abstract class Tendencia {

    private String nombre;

    public Tendencia(String nombre) {
        this.nombre = nombre;
    }

    public abstract double calcularFactorDemanda(double factorDemanda, double cantidadTotalCocheras, double ocupacionTotal);

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
