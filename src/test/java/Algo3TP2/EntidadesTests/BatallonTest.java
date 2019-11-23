package Algo3TP2.EntidadesTests;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Tablero.Direccion.*;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Unidades.Batallon.Batallon;
import Algo3TP2.Modelos.Unidades.Batallon.BatallonCompletoExcepcion;
import Algo3TP2.Modelos.Unidades.Batallon.BatallonIncompletoExcepcion;
import Algo3TP2.Modelos.Unidades.Batallon.ElSoldadoNoSeEncuentraContiguoAlBatallonExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Modelos.*;
import Algo3TP2.Modelos.Unidades.Soldado;
import Algo3TP2.Modelos.Unidades.Unidad;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BatallonTest {

    private Tablero tablero;
    private Bando bandoAliado, bandoEnemigo;

    @Before // Inicializo el tablero y los bandos Aliados/Enemigos
    public void before(){
        Jugador jugadorAliado = new Jugador();
        bandoAliado = new Bando(jugadorAliado);
        Jugador jugadorEnemigo = new Jugador();
        bandoEnemigo = new Bando(jugadorEnemigo);
        tablero = Tablero.getTablero();
        tablero.inicializarTablero(20,20, jugadorAliado, jugadorEnemigo);
    }
    /*
    @Test
    public void tresSoldadosSePuedenMoverComoBatallonTest()
            throws CasilleroOcupadoExcepcion, CasilleroFueraDelLosLimitesDelTableroExcepcion, BatallonCompletoExcepcion,
            BatallonIncompletoExcepcion, ElSoldadoNoSeEncuentraContiguoAlBatallonExcepcion {
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Soldado soldado1 = new Soldado(bando);
        Soldado soldado2 = new Soldado(bando);
        Soldado soldado3 = new Soldado(bando);
        Tablero tablero = Tablero.getTablero();
        tablero.inicializarTablero(20, 20, jugador, new Jugador());
        soldado1.colocarEnCasillero(tablero.getCasilleroEnPosicion(new Coordenada(2,1)));
        soldado2.colocarEnCasillero(tablero.getCasilleroEnPosicion(new Coordenada(2,2)));
        soldado3.colocarEnCasillero(tablero.getCasilleroEnPosicion(new Coordenada(2,3)));

        soldado1.conformarBatallonCon(soldado2);
        soldado1.conformarBatallonCon(soldado3);
        soldado1.moverBatallonHaciaAbajo();
        

        assertEquals(soldado1.getCasillero(), tablero.getCasilleroEnPosicion(new Coordenada(2,0)));
        assertEquals(soldado2.getCasillero(), tablero.getCasilleroEnPosicion(new Coordenada(2,1)));
        assertEquals(soldado3.getCasillero(), tablero.getCasilleroEnPosicion(new Coordenada(2,2)));
    }
     */

    @Test
    public void reunirBatallonMetodoTest() throws Exception{
        Soldado soldado = new Soldado(bandoAliado);
        tablero.posicionarUnidad(soldado, new Coordenada(5,5));

        Soldado soldado1 = new Soldado(bandoAliado);
        tablero.posicionarUnidad(soldado1, new Coordenada(5,6));

        Soldado soldado2 = new Soldado(bandoAliado);
        tablero.posicionarUnidad(soldado2, new Coordenada(5,7));

        ArrayList<Soldado> soldadoDelBatallon = soldado.reunirBatallon();
        Iterator<Soldado> iter = soldadoDelBatallon.iterator();
        Soldado integrante1 = iter.next();
        Soldado integrante2 = iter.next();
        Soldado integrante3 = iter.next();
        assertTrue((soldado1 == integrante1) || ( soldado1 == integrante2) || (soldado1 == integrante3));
        assertTrue((soldado2 == integrante1) || ( soldado2 == integrante2) || (soldado2 == integrante3));
        assertTrue((soldado == integrante1) || ( soldado == integrante2) || (soldado == integrante3));
    }
}