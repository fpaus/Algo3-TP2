package EntidadesTests;

import Algo3TP2.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Modelos.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JineteAtaqueTest {

    @Test
    public void JineteNuevoEsDistintoAnull(){
        // Arrange
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);

        // Act
        Unidad jinete = new Jinete(bando);

        // Assert
        assertNotNull( jinete);
    }

    @Test
    public void JineteNuevoTiene100DeVida(){
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
    public void JineteNuevoTrasGenerarDanioNoTiene100DeVida(){
        // Arrange
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Unidad jinete = new Jinete(bando);

        // Act
        jinete.generarDanio(10);
        int vidaJinete = jinete.getVida();

        // Assert
        assert(100 != vidaJinete);
    }

    @Test
    public void JineteNuevoTrasGenerarDanioPor15PuntosAhoraTiene90DeVida(){
        // Arrange
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Unidad jinete = new Jinete(bando);

        // Act
        jinete.generarDanio(15);

        // Assert
        assertEquals(85, jinete.getVida());
    }

    @Test
    public void JineteAtacaConEstrategiaArcoYFlechaAJineteEnemigoCausa15PuntosDeDanio() throws Exception{
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(1,1,jugador1);
        Jinete jineteAtacante = new Jinete(bando1);
        jineteAtacante.colocarEnCasillero(casillero1);
        jineteAtacante.setEstrategiaDeAtaque(new AtaqueDeJIneteConArcoYFlecha());

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(5,5,jugador2);
        Jinete jineteAtacado = new Jinete(bando2);
        jineteAtacado.colocarEnCasillero(casillero2);

        // Act
        jineteAtacante.atacar(jineteAtacado);

        // Assert
        assertEquals(85, jineteAtacado.getVida());
    }

    @Test
    public void JineteAtacaConEstrategiaEspadaAJineteEnemigoCausa5PuntosDeDanio() throws Exception{
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(1,1,jugador1);
        Jinete jineteAtacante = new Jinete(bando1);
        jineteAtacante.colocarEnCasillero(casillero1);
        jineteAtacante.setEstrategiaDeAtaque(new AtaqueDeJineteConEspada());

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(2,2,jugador2);
        Jinete jineteAtacado = new Jinete(bando2);
        jineteAtacado.colocarEnCasillero(casillero2);

        // Act
        jineteAtacante.atacar(jineteAtacado);

        // Assert
        assertEquals(95, jineteAtacado.getVida());
    }

    @Test
    public void JineteAtaca2VecesConEstrategiaEspadaAJineteEnemigoCausa10PuntosDeDanio() throws Exception{
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(1,1,jugador1);
        Jinete jineteAtacante = new Jinete(bando1);
        jineteAtacante.colocarEnCasillero(casillero1);
        jineteAtacante.setEstrategiaDeAtaque(new AtaqueDeJineteConEspada());

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(3,3,jugador2);
        Jinete jineteAtacado = new Jinete(bando2);
        jineteAtacado.colocarEnCasillero(casillero2);

        // Act
        jineteAtacante.atacar(jineteAtacado);
        jineteAtacante.atacar(jineteAtacado);

        // Assert
        assertEquals(90, jineteAtacado.getVida());
    }

    @Test
    public void JineteAtaca2VecesConEstrategiaArcoYFlechaAJineteEnemigoCausa30PuntosDeDanio() throws Exception{
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(1,1,jugador1);
        Jinete jineteAtacante = new Jinete(bando1);
        jineteAtacante.colocarEnCasillero(casillero1);
        jineteAtacante.setEstrategiaDeAtaque(new AtaqueDeJIneteConArcoYFlecha());

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(6,6,jugador2);
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
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion{
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(1,1,jugador1);
        Jinete jineteAtacante = new Jinete(bando1);
        jineteAtacante.colocarEnCasillero(casillero1);
        jineteAtacante.setEstrategiaDeAtaque(new AtaqueDeJineteConEspada());

        Casillero casillero2 = new Casillero(2,2,jugador1);
        Jinete jineteAtacado = new Jinete(bando1);
        jineteAtacado.colocarEnCasillero(casillero2);

        // Act Assert
        jineteAtacante.atacar(jineteAtacado);
    }

    @Test(expected = UnidadAtacadaEsAliadaExcepcion.class)
    public void JineteAtacaConEstrategiaArcoYFlechaAJineteAliadoLanzaExcepcion()
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion{
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(1,1,jugador1);
        Jinete jineteAtacante = new Jinete(bando1);
        jineteAtacante.colocarEnCasillero(casillero1);
        jineteAtacante.setEstrategiaDeAtaque(new AtaqueDeJIneteConArcoYFlecha());

        Casillero casillero2 = new Casillero(5,5,jugador1);
        Jinete jineteAtacado = new Jinete(bando1);
        jineteAtacado.colocarEnCasillero(casillero2);

        // Act Assert
        jineteAtacante.atacar(jineteAtacado);
    }


    @Test(expected = DistanciaDeAtaqueIncorrectaExcepcion.class)
    public void JineteAtacaConEstrategiaEspadaAJineteEnemigoUbicadoADistanciaMayorQueLaCortaLanzaExcepcion()
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion{
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(1,1,jugador1);
        Jinete jineteAtacante = new Jinete(bando1);
        jineteAtacante.colocarEnCasillero(casillero1);
        jineteAtacante.setEstrategiaDeAtaque(new AtaqueDeJineteConEspada());

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(20,20,jugador2);
        Jinete jineteAtacado = new Jinete(bando2);
        jineteAtacado.colocarEnCasillero(casillero2);

        // Act Assert
        jineteAtacante.atacar(jineteAtacado);
    }

    @Test(expected = DistanciaDeAtaqueIncorrectaExcepcion.class)
    public void JineteAtacaConEstrategiaArcoYFlechaAJineteEnemigoUbicadoADistanciaMayorQueLaMediaLanzaExcepcion()
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion{
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(1,1,jugador1);
        Jinete jineteAtacante = new Jinete(bando1);
        jineteAtacante.colocarEnCasillero(casillero1);
        jineteAtacante.setEstrategiaDeAtaque(new AtaqueDeJIneteConArcoYFlecha());

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(20,20,jugador2);
        Jinete jineteAtacado = new Jinete(bando2);
        jineteAtacado.colocarEnCasillero(casillero2);

        // Act Assert
        jineteAtacante.atacar(jineteAtacado);
    }

    @Test(expected = DistanciaDeAtaqueIncorrectaExcepcion.class)
    public void JineteAtacaConEstrategiaArcoYFlechaAJineteEnemigoUbicadoADistanciaMenorQueLaMediaLanzaExcepcion()
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion{
    // Arrange
    Jugador jugador1 = new Jugador();
    Bando bando1 = new Bando(jugador1);
    Casillero casillero1 = new Casillero(1,1,jugador1);
    Jinete jineteAtacante = new Jinete(bando1);
        jineteAtacante.colocarEnCasillero(casillero1);
        jineteAtacante.setEstrategiaDeAtaque(new AtaqueDeJIneteConArcoYFlecha());

    Jugador jugador2 = new Jugador();
    Bando bando2 = new Bando(jugador2);
    Casillero casillero2 = new Casillero(3,3,jugador2);
    Jinete jineteAtacado = new Jinete(bando2);
        jineteAtacado.colocarEnCasillero(casillero2);

    // Act Assert
        jineteAtacante.atacar(jineteAtacado);
}

}