package Algo3TP2.Modelos.Casillero.ExcepcionesCasillero;

public class CasilleroEnemigoExcepcion extends Exception {
    public CasilleroEnemigoExcepcion() {
        super("No se puede colocar la unidad en un casillero enemigo");
    }
}
