package logica;

public class TendenciaPositiva extends Tendencia {


    public TendenciaPositiva() {
        super("Positiva");
    }

    @Override
    public double calcularFactorDemanda(double factorDemanda, double cantidadCocheras, double ocupacionTotal) {

        if (ocupacionTotal < cantidadCocheras * 0.33) {
            return Math.min(10, factorDemanda + 0.05);
        } else if (ocupacionTotal < cantidadCocheras * 0.66) {
            return Math.min(10, factorDemanda + 0.1);
        } else {
            return Math.min(10, factorDemanda + 0.15);
        }


    }
}
