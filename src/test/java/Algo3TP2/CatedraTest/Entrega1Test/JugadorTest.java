package Algo3TP2.CatedraTest.Entrega1Test;

import Algo3TP2.Modelos.*;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Unidades.Catapulta;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Properties;
import Algo3TP2.Modelos.Turnador;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JugadorTest {

    private Tablero tablero;
    private Bando bandoAliado, bandoEnemigo;
    private Jugador jugadorAliado, jugadorEnemigo;

    @Before // Inicializo el tablero y los bandos Aliados/Enemigos
    public void before() {
        this.jugadorAliado = new Jugador("JugadorAliado");
        bandoAliado = new Bando(jugadorAliado);
        this.jugadorEnemigo = new Jugador("JugadorEnemigo");
        bandoEnemigo = new Bando(jugadorEnemigo);
        tablero = Tablero.getTablero();
        tablero.inicializarTablero(20, 20, jugadorAliado, jugadorEnemigo);
    }

    @Test(expected = PuntosInsuficientesExcepcion.class)
    public void jugadorNoPuedeTomarMasEntidadesDeLoQueSusPuntosLePermitenTest() throws Exception {

        jugadorAliado.colocarUnidadEnCasillero(new Catapulta(bandoAliado), tablero.getCasilleroEnCoordenada(new Coordenada(1, 2)));
        jugadorAliado.colocarUnidadEnCasillero(new Catapulta(bandoAliado), tablero.getCasilleroEnCoordenada(new Coordenada(1, 3)));
        jugadorAliado.colocarUnidadEnCasillero(new Catapulta(bandoAliado), tablero.getCasilleroEnCoordenada(new Coordenada(1, 4)));
        jugadorAliado.colocarUnidadEnCasillero(new Catapulta(bandoAliado), tablero.getCasilleroEnCoordenada(new Coordenada(1, 6)));
        jugadorAliado.colocarUnidadEnCasillero(new Catapulta(bandoAliado), tablero.getCasilleroEnCoordenada(new Coordenada(1, 7)));
        // Lanza excepcion

        jugadorAliado.colocarUnidadEnCasillero(new Catapulta(bandoAliado), tablero.getCasilleroEnCoordenada(new Coordenada(1, 8)));
    }


    @Test(expected = JugadorSinUnidadesExcepcion.class)
    public void elJugadorQueSeQuedaSinEntidadesEsElPerdedorTest() throws Exception {
        Turnador turnador = new Turnador(jugadorAliado, jugadorEnemigo);

        Unidad unidadAliada = new Catapulta(bandoAliado);
        jugadorAliado.colocarUnidadEnCasillero(unidadAliada, tablero.getCasilleroEnCoordenada(new Coordenada(1, 2)));

        Unidad unidadEnemiga = new Catapulta(bandoEnemigo);
        jugadorEnemigo.colocarUnidadEnCasillero(unidadEnemiga, tablero.getCasilleroEnCoordenada(new Coordenada(1, 3)));

        unidadAliada.recibirDanio(Properties.vidaCatapulta);

        turnador.getJugadorSiguienteTurno();
    }

}