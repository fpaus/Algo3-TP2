package Algo3TP2.Modelos;

import java.util.List;

public class Tablero {

    private Casillero[][] casilleros;

    public Tablero(int x, int y, Jugador j1, Jugador j2){
        casilleros = new Casillero[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(j < y/2){
                    casilleros[i][j] = new Casillero(i,j, j1);}
                else {
                    casilleros[i][j] = new Casillero(i,j, j2);
                }
            }
        }
    }

    public Casillero getCasilleroEnPosicion(int x, int y) {
        return casilleros[x][y];
    }
}
