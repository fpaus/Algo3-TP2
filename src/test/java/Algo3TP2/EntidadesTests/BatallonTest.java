package Algo3TP2.EntidadesTests;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Jugador;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Unidades.ExcepcionesBatallon.BatallonIncompletoExcepcion;
import Algo3TP2.Modelos.Unidades.Soldado;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BatallonTest {

    private Tablero tablero;
    private Bando bandoAliado, bandoEnemigo;

    @Before // Inicializo el tablero y los bandos Aliados/Enemigos
    public void before() {
        Jugador jugadorAliado = new Jugador();
        bandoAliado = new Bando(jugadorAliado);
        Jugador jugadorEnemigo = new Jugador();
        bandoEnemigo = new Bando(jugadorEnemigo);
        tablero = Tablero.getTablero();
        tablero.inicializarTablero(20, 20, jugadorAliado, jugadorEnemigo);
    }

    @Test
    public void tresSoldadosSePuedenMoverComoBatallonTest() throws Exception {
        // Arrange
        Soldado soldado1 = new Soldado(bandoAliado);
        tablero.posicionarUnidad(soldado1, new Coordenada(2, 1));
        Soldado soldado2 = new Soldado(bandoAliado);
        tablero.posicionarUnidad(soldado2, new Coordenada(2, 2));
        Soldado soldado3 = new Soldado(bandoAliado);
        tablero.posicionarUnidad(soldado3, new Coordenada(2, 3));

        // Act
        soldado1.moverComoBatallonHaciaLaDerecha();

        // Assert
        assertEquals(soldado1.getCasillero(), tablero.getCasilleroEnCoordenada(new Coordenada(3, 1)));
        assertEquals(soldado2.getCasillero(), tablero.getCasilleroEnCoordenada(new Coordenada(3, 2)));
        assertEquals(soldado3.getCasillero(), tablero.getCasilleroEnCoordenada(new Coordenada(3, 3)));
    }

    @Test(expected = BatallonIncompletoExcepcion.class)
    public void dosSoldadosSePuedenMoverComoBatallonTest() throws Exception {
        Soldado soldado1 = new Soldado(bandoAliado);
        tablero.posicionarUnidad(soldado1, new Coordenada(2, 1));
        Soldado soldado2 = new Soldado(bandoAliado);
        tablero.posicionarUnidad(soldado2, new Coordenada(2, 2));

        // Assert
        soldado1.moverComoBatallonHaciaLaDerecha();
    }

    @Test(expected = BatallonIncompletoExcepcion.class)
    public void unSoldadosSePuedenMoverComoBatallonTest() throws Exception {
        Soldado soldado1 = new Soldado(bandoAliado);
        tablero.posicionarUnidad(soldado1, new Coordenada(2, 1));

        // Assert
        soldado1.moverComoBatallonHaciaLaDerecha();
    }
}