package Algo3TP2.EntidadesTests;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Jugador;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.UnidadInvalidaException;
import Algo3TP2.Modelos.Unidades.Catapulta;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.Soldado;
import Algo3TP2.Modelos.Unidades.Unidad;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CatapultaTest {

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
    public void catapultaNuevaEsDistintaAnull() {
        // Act
        Unidad catapulta = new Catapulta(bandoAliado);

        // Assert
        assertNotNull(catapulta);
    }

    @Test
    public void CatapultaNuevaTiene50DeVida() {
        // Arrange
        Unidad catapulta = new Catapulta(bandoAliado);

        // Assert
        assertEquals(50, catapulta.getVida(), 0);
    }

    @Test
    public void CatapultaNuevaTrasGenerarDanioNoTiene50DeVida() throws UnidadInvalidaException, CasilleroOcupadoExcepcion, CasilleroFueraDelLosLimitesDelTableroExcepcion {
        // Arrange
        Unidad catapulta = new Catapulta(bandoAliado);
        tablero.posicionarUnidad(catapulta, new Coordenada(1, 1));

        // Act
        catapulta.recibirDanio(10);

        // Assert
        assert (50 != catapulta.getVida());
    }

    @Test
    public void CatapultaNuevaTrasGenerarDanioPor15PuntosAhoraTiene35DeVida() throws UnidadInvalidaException, CasilleroOcupadoExcepcion, CasilleroFueraDelLosLimitesDelTableroExcepcion {
        // Arrange
        Unidad catapulta = new Catapulta(bandoAliado);
        tablero.posicionarUnidad(catapulta, new Coordenada(1, 1));

        // Act
        catapulta.recibirDanio(15);

        // Assert
        assertEquals(35, catapulta.getVida(), 0);
    }

    @Test
    public void CatapultaAtacaACatapultaEnemigaQueEstaSolaCausa20PuntosDeDanio() throws Exception {
        // Arrange
        Catapulta catapultaAtacante = new Catapulta(bandoAliado);
        tablero.posicionarUnidad(catapultaAtacante, new Coordenada(1, 1));

        Catapulta catapultaAtacada = new Catapulta(bandoEnemigo);
        tablero.posicionarUnidad(catapultaAtacada, new Coordenada(19, 19));

        // Act
        catapultaAtacante.atacar(catapultaAtacada);

        // Assert
        assertEquals(30, catapultaAtacada.getVida(), 0);
    }

    @Test
    public void CatapultaAtaca2VecesACatapultaEnemigaQueEstaSolaCausa40PuntosDeDanio() throws Exception {
        // Arrange
        Catapulta catapultaAtacante = new Catapulta(bandoAliado);
        tablero.posicionarUnidad(catapultaAtacante, new Coordenada(1, 1));

        Catapulta catapultaAtacada = new Catapulta(bandoEnemigo);
        tablero.posicionarUnidad(catapultaAtacada, new Coordenada(19, 19));

        // Act
        catapultaAtacante.atacar(catapultaAtacada);
        catapultaAtacante.atacar(catapultaAtacada);

        // Assert
        assertEquals(10, catapultaAtacada.getVida(), 0);
    }

    @Test
    public void CatapultaAtacaACatapultaAliadaYLeCausaDanio() throws Exception {
        // Arrange
        Catapulta catapultaAtacante = new Catapulta(bandoAliado);
        tablero.posicionarUnidad(catapultaAtacante, new Coordenada(1, 1));

        Catapulta catapultaAtacada = new Catapulta(bandoAliado);
        tablero.posicionarUnidad(catapultaAtacada, new Coordenada(7, 7));

        // Act
        catapultaAtacante.atacar(catapultaAtacada);

        // Assert
        assertEquals(30, catapultaAtacada.getVida(), 0);
    }

    @Test
    public void CatapultaAtacaACatapultaEnemigaEnTerritorioContrarioYLeCausaMasDanio() throws Exception {
        // Arrange
        Catapulta catapultaAtacante = new Catapulta(bandoAliado);
        tablero.posicionarUnidad(catapultaAtacante, new Coordenada(1, 1));

        Catapulta catapultaAtacada = new Catapulta(bandoEnemigo);
        tablero.posicionarUnidad(catapultaAtacada, new Coordenada(7, 7));

        // Act
        catapultaAtacante.atacar(catapultaAtacada);

        // Assert
        assertEquals(29, catapultaAtacada.getVida(), 0);
    }

    @Test(expected = DistanciaDeAtaqueIncorrectaExcepcion.class)
    public void CatapultaAtacaACatapultaEnemigaUbicadaADistanciaMenorQueLaLargaLanzaExcepcion() throws Exception {
        // Arrange
        Catapulta catapultaAtacante = new Catapulta(bandoAliado);
        tablero.posicionarUnidad(catapultaAtacante, new Coordenada(1, 1));

        Catapulta catapultaAtacada = new Catapulta(bandoEnemigo);
        tablero.posicionarUnidad(catapultaAtacada, new Coordenada(2, 2));

        // Act Assert
        catapultaAtacante.atacar(catapultaAtacada);
    }

    @Test(expected = DistanciaDeAtaqueIncorrectaExcepcion.class) //Caso Borde
    public void CatapultaAtacaACatapultaEnemigaUbicadaADistancia5LanzaExcepcion() throws Exception {
        Catapulta catapultaAtacante = new Catapulta(bandoAliado);
        tablero.posicionarUnidad(catapultaAtacante, new Coordenada(5, 5));

        Catapulta catapultaAtacada = new Catapulta(bandoEnemigo);
        tablero.posicionarUnidad(catapultaAtacada, new Coordenada(10, 10));

        // Act Assert
        catapultaAtacante.atacar(catapultaAtacada);
    }

    @Test //Caso Borde
    public void CatapultaAtacaACatapultaEnemigaUbicadaADistancia7GeneraDanio() throws Exception {
        // Arrange
        Catapulta catapultaAtacante = new Catapulta(bandoAliado);
        tablero.posicionarUnidad(catapultaAtacante, new Coordenada(12, 12));

        Catapulta catapultaAtacada = new Catapulta(bandoEnemigo);
        tablero.posicionarUnidad(catapultaAtacada, new Coordenada(19, 19));

        // Act
        catapultaAtacante.atacar(catapultaAtacada);

        // Assert
        assertEquals(30, catapultaAtacada.getVida(), 0);
    }

    @Test
    public void CatapultaAtacaAUnidadGeneraDanioATodasLasUnidadesContiguas() throws Exception {
        // Arrange
        Catapulta catapultaAtacante = new Catapulta(bandoAliado);
        tablero.posicionarUnidad(catapultaAtacante, new Coordenada(10, 10));

        Unidad soldadoAtacado1 = new Soldado(bandoEnemigo);
        tablero.posicionarUnidad(soldadoAtacado1, new Coordenada(17, 17));
        Unidad soldadoAtacado2 = new Soldado(bandoEnemigo);
        tablero.posicionarUnidad(soldadoAtacado2, new Coordenada(16, 17));
        Unidad soldadoAtacado3 = new Soldado(bandoEnemigo);
        tablero.posicionarUnidad(soldadoAtacado3, new Coordenada(16, 16));
        Unidad soldadoNoAtacado = new Soldado(bandoEnemigo);
        tablero.posicionarUnidad(soldadoNoAtacado, new Coordenada(13, 17));

        // Act
        catapultaAtacante.atacar(soldadoAtacado1);

        // Assert
        assertEquals(80, soldadoAtacado1.getVida(), 0);
        assertEquals(80, soldadoAtacado2.getVida(), 0);
        assertEquals(80, soldadoAtacado3.getVida(), 0);
        assertEquals(100, soldadoNoAtacado.getVida(), 0);
    }

}
