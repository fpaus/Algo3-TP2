package Algo3TP2.ExcepcionesAtaque;

public class DistanciaDeAtaqueIncorrectaExcepcion extends Exception {
    public DistanciaDeAtaqueIncorrectaExcepcion(){
        super("La unidad no puede realizar un ataque a la distancia en la que se encuentra el enemigo");
    }
}
