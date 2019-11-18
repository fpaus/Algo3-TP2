package Algo3TP2.EntidadesTests;

import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.*;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.*;
import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Unidades.Soldado;
import Algo3TP2.Modelos.Unidades.Unidad;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CasilleroTest {
    @Test
    public void casilleroNuevoEsDistintoAnull() {
        // Arrenge
        Casillero casillero;

        // Act
        casillero = new Casillero(new Coordenada(1, 1), new Jugador());

        // Assert
        assertFalse(casillero == null);
    }

    @Test
    public void casilleroNuevoSeEncuentraVacioTest() throws CasilleroOcupadoExcepcion {
        // Arrenge
        Casillero casillero = new Casillero(new Coordenada(1, 1), new Jugador());
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Unidad unidadEnCasillero = new Soldado(bando);

        // act, assert
        // Intento setear una unidad en un casillero que deberia estar vacio
        // si se encuentra vacio no deberia lanzar excepcion
        casillero.setUnidad(unidadEnCasillero);
    }

    @Test(expected = CasilleroOcupadoExcepcion.class)
    public void casilleroNuevoSeLeSeteaUnidadAhoraSeEncuentraOcupadoTest() throws CasilleroOcupadoExcepcion {
        // Arrenge
        Casillero casillero = new Casillero(new Coordenada(1, 1), new Jugador());
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Unidad unidadEnCasillero = new Soldado(bando);
        Unidad unidadNueva = new Soldado(bando);

        // act
        casillero.setUnidad(unidadEnCasillero);

        // Assert
        // Intento setear una unidad en un casillero que deberia estar ocupado
        // si se encuentra ocupado debe lanzar excepcion
        casillero.setUnidad(unidadNueva);
    }

    @Test(expected = CasilleroVacioExcepcion.class)
    public void casilleroVacioGetUnidadLanzaExcepcion() throws CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        // Arrange
        Casillero casillero = new Casillero(new Coordenada(1, 1), new Jugador());
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Unidad unidad = new Soldado(bando);

        // Assert
        Unidad unidadEnCasillero = casillero.getUnidad();
    }

    @Test
    public void casilleroSeLeSeteaUnidadGetUnidadRetornaUnidadEnCuestion()
            throws CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        // Arrange
        Casillero casillero = new Casillero(new Coordenada(1, 1), new Jugador());
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Unidad unidad = new Soldado(bando);

        // Act
        casillero.setUnidad(unidad);

        // Assert
        Unidad unidadEnCasillero = casillero.getUnidad();
        assertEquals(unidad, unidadEnCasillero);
    }

    @Test(expected = CasilleroVacioExcepcion.class)
    public void casilleroVacioQuitarUnidadLanzaExcepcion() throws CasilleroVacioExcepcion {
        // Arrange
        Casillero casillero = new Casillero(new Coordenada(1, 1), new Jugador());

        // Assert
        casillero.quitarUnidad();
    }

    @Test
    public void casilleroOcupadoQuitarUnidadNoLanzaExcepcion()
            throws CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        // Arrange
        Casillero casillero = new Casillero(new Coordenada(1, 1), new Jugador());
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Unidad unidad = new Soldado(bando);

        // Act
        casillero.setUnidad(unidad);

        // Assert
        casillero.quitarUnidad();
    }

    @Test(expected = CasilleroVacioExcepcion.class)
    public void casilleroOcupadoQuitarUnidadCasilleroQuedaVacio() throws CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        // Arrange
        Casillero casillero = new Casillero(new Coordenada(1, 1), new Jugador());
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Unidad unidad = new Soldado(bando);

        // Act
        casillero.setUnidad(unidad);
        casillero.quitarUnidad();

        // Assert
        // Tras quitar la unidad, get unidad debe lanzar CasilleroVacioExcepcion
        casillero.getUnidad();
    }

    @Test
    public void casilleroSetUnidadAlInicioDelJuegoGetUnidadRetornaUnidadEnCuestion()
            throws CasilleroOcupadoExcepcion, CasilleroVacioExcepcion, CasilleroEnemigoExcepcion {
        // Arrange
        Jugador jugador = new Jugador();
        Casillero casillero = new Casillero(new Coordenada(1, 1), jugador);
        Bando bando = new Bando(jugador);
        Unidad unidad = new Soldado(bando);

        // Act
        casillero.setUnidadAlInicioDelJuego(unidad);

        // Assert
        assertEquals(unidad, casillero.getUnidad());
    }

    @Test(expected = CasilleroEnemigoExcepcion.class)
    public void casilleroSetUnidadAlInicioDelJuegoCasilleroEnemigoRetornaExcepcion()
            throws CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion {
        // Arrange
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Unidad unidad = new Soldado(bando);
        Jugador jugadorEnemigo = new Jugador();
        Casillero casillero = new Casillero(new Coordenada(1, 1), jugadorEnemigo);

        // Act Assert
        casillero.setUnidadAlInicioDelJuego(unidad);
    }
}
