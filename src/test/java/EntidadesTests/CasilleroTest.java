package EntidadesTests;

import Algo3TP2.ExcepcionesCasillero.*;
import Algo3TP2.Modelos.Casillero;
import Algo3TP2.Modelos.Jugador;
import Algo3TP2.Modelos.Soldado;
import Algo3TP2.Modelos.Unidad;
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
        Unidad unidadEnCasillero = new Soldado();

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
        Unidad unidadEnCasillero = new Soldado();
        Unidad unidadNueva = new Soldado();

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
        Unidad unidad = new Soldado();

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
        Unidad unidad = new Soldado();

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
    public void casilleroVacioQuitarUnidadLanzaExcepcion(){
        // Arrange
        Casillero casillero = new Casillero(1, 1, new Jugador());

        // Assert
        try {
            casillero.quitarUnidad();
            assert (false);
        } catch (CasilleroVacioExcepcion ex){
            assert (true);
        }
    }

    @Test
    public void casilleroOcupadoQuitarUnidadNoLanzaExcepcion() throws CasilleroOcupadoExcepcion{
        // Arrange
        Casillero casillero = new Casillero(1, 1, new Jugador());
        Unidad unidad = new Soldado();

        // Act
        casillero.setUnidad(unidad);

        // Assert
        try {
            casillero.quitarUnidad();
            assert (true);
        } catch (CasilleroVacioExcepcion ex){
            assert (false);
        }
    }

    @Test
    public void casilleroOcupadoQuitarUnidadCasilleroQuedaVacio() throws CasilleroOcupadoExcepcion, CasilleroVacioExcepcion{
        // Arrange
        Casillero casillero = new Casillero(1, 1, new Jugador());
        Unidad unidad = new Soldado();

        // Act
        casillero.setUnidad(unidad);
        casillero.quitarUnidad();

        // Assert
        // Tras quitar la unidad, get unidad debe lanzar CasilleroVacioExcepcion
        try {
            casillero.getUnidad();
            assert (false);
        } catch (CasilleroVacioExcepcion ex){
            assert (true);
        }
    }
}
