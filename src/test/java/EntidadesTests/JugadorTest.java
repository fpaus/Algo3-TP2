package EntidadesTests;

import Algo3TP2.Modelos.Catapulta;
import Algo3TP2.Modelos.Jugador;
import Algo3TP2.Modelos.Tablero;
import Algo3TP2.Modelos.Unidad;
import org.junit.Test;

public class JugadorTest {

    @Test//(expected = PuntosInsuficientesException.class)
    public void jugadorNoPuedeTomarMásEntidadesDeLoQueSusPuntosLePermitenTest() {
        Jugador jugador = new Jugador();
        Tablero tablero = new Tablero(20, 20 , jugador, new Jugador());

        jugador.colocarUnidadEnCasillero(new Catapulta(), tablero.getCasilleroEnPosicion(1,2));
        jugador.colocarUnidadEnCasillero(new Catapulta(), tablero.getCasilleroEnPosicion(1,2));
        jugador.colocarUnidadEnCasillero(new Catapulta(), tablero.getCasilleroEnPosicion(1,2));
        jugador.colocarUnidadEnCasillero(new Catapulta(), tablero.getCasilleroEnPosicion(1,2));
        //Tira excepcion
        jugador.colocarUnidadEnCasillero(new Catapulta(), tablero.getCasilleroEnPosicion(1,2));
    }

//    @Test//(expected = JugadorSinUnidadesException.class)
//    public void elJugadorQueSeQuedaSinEntidadesEsElPerdedorTest(){
//        Tablero tablero = new Tablero();
//        //jugador se crea con 20 puntos
//        Jugador jugador = new Jugador();
//        Unidad unidad = new Catapulta();
//        jugador.colocarUnidadEnCasillero(unidad, tablero.getCasilleroEnPosicion(1,2));
//        unidad.morir();
//        assertEqual(juego.siguienteTurno());}



}
