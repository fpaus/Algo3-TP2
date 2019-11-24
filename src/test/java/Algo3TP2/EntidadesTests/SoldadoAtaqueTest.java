package Algo3TP2.EntidadesTests;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Jugador;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Modelos.Unidades.Soldado;
import Algo3TP2.Modelos.Unidades.Unidad;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SoldadoAtaqueTest {

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
    public void soldadoNuevoEsDistintoAnull() {
        // Act
        Unidad soldado = new Soldado(bandoAliado);

        // Assert
        assertNotNull(soldado);
    }

    @Test
    public void SoladoNuevoTiene100DeVida() {
        // Arrange
        Unidad soldado = new Soldado(bandoAliado);

        // Assert
        assertEquals(100, soldado.getVida(), 0);
    }

    @Test
    public void SoladoNuevoTrasGenerarDanioNoTiene100DeVida() throws Exception {
        // Arrange
        Unidad soldado = new Soldado(bandoAliado);

        // Act
        soldado.recibirDanio(10);

        // Assert
        assert (100 != soldado.getVida());
    }

    @Test
    public void SoladoNuevoTrasGenerarDanioPor15PuntosAhoraTiene85DeVida() throws Exception {
        // Arrange
        Unidad soldado = new Soldado(bandoAliado);

        // Act
        soldado.recibirDanio(15);

        // Assert
        assertEquals(85, soldado.getVida(), 0);
    }

    @Test
    public void SoladoAtacaASoldadoEnemigoCausa10PuntosDeDanio() throws Exception {
        // Arrange
        Soldado soldadoAtacante = new Soldado(bandoAliado);
        tablero.posicionarUnidad(soldadoAtacante, new Coordenada(1, 1));

        Soldado soldadoAtacado = new Soldado(bandoEnemigo);
        tablero.posicionarUnidad(soldadoAtacado, new Coordenada(2, 2));

        // Act
        soldadoAtacante.atacar(soldadoAtacado);

        // Assert
        assertEquals(90, soldadoAtacado.getVida(), 0);
    }

    @Test
    public void SoladoAtaca2VecesASoldadoEnemigoCausa20PuntosDeDanio() throws Exception {
        // Arrange
        Soldado soldadoAtacante = new Soldado(bandoAliado);
        tablero.posicionarUnidad(soldadoAtacante, new Coordenada(1, 1));

        Soldado soldadoAtacado = new Soldado(bandoEnemigo);
        tablero.posicionarUnidad(soldadoAtacado, new Coordenada(2, 2));

        // Act
        soldadoAtacante.atacar(soldadoAtacado);
        soldadoAtacante.atacar(soldadoAtacado);

        // Assert
        assertEquals(80, soldadoAtacado.getVida(), 0);
    }

    @Test(expected = UnidadAtacadaEsAliadaExcepcion.class)
    public void SoladoAtacaASoldadoAliadoLanzaExcepcion() throws Exception {
        // Arrange
        Soldado soldadoAtacante = new Soldado(bandoAliado);
        tablero.posicionarUnidad(soldadoAtacante, new Coordenada(1, 1));

        Soldado soldadoAtacado = new Soldado(bandoAliado);
        tablero.posicionarUnidad(soldadoAtacado, new Coordenada(2, 2));

        // Act Assert
        soldadoAtacante.atacar(soldadoAtacado);
    }

    @Test(expected = DistanciaDeAtaqueIncorrectaExcepcion.class)
    public void SoladoAtacaASoldadoEnemigoUbicadoADistanciaMayorQueLaCortaLanzaExcepcion() throws Exception {
        // Arrange;
        Soldado soldadoAtacante = new Soldado(bandoAliado);
        tablero.posicionarUnidad(soldadoAtacante, new Coordenada(1, 1));

        Soldado soldadoAtacado = new Soldado(bandoEnemigo);
        tablero.posicionarUnidad(soldadoAtacado, new Coordenada(19, 19));

        // Act Assert
        soldadoAtacante.atacar(soldadoAtacado);
    }

    @Test(expected = DistanciaDeAtaqueIncorrectaExcepcion.class) //Caso Borde
    public void SoladoAtacaASoldadoEnemigoUbicadoADistancia3LanzaExcepcion() throws Exception {
        // Arrange
        Soldado soldadoAtacante = new Soldado(bandoAliado);
        tablero.posicionarUnidad(soldadoAtacante, new Coordenada(1, 1));

        Soldado soldadoAtacado = new Soldado(bandoEnemigo);
        tablero.posicionarUnidad(soldadoAtacado, new Coordenada(4, 4));

        // Act Assert
        soldadoAtacante.atacar(soldadoAtacado);
    }

    @Test //Caso Borde
    public void SoladoAtacaASoldadoEnemigoUbicadoADistancia2GeneraDanio() throws Exception {
        // Arrange
        Soldado soldadoAtacante = new Soldado(bandoAliado);
        tablero.posicionarUnidad(soldadoAtacante, new Coordenada(1, 1));

        Soldado soldadoAtacado = new Soldado(bandoEnemigo);
        tablero.posicionarUnidad(soldadoAtacado, new Coordenada(3, 3));

        // Act
        soldadoAtacante.atacar(soldadoAtacado);

        // Assert
        assertEquals(90, soldadoAtacado.getVida(), 0);
    }

}
