package logica;

public class TendenciaEstable extends Tendencia {


    public TendenciaEstable() {
        super("Estable");
    }


    @Override
    public double calcularFactorDemanda(double factorDemanda, double cantidadTotalCocheras, double ocupacionTotal) {
        //Se le resta 0.01 por cada UT en que la tendencia transcurre en modo estable. El factor de demanda, nunca puede ser menor a 0.25

        return Math.max(0.25, factorDemanda - 0.01);

    }
}
