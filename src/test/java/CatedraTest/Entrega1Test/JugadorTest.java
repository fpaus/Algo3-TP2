package CatedraTest.Entrega1Test;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Jugador;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Unidades.Catapulta;
import Algo3TP2.Modelos.Unidades.PuntosInsuficientesExcepcion;
import org.junit.Test;

public class JugadorTest {

    @Test(expected = PuntosInsuficientesExcepcion.class)
    public void jugadorNoPuedeTomarMásEntidadesDeLoQueSusPuntosLePermitenTest()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, PuntosInsuficientesExcepcion {
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Tablero tablero = new Tablero(20, 20 , jugador, new Jugador());

        jugador.colocarUnidadEnCasillero(new Catapulta(bando), tablero.getCasilleroEnPosicion(1,2));
        jugador.colocarUnidadEnCasillero(new Catapulta(bando), tablero.getCasilleroEnPosicion(1,2));
        jugador.colocarUnidadEnCasillero(new Catapulta(bando), tablero.getCasilleroEnPosicion(1,2));
        jugador.colocarUnidadEnCasillero(new Catapulta(bando), tablero.getCasilleroEnPosicion(1,2));
        // Lanza excepcion
        jugador.colocarUnidadEnCasillero(new Catapulta(bando), tablero.getCasilleroEnPosicion(1,2));

    }
/*
    @Test//(expected = JugadorSinUnidadesException.class)
    public void elJugadorQueSeQuedaSinEntidadesEsElPerdedorTest(){
       Tablero tablero = new Tablero();
        // jugador se crea con 20 puntos
        Jugador jugador = new Jugador();
        Unidad unidad = new Catapulta();
        jugador.colocarUnidadEnCasillero(unidad, tablero.getCasilleroEnPosicion(1,2));
        unidad.morir();
        assertEqual(juego.siguienteTurno());}
*/

}
