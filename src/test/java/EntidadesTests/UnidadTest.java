package EntidadesTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import Algo3TP2.Modelos.*;
import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Unidades.MovimientoInvalidoExcepcion;
import Algo3TP2.Modelos.Unidades.Soldado;
import Algo3TP2.Modelos.Unidades.UnidadMovible;
import org.junit.Test;

public class UnidadTest {

    @Test
    public void unidadMovibleSePuedeMoverEnTodasDireccionesTest()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
        Jugador j1 = new Jugador();
        Tablero tablero = new Tablero(20,20, j1, new Jugador());
        UnidadMovible unidad = new Soldado(new Bando(j1));

        Casillero casillero = tablero.getCasilleroEnPosicion(2,2);
        unidad.colocarEnCasillero(casillero);

        //me muevo hacia arriba
        unidad.mover(tablero.getCasilleroEnPosicion(2,3));
        assertEquals(unidad.getCasillero(), tablero.getCasilleroEnPosicion(2,3));
        //me muevo hacia abajo
        unidad.mover(tablero.getCasilleroEnPosicion(2,2));
        assertEquals(unidad.getCasillero(), tablero.getCasilleroEnPosicion(2,2));
        //me muevo hacia la izquierda
        unidad.mover(tablero.getCasilleroEnPosicion(1,2));
        assertEquals(unidad.getCasillero(), tablero.getCasilleroEnPosicion(1,2));
        //me muevo hacia la derecha
        unidad.mover(tablero.getCasilleroEnPosicion(2,2));
        assertEquals(unidad.getCasillero(),tablero.getCasilleroEnPosicion(2,2));
        //me muevo hacia arriba - izquierda
        unidad.mover(tablero.getCasilleroEnPosicion(1,3));
        assertEquals(unidad.getCasillero(), tablero.getCasilleroEnPosicion(1,3));
        //me muevo hacia abajo, derecha
        unidad.mover(tablero.getCasilleroEnPosicion(2,2));
        assertEquals(unidad.getCasillero(), tablero.getCasilleroEnPosicion(2,2));
        ////me muevo hacia arriba - derecha
        unidad.mover(tablero.getCasilleroEnPosicion(3,3));
        assertEquals(unidad.getCasillero(), tablero.getCasilleroEnPosicion(3,3));
        //me muevo hacia abajo - izquierda
        unidad.mover(tablero.getCasilleroEnPosicion(2,2));
        assertEquals(unidad.getCasillero(), tablero.getCasilleroEnPosicion(2,2));

    }
    /*
    @Test
    public void unidadMovibleNoPuedeMoverseAUnCasilleroOcupadoTest() {

    }

    @Test
    public void soldadoDeInfanteriaAliadoAtacaPiezaEnemigaSeVerificaQueSeRestaVidaCorrecpondienteTest() {

    }

    @Test
    public void jineteAliadoAtacaPiezaEnemigaSeVerificaQueSeRestaVidaCorrespondienteTest() {

    }

    @Test
    public void curanderoAliadoCuraPiezaAliadaSeVerificaQueSeSumaVidaCorrespondienteTest() {

    }

    @Test
    public void catapultaAliadaAtacaPiezaEnemigaSeVerificaQueSeRestaVidaCorrespondienteTest() {

    }
    */

}
