package Algo3TP2.CatedraTest.Entrega1Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import Algo3TP2.Modelos.*;
import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Unidades.*;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.AtaqueDeJIneteConArcoYFlecha;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.AtaqueDeJineteConEspada;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesCurar.AliadoConSaludCompletaNoSePuedeCurarExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesCurar.CatapultaNoPuedeSerCuradaExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesCurar.DistanciaParaCurarIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesCurar.UnidadCuradaEsEnemigaExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesMovimientos.MovimientoNoContiguoExcepcion;
import org.junit.Test;

public class UnidadTest {

    @Test
    public void unidadMovibleSePuedeMoverEnTodasDireccionesTest() throws CasilleroFueraDelLosLimitesDelTableroExcepcion,
            MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        Jugador j1 = new Jugador();
        Tablero tablero = Tablero.getTablero();
        tablero.inicializarTablero(20, 20, j1, new Jugador());
        UnidadMovible unidad = new Soldado(new Bando(j1));

        Casillero casillero = tablero.getCasilleroEnPosicion(new Coordenada(2,2));
        unidad.colocarEnCasillero(casillero);


        unidad.moverHaciaArriba();
        assertEquals(unidad.getCasillero(), tablero.getCasilleroEnPosicion(new Coordenada(2,3)));

        unidad.moverHaciaAbajo();
        assertEquals(unidad.getCasillero(), tablero.getCasilleroEnPosicion(new Coordenada(2,2)));

        unidad.moverHaciaLaIzquierda();
        assertEquals(unidad.getCasillero(), tablero.getCasilleroEnPosicion(new Coordenada(1,2)));

        unidad.moverHaciaLaDerecha();
        assertEquals(unidad.getCasillero(),tablero.getCasilleroEnPosicion(new Coordenada(2,2)));

        unidad.moverHaciaLaIzquierdaArriba();
        assertEquals(unidad.getCasillero(), tablero.getCasilleroEnPosicion(new Coordenada(1,3)));

        unidad.moverHaciaLaDerechaAbajo();
        assertEquals(unidad.getCasillero(), tablero.getCasilleroEnPosicion(new Coordenada(2,2)));

        unidad.moverHaciaLaDerechaArriba();
        assertEquals(unidad.getCasillero(), tablero.getCasilleroEnPosicion(new Coordenada(3,3)));

        unidad.moverHaciaLaIzquierdaAbajo();
        assertEquals(unidad.getCasillero(), tablero.getCasilleroEnPosicion(new Coordenada(2,2)));

    }

    @Test(expected = CasilleroOcupadoExcepcion.class)
    public void unidadMovibleNoPuedeMoverseAUnCasilleroOcupadoTest()
            throws MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        // Arrange
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Casillero casillero = new Casillero(new Coordenada(1,1),jugador);
        Casillero casilleroContiguoOcupado = new Casillero(new Coordenada(2,1),jugador);
        Unidad unidadOcupante = new Soldado(bando);
        casilleroContiguoOcupado.setUnidad(unidadOcupante);

        UnidadMovible soldado = new Soldado(bando);
        soldado.colocarEnCasillero(casillero);
        casillero.setUnidad(soldado);

        // Act
        soldado.mover(casilleroContiguoOcupado);
    }

    @Test
    public void soldadoDeInfanteriaAliadoAtacaPiezaEnemigaSeVerificaQueSeRestaVidaCorrecpondienteTest()
            throws UnidadAtacadaEsAliadaExcepcion, DistanciaDeAtaqueIncorrectaExcepcion, UnidadInvalidaException,
            CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(new Coordenada(1, 1), jugador1);
        Soldado soldadoAtacante = new Soldado(bando1);
        soldadoAtacante.colocarEnCasillero(casillero1);

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(new Coordenada(2, 2), jugador2);
        Soldado soldadoAtacado = new Soldado(bando2);
        soldadoAtacado.colocarEnCasillero(casillero2);

        // Act
        soldadoAtacante.atacar(soldadoAtacado);

        // Assert
        assertEquals(90, soldadoAtacado.getVida());
    }

    @Test
    public void jineteAliadoAtacaPiezaEnemigaSeVerificaQueSeRestaVidaCorrespondienteTest()
            throws UnidadAtacadaEsAliadaExcepcion, DistanciaDeAtaqueIncorrectaExcepcion, UnidadInvalidaException,
            CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        // Arrange Ataque con espada a distancia corta
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(new Coordenada(1, 1), jugador1);
        Jinete jineteAtacante = new Jinete(bando1);
        jineteAtacante.colocarEnCasillero(casillero1);
        jineteAtacante.setEstrategiaDeAtaque(new AtaqueDeJineteConEspada());

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casilleroDistanciaCorta = new Casillero(new Coordenada(2, 2), jugador2);
        Jinete jineteAtacado = new Jinete(bando2);
        jineteAtacado.colocarEnCasillero(casilleroDistanciaCorta);

        // Act
        jineteAtacante.atacar(jineteAtacado);
        // Assert
        assertEquals(95, jineteAtacado.getVida());

        // Arrange  Ataque con arco y flecha a distancia media
        Casillero casilleroDistanciaMedia = new Casillero(new Coordenada(5, 5), jugador2);
        jineteAtacado.colocarEnCasillero(casilleroDistanciaMedia);
        jineteAtacante.setEstrategiaDeAtaque(new AtaqueDeJIneteConArcoYFlecha());

        // Act
        jineteAtacante.atacar(jineteAtacado);
        // Assert
        assertEquals(80, jineteAtacado.getVida());
    }

    @Test
    public void curanderoAliadoCuraPiezaAliadaSeVerificaQueSeSumaVidaCorrespondienteTest()
            throws DistanciaParaCurarIncorrectaExcepcion, AliadoConSaludCompletaNoSePuedeCurarExcepcion,
            CatapultaNoPuedeSerCuradaExcepcion, UnidadCuradaEsEnemigaExcepcion, UnidadInvalidaException,
            CasilleroOcupadoExcepcion {
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(new Coordenada(1, 1), jugador1);
        Casillero casillero2 = new Casillero(new Coordenada(2, 2), jugador1);
        Curandero curanderoCurador = new Curandero(bando1);
        Curandero curanderoCurado = new Curandero(bando1);
        curanderoCurador.colocarEnCasillero(casillero1);
        curanderoCurado.colocarEnCasillero(casillero2);

        // Act
        curanderoCurado.recibirDanio(30);
        curanderoCurador.curar(curanderoCurado);

        // Assert
        assertEquals(60, curanderoCurado.getVida());
    }

    @Test
    public void catapultaAliadaAtacaPiezaEnemigaSeVerificaQueSeRestaVidaCorrespondienteTest()
            throws UnidadAtacadaEsAliadaExcepcion, DistanciaDeAtaqueIncorrectaExcepcion, UnidadInvalidaException,
            CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(new Coordenada(1, 1), jugador1);
        Catapulta catapulta = new Catapulta(bando1);
        catapulta.colocarEnCasillero(casillero1);

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(new Coordenada(20, 20), jugador2);
        Soldado soldadoAtacado = new Soldado(bando2);
        soldadoAtacado.colocarEnCasillero(casillero2);

        // Act
        catapulta.atacar(soldadoAtacado);

        // Assert
        assertEquals(80, soldadoAtacado.getVida());
    }


}
