package logica;

public class TendenciaEstable extends Tendencia {


    public TendenciaEstable() {
        super("Estable");
    }


    @Override
    public double calcularFactorDemanda(double factorDemanda, double cantidadTotalCocheras, double ocupacionTotal) {

        return Math.max(0.25, factorDemanda - 0.01);

    }
}
