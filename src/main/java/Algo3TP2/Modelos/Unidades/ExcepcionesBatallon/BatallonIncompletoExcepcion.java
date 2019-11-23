package Algo3TP2.Modelos.Unidades.ExcepcionesBatallon;

public class BatallonIncompletoExcepcion extends Exception {
    public BatallonIncompletoExcepcion(){
        super("No hay suficientes soldados aliado para conformar un batallon");
    }
}
