package Algo3TP2.EntidadesTests;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Jugador;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Unidades.ExcepcionesMovimientos.MovimientoNoContiguoExcepcion;
import Algo3TP2.Modelos.Unidades.Soldado;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Modelos.Unidades.UnidadMovible;
import org.junit.Test;

public class UnidadMovibleMovimientosTest {


    @Test(expected = CasilleroOcupadoExcepcion.class)
    public void UnidadMovilbleNoSePuedeMoverACasillaContiguaOcupada()
            throws CasilleroOcupadoExcepcion, MovimientoNoContiguoExcepcion, CasilleroVacioExcepcion {
        // Arrange
        Jugador jugador = new Jugador();
        Casillero casillero = new Casillero(new Coordenada(1, 1), jugador);
        Casillero casilleroContiguoOcupado = new Casillero(new Coordenada(2, 1), jugador);

        Unidad unidadOcupante = new Soldado(new Bando(jugador));
        unidadOcupante.colocarEnCasillero(casilleroContiguoOcupado);

        UnidadMovible soldado = new Soldado(new Bando(jugador));
        soldado.colocarEnCasillero(casillero);

        // Act
        soldado.mover(casilleroContiguoOcupado);
    }

}
