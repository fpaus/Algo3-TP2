package Algo3TP2.Modelos;

public class PuntosInsuficientesExcepcion extends Exception {
    public PuntosInsuficientesExcepcion() {
        super("No posee los puntos suficientes para comprar la unidad");
    }
}
