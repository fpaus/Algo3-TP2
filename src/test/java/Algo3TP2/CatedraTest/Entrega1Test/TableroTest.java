package Algo3TP2.CatedraTest.Entrega1Test;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroEnemigoExcepcion;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Jugador.Jugador;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Unidades.Soldado;
import Algo3TP2.Modelos.Unidades.Unidad;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TableroTest {

    private Tablero tablero;
    private Bando bandoAliado, bandoEnemigo;

    @Before // Inicializo el tablero y los bandos Aliados/Enemigos
    public void before() {
        Jugador jugadorAliado = new Jugador("JugadorAliado");
        bandoAliado = new Bando(jugadorAliado);
        Jugador jugadorEnemigo = new Jugador("JugadorEnemigo");
        bandoEnemigo = new Bando(jugadorEnemigo);
        tablero = Tablero.getTablero();
        tablero.inicializarTablero(20, 20, jugadorAliado, jugadorEnemigo);
    }

    @Test
    public void correctaInicializacionDelTablero() throws Exception {
        tableroNuevoPoseeElTamanioCorrecto();
        tableroNuevoPoseeTodasLasCasillasVacias();
        tableroNuevoPoseeLaMitadDeLasCasillasCorrespondientesAUnBandoDistintoAlDeLaOtraMitad();
    }


    @Test(expected = CasilleroEnemigoExcepcion.class)
    public void noSePuedeColocarUnaPiezaAliadaEnUnCasilleroDelSectorAliadoOcupadoTest() throws Exception {
        // Arrange
        Unidad unidadAliadaOcupante = new Soldado(bandoAliado);
        tablero.posicionarUnidadAlInicioDelJuego(unidadAliadaOcupante, new Coordenada(5, 5));
        Unidad unidadAliada = new Soldado(bandoEnemigo);


        // Act Assert
        tablero.posicionarUnidadAlInicioDelJuego(unidadAliada, new Coordenada(5, 5));
    }

    @Test(expected = CasilleroEnemigoExcepcion.class)
    public void noSePuedeColocarUnaPiezaAliadaEnUnCasilleroDelSectorEnemigoTest() throws Exception {
        // Arrange
        Unidad unidadAliada = new Soldado(bandoAliado);

        // Act Assert
        tablero.posicionarUnidadAlInicioDelJuego(unidadAliada, new Coordenada(19, 19));
    }

    @Test
    public void seColocaUnaPiezaAliadaEnUnCasilleroDelSectorAliadoVacioConExitoTest() throws Exception {
        // Arrange
        Unidad unidadAliada = new Soldado(bandoAliado);

        // Act
        tablero.posicionarUnidadAlInicioDelJuego(unidadAliada, new Coordenada(5, 5));

        // Assert
        assertEquals(unidadAliada, tablero.getCasilleroEnCoordenada(new Coordenada(5, 5)).getUnidad());
    }

    @Test
    public void tableroNuevoPoseeElTamanioCorrecto() {
        // Arrange
        int x = 20, y = 20;
        Tablero tablero = Tablero.getTablero();
        tablero.inicializarTablero(x, y, new Jugador("JugadorDePrueba"), new Jugador("JugadorDePrueba2"));

        // Assert
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                try {
                    Casillero casillero = tablero.getCasilleroEnCoordenada(new Coordenada(i, j));
                    assert (true);
                } catch (CasilleroFueraDelLosLimitesDelTableroExcepcion ex) {
                    assert (false);
                }
            }
        }
    }

    @Test
    public void tableroNuevoPoseeTodasLasCasillasVacias() throws Exception {
        // Arrange
        int x = 20, y = 20;
        Tablero tablero = Tablero.getTablero();
        tablero.inicializarTablero(x, y, new Jugador("JugadorDePrueba"), new Jugador("JugadorDePrueba2"));

        // Assert
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Casillero casillero = tablero.getCasilleroEnCoordenada(new Coordenada(i, j));
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
        Jugador jugador1 = new Jugador("JugadorDePrueba"), jugador2 = new Jugador("JugadorDePrueba2");
        Tablero tablero = Tablero.getTablero();
        tablero.inicializarTablero(20, 20, jugador1, jugador2);

        // Assert
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Casillero casillero = tablero.getCasilleroEnCoordenada(new Coordenada(i, j));
                if (j < y / 2) {
                    assertEquals(jugador1, casillero.getBando().getDuenio());
                } else {
                    assertEquals(jugador2, casillero.getBando().getDuenio());
                }
            }
        }
    }
}
