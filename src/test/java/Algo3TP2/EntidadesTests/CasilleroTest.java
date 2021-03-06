package Algo3TP2.EntidadesTests;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Jugador.Jugador;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Unidades.Soldado;
import Algo3TP2.Modelos.Unidades.Unidad;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CasilleroTest {

    @Test
    public void casilleroNuevoEsDistintoAnull() {
        // Arrenge
        Casillero casillero;

        // Act
        casillero = new Casillero(new Coordenada(1, 1), new Jugador("JugadorDePrueba"));

        // Assert
        assertNotNull(casillero);
    }

    @Test(expected = CasilleroVacioExcepcion.class)
    public void casilleroNuevoSeEncuentraVacioTest() throws CasilleroVacioExcepcion {
        // Arrenge
        Casillero casillero = new Casillero(new Coordenada(1, 1), new Jugador("JugadorDePrueba"));

        // act, assert
        casillero.getUnidad();
    }

    @Test(expected = CasilleroOcupadoExcepcion.class)
    public void casilleroNuevoSeLeSeteaUnidadAhoraSeEncuentraOcupadoTest() throws CasilleroOcupadoExcepcion {
        // Arrenge
        Jugador jugador = new Jugador("JugadorDePrueba");
        Casillero casillero = new Casillero(new Coordenada(1, 1), jugador);
        Unidad unidadEnCasillero = new Soldado(new Bando(jugador));
        Unidad unidadNueva = new Soldado(new Bando(jugador));

        // act
        casillero.setUnidad(unidadEnCasillero);

        // Assert
        // Intento setear una unidad en un casillero que deberia estar ocupado
        // si se encuentra ocupado debe lanzar excepcion
        casillero.setUnidad(unidadNueva);
    }

    @Test(expected = CasilleroVacioExcepcion.class)
    public void casilleroVacioGetUnidadLanzaExcepcion() throws CasilleroVacioExcepcion {
        // Arrange
        Casillero casillero = new Casillero(new Coordenada(1, 1), new Jugador("JugadorDePrueba"));

        // Assert
        casillero.getUnidad();
    }

    @Test
    public void casilleroSeLeSeteaUnidadGetUnidadRetornaUnidadEnCuestion()
            throws CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        // Arrange
        Jugador jugador = new Jugador("JugadorDePrueba");
        Casillero casillero = new Casillero(new Coordenada(1, 1), jugador);
        Unidad unidad = new Soldado(new Bando(jugador));

        // Act
        casillero.setUnidad(unidad);

        // Assert
        assertEquals(unidad, casillero.getUnidad());
    }

    @Test(expected = CasilleroVacioExcepcion.class)
    public void casilleroVacioQuitarUnidadLanzaExcepcion() throws CasilleroVacioExcepcion {
        // Arrange
        Casillero casillero = new Casillero(new Coordenada(1, 1), new Jugador("JugadorDePrueba"));

        // Assert
        casillero.quitarUnidad();
    }

    @Test
    public void casilleroOcupadoQuitarUnidadNoLanzaExcepcion()
            throws CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        // Arrange
        Jugador jugador = new Jugador("JugadorDePrueba");
        Casillero casillero = new Casillero(new Coordenada(1, 1), jugador);
        Unidad unidad = new Soldado(new Bando(jugador));

        // Act
        casillero.setUnidad(unidad);

        // Assert
        casillero.quitarUnidad();
    }

    @Test(expected = CasilleroVacioExcepcion.class)
    public void casilleroOcupadoQuitarUnidadCasilleroQuedaVacio() throws CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        // Arrange
        Jugador jugador = new Jugador("JugadorDePrueba");
        Casillero casillero = new Casillero(new Coordenada(1, 1), jugador);
        Unidad unidad = new Soldado(new Bando(jugador));

        // Act
        casillero.setUnidad(unidad);
        casillero.quitarUnidad();

        // Assert
        // Tras quitar la unidad, get unidad debe lanzar CasilleroVacioExcepcion
        casillero.getUnidad();
    }

    @Test
    public void getTodasLosCasillerosVecinos() throws CasilleroFueraDelLosLimitesDelTableroExcepcion {
        // Arrange
        Tablero tablero = Tablero.getTablero();
        tablero.inicializarTablero(20, 20, new Jugador("JugadorDePrueba"), new Jugador("JugadorDePrueba2"));
        int posicionX = 2, posicionY = 2;
        Casillero casillero = tablero.getCasilleroEnCoordenada(new Coordenada(posicionX, posicionY));

        // Act
        ArrayList<Casillero> casillerosVecinos = casillero.getTodosLosCasillerosVecinos();

        // Assert
        Iterator<Casillero> iter = casillerosVecinos.iterator();
        for (int i = posicionX - 1; i <= posicionX + 1; i++) {
            for (int j = posicionY - 1; j <= posicionY + 1; j++) {
                if (!(posicionX == i && posicionY == j)) {
                    assertEquals(tablero.getCasilleroEnCoordenada(new Coordenada(i, j)), iter.next());
                }
            }
        }
    }
}
