package EntidadesTests;

import Algo3TP2.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Modelos.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SoldadoAtaqueTest {

    @Test
    public void soldadoNuevoEsDistintoAnull(){
        // Arrange
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);

        // Act
        Unidad soldado = new Soldado(bando);

        // Assert
        assertNotNull( soldado);
    }

    @Test
    public void SoladoNuevoTiene100DeVida(){
        // Arrange
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Unidad soldado = new Soldado(bando);

        // Act
        int vidaSoldado = soldado.getVida();

        // Assert
        assertEquals(100, vidaSoldado);
    }

    @Test
    public void SoladoNuevoTrasGenerarDanioNoTiene100DeVida(){
        // Arrange
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Unidad soldado = new Soldado(bando);

        // Act
        soldado.generarDanio(10);
        int vidaSoldado = soldado.getVida();

        // Assert
        assert(100 != vidaSoldado);
    }

    @Test
    public void SoladoNuevoTrasGenerarDanioPor15PuntosAhoraTiene90DeVida(){
        // Arrange
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Unidad soldado = new Soldado(bando);

        // Act
        soldado.generarDanio(15);

        // Assert
        assertEquals(85, soldado.getVida());
    }

    @Test
    public void SoladoAtacaASoldadoEnemigoCausa10PuntosDeDanio() throws Exception{
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(1,1,jugador1);
        Soldado soldadoAtacante = new Soldado(bando1);
        soldadoAtacante.colocarEnCasillero(casillero1);

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(2,2,jugador2);
        Soldado soldadoAtacado = new Soldado(bando2);
        soldadoAtacado.colocarEnCasillero(casillero1);

        // Act
        soldadoAtacante.atacar(soldadoAtacado);

        // Assert
        assertEquals(90, soldadoAtacado.getVida());
    }

    @Test
    public void SoladoAtaca2VecesASoldadoEnemigoCausa20PuntosDeDanio() throws Exception{
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(1,1,jugador1);
        Soldado soldadoAtacante = new Soldado(bando1);
        soldadoAtacante.colocarEnCasillero(casillero1);

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(2,2,jugador2);
        Soldado soldadoAtacado = new Soldado(bando2);
        soldadoAtacado.colocarEnCasillero(casillero1);

        // Act
        soldadoAtacante.atacar(soldadoAtacado);
        soldadoAtacante.atacar(soldadoAtacado);

        // Assert
        assertEquals(80, soldadoAtacado.getVida());
    }

    @Test(expected = UnidadAtacadaEsAliadaExcepcion.class)
    public void SoladoAtacaASoldadoAliadoLanzaExcepcion()
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion{
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(1,1,jugador1);
        Soldado soldadoAtacante = new Soldado(bando1);
        soldadoAtacante.colocarEnCasillero(casillero1);

        Casillero casillero2 = new Casillero(2,2,jugador1);
        Soldado soldadoAtacado = new Soldado(bando1);
        soldadoAtacado.colocarEnCasillero(casillero2);

        // Act Assert
        soldadoAtacante.atacar(soldadoAtacado);
    }

    @Test(expected = DistanciaDeAtaqueIncorrectaExcepcion.class)
    public void SoladoAtacaASoldadoEnemigoUbicadoADistanciaMayorQueLaCortaLanzaExcepcion()
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion{
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(1,1,jugador1);
        Soldado soldadoAtacante = new Soldado(bando1);
        soldadoAtacante.colocarEnCasillero(casillero1);

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(20,20,jugador2);
        Soldado soldadoAtacado = new Soldado(bando2);
        soldadoAtacado.colocarEnCasillero(casillero2);

        // Act Assert
        soldadoAtacante.atacar(soldadoAtacado);
    }

    @Test(expected = DistanciaDeAtaqueIncorrectaExcepcion.class) //Caso Borde
    public void SoladoAtacaASoldadoEnemigoUbicadoADistancia3LanzaExcepcion()
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion{
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(1,1,jugador1);
        Soldado soldadoAtacante = new Soldado(bando1);
        soldadoAtacante.colocarEnCasillero(casillero1);

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(4,4,jugador2);
        Soldado soldadoAtacado = new Soldado(bando2);
        soldadoAtacado.colocarEnCasillero(casillero2);

        // Act Assert
        soldadoAtacante.atacar(soldadoAtacado);
    }

    @Test //Caso Borde
    public void SoladoAtacaASoldadoEnemigoUbicadoADistancia2GeneraDanio()
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion{
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(1,1,jugador1);
        Soldado soldadoAtacante = new Soldado(bando1);
        soldadoAtacante.colocarEnCasillero(casillero1);

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(3,3,jugador2);
        Soldado soldadoAtacado = new Soldado(bando2);
        soldadoAtacado.colocarEnCasillero(casillero2);

        // Act
        soldadoAtacante.atacar(soldadoAtacado);

        // Assert
        assertEquals(90, soldadoAtacado.getVida());
    }

}
