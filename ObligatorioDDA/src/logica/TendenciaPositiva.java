package logica;

public class TendenciaPositiva extends Tendencia {


    public TendenciaPositiva() {
        super("Positiva");
    }

    @Override
    public double calcularFactorDemanda(double factorDemanda, double cantidadCocheras, double ocupacionTotal) {

        //Si la ocupacionTotal es menor al 33% de la cantidad de cocheras, el factorDemanda aumenta en 0.05 por cada UT en que la tendencia trasncurre en modo positivo.

        if (ocupacionTotal < cantidadCocheras * 0.33) {
            return Math.min(10, factorDemanda + 0.05);
        } else if (ocupacionTotal < cantidadCocheras * 0.66) {
            return Math.min(10, factorDemanda + 0.1);
        } else {
            return Math.min(10, factorDemanda + 0.15);
        }


    }
}
