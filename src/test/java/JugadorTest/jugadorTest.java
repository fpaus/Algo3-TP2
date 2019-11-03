package JugadorTest;

import Algo3TP2.Modelos.Casillero;
import Algo3TP2.Modelos.Jugador;
import Algo3TP2.Modelos.Tablero;
import Algo3TP2.Modelos.Unidad;
import org.junit.Test;

public class jugadorTest {

    @Test(expected = PuntosInsuficientesParaColocarUnidad.class)
    public void JugadorNoPuedeTomarMásEntidadesDeLoQueSusPuntosLePermitenTest() {
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador();
        jugador.ColocarUnidadEnCasillero(new Catapulta catapulta, getCasilleroEnPosicion(1,2));
        jugador.ColocarUnidadEnCasillero(new Catapulta catapulta, getCasilleroEnPosicion(1,2));
        jugador.ColocarUnidadEnCasillero(new Catapulta catapulta, getCasilleroEnPosicion(1,2));
        jugador.ColocarUnidadEnCasillero(new Catapulta catapulta, getCasilleroEnPosicion(1,2));
        //Tira excepcion
        jugador.ColocarUnidadEnCasillero(new Catapulta catapulta, getCasilleroEnPosicion(1,2));
    }

    @Test
    public void ElJugadorQueSeQuedaSinEntidadesEsElPerdedorTest(){
        Tablero tablero = new Tablero();
        //jugador se crea con 20 puntos
        Jugador jugador = new Jugador();
        jugador.
    }

}
