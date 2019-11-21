package Algo3TP2.EntidadesTests;

import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.*;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.*;
import Algo3TP2.Modelos.*;
import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Unidades.Unidad;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TableroTest {

    @Test
    public void TableroNuevoEsDistintoAnull() {
        // Arrenge
        Tablero tablero;

        // Act
        tablero = Tablero.getTablero();
        tablero.inicializarTablero(20, 20, new Jugador(), new Jugador());

        // Assert
        assertFalse(tablero == null);
    }

    @Test
    public void tableroGetCasilleroEnPosicionRetornaUnCasillero() throws CasilleroFueraDelLosLimitesDelTableroExcepcion {
        // Arrange
        Tablero tablero = Tablero.getTablero();
        tablero.inicializarTablero(20, 20, new Jugador(), new Jugador());
        Casillero casillero;

        // Act
        casillero = tablero.getCasilleroEnPosicion(new Coordenada(5, 5));

        // Assert
        assertEquals(Casillero.class, casillero.getClass());
    }

    @Test(expected = CasilleroFueraDelLosLimitesDelTableroExcepcion.class)
    public void tableroGetCasilleroEnPosicionFueraDeRangoLanzaUnaExcepcion()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion {
        // Arrange
        Tablero tablero = Tablero.getTablero();
        tablero.inicializarTablero(20, 20, new Jugador(), new Jugador());

        // Assert
        Casillero casillero = tablero.getCasilleroEnPosicion(new Coordenada(50, 50));
    }

    @Test
    public void tableroNuevoPoseeElTamanioCorrecto() {
        // Arrange
        int x = 20, y = 20;
        Tablero tablero = Tablero.getTablero();
        tablero.inicializarTablero(x, y, new Jugador(), new Jugador());

        // Assert
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                try {
                    Casillero casillero = tablero.getCasilleroEnPosicion(new Coordenada(i, j));
                    assert (true);
                } catch (CasilleroFueraDelLosLimitesDelTableroExcepcion ex) {
                    assert (false);
                }
            }
        }
    }

    @Test
    public void tableroNuevoPoseeTodasLasCasillasVacias() throws CasilleroFueraDelLosLimitesDelTableroExcepcion {
        // Arrange
        int x = 20, y = 20;
        Tablero tablero = Tablero.getTablero();
        tablero.inicializarTablero(x, y, new Jugador(), new Jugador());

        // Assert
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Casillero casillero = tablero.getCasilleroEnPosicion(new Coordenada(i, j));
                try {
                    Unidad unidad = casillero.getUnidad();
                    assert (false);
                } catch (CasilleroVacioExcepcion ex) {
                    assert (true);
                }
            }
        }
    }

    @Test
    public void tableroNuevoPoseeLaMitadDeLasCasillasCorrespondientesAUnBandoDistintoAlDeLaOtraMitad()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion {
        // Arrange
        int x = 20, y = 20;
        Jugador jugador1 = new Jugador(), jugador2 = new Jugador();
        Tablero tablero = Tablero.getTablero();
        tablero.inicializarTablero(x, y, jugador1, jugador2);

        // Assert
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Casillero casillero = tablero.getCasilleroEnPosicion(new Coordenada(i, j));
                if (j < y / 2) {
                    assertEquals(jugador1, casillero.getBando().getDuenio());
                } else {
                    assertEquals(jugador2, casillero.getBando().getDuenio());
                }
            }
        }
    }

}
