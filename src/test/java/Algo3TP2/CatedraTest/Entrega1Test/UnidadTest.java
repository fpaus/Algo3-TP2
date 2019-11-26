package Algo3TP2.CatedraTest.Entrega1Test;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Jugador;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Unidades.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnidadTest {

    private Tablero tablero;
    private Bando bandoAliado, bandoEnemigo;

    @Before // Inicializo el tablero y los bandos Aliados/Enemigos
    public void before() {
        Jugador jugadorAliado = new Jugador("JugadorAliado");
        bandoAliado = new Bando(jugadorAliado);
        Jugador jugadorEnemigo = new Jugador("JugadorEnemigo");
        bandoEnemigo = new Bando(jugadorEnemigo);
        tablero = Tablero.getTablero();
        tablero.inicializarTablero(20, 20, jugadorAliado, jugadorEnemigo);
    }

    @Test
    public void unidadMovibleSePuedeMoverEnTodasDireccionesTest() throws Exception {

        UnidadMovible unidad = new Soldado(bandoAliado);
        tablero.posicionarUnidad(unidad, new Coordenada(2, 2));

        unidad.moverHaciaArriba();
        assertEquals(unidad.getCasillero(), tablero.getCasilleroEnCoordenada(new Coordenada(2, 3)));

        unidad.moverHaciaAbajo();
        assertEquals(unidad.getCasillero(), tablero.getCasilleroEnCoordenada(new Coordenada(2, 2)));

        unidad.moverHaciaLaIzquierda();
        assertEquals(unidad.getCasillero(), tablero.getCasilleroEnCoordenada(new Coordenada(1, 2)));

        unidad.moverHaciaLaDerecha();
        assertEquals(unidad.getCasillero(), tablero.getCasilleroEnCoordenada(new Coordenada(2, 2)));

        unidad.moverHaciaLaIzquierdaArriba();
        assertEquals(unidad.getCasillero(), tablero.getCasilleroEnCoordenada(new Coordenada(1, 3)));

        unidad.moverHaciaLaDerechaAbajo();
        assertEquals(unidad.getCasillero(), tablero.getCasilleroEnCoordenada(new Coordenada(2, 2)));

        unidad.moverHaciaLaDerechaArriba();
        assertEquals(unidad.getCasillero(), tablero.getCasilleroEnCoordenada(new Coordenada(3, 3)));

        unidad.moverHaciaLaIzquierdaAbajo();
        assertEquals(unidad.getCasillero(), tablero.getCasilleroEnCoordenada(new Coordenada(2, 2)));

    }

    @Test(expected = CasilleroOcupadoExcepcion.class)
    public void unidadMovibleNoPuedeMoverseAUnCasilleroOcupadoTest() throws Exception {
        // Arrange
        Unidad unidadOcupante = new Soldado(bandoAliado);
        tablero.posicionarUnidad(unidadOcupante, new Coordenada(1, 2));

        UnidadMovible soldado = new Soldado(bandoAliado);
        tablero.posicionarUnidad(soldado, new Coordenada(1, 1));

        // Act
        soldado.moverHaciaArriba();
    }

    @Test
    public void soldadoDeInfanteriaAliadoAtacaPiezaEnemigaSeVerificaQueSeRestaVidaCorrecpondienteTest() throws Exception {
        // Arrange
        Soldado soldadoAtacante = new Soldado(bandoAliado);
        tablero.posicionarUnidad(soldadoAtacante, new Coordenada(15, 15));

        Soldado soldadoAtacado = new Soldado(bandoEnemigo);
        tablero.posicionarUnidad(soldadoAtacado, new Coordenada(16, 16));

        // Act
        soldadoAtacante.atacar(soldadoAtacado);

        // Assert
        assertEquals(90, soldadoAtacado.getVida(),0);
    }

    @Test
    public void jineteAliadoAtacaPiezaEnemigaDistanciaCortaSeVerificaQueSeRestaVidaCorrespondienteTest() throws Exception {
        // Arrange Ataque con espada a distancia corta
        Jinete jineteAtacante = new Jinete(bandoAliado);
        tablero.posicionarUnidad(jineteAtacante, new Coordenada(15, 15));

        Jinete jineteAtacado = new Jinete(bandoEnemigo);
        tablero.posicionarUnidad(jineteAtacado, new Coordenada(16, 16));

        // Act
        jineteAtacante.atacar(jineteAtacado);

        // Assert
        assertEquals(95, jineteAtacado.getVida(), 0);
    }

    @Test
    public void jineteAliadoAtacaPiezaEnemigaDistanciaMediaSeVerificaQueSeRestaVidaCorrespondienteTest() throws Exception {
        // Arrange Ataque con espada a distancia corta
        Jinete jineteAtacante = new Jinete(bandoAliado);
        tablero.posicionarUnidad(jineteAtacante, new Coordenada(15, 15));

        Jinete jineteAtacado = new Jinete(bandoEnemigo);
        tablero.posicionarUnidad(jineteAtacado, new Coordenada(19, 19));

        // Act
        jineteAtacante.atacar(jineteAtacado);

        // Assert
        assertEquals(85, jineteAtacado.getVida(), 0);
    }

    @Test
    public void curanderoAliadoCuraPiezaAliadaSeVerificaQueSeSumaVidaCorrespondienteTest() throws Exception {
        // Arrange
        Curandero curanderoCurador = new Curandero(bandoAliado);
        tablero.posicionarUnidad(curanderoCurador, new Coordenada(1, 1));

        Curandero curanderoCurado = new Curandero(bandoAliado);
        tablero.posicionarUnidad(curanderoCurado, new Coordenada(2, 2));

        curanderoCurado.recibirDanio(30);
        // Act
        curanderoCurador.curar(curanderoCurado);

        // Assert
        assertEquals(60, curanderoCurado.getVida(), 0);
    }

    @Test
    public void catapultaAliadaAtacaPiezaEnemigaSeVerificaQueSeRestaVidaCorrespondienteTest() throws Exception {
        // Arrange
        Catapulta catapulta = new Catapulta(bandoAliado);
        tablero.posicionarUnidad(catapulta, new Coordenada(1, 1));

        Soldado soldadoAtacado = new Soldado(bandoEnemigo);
        tablero.posicionarUnidad(soldadoAtacado, new Coordenada(19, 19));

        // Act
        catapulta.atacar(soldadoAtacado);

        // Assert
        assertEquals(80, soldadoAtacado.getVida(), 0);
    }

}
