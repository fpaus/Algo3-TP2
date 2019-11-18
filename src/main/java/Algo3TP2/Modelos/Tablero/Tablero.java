package Algo3TP2.Modelos.Tablero;

import Algo3TP2.Modelos.Jugador;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.*;
import Algo3TP2.Modelos.Casillero.Casillero;

public class Tablero {

    private static Tablero tablero;

    private Casillero[][] casilleros;

    private Tablero() {
    }

    public void inicializarTablero(int x, int y, Jugador j1, Jugador j2){
        casilleros = new Casillero[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (j < y / 2) {
                    casilleros[i][j] = new Casillero(i, j, j1);
                } else {
                    casilleros[i][j] = new Casillero(i, j, j2);
                }
            }
        }
    }

    public static Tablero getTablero(){
        if(tablero == null){
            tablero = new Tablero();
        }
        return tablero;
    }

    public Casillero getCasilleroEnPosicion(int x, int y) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {
        try {
            return casilleros[x][y];
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new CasilleroFueraDelLosLimitesDelTableroExcepcion();
        }
    }

    public Casillero getCasilleroConCoordenada(Coordenada coordenada){
        return casilleros[0][0];
    }

    public int medirDistanciaEnXDeCasilleroACasillero(Casillero casilleroUno, Casillero casilleroDos) {
        int casilleroUnoCoordenadaX = casilleroUno.getCoordenadaX();
        int casilleroDosCoordenadaX = casilleroDos.getCoordenadaX();
        return (Math.abs(casilleroUnoCoordenadaX - casilleroDosCoordenadaX));
    }

    public int medirDistanciaEnYDeCasilleroACasillero(Casillero casilleroUno, Casillero casilleroDos) {
        int casilleroUnoCoordenadaY = casilleroUno.getCoordenadaY();
        int casilleroDosCoordenadaY = casilleroDos.getCoordenadaY();
        return (Math.abs(casilleroUnoCoordenadaY - casilleroDosCoordenadaY));
    }


}