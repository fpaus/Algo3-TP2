package Algo3TP2.Modelos.Unidades.ExcepcionesCurar;

public class CatapultaNoPuedeSerCuradaExcepcion extends Exception {
    public CatapultaNoPuedeSerCuradaExcepcion() {
        super("La catapulta no puede ser curada");
    }
}
