package Algo3TP2.Modelos.Tablero;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroEnemigoExcepcion;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Jugador.Jugador;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Unidades.Unidad;

import java.util.HashMap;

public class Tablero {

    private static Tablero tablero;

    HashMap<Coordenada, Casillero> casilleros;

    private Tablero() {
    }

    public void inicializarTablero(int x, int y, Jugador j1, Jugador j2) {
        casilleros = new HashMap<Coordenada, Casillero>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Coordenada coordenada = new Coordenada(i, j);
                if (j < y / 2) {
                    casilleros.put(coordenada, new Casillero(coordenada, j1));
                } else {
                    casilleros.put(coordenada, new Casillero(coordenada, j2));
                }
            }
        }
    }

    public static Tablero getTablero() {
        if (tablero == null) {
            tablero = new Tablero();
        }
        return tablero;
    }

    public Casillero getCasilleroEnCoordenada(Coordenada coordenada) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {
        Casillero casillero = casilleros.get(coordenada);
        if (casillero == null) {
            throw new CasilleroFueraDelLosLimitesDelTableroExcepcion();
        }
        return casillero;
    }

    public void posicionarUnidad(Unidad unidad, Coordenada coordenada)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion {
        Casillero destino = this.getCasilleroEnCoordenada(coordenada);
        unidad.colocarEnCasillero(destino);
    }


    public void posicionarUnidadAlInicioDelJuego(Unidad unidad, Coordenada coordenada)
            throws CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion, CasilleroFueraDelLosLimitesDelTableroExcepcion {
        Casillero destino = this.getCasilleroEnCoordenada(coordenada);
        if (!destino.getBando().equals(unidad.getBando())) {
            throw new CasilleroEnemigoExcepcion();
        }
        unidad.colocarEnCasillero(destino);
    }
}