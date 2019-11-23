package Algo3TP2.CatedraTest.Entrega1Test;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Jugador;
import Algo3TP2.Modelos.PuntosInsuficientesExcepcion;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.UnidadInvalidaException;
import Algo3TP2.Modelos.Unidades.Catapulta;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Properties;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JugadorTest {

    @Test(expected = PuntosInsuficientesExcepcion.class)
    public void jugadorNoPuedeTomarMasEntidadesDeLoQueSusPuntosLePermitenTest()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, PuntosInsuficientesExcepcion,
            CasilleroOcupadoExcepcion {
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Tablero tablero = Tablero.getTablero();
        tablero.inicializarTablero(20, 20, jugador, new Jugador());

        jugador.colocarUnidadEnCasillero(new Catapulta(bando), tablero.getCasilleroEnCoordenada(new Coordenada(1, 2)));
        jugador.colocarUnidadEnCasillero(new Catapulta(bando), tablero.getCasilleroEnCoordenada(new Coordenada(1, 3)));
        jugador.colocarUnidadEnCasillero(new Catapulta(bando), tablero.getCasilleroEnCoordenada(new Coordenada(1, 4)));
        jugador.colocarUnidadEnCasillero(new Catapulta(bando), tablero.getCasilleroEnCoordenada(new Coordenada(1, 6)));
        // Lanza excepcion
        jugador.colocarUnidadEnCasillero(new Catapulta(bando), tablero.getCasilleroEnCoordenada(new Coordenada(1, 6)));

    }

    public void elJugadorQueSeQuedaSinEntidadesEsElPerdedorTest() throws PuntosInsuficientesExcepcion,
            CasilleroFueraDelLosLimitesDelTableroExcepcion, UnidadInvalidaException, CasilleroOcupadoExcepcion {
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Tablero tablero = Tablero.getTablero();
        tablero.inicializarTablero(20, 20, jugador, new Jugador());

        Unidad unidad1 = new Catapulta(bando);
        Unidad unidad2 = new Catapulta(bando);
        Unidad unidad3 = new Catapulta(bando);
        Unidad unidad4 = new Catapulta(bando);

        jugador.colocarUnidadEnCasillero(unidad1, tablero.getCasilleroEnCoordenada(new Coordenada(1, 2)));
        jugador.colocarUnidadEnCasillero(unidad2, tablero.getCasilleroEnCoordenada(new Coordenada(1, 3)));
        jugador.colocarUnidadEnCasillero(unidad3, tablero.getCasilleroEnCoordenada(new Coordenada(1, 4)));
        jugador.colocarUnidadEnCasillero(unidad4, tablero.getCasilleroEnCoordenada(new Coordenada(1, 5)));

        unidad1.recibirDanio(Properties.vidaCatapulta);
        unidad2.recibirDanio(Properties.vidaCatapulta);
        unidad3.recibirDanio(Properties.vidaCatapulta);
        unidad4.recibirDanio(Properties.vidaCatapulta);
        assertEquals(jugador.sigueEnJuego(), false);
    }
}
