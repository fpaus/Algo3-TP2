package EntidadesTests;
import static org.junit.Assert.assertTrue;

import Algo3TP2.Modelos.*;
import org.junit.Test;

public class UnidadTest {

    @Test
    public void unidadMovibleSePuedeMoverEnTodasDireccionesTest(){
        /*Jugador j1 = new Jugador();
        Tablero tablero = new Tablero(20,20, j1, new Jugador());

        Unidad unidad = new Soldado();
        Casillero casillero = tablero.getCasilleroEnPosicion(2,2);
        unidad.colocarEnCasillero(casillero);
        //me muevo hacia arriba
        unidad.mover(tablero.getCasilleroEnPosicion(2,3));
        assertTrue(unidad.getCasillero() == tablero.getCasilleroEnPosicion(2,3));
        //me muevo hacia abajo
        unidad.mover(tablero.getCasilleroEnPosicion(2,2));
        assertTrue(unidad.getCasillero() == tablero.getCasilleroEnPosicion(2,2));
        //me muevo hacia la izquierda
        unidad.mover(tablero.getCasilleroEnPosicion(1,2));
        assertTrue(unidad.getCasillero() == tablero.getCasilleroEnPosicion(1,2));
        //me muevo hacia la derecha
        unidad.mover(tablero.getCasilleroEnPosicion(1,1));
        assertTrue(unidad.getCasillero() == tablero.getCasilleroEnPosicion(2,2));
        //me muevo hacia arriba - izquierda
        unidad.mover(tablero.getCasilleroEnPosicion(1,2));
        assertTrue(unidad.getCasillero() == tablero.getCasilleroEnPosicion(2,2));
        //me muevo hacia abajo, derecha
        unidad.mover(tablero.getCasilleroEnPosicion(1,3));
        assertTrue(unidad.getCasillero() == tablero.getCasilleroEnPosicion(1,3));
        ////me muevo hacia arriba - derecha
        unidad.mover(tablero.getCasilleroEnPosicion(2,2));
        assertTrue(unidad.getCasillero() == tablero.getCasilleroEnPosicion(2,2));
        //me muevo hacia abajo - izquierda
        unidad.mover(tablero.getCasilleroEnPosicion(3,3));
        assertTrue(unidad.getCasillero() == tablero.getCasilleroEnPosicion(3,3));
        */
    }
    @Test
    public void unidadMovibleNoPuedeMoverseAUnCasilleroOcupadoTest(){

    }
    @Test
    public void soldadoDeInfanteriaAliadoAtacaPiezaEnemigaSeVerificaQueSeRestaVidaCorrecpondienteTest(){

    }

    @Test
    public void jineteAliadoAtacaPiezaEnemigaSeVerificaQueSeRestaVidaCorrespondienteTest(){

    }
    @Test
    public void curanderoAliadoCuraPiezaAliadaSeVerificaQueSeSumaVidaCorrespondienteTest(){

    }

    @Test
    public void catapultaAliadaAtacaPiezaEnemigaSeVerificaQueSeRestaVidaCorrespondienteTest(){

    }


}
