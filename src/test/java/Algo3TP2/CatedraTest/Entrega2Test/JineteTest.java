package Algo3TP2.CatedraTest.Entrega2Test;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Jugador;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.Jinete;
import Algo3TP2.Modelos.Unidades.Soldado;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JineteTest {

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
    /*Un jinete sin aliados en distancia corta y un enemigo
    en distancia corta, ataca con su espada al enemigo y se
    verifica que se realiza correctamente el ataque.*/
    public void jineteSinAliadosADistanciaCortaAtacaConEspada() throws Exception {
        // Arrange
        Jinete jinete = new Jinete(bandoAliado);
        tablero.posicionarUnidad(jinete, new Coordenada(5, 5));

        Soldado soladoEnemigo = new Soldado(bandoEnemigo);
        tablero.posicionarUnidad(soladoEnemigo, new Coordenada(5, 6));

        // Act
        jinete.atacar(soladoEnemigo);

        // Assert
        assertEquals(95, soladoEnemigo.getVida(), 0);
    }

    @Test(expected = DistanciaDeAtaqueIncorrectaExcepcion.class)
    /*Un jinete sin aliados en distancia corta y un enemigo
    en distancia corta y otro enemigo en distancia media,
    trata de atacar al enemigo en distancia media y se
    verifica que no se puede realizar el ataque.*/
    public void jineteSinAliadosADistanciaMediaNoPuedeAtacar() throws Exception {
        // Arrange
        Jinete jinete = new Jinete(bandoAliado);
        tablero.posicionarUnidad(jinete, new Coordenada(5, 5));

        Soldado soladoEnemigoCercano = new Soldado(bandoEnemigo);
        tablero.posicionarUnidad(soladoEnemigoCercano, new Coordenada(5, 6));

        Soldado soladoEnemigoLejano = new Soldado(bandoEnemigo);
        tablero.posicionarUnidad(soladoEnemigoLejano, new Coordenada(9, 9));

        // Act Assert
        jinete.atacar(soladoEnemigoLejano);
    }
}
