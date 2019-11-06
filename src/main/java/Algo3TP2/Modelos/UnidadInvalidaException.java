package Algo3TP2.Modelos;

public class UnidadInvalidaException extends Exception{
    public UnidadInvalidaException(){
        super("La unidad no existe o no pertenece al jugador");
    }
}
