package Algo3TP2.EntidadesTests;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Jugador;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.UnidadInvalidaException;
import Algo3TP2.Modelos.Unidades.Catapulta;
import Algo3TP2.Modelos.Unidades.Curandero;
import Algo3TP2.Modelos.Unidades.ExcepcionesCurar.AliadoConSaludCompletaNoSePuedeCurarExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesCurar.CatapultaNoPuedeSerCuradaExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesCurar.DistanciaParaCurarIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesCurar.UnidadCuradaEsEnemigaExcepcion;
import Algo3TP2.Modelos.Unidades.Unidad;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CuranderoTests {

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
    public void CuranderoNuevoEsDistintoAnull() {
        // Act
        Unidad curandero = new Curandero(bandoAliado);

        // Assert
        assertNotNull(curandero);
    }

    @Test
    public void CuranderoNuevoTiene75DeVida() {
        // Arrange
        Unidad curandero = new Curandero(bandoAliado);

        // Assert
        assertEquals(75, curandero.getVida());
    }

    @Test
    public void CuranderoNuevoTrasGenerarDanioNoTiene75DeVida() throws UnidadInvalidaException {
        // Arrange
        Unidad curandero = new Curandero(bandoAliado);

        // Act
        curandero.recibirDanio(10);

        // Assert
        assert (75 != curandero.getVida());
    }

    @Test
    public void CuranderoNuevoTrasGenerarDanioPor15PuntosAhoraTiene60DeVida() throws UnidadInvalidaException {
        // Arrange
        Unidad curandero = new Curandero(bandoAliado);

        // Act
        curandero.recibirDanio(15);

        // Assert
        assertEquals(60, curandero.getVida());
    }

    @Test
    public void CuranderoCuraACuranderoAliadoCura15PuntosDeVida() throws Exception {
        // Arrange
        Curandero curanderoCurador = new Curandero(bandoAliado);
        tablero.posicionarUnidad(curanderoCurador, new Coordenada(1, 1));

        Curandero curanderoCurado = new Curandero(bandoAliado);
        tablero.posicionarUnidad(curanderoCurado, new Coordenada(2, 2));

        // Act
        curanderoCurado.recibirDanio(30);
        curanderoCurador.curar(curanderoCurado);

        // Assert
        assertEquals(60, curanderoCurado.getVida());
    }

    @Test
    public void CuranderoCura2VecesACuranderoAliadoCurando30PuntosDeVida() throws Exception {
        // Arrange
        Curandero curanderoCurador = new Curandero(bandoAliado);
        tablero.posicionarUnidad(curanderoCurador, new Coordenada(1, 1));

        Curandero curanderoCurado = new Curandero(bandoAliado);
        tablero.posicionarUnidad(curanderoCurado, new Coordenada(2, 2));

        // Act
        curanderoCurado.recibirDanio(30);
        curanderoCurador.curar(curanderoCurado);
        curanderoCurador.curar(curanderoCurado);

        // Assert
        assertEquals(75, curanderoCurado.getVida());
    }

    @Test(expected = UnidadCuradaEsEnemigaExcepcion.class)
    public void CuranderoCuraACuranderoEnemigoLanzaExcepcion()
            throws Exception {
        // Arrange
        Curandero curanderoCurador = new Curandero(bandoAliado);
        tablero.posicionarUnidad(curanderoCurador, new Coordenada(1, 1));

        Curandero curanderoCurado = new Curandero(bandoEnemigo);
        tablero.posicionarUnidad(curanderoCurado, new Coordenada(2, 2));

        // Act Assert
        curanderoCurador.curar(curanderoCurado);
    }

    @Test(expected = DistanciaParaCurarIncorrectaExcepcion.class)
    public void CuranderoCuraACuranderoAliadoUbicadoADistanciaMayorQueLaCortaLanzaExcepcion() throws Exception {
        // Arrange
        Curandero curanderoCurador = new Curandero(bandoAliado);
        tablero.posicionarUnidad(curanderoCurador, new Coordenada(1, 1));

        Curandero curanderoCurado = new Curandero(bandoAliado);
        tablero.posicionarUnidad(curanderoCurado, new Coordenada(19, 19));

        // Act Assert
        curanderoCurador.curar(curanderoCurado);
    }

    @Test(expected = AliadoConSaludCompletaNoSePuedeCurarExcepcion.class)
    public void CuranderoNoPuedeCurarAUnidadAliadaQueTieneLaVidaMaxima() throws Exception {
        // Arrange
        Curandero curanderoCurador = new Curandero(bandoAliado);
        tablero.posicionarUnidad(curanderoCurador, new Coordenada(1, 1));

        Curandero curanderoVidaCompleta = new Curandero(bandoAliado);
        tablero.posicionarUnidad(curanderoVidaCompleta, new Coordenada(2, 2));

        // Act Assert
        curanderoCurador.curar(curanderoVidaCompleta);
    }

    @Test
    public void CuranderoCuraAUnidadAliadaQueLeSacaron5PuntosYHaceQueSuVidaSeaMaxima() throws Exception {
        // Arrange
        Curandero curanderoCurador = new Curandero(bandoAliado);
        tablero.posicionarUnidad(curanderoCurador, new Coordenada(1, 1));

        Curandero curanderoCurado = new Curandero(bandoAliado);
        tablero.posicionarUnidad(curanderoCurado, new Coordenada(2, 2));

        // Act
        curanderoCurado.recibirDanio(5);
        curanderoCurador.curar(curanderoCurado);

        // Assert
        assertEquals(75, curanderoCurado.getVida());
    }

    @Test(expected = CatapultaNoPuedeSerCuradaExcepcion.class)
    public void CurarACatapultaLanzaExcepcion()
            throws Exception {
        //Arrange
        Curandero curandero = new Curandero(bandoAliado);
        tablero.posicionarUnidad(curandero, new Coordenada(1, 1));

        Catapulta catapulta = new Catapulta(bandoAliado);
        tablero.posicionarUnidad(catapulta, new Coordenada(2, 2));

        //Act Assert
        curandero.curar(catapulta);
    }
}
