package Algo3TP2.EntidadesTests;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Jugador;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.UnidadInvalidaException;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Modelos.Unidades.Jinete;
import Algo3TP2.Modelos.Unidades.Unidad;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JineteAtaqueTest {

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
    public void JineteNuevoEsDistintoAnull() {
        // Act
        Unidad jinete = new Jinete(bandoAliado);

        // Assert
        assertNotNull(jinete);
    }

    @Test
    public void JineteNuevoTiene100DeVida() {
        // Arrange
        Unidad jinete = new Jinete(bandoAliado);

        // Act
        float vidaJinete = jinete.getVida();

        // Assert
        assertEquals(100, vidaJinete, 0);
    }

    @Test
    public void JineteNuevoTrasRecibirDanioNoTiene100DeVida() throws UnidadInvalidaException, CasilleroOcupadoExcepcion, CasilleroFueraDelLosLimitesDelTableroExcepcion {
        // Arrange
        Unidad jinete = new Jinete(bandoAliado);
        tablero.posicionarUnidad(jinete, new Coordenada(1, 1));

        // Act
        jinete.recibirDanio(10);

        // Assert
        assert (100 != jinete.getVida());
    }

    @Test
    public void JineteNuevoTrasGenerarDanioPor15PuntosAhoraTiene90DeVida() throws UnidadInvalidaException, CasilleroOcupadoExcepcion, CasilleroFueraDelLosLimitesDelTableroExcepcion {
        // Arrange
        Unidad jinete = new Jinete(bandoAliado);
        tablero.posicionarUnidad(jinete, new Coordenada(1, 1));

        // Act
        jinete.recibirDanio(15);

        // Assert
        assertEquals(85, jinete.getVida(), 0);
    }

    @Test
    public void JineteAtacaConEstrategiaArcoYFlechaAJineteEnemigoCausa15PuntosDeDanio() throws Exception {
        // Arrange
        Jinete jineteAtacante = new Jinete(bandoAliado);
        tablero.posicionarUnidad(jineteAtacante, new Coordenada(12, 12));

        Jinete jineteAtacado = new Jinete(bandoEnemigo);
        tablero.posicionarUnidad(jineteAtacado, new Coordenada(16, 16));

        // Act
        jineteAtacante.atacar(jineteAtacado);

        // Assert
        assertEquals(85, jineteAtacado.getVida(), 0);
    }

    @Test
    public void JineteAtacaConEstrategiaArcoYFlechaAJineteEnemigoEnTerritorioContrarioCausandoMasDanio() throws Exception {
        // Arrange
        Jinete jineteAtacante = new Jinete(bandoAliado);
        tablero.posicionarUnidad(jineteAtacante, new Coordenada(1, 1));

        Jinete jineteAtacado = new Jinete(bandoEnemigo);
        tablero.posicionarUnidad(jineteAtacado, new Coordenada(5, 5));

        // Act
        jineteAtacante.atacar(jineteAtacado);

        // Assert
        assertEquals(84.25, jineteAtacado.getVida(), 0);
    }

    @Test
    public void JineteAtacaConEstrategiaEspadaAJineteEnemigoCausa5PuntosDeDanio() throws Exception {
        // Arrange
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
    public void JineteAtacaConEstrategiaEspadaAJineteEnemigoEnTerritorioContrarioCausandoMasDanio() throws Exception {
        // Arrange
        Jinete jineteAtacante = new Jinete(bandoAliado);
        tablero.posicionarUnidad(jineteAtacante, new Coordenada(1, 1));

        Jinete jineteAtacado = new Jinete(bandoEnemigo);
        tablero.posicionarUnidad(jineteAtacado, new Coordenada(2, 2));

        // Act
        jineteAtacante.atacar(jineteAtacado);

        // Assert
        assertEquals(94.75, jineteAtacado.getVida(), 0);
    }

    @Test
    public void JineteAtaca2VecesConEstrategiaEspadaAJineteEnemigoCausa10PuntosDeDanio() throws Exception {
        // Arrange
        Jinete jineteAtacante = new Jinete(bandoAliado);
        tablero.posicionarUnidad(jineteAtacante, new Coordenada(15, 15));

        Jinete jineteAtacado = new Jinete(bandoEnemigo);
        tablero.posicionarUnidad(jineteAtacado, new Coordenada(17, 17));

        // Act
        jineteAtacante.atacar(jineteAtacado);
        jineteAtacante.atacar(jineteAtacado);

        // Assert
        assertEquals(90, jineteAtacado.getVida(), 0);
    }

    @Test
    public void JineteAtaca2VecesConEstrategiaArcoYFlechaAJineteEnemigoCausa30PuntosDeDanio() throws Exception {
        // Arrange
        Jinete jineteAtacante = new Jinete(bandoAliado);
        tablero.posicionarUnidad(jineteAtacante, new Coordenada(15, 15));

        Jinete jineteAtacado = new Jinete(bandoEnemigo);
        tablero.posicionarUnidad(jineteAtacado, new Coordenada(19, 19));

        // Act
        jineteAtacante.atacar(jineteAtacado);
        jineteAtacante.atacar(jineteAtacado);

        // Assert
        assertEquals(70, jineteAtacado.getVida(), 0);
    }

    @Test(expected = UnidadAtacadaEsAliadaExcepcion.class)
    public void JineteAtacaConEstrategiaEspadaAJineteAliadoLanzaExcepcion() throws Exception {
        // Arrange
        Jinete jineteAtacante = new Jinete(bandoAliado);
        tablero.posicionarUnidad(jineteAtacante, new Coordenada(1, 1));

        Jinete jineteAtacado = new Jinete(bandoAliado);
        tablero.posicionarUnidad(jineteAtacado, new Coordenada(2, 2));

        // Act Assert
        jineteAtacante.atacar(jineteAtacado);
    }

    @Test(expected = UnidadAtacadaEsAliadaExcepcion.class)
    public void JineteAtacaConEstrategiaArcoYFlechaAJineteAliadoLanzaExcepcion() throws Exception {
        // Arrange
        Jinete jineteAtacante = new Jinete(bandoAliado);
        tablero.posicionarUnidad(jineteAtacante, new Coordenada(1, 1));

        Jinete jineteAtacado = new Jinete(bandoAliado);
        tablero.posicionarUnidad(jineteAtacado, new Coordenada(5, 5));

        // Act Assert
        jineteAtacante.atacar(jineteAtacado);
    }


    @Test(expected = DistanciaDeAtaqueIncorrectaExcepcion.class)
    public void JineteAtacaEnemigoUbicadoADistanciaMayorQueLaCortaLanzaExcepcion() throws Exception {
        // Arrange
        Jinete jineteAtacante = new Jinete(bandoAliado);
        tablero.posicionarUnidad(jineteAtacante, new Coordenada(1, 1));

        Jinete jineteAtacado = new Jinete(bandoEnemigo);
        tablero.posicionarUnidad(jineteAtacado, new Coordenada(19, 19));

        // Act Assert
        jineteAtacante.atacar(jineteAtacado);
    }
}
