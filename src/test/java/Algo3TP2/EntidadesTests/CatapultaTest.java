package Algo3TP2.EntidadesTests;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Modelos.*;
import Algo3TP2.Modelos.Unidades.Catapulta;
import Algo3TP2.Modelos.Unidades.Jinete;
import Algo3TP2.Modelos.Unidades.Soldado;
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
        Casillero casillero1 = new Casillero(new Coordenada(1, 1), jugador1);
        Catapulta catapultaAtacante = new Catapulta(bando1);
        catapultaAtacante.colocarEnCasillero(casillero1);

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(new Coordenada(20, 20), jugador2);
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
        Casillero casillero1 = new Casillero(new Coordenada(1, 1), jugador1);
        Catapulta catapultaAtacante = new Catapulta(bando1);
        catapultaAtacante.colocarEnCasillero(casillero1);

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(new Coordenada(20, 20), jugador2);
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
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion, UnidadInvalidaException,
            CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(new Coordenada(1, 1), jugador1);
        Catapulta catapultaAtacante = new Catapulta(bando1);
        catapultaAtacante.colocarEnCasillero(casillero1);

        Casillero casillero2 = new Casillero(new Coordenada(20, 20), jugador1);
        Catapulta catapultaAtacada = new Catapulta(bando1);
        catapultaAtacada.colocarEnCasillero(casillero2);

        // Act
        catapultaAtacante.atacar(catapultaAtacada);

        // Assert
        assertEquals(30, catapultaAtacada.getVida());
    }

    @Test(expected = DistanciaDeAtaqueIncorrectaExcepcion.class)
    public void CatapultaAtacaACatapultaEnemigaUbicadaADistanciaMenorQueLaLargaLanzaExcepcion()
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion, UnidadInvalidaException,
            CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(new Coordenada(1, 1), jugador1);
        Catapulta catapultaAtacante = new Catapulta(bando1);
        catapultaAtacante.colocarEnCasillero(casillero1);

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(new Coordenada(2, 2), jugador2);
        Catapulta catapultaAtacada = new Catapulta(bando2);
        catapultaAtacada.colocarEnCasillero(casillero2);

        // Act Assert
        catapultaAtacante.atacar(catapultaAtacada);
    }

    @Test(expected = DistanciaDeAtaqueIncorrectaExcepcion.class) //Caso Borde
    public void CatapultaAtacaACatapultaEnemigaUbicadaADistancia5LanzaExcepcion()
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion, UnidadInvalidaException,
            CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(new Coordenada(1, 1), jugador1);
        Catapulta catapultaAtacante = new Catapulta(bando1);
        catapultaAtacante.colocarEnCasillero(casillero1);

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(new Coordenada(5, 5), jugador2);
        Catapulta catapultaAtacada = new Catapulta(bando2);
        catapultaAtacada.colocarEnCasillero(casillero2);

        // Act Assert
        catapultaAtacante.atacar(catapultaAtacada);
    }

    @Test //Caso Borde
    public void CatapultaAtacaACatapultaEnemigaUbicadaADistancia7GeneraDanio()
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion, UnidadInvalidaException,
            CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        // Arrange
        Jugador jugador1 = new Jugador();
        Bando bando1 = new Bando(jugador1);
        Casillero casillero1 = new Casillero(new Coordenada(1, 1), jugador1);
        Catapulta catapultaAtacante = new Catapulta(bando1);
        catapultaAtacante.colocarEnCasillero(casillero1);

        Jugador jugador2 = new Jugador();
        Bando bando2 = new Bando(jugador2);
        Casillero casillero2 = new Casillero(new Coordenada(7, 7), jugador2);
        Catapulta catapultaAtacada = new Catapulta(bando2);
        catapultaAtacada.colocarEnCasillero(casillero2);

        // Act
        catapultaAtacante.atacar(catapultaAtacada);

        // Assert
        assertEquals(30, catapultaAtacada.getVida());
    }

    @Test
    public void CatapultaAtacaAUnidadGeneraDanioATodasLasUnidadesContiguas()
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion, UnidadInvalidaException,
            CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        // Arrange
        Jugador jugador1 = new Jugador(); Bando bando1 = new Bando(jugador1);
        Jugador jugador2 = new Jugador(); Bando bando2 = new Bando(jugador2);
        Tablero tablero = Tablero.getTablero();
        tablero.inicializarTablero(20,20, jugador1, jugador2);

        Casillero casilleroAtacante = tablero.getCasilleroEnPosicion(new Coordenada(1,1));
        Catapulta catapultaAtacante = new Catapulta(bando1);
        catapultaAtacante.colocarEnCasillero(casilleroAtacante);

        Casillero casilleroAtacado1 = tablero.getCasilleroEnPosicion(new Coordenada(7,7));
        Soldado soldadoAtacado1 = new Soldado(bando1);
        soldadoAtacado1.colocarEnCasillero(casilleroAtacado1);
        //casilleroAtacado1.setUnidad(soldadoAtacado1);

        Casillero casilleroAtacado2 = tablero.getCasilleroEnPosicion(new Coordenada(6,7));
        Soldado soldadoAtacado2 = new Soldado(bando2);
        soldadoAtacado2.colocarEnCasillero(casilleroAtacado2);
        //casilleroAtacado2.setUnidad(soldadoAtacado2);

        Casillero casilleroAtacado3 = tablero.getCasilleroEnPosicion(new Coordenada(5,7));
        Jinete jineteAtacado3 = new Jinete(bando2);
        jineteAtacado3.colocarEnCasillero(casilleroAtacado3);
        //casilleroAtacado3.setUnidad(jineteAtacado3);

        Casillero casilleroNoAtacado4 = tablero.getCasilleroEnPosicion(new Coordenada(3,7));
        Jinete jineteNoAtacado4 = new Jinete(bando1);
        jineteNoAtacado4.colocarEnCasillero(casilleroNoAtacado4);
        //casilleroNoAtacado4.setUnidad(jineteNoAtacado4);

        // Act
        catapultaAtacante.atacar(soldadoAtacado1);

        // Assert
        assertEquals(80, soldadoAtacado1.getVida());
        assertEquals(80, soldadoAtacado2.getVida());
        assertEquals(80, jineteAtacado3.getVida());
        assertEquals(100, jineteNoAtacado4.getVida());
    }

}
