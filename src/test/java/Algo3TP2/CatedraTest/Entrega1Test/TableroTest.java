package Algo3TP2.CatedraTest.Entrega1Test;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.*;
import Algo3TP2.Modelos.Jugador;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Unidades.Soldado;
import Algo3TP2.Modelos.Unidades.Unidad;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TableroTest {

    @Test
    public void tableroNuevoPoseeElTamanioCorrecto() {
        // Arrange
        int x = 20, y = 20;
        Tablero tablero = new Tablero(x, y, new Jugador(), new Jugador());

        // Assert
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                try {
                    Casillero casillero = tablero.getCasilleroEnPosicion(i, j);
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
        Tablero tablero = new Tablero(x, y, new Jugador(), new Jugador());

        // Assert
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Casillero casillero = tablero.getCasilleroEnPosicion(i, j);
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
        Tablero tablero = new Tablero(x, y, jugador1, jugador2);

        // Assert
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Casillero casillero = tablero.getCasilleroEnPosicion(i, j);
                if (j < y / 2) {
                    assertEquals(jugador1, casillero.getBando().getDuenio());
                } else {
                    assertEquals(jugador2, casillero.getBando().getDuenio());
                }
            }
        }
    }

    @Test
    public void correctaInicializacionDelTablero() throws Exception {
        tableroNuevoPoseeElTamanioCorrecto();
        tableroNuevoPoseeTodasLasCasillasVacias();
        tableroNuevoPoseeLaMitadDeLasCasillasCorrespondientesAUnBandoDistintoAlDeLaOtraMitad();
    }

    @Test(expected = CasilleroOcupadoExcepcion.class)
    public void noSePuedeColocarUnaPiezaAliadaEnUnCasilleroDelSectorAliadoOcupadoTest()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion {
        // Arrange
        Jugador jugadorAliado = new Jugador();
        Jugador jugadorEnemigo = new Jugador();
        Tablero tablero = new Tablero(20,20, jugadorAliado, jugadorEnemigo);
        Unidad unidadAliadaOcupante = new Soldado(new Bando(jugadorAliado));
        tablero.getCasilleroEnPosicion(5,5).setUnidadAlInicioDelJuego(unidadAliadaOcupante);
        Unidad unidadAliada = new Soldado(new Bando(jugadorAliado));


        // Act Assert
        Casillero casilleroOcupadoPorUnidadAliada = tablero.getCasilleroEnPosicion(5,5);
        casilleroOcupadoPorUnidadAliada.setUnidadAlInicioDelJuego(unidadAliada);
    }

    @Test(expected = CasilleroEnemigoExcepcion.class)
    public void noSePuedeColocarUnaPiezaAliadaEnUnCasilleroDelSectorEnemigoTest()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion {
        // Arrange
        Jugador jugadorAliado = new Jugador();
        Jugador jugadorEnemigo = new Jugador();
        Tablero tablero = new Tablero(20,20, jugadorAliado, jugadorEnemigo);
        Unidad unidadAliada = new Soldado(new Bando(jugadorAliado));


        // Act Assert
        Casillero casilleroEnemigo = tablero.getCasilleroEnPosicion(19,19);
        casilleroEnemigo.setUnidadAlInicioDelJuego(unidadAliada);
    }

    @Test
    public void seColocaUnaPiezaAliadaEnUnCasilleroDelSectorAliadoVacioConExitoTest()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion,
            CasilleroEnemigoExcepcion, CasilleroVacioExcepcion {
        // Arrange
        Jugador jugadorAliado = new Jugador();
        Jugador jugadorEnemigo = new Jugador();
        Tablero tablero = new Tablero(20,20, jugadorAliado, jugadorEnemigo);
        Unidad unidadAliada = new Soldado(new Bando(jugadorAliado));

        // Act
        tablero.getCasilleroEnPosicion(5,5).setUnidadAlInicioDelJuego(unidadAliada);

        // Assert
        assertEquals(unidadAliada, tablero.getCasilleroEnPosicion(5,5).getUnidad());
    }
}
