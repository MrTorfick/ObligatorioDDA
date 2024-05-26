package logica;

public class TendenciaNegativa extends Tendencia {


    public TendenciaNegativa() {
        super("Negativa");
    }

    @Override
    public double calcularFactorDemanda(double factorDemanda, double cantidadTotalCocheras, double ocupacionTotal) {

        if (factorDemanda > 1) {
            return 1;
        } else {
            return Math.max(0.25, factorDemanda - 0.05);
        }
    }
}
