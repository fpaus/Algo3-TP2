package Algo3TP2.Modelos.Unidades;

public class PuntosInsuficientesExcepcion extends Exception {
    public PuntosInsuficientesExcepcion(){
        super("No posee los puntos suficientes para comprar la unidad");
    }
}
