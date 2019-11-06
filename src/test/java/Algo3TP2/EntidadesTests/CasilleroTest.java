package Algo3TP2.EntidadesTests;

import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.*;
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
        casillero = new Casillero(1, 1, new Jugador());

        // Assert
        assertFalse(casillero == null);
    }

    @Test
    public void casilleroNuevoSeEncuentraVacioTest() {
        // Arrenge
        Casillero casillero = new Casillero(1, 1, new Jugador());
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Unidad unidadEnCasillero = new Soldado(bando);

        // act, assert
        // Intento setear una unidad en un casillero que deberia estar vacio
        // si se encuentra vacio no deberia lanzar excepcion
        try {
            casillero.setUnidad(unidadEnCasillero);
            assert (true);
        } catch (CasilleroOcupadoExcepcion ex) {
            assert (false);
        }
    }

    @Test
    public void casilleroNuevoSeLeSeteaUnidadAhoraSeEncuentraOcupadoTest() throws CasilleroOcupadoExcepcion {
        // Arrenge
        Casillero casillero = new Casillero(1, 1, new Jugador());
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Unidad unidadEnCasillero = new Soldado(bando);
        Unidad unidadNueva = new Soldado(bando);

        // act
        casillero.setUnidad(unidadEnCasillero);

        // Assert
        // Intento setear una unidad en un casillero que deberia estar ocupado
        // si se encuentra ocupado debe lanzar excepcion
        try {
            casillero.setUnidad(unidadNueva);
            assert (false);
        } catch (CasilleroOcupadoExcepcion ex) {
            assert (true);
        }
    }

    @Test
    public void casilleroVacioGetUnidadLanzaExcepcion() throws CasilleroOcupadoExcepcion {
        // Arrange
        Casillero casillero = new Casillero(1, 1, new Jugador());
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Unidad unidad = new Soldado(bando);

        // Assert
        try {
            Unidad unidadEnCasillero = casillero.getUnidad();
            assert (false);
        } catch (CasilleroVacioExcepcion ex) {
            assert (true);
        }
    }

    @Test
    public void casilleroSeLeSeteaUnidadGetUnidadRetornaUnidadEnCuestion() throws CasilleroOcupadoExcepcion {
        // Arrange
        Casillero casillero = new Casillero(1, 1, new Jugador());
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Unidad unidad = new Soldado(bando);

        // Act
        casillero.setUnidad(unidad);

        // Assert
        try {
            Unidad unidadEnCasillero = casillero.getUnidad();
            assertEquals(unidad, unidadEnCasillero);
        } catch (CasilleroVacioExcepcion ex) {
            assert (false);
        }
    }

    @Test
    public void casilleroVacioQuitarUnidadLanzaExcepcion() {
        // Arrange
        Casillero casillero = new Casillero(1, 1, new Jugador());

        // Assert
        try {
            casillero.quitarUnidad();
            assert (false);
        } catch (CasilleroVacioExcepcion ex) {
            assert (true);
        }
    }

    @Test
    public void casilleroOcupadoQuitarUnidadNoLanzaExcepcion() throws CasilleroOcupadoExcepcion {
        // Arrange
        Casillero casillero = new Casillero(1, 1, new Jugador());
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Unidad unidad = new Soldado(bando);

        // Act
        casillero.setUnidad(unidad);

        // Assert
        try {
            casillero.quitarUnidad();
            assert (true);
        } catch (CasilleroVacioExcepcion ex) {
            assert (false);
        }
    }

    @Test
    public void casilleroOcupadoQuitarUnidadCasilleroQuedaVacio() throws CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        // Arrange
        Casillero casillero = new Casillero(1, 1, new Jugador());
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Unidad unidad = new Soldado(bando);

        // Act
        casillero.setUnidad(unidad);
        casillero.quitarUnidad();

        // Assert
        // Tras quitar la unidad, get unidad debe lanzar CasilleroVacioExcepcion
        try {
            casillero.getUnidad();
            assert (false);
        } catch (CasilleroVacioExcepcion ex) {
            assert (true);
        }
    }
}
