package Algo3TP2.Modelos.Unidades.ExcepcionesBatallon;

public class BatallonNoFormadoException extends Exception {
    public BatallonNoFormadoException() {
        super("El batallon no ha sido formado todavia");
    }
}
