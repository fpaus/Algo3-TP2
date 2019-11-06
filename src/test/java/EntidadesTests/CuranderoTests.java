package EntidadesTests;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Unidades.ExcepcionesCurar.AliadoConSaludCompletaNoSePuedeCurarExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesCurar.CatapultaNoPuedeSerCuradaExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesCurar.DistanciaParaCurarIncorrectaExcepcion;
import Algo3TP2.Modelos.*;
import Algo3TP2.Modelos.Unidades.Curandero;
import Algo3TP2.Modelos.Unidades.ExcepcionesCurar.UnidadCuradaEsEnemigaExcepcion;
import Algo3TP2.Modelos.Unidades.Unidad;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CuranderoTests {

    @Test
    public void CuranderoNuevoEsDistintoAnull() {
        // Arrange
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);

        // Act
        Unidad curandero = new Curandero(bando);

        // Assert
        assertNotNull(curandero);
    }

    @Test
    public void CuranderoNuevoTiene75DeVida() {
        // Arrange
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Unidad curandero = new Curandero(bando);

        // Act
        int vidaCurandero = curandero.getVida();

        // Assert
        assertEquals(75, vidaCurandero);
    }

    @Test
    public void CuranderoNuevoTrasGenerarDanioNoTiene75DeVida() {
        // Arrange
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Unidad curandero = new Curandero(bando);

        // Act
        curandero.generarDanio(10);
        int vidaCurandero = curandero.getVida();

        // Assert
        assert (75 != vidaCurandero);
    }

    @Test
    public void CuranderoNuevoTrasGenerarDanioPor15PuntosAhoraTiene60DeVida() {
        // Arrange
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Unidad curandero = new Curandero(bando);

        // Act
        curandero.generarDanio(15);

        // Assert
        assertEquals(60, curandero.getVida());
    }

    @Test
    public void CuranderoCuraACuranderoAliadoCura15PuntosDeVida() throws Exception {
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(1, 1, jugador1);
        Casillero casillero2 = new Casillero(2, 2, jugador1);
        Curandero curanderoCurador = new Curandero(bando1);
        Curandero curanderoCurado = new Curandero(bando1);
        curanderoCurador.colocarEnCasillero(casillero1);
        curanderoCurado.colocarEnCasillero(casillero2);

        // Act
        curanderoCurado.generarDanio(30);
        curanderoCurador.curar(curanderoCurado);

        // Assert
        assertEquals(60, curanderoCurado.getVida());
    }

    @Test
    public void CuranderoCura2VecesACuranderoAliadoCurando30PuntosDeVida() throws Exception {
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(1, 1, jugador1);
        Casillero casillero2 = new Casillero(2, 2, jugador1);
        Curandero curanderoCurador = new Curandero(bando1);
        Curandero curanderoCurado = new Curandero(bando1);
        curanderoCurador.colocarEnCasillero(casillero1);
        curanderoCurado.colocarEnCasillero(casillero2);

        // Act
        curanderoCurado.generarDanio(30);
        curanderoCurador.curar(curanderoCurado);
        curanderoCurador.curar(curanderoCurado);

        // Assert
        assertEquals(75, curanderoCurado.getVida());
    }

    @Test(expected = UnidadCuradaEsEnemigaExcepcion.class)
    public void CuranderoCuraACuranderoEnemigoLanzaExcepcion()
            throws DistanciaParaCurarIncorrectaExcepcion, AliadoConSaludCompletaNoSePuedeCurarExcepcion,
                CatapultaNoPuedeSerCuradaExcepcion, UnidadCuradaEsEnemigaExcepcion {
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(1, 1, jugador1);
        Curandero curanderoCurador = new Curandero(bando1);
        curanderoCurador.colocarEnCasillero(casillero1);

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(2, 2, jugador2);
        Curandero curanderoCurado = new Curandero(bando2);
        curanderoCurado.colocarEnCasillero(casillero2);

        // Act Assert
        curanderoCurador.curar(curanderoCurado);
    }

    @Test(expected = DistanciaParaCurarIncorrectaExcepcion.class)
    public void CuranderoCuraACuranderoAliadoUbicadoADistanciaMayorQueLaCortaLanzaExcepcion()
            throws DistanciaParaCurarIncorrectaExcepcion, UnidadCuradaEsEnemigaExcepcion,
                CatapultaNoPuedeSerCuradaExcepcion, AliadoConSaludCompletaNoSePuedeCurarExcepcion {
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(1, 1, jugador1);
        Curandero curanderoCurador = new Curandero(bando1);
        curanderoCurador.colocarEnCasillero(casillero1);

        Casillero casillero2 = new Casillero(20, 20, jugador1);
        Curandero curanderoCurado = new Curandero(bando1);
        curanderoCurado.colocarEnCasillero(casillero2);
        // Act Assert
        curanderoCurador.curar(curanderoCurado);
    }

    @Test(expected = AliadoConSaludCompletaNoSePuedeCurarExcepcion.class)
    public void CuranderoNoPuedeCurarAUnidadAliadaQueTieneLaVidaMaxima()
        throws DistanciaParaCurarIncorrectaExcepcion, UnidadCuradaEsEnemigaExcepcion,
            CatapultaNoPuedeSerCuradaExcepcion, AliadoConSaludCompletaNoSePuedeCurarExcepcion {
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(1, 1, jugador1);
        Curandero curanderoCurador = new Curandero(bando1);
        curanderoCurador.colocarEnCasillero(casillero1);

        Casillero casillero2 = new Casillero(2, 2, jugador1);
        Curandero curanderoCurado = new Curandero(bando1);
        curanderoCurado.colocarEnCasillero(casillero2);
        // Act Assert
        curanderoCurador.curar(curanderoCurado);
    }

    @Test
    public void CuranderoCuraAUnidadAliadaQueLeSacaron5PuntosYHaceQueSuVidaSeaMaxima()
        throws DistanciaParaCurarIncorrectaExcepcion, UnidadCuradaEsEnemigaExcepcion,
            CatapultaNoPuedeSerCuradaExcepcion, AliadoConSaludCompletaNoSePuedeCurarExcepcion {
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(1, 1, jugador1);
        Curandero curanderoCurador = new Curandero(bando1);
        curanderoCurador.colocarEnCasillero(casillero1);

        Casillero casillero2 = new Casillero(2, 2, jugador1);
        Curandero curanderoCurado = new Curandero(bando1);
        curanderoCurado.colocarEnCasillero(casillero2);
        // Act Assert
        curanderoCurado.generarDanio(5);
        curanderoCurador.curar(curanderoCurado);
        assertEquals(75, curanderoCurado.getVida());
    }
}
