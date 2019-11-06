package Algo3TP2.Modelos.Unidades.ExcepcionesCurar;

public class DistanciaParaCurarIncorrectaExcepcion extends Exception {
    public DistanciaParaCurarIncorrectaExcepcion() {
        super("La unidad no puede curar a la distancia en la que se encuentra el aliado");
    }
}
