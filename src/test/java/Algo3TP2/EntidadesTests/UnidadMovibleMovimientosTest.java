package Algo3TP2.EntidadesTests;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Jugador;
import Algo3TP2.Modelos.Unidades.ExcepcionesMovimientos.MovimientoNoContiguoExcepcion;
import Algo3TP2.Modelos.Unidades.Soldado;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Modelos.Unidades.UnidadMovible;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnidadMovibleMovimientosTest {

    @Test
    public void UnidadMovilbleSePuedeMoverACasillaContigua() throws CasilleroOcupadoExcepcion, MovimientoNoContiguoExcepcion {
        // Arrange
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Casillero casillero = new Casillero(1,1,jugador);
        Casillero casilleroContiguo = new Casillero(2,1,jugador);
        UnidadMovible soldado = new Soldado(bando);
        soldado.colocarEnCasillero(casillero);
        casillero.setUnidad(soldado);

        // Act
        soldado.mover(casilleroContiguo);

        // Assert
        assertEquals(casilleroContiguo, soldado.getCasillero());
    }

    @Test(expected = MovimientoNoContiguoExcepcion.class)
    public void UnidadMovilbleNoSePuedeMoverACasillaNoContigua() throws CasilleroOcupadoExcepcion, MovimientoNoContiguoExcepcion {
        // Arrange
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Casillero casillero = new Casillero(1,1,jugador);
        Casillero casilleroNoContiguo = new Casillero(3,1,jugador);
        UnidadMovible soldado = new Soldado(bando);
        soldado.colocarEnCasillero(casillero);
        casillero.setUnidad(soldado);

        // Act Assert
        soldado.mover(casilleroNoContiguo);
    }

    @Test(expected = CasilleroOcupadoExcepcion.class)
    public void UnidadMovilbleNoSePuedeMoverACasillaContiguaOcupada()
            throws CasilleroOcupadoExcepcion, MovimientoNoContiguoExcepcion {
        // Arrange
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Casillero casillero = new Casillero(1,1,jugador);
        Casillero casilleroContiguoOcupado = new Casillero(2,1,jugador);
        Unidad unidadOcupante = new Soldado(bando);
        casilleroContiguoOcupado.setUnidad(unidadOcupante);

        UnidadMovible soldado = new Soldado(bando);
        soldado.colocarEnCasillero(casillero);
        casillero.setUnidad(soldado);

        // Act
        soldado.mover(casilleroContiguoOcupado);
    }

}
