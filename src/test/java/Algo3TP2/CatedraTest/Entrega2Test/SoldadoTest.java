package Algo3TP2.CatedraTest.Entrega2Test;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Jugador;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Unidades.ExcepcionesBatallon.BatallonIncompletoExcepcion;
import Algo3TP2.Modelos.Unidades.Soldado;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SoldadoTest {

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
    /*se verifica que 3 soldados contiguos pueden moverse al mismo
    tiempo en la misma dirección con una sola acción.
    */
    public void tresSoldadosContiguosPuedenMoverseEnUnaSolaAccion() throws Exception {
        // Arrange
        Soldado soldado1 = new Soldado(bandoAliado);
        Soldado soldado2 = new Soldado(bandoAliado);
        Soldado soldado3 = new Soldado(bandoAliado);
        tablero.posicionarUnidad(soldado1, new Coordenada(2, 1));
        tablero.posicionarUnidad(soldado2, new Coordenada(2, 2));
        tablero.posicionarUnidad(soldado3, new Coordenada(2, 3));

        // Act
        soldado1.moverComoBatallonHaciaLaDerecha();

        // Assert
        assertEquals(soldado1.getCasillero(), tablero.getCasilleroEnCoordenada(new Coordenada(3, 1)));
        assertEquals(soldado2.getCasillero(), tablero.getCasilleroEnCoordenada(new Coordenada(3, 2)));
        assertEquals(soldado3.getCasillero(), tablero.getCasilleroEnCoordenada(new Coordenada(3, 3)));
    }

    @Test
    /*Teniendo 3 soldados contiguos, y un obstáculo (una entidad distinta
    a los otros dos soldados) obstruyendo a uno de los 3, se verifica que
    al mover el Batallón, se mueven 2 soldados y uno se queda quieto.*/
    public void tresSoldadosContiguosSeMuevenPeroUnoQuedaObstaculizado() throws Exception {
        // Arrange
        Soldado soldado1 = new Soldado(bandoAliado);
        Soldado soldado2 = new Soldado(bandoAliado);
        Soldado soldado3 = new Soldado(bandoAliado);
        Soldado soldadoObstaculo = new Soldado(bandoEnemigo);
        tablero.posicionarUnidad(soldado1, new Coordenada(2, 1));
        tablero.posicionarUnidad(soldado2, new Coordenada(2, 2));
        tablero.posicionarUnidad(soldado3, new Coordenada(2, 3));
        tablero.posicionarUnidad(soldadoObstaculo, new Coordenada(3, 3));

        // Act
        soldado1.moverComoBatallonHaciaLaDerecha();

        // Assert
        assertEquals(soldado1.getCasillero(), tablero.getCasilleroEnCoordenada(new Coordenada(3, 1)));
        assertEquals(soldado2.getCasillero(), tablero.getCasilleroEnCoordenada(new Coordenada(3, 2)));
        assertEquals(soldado3.getCasillero(), tablero.getCasilleroEnCoordenada(new Coordenada(2, 3)));
    }

    @Test(expected = BatallonIncompletoExcepcion.class)
    /*(En la situación anterior) Se verifica que
    el Batallón se disuelve, al quedar separados
    los 3 soldados.*/
    public void batallonObstaculizadoSeDisuelve() throws Exception {
        // Arrange
        Soldado soldado1 = new Soldado(bandoAliado);
        Soldado soldado2 = new Soldado(bandoAliado);
        Soldado soldado3 = new Soldado(bandoAliado);
        Soldado soldadoObstaculo = new Soldado(bandoEnemigo);
        tablero.posicionarUnidad(soldado1, new Coordenada(2, 1));
        tablero.posicionarUnidad(soldado2, new Coordenada(2, 2));
        tablero.posicionarUnidad(soldado3, new Coordenada(2, 3));
        tablero.posicionarUnidad(soldadoObstaculo, new Coordenada(3, 3));

        // Act
        soldado1.moverComoBatallonHaciaLaDerecha();
        // Aun se encuentra a distancia 1 como para continuar siendo parte del batallon
        soldado1.moverComoBatallonHaciaLaDerecha();

        // Assert
        soldado1.moverComoBatallonHaciaLaDerecha();
    }

    @Test
    /*habiendo 4 soldados contiguos, se verifica que al
    mover un Batallón se mueven únicamente 3.*/
    public void batallonMueveSoloTresSoldadosYNoCuatro() throws Exception {
        // Arrange
        Soldado soldado1 = new Soldado(bandoAliado);
        Soldado soldado2 = new Soldado(bandoAliado);
        Soldado soldado3 = new Soldado(bandoAliado);
        Soldado soldado4 = new Soldado(bandoAliado);
        soldado1.colocarEnCasillero(tablero.getCasilleroEnCoordenada(new Coordenada(2, 1)));
        soldado2.colocarEnCasillero(tablero.getCasilleroEnCoordenada(new Coordenada(2, 2)));
        soldado3.colocarEnCasillero(tablero.getCasilleroEnCoordenada(new Coordenada(2, 3)));
        soldado4.colocarEnCasillero(tablero.getCasilleroEnCoordenada(new Coordenada(2, 4)));

        // Act
        soldado1.moverComoBatallonHaciaLaDerecha();

        // Assert
        assertEquals(soldado1.getCasillero(), tablero.getCasilleroEnCoordenada(new Coordenada(3, 1)));
        assertEquals(soldado2.getCasillero(), tablero.getCasilleroEnCoordenada(new Coordenada(3, 2)));
        assertEquals(soldado3.getCasillero(), tablero.getCasilleroEnCoordenada(new Coordenada(3, 3)));
        assertEquals(soldado4.getCasillero(), tablero.getCasilleroEnCoordenada(new Coordenada(2, 4)));
    }

    // @Test
    // /*se verifica que 3 soldados contiguos pueden moverse al mismo
    // tiempo en la misma dirección con una sola acción.
    // */
    // public void tresSoldadosContiguosNoSeObtaculizanEntreEllos() throws Exception {
    //     // Arrange
    //     Soldado soldado1 = new Soldado(bandoAliado);
    //     Soldado soldado2 = new Soldado(bandoAliado);
    //     Soldado soldado3 = new Soldado(bandoAliado);
    //     tablero.posicionarUnidad(soldado1, new Coordenada(2, 1));
    //     tablero.posicionarUnidad(soldado2, new Coordenada(2, 2));
    //     tablero.posicionarUnidad(soldado3, new Coordenada(2, 3));

    //     // Act
    //     soldado1.moverComoBatallonHaciaAbajo();

    //     // Assert
    //     assertEquals(soldado1.getCasillero(), tablero.getCasilleroEnCoordenada(new Coordenada(3, 1)));
    //     assertEquals(soldado2.getCasillero(), tablero.getCasilleroEnCoordenada(new Coordenada(3, 2)));
    //     assertEquals(soldado3.getCasillero(), tablero.getCasilleroEnCoordenada(new Coordenada(3, 3)));
    // }
}
