package Algo3TP2.EntidadesTests;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Modelos.*;
import Algo3TP2.Modelos.Unidades.Catapulta;
import Algo3TP2.Modelos.Unidades.Unidad;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CatapultaTest {

    @Test
    public void catapultaNuevaEsDistintaAnull() {
        // Arrange
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);

        // Act
        Unidad catapulta = new Catapulta(bando);

        // Assert
        assertNotNull(catapulta);
    }

    @Test
    public void CatapultaNuevaTiene50DeVida() {
        // Arrange
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Unidad catapulta = new Catapulta(bando);

        // Act
        int vidaCatapulta = catapulta.getVida();

        // Assert
        assertEquals(50, vidaCatapulta);
    }

    @Test
    public void CatapultaNuevaTrasGenerarDanioNoTiene50DeVida() throws UnidadInvalidaException {
        // Arrange
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Unidad catapulta = new Catapulta(bando);

        // Act
        catapulta.recibirDanio(10);
        int vidaCatapulta = catapulta.getVida();

        // Assert
        assert (50 != vidaCatapulta);
    }

    @Test
    public void CatapultaNuevaTrasGenerarDanioPor15PuntosAhoraTiene35DeVida() throws UnidadInvalidaException {
        // Arrange
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Unidad catapulta = new Catapulta(bando);

        // Act
        catapulta.recibirDanio(15);

        // Assert
        assertEquals(35, catapulta.getVida());
    }

    @Test
    public void CatapultaAtacaACatapultaEnemigaQueEstaSolaCausa20PuntosDeDanio() throws Exception {
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(1, 1, jugador1);
        Catapulta catapultaAtacante = new Catapulta(bando1);
        catapultaAtacante.colocarEnCasillero(casillero1);

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(20, 20, jugador2);
        Catapulta catapultaAtacada = new Catapulta(bando2);
        catapultaAtacada.colocarEnCasillero(casillero2);

        // Act
        catapultaAtacante.atacar(catapultaAtacada);

        // Assert
        assertEquals(30, catapultaAtacada.getVida());
    }

    @Test
    public void CatapuñtaAtaca2VecesACatapultaEnemigaQueEstaSolaCausa40PuntosDeDanio() throws Exception {
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(1, 1, jugador1);
        Catapulta catapultaAtacante = new Catapulta(bando1);
        catapultaAtacante.colocarEnCasillero(casillero1);

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(20, 20, jugador2);
        Catapulta catapultaAtacada = new Catapulta(bando2);
        catapultaAtacada.colocarEnCasillero(casillero2);

        // Act
        catapultaAtacante.atacar(catapultaAtacada);
        catapultaAtacante.atacar(catapultaAtacada);

        // Assert
        assertEquals(10, catapultaAtacada.getVida());
    }

    @Test
    public void CatapultaAtacaACatapultaAliadaYLeCausaDanio()
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion, UnidadInvalidaException {
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(1, 1, jugador1);
        Catapulta catapultaAtacante = new Catapulta(bando1);
        catapultaAtacante.colocarEnCasillero(casillero1);

        Casillero casillero2 = new Casillero(20, 20, jugador1);
        Catapulta catapultaAtacada = new Catapulta(bando1);
        catapultaAtacada.colocarEnCasillero(casillero2);

        // Act
        catapultaAtacante.atacar(catapultaAtacada);

        // Assert
        assertEquals(30, catapultaAtacada.getVida());
    }

    @Test(expected = DistanciaDeAtaqueIncorrectaExcepcion.class)
    public void CatapultaAtacaACatapultaEnemigaUbicadaADistanciaMenorQueLaLargaLanzaExcepcion()
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion, UnidadInvalidaException {
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(1, 1, jugador1);
        Catapulta catapultaAtacante = new Catapulta(bando1);
        catapultaAtacante.colocarEnCasillero(casillero1);

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(2, 2, jugador2);
        Catapulta catapultaAtacada = new Catapulta(bando2);
        catapultaAtacada.colocarEnCasillero(casillero2);

        // Act Assert
        catapultaAtacante.atacar(catapultaAtacada);
    }

    @Test(expected = DistanciaDeAtaqueIncorrectaExcepcion.class) //Caso Borde
    public void CatapultaAtacaACatapultaEnemigaUbicadaADistancia5LanzaExcepcion()
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion, UnidadInvalidaException {
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(1, 1, jugador1);
        Catapulta catapultaAtacante = new Catapulta(bando1);
        catapultaAtacante.colocarEnCasillero(casillero1);

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(5, 5, jugador2);
        Catapulta catapultaAtacada = new Catapulta(bando2);
        catapultaAtacada.colocarEnCasillero(casillero2);

        // Act Assert
        catapultaAtacante.atacar(catapultaAtacada);
    }

    @Test //Caso Borde
    public void CatapultaAtacaACatapultaEnemigaUbicadaADistancia7GeneraDanio()
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion, UnidadInvalidaException {
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(1, 1, jugador1);
        Catapulta catapultaAtacante = new Catapulta(bando1);
        catapultaAtacante.colocarEnCasillero(casillero1);

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(7, 7, jugador2);
        Catapulta catapultaAtacada = new Catapulta(bando2);
        catapultaAtacada.colocarEnCasillero(casillero2);

        // Act
        catapultaAtacante.atacar(catapultaAtacada);

        // Assert
        assertEquals(30, catapultaAtacada.getVida());
    }
}
