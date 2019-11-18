package Algo3TP2.EntidadesTests;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Modelos.*;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.AtaqueDeJIneteConArcoYFlecha;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.AtaqueDeJineteConEspada;
import Algo3TP2.Modelos.Unidades.Jinete;
import Algo3TP2.Modelos.Unidades.Unidad;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JineteAtaqueTest {

    @Test
    public void JineteNuevoEsDistintoAnull() {
        // Arrange
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);

        // Act
        Unidad jinete = new Jinete(bando);

        // Assert
        assertNotNull(jinete);
    }

    @Test
    public void JineteNuevoTiene100DeVida() {
        // Arrange
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Unidad jinete = new Jinete(bando);

        // Act
        int vidaJinete = jinete.getVida();

        // Assert
        assertEquals(100, vidaJinete);
    }

    @Test
    public void JineteNuevoTrasGenerarDanioNoTiene100DeVida() throws UnidadInvalidaException {
        // Arrange
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Unidad jinete = new Jinete(bando);

        // Act
        jinete.recibirDanio(10);
        int vidaJinete = jinete.getVida();

        // Assert
        assert (100 != vidaJinete);
    }

    @Test
    public void JineteNuevoTrasGenerarDanioPor15PuntosAhoraTiene90DeVida() throws UnidadInvalidaException {
        // Arrange
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Unidad jinete = new Jinete(bando);

        // Act
        jinete.recibirDanio(15);

        // Assert
        assertEquals(85, jinete.getVida());
    }

    @Test
    public void JineteAtacaConEstrategiaArcoYFlechaAJineteEnemigoCausa15PuntosDeDanio() throws Exception {
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(new Coordenada(1, 1), jugador1);
        Jinete jineteAtacante = new Jinete(bando1);
        jineteAtacante.colocarEnCasillero(casillero1);
        jineteAtacante.setEstrategiaDeAtaque(new AtaqueDeJIneteConArcoYFlecha());

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(new Coordenada(5, 5), jugador2);
        Jinete jineteAtacado = new Jinete(bando2);
        jineteAtacado.colocarEnCasillero(casillero2);

        // Act
        jineteAtacante.atacar(jineteAtacado);

        // Assert
        assertEquals(85, jineteAtacado.getVida());
    }

    @Test
    public void JineteAtacaConEstrategiaEspadaAJineteEnemigoCausa5PuntosDeDanio() throws Exception {
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(new Coordenada(1, 1), jugador1);
        Jinete jineteAtacante = new Jinete(bando1);
        jineteAtacante.colocarEnCasillero(casillero1);
        jineteAtacante.setEstrategiaDeAtaque(new AtaqueDeJineteConEspada());

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(new Coordenada(2, 2), jugador2);
        Jinete jineteAtacado = new Jinete(bando2);
        jineteAtacado.colocarEnCasillero(casillero2);

        // Act
        jineteAtacante.atacar(jineteAtacado);

        // Assert
        assertEquals(95, jineteAtacado.getVida());
    }

    @Test
    public void JineteAtaca2VecesConEstrategiaEspadaAJineteEnemigoCausa10PuntosDeDanio() throws Exception {
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(new Coordenada(1, 1), jugador1);
        Jinete jineteAtacante = new Jinete(bando1);
        jineteAtacante.colocarEnCasillero(casillero1);
        jineteAtacante.setEstrategiaDeAtaque(new AtaqueDeJineteConEspada());

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(new Coordenada(3, 3), jugador2);
        Jinete jineteAtacado = new Jinete(bando2);
        jineteAtacado.colocarEnCasillero(casillero2);

        // Act
        jineteAtacante.atacar(jineteAtacado);
        jineteAtacante.atacar(jineteAtacado);

        // Assert
        assertEquals(90, jineteAtacado.getVida());
    }

    @Test
    public void JineteAtaca2VecesConEstrategiaArcoYFlechaAJineteEnemigoCausa30PuntosDeDanio() throws Exception {
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(new Coordenada(1, 1), jugador1);
        Jinete jineteAtacante = new Jinete(bando1);
        jineteAtacante.colocarEnCasillero(casillero1);
        jineteAtacante.setEstrategiaDeAtaque(new AtaqueDeJIneteConArcoYFlecha());

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(new Coordenada(6, 6), jugador2);
        Jinete jineteAtacado = new Jinete(bando2);
        jineteAtacado.colocarEnCasillero(casillero2);

        // Act
        jineteAtacante.atacar(jineteAtacado);
        jineteAtacante.atacar(jineteAtacado);

        // Assert
        assertEquals(70, jineteAtacado.getVida());
    }

    @Test(expected = UnidadAtacadaEsAliadaExcepcion.class)
    public void JineteAtacaConEstrategiaEspadaAJineteAliadoLanzaExcepcion()
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion, UnidadInvalidaException {
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(new Coordenada(1, 1), jugador1);
        Jinete jineteAtacante = new Jinete(bando1);
        jineteAtacante.colocarEnCasillero(casillero1);
        jineteAtacante.setEstrategiaDeAtaque(new AtaqueDeJineteConEspada());

        Casillero casillero2 = new Casillero(new Coordenada(2, 2), jugador1);
        Jinete jineteAtacado = new Jinete(bando1);
        jineteAtacado.colocarEnCasillero(casillero2);

        // Act Assert
        jineteAtacante.atacar(jineteAtacado);
    }

    @Test(expected = UnidadAtacadaEsAliadaExcepcion.class)
    public void JineteAtacaConEstrategiaArcoYFlechaAJineteAliadoLanzaExcepcion()
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion, UnidadInvalidaException {
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(new Coordenada(1, 1), jugador1);
        Jinete jineteAtacante = new Jinete(bando1);
        jineteAtacante.colocarEnCasillero(casillero1);
        jineteAtacante.setEstrategiaDeAtaque(new AtaqueDeJIneteConArcoYFlecha());

        Casillero casillero2 = new Casillero(new Coordenada(5, 5), jugador1);
        Jinete jineteAtacado = new Jinete(bando1);
        jineteAtacado.colocarEnCasillero(casillero2);

        // Act Assert
        jineteAtacante.atacar(jineteAtacado);
    }


    @Test(expected = DistanciaDeAtaqueIncorrectaExcepcion.class)
    public void JineteAtacaConEstrategiaEspadaAJineteEnemigoUbicadoADistanciaMayorQueLaCortaLanzaExcepcion()
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion, UnidadInvalidaException {
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(new Coordenada(1, 1), jugador1);
        Jinete jineteAtacante = new Jinete(bando1);
        jineteAtacante.colocarEnCasillero(casillero1);
        jineteAtacante.setEstrategiaDeAtaque(new AtaqueDeJineteConEspada());

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(new Coordenada(20, 20), jugador2);
        Jinete jineteAtacado = new Jinete(bando2);
        jineteAtacado.colocarEnCasillero(casillero2);

        // Act Assert
        jineteAtacante.atacar(jineteAtacado);
    }

    @Test(expected = DistanciaDeAtaqueIncorrectaExcepcion.class)
    public void JineteAtacaConEstrategiaArcoYFlechaAJineteEnemigoUbicadoADistanciaMayorQueLaMediaLanzaExcepcion()
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion, UnidadInvalidaException {
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(new Coordenada(1, 1), jugador1);
        Jinete jineteAtacante = new Jinete(bando1);
        jineteAtacante.colocarEnCasillero(casillero1);
        jineteAtacante.setEstrategiaDeAtaque(new AtaqueDeJIneteConArcoYFlecha());

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(new Coordenada(20, 20), jugador2);
        Jinete jineteAtacado = new Jinete(bando2);
        jineteAtacado.colocarEnCasillero(casillero2);

        // Act Assert
        jineteAtacante.atacar(jineteAtacado);
    }

    @Test(expected = DistanciaDeAtaqueIncorrectaExcepcion.class)
    public void JineteAtacaConEstrategiaArcoYFlechaAJineteEnemigoUbicadoADistanciaMenorQueLaMediaLanzaExcepcion()
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion, UnidadInvalidaException {
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(new Coordenada(1, 1), jugador1);
        Jinete jineteAtacante = new Jinete(bando1);
        jineteAtacante.colocarEnCasillero(casillero1);
        jineteAtacante.setEstrategiaDeAtaque(new AtaqueDeJIneteConArcoYFlecha());

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(new Coordenada(3, 3), jugador2);
        Jinete jineteAtacado = new Jinete(bando2);
        jineteAtacado.colocarEnCasillero(casillero2);

        // Act Assert
        jineteAtacante.atacar(jineteAtacado);
    }

}
