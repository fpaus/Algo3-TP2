package Algo3TP2.CatedraTest.Entrega2Test;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Jugador;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.UnidadInvalidaException;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Modelos.Unidades.Jinete;
import Algo3TP2.Modelos.Unidades.Soldado;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JineteTest {

    Tablero tablero;
    Bando bandoAliado, bandoEnemigo;

    @Before
    public void before(){
        Jugador jugadorAliado = new Jugador();
        bandoAliado = new Bando(jugadorAliado);
        Jugador jugadorEnemigo = new Jugador();
        bandoEnemigo = new Bando(jugadorEnemigo);
        tablero = Tablero.getTablero();
        tablero.inicializarTablero(20,20, jugadorAliado, jugadorEnemigo);
    }

    @Test
    /*Un jinete sin aliados en distancia corta y un enemigo
    en distancia corta, ataca con su espada al enemigo y se
    verifica que se realiza correctamente el ataque.*/
    public void jineteSinAliadosADistanciaCortaAtacaConEspada() throws CasilleroFueraDelLosLimitesDelTableroExcepcion,
            CasilleroOcupadoExcepcion, DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion, UnidadInvalidaException {
        // Arrange

        Jinete jinete = new Jinete(bandoAliado);

        Casillero casillero = tablero.getCasilleroEnPosicion(new Coordenada(5,5));
        jinete.colocarEnCasillero(casillero);

        Soldado soladoEnemigo = new Soldado(bandoEnemigo);

        Casillero casilleroContiguo = tablero.getCasilleroEnPosicion(new Coordenada(5,6));
        soladoEnemigo.colocarEnCasillero(casilleroContiguo);

        // Act
        jinete.atacar(soladoEnemigo);

        // Assert
        assertEquals(95,soladoEnemigo.getVida());
    }

    @Test(expected = DistanciaDeAtaqueIncorrectaExcepcion.class)
    /*Un jinete sin aliados en distancia corta y un enemigo
    en distancia corta y otro enemigo en distancia media,
    trata de atacar al enemigo en distancia media y se
    verifica que no se puede realizar el ataque.*/
    public void jineteSinAliadosADistanciaMediaNoPuedeAtacar() throws CasilleroFueraDelLosLimitesDelTableroExcepcion,
            CasilleroOcupadoExcepcion, UnidadAtacadaEsAliadaExcepcion, UnidadInvalidaException, DistanciaDeAtaqueIncorrectaExcepcion {
        // Arrange
        Tablero tablero = Tablero.getTablero();
        Jugador jugadorAliado = new Jugador();
        Bando bandoAliado = new Bando(jugadorAliado);
        Jugador jugadorEnemigo = new Jugador();
        Bando bandoEnemigo = new Bando(jugadorEnemigo);
        tablero.inicializarTablero(20,20, jugadorAliado, jugadorEnemigo);

        Jinete jinete = new Jinete(bandoAliado);
        Casillero casillero = tablero.getCasilleroEnPosicion(new Coordenada(5,5));
        jinete.colocarEnCasillero(casillero);
        Soldado soladoEnemigoCercano = new Soldado(bandoEnemigo);
        Casillero casilleroContiguo = tablero.getCasilleroEnPosicion(new Coordenada(5,6));
        soladoEnemigoCercano.colocarEnCasillero(casilleroContiguo);
        Soldado soladoEnemigoLejano = new Soldado(bandoEnemigo);
        Casillero casilleroLejano = tablero.getCasilleroEnPosicion(new Coordenada(9,9));
        soladoEnemigoLejano.colocarEnCasillero(casilleroLejano);

        // Act Assert
        jinete.atacar(soladoEnemigoLejano);
    }
}
