package CatedraTest.Entrega1Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import Algo3TP2.Modelos.*;
import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
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
import Algo3TP2.Modelos.Unidades.ExcepcionesMovimientos.MovimientoInvalidoExcepcion;
import org.junit.Test;

public class UnidadTest {

    @Test
    public void unidadMovibleSePuedeMoverEnTodasDireccionesTest()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
        Jugador j1 = new Jugador();
        Tablero tablero = new Tablero(20,20, j1, new Jugador());
        UnidadMovible unidad = new Soldado(new Bando(j1));

        Casillero casillero = tablero.getCasilleroEnPosicion(2,2);
        unidad.colocarEnCasillero(casillero);

        //me muevo hacia arriba
        unidad.mover(tablero.getCasilleroEnPosicion(2,3));
        assertEquals(unidad.getCasillero(), tablero.getCasilleroEnPosicion(2,3));
        //me muevo hacia abajo
        unidad.mover(tablero.getCasilleroEnPosicion(2,2));
        assertEquals(unidad.getCasillero(), tablero.getCasilleroEnPosicion(2,2));
        //me muevo hacia la izquierda
        unidad.mover(tablero.getCasilleroEnPosicion(1,2));
        assertEquals(unidad.getCasillero(), tablero.getCasilleroEnPosicion(1,2));
        //me muevo hacia la derecha
        unidad.mover(tablero.getCasilleroEnPosicion(2,2));
        assertEquals(unidad.getCasillero(),tablero.getCasilleroEnPosicion(2,2));
        //me muevo hacia arriba - izquierda
        unidad.mover(tablero.getCasilleroEnPosicion(1,3));
        assertEquals(unidad.getCasillero(), tablero.getCasilleroEnPosicion(1,3));
        //me muevo hacia abajo, derecha
        unidad.mover(tablero.getCasilleroEnPosicion(2,2));
        assertEquals(unidad.getCasillero(), tablero.getCasilleroEnPosicion(2,2));
        ////me muevo hacia arriba - derecha
        unidad.mover(tablero.getCasilleroEnPosicion(3,3));
        assertEquals(unidad.getCasillero(), tablero.getCasilleroEnPosicion(3,3));
        //me muevo hacia abajo - izquierda
        unidad.mover(tablero.getCasilleroEnPosicion(2,2));
        assertEquals(unidad.getCasillero(), tablero.getCasilleroEnPosicion(2,2));

    }

    @Test(expected = CasilleroOcupadoExcepcion.class)
    public void unidadMovibleNoPuedeMoverseAUnCasilleroOcupadoTest()
            throws MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
        // Arrange
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Casillero casillero = new Casillero(1,1,jugador);
        Casillero casilleroContiguoOcupado = new Casillero(2,1,jugador);
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
            throws UnidadAtacadaEsAliadaExcepcion, DistanciaDeAtaqueIncorrectaExcepcion {
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(1, 1, jugador1);
        Soldado soldadoAtacante = new Soldado(bando1);
        soldadoAtacante.colocarEnCasillero(casillero1);

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(2, 2, jugador2);
        Soldado soldadoAtacado = new Soldado(bando2);
        soldadoAtacado.colocarEnCasillero(casillero2);

        // Act
        soldadoAtacante.atacar(soldadoAtacado);

        // Assert
        assertEquals(90, soldadoAtacado.getVida());
    }

    @Test
    public void jineteAliadoAtacaPiezaEnemigaSeVerificaQueSeRestaVidaCorrespondienteTest()
            throws UnidadAtacadaEsAliadaExcepcion, DistanciaDeAtaqueIncorrectaExcepcion {
        // Arrange Ataque con espada a distancia corta
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(1, 1, jugador1);
        Jinete jineteAtacante = new Jinete(bando1);
        jineteAtacante.colocarEnCasillero(casillero1);
        jineteAtacante.setEstrategiaDeAtaque(new AtaqueDeJineteConEspada());

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casilleroDistanciaCorta = new Casillero(2, 2, jugador2);
        Jinete jineteAtacado = new Jinete(bando2);
        jineteAtacado.colocarEnCasillero(casilleroDistanciaCorta);

        // Act
        jineteAtacante.atacar(jineteAtacado);
        // Assert
        assertEquals(95, jineteAtacado.getVida());

        // Arrange  Ataque con arco y flecha a distancia media
        Casillero casilleroDistanciaMedia = new Casillero(5, 5, jugador2);
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
            CatapultaNoPuedeSerCuradaExcepcion, UnidadCuradaEsEnemigaExcepcion {
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
    public void catapultaAliadaAtacaPiezaEnemigaSeVerificaQueSeRestaVidaCorrespondienteTest()
            throws UnidadAtacadaEsAliadaExcepcion, DistanciaDeAtaqueIncorrectaExcepcion {
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(1, 1, jugador1);
        Catapulta catapulta = new Catapulta(bando1);
        catapulta.colocarEnCasillero(casillero1);

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(20, 20, jugador2);
        Soldado soldadoAtacado = new Soldado(bando2);
        soldadoAtacado.colocarEnCasillero(casillero2);

        // Act
        catapulta.atacar(soldadoAtacado);

        // Assert
        assertEquals(80, soldadoAtacado.getVida());
    }


}
