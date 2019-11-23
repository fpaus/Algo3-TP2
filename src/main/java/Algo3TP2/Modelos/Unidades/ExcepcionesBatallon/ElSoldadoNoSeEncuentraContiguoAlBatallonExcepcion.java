package Algo3TP2.Modelos.Unidades.ExcepcionesBatallon;

public class ElSoldadoNoSeEncuentraContiguoAlBatallonExcepcion extends Exception {
    ElSoldadoNoSeEncuentraContiguoAlBatallonExcepcion(){
        super("El soldado no se encuentra en una posicion contigua al batallon");
    }
}
