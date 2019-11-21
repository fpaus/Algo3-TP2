package Algo3TP2.Modelos.Unidades.Batallon;

public class ElSoldadoNoSeEncuentraContiguoAlBatallonExcepcion extends Exception {
    ElSoldadoNoSeEncuentraContiguoAlBatallonExcepcion(){
        super("El soldado no se encuentra en una posicion contigua al batallon");
    }
}
