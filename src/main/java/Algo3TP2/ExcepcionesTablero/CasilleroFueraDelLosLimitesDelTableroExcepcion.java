package Algo3TP2.ExcepcionesTablero;

public class CasilleroFueraDelLosLimitesDelTableroExcepcion extends Exception {
    public CasilleroFueraDelLosLimitesDelTableroExcepcion(){
        super("El casillero solicitado no se encuentra dentro de los limites de tablero de juego");
    }
}
