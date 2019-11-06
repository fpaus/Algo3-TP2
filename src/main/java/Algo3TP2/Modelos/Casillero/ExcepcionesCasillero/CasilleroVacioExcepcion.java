package Algo3TP2.Modelos.Casillero.ExcepcionesCasillero;

public class CasilleroVacioExcepcion extends Exception{
    public CasilleroVacioExcepcion(){
        super("El casillero se encuentra vacio");
    }
}
