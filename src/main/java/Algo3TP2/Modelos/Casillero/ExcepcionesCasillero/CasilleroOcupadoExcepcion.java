package Algo3TP2.Modelos.Casillero.ExcepcionesCasillero;

public class CasilleroOcupadoExcepcion extends Exception{
    public CasilleroOcupadoExcepcion(){
        super("El casillero se encuentra ocupado");
    }
}
