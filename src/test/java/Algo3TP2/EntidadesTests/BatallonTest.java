package Algo3TP2.EntidadesTests;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Tablero.Direccion.*;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Modelos.*;
import Algo3TP2.Modelos.Unidades.Soldado;
import Algo3TP2.Modelos.Unidades.Unidad;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BatallonTest {
    @Test
    public void tresSoldadosSePuedenMoverComoBatallonTest()
            throws CasilleroOcupadoExcepcion, CasilleroFueraDelLosLimitesDelTableroExcepcion {
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

        
        soldado1.moverComoBatallon(new Arriba());
        

        assertEquals(soldado1.getCasillero(), tablero.getCasilleroEnPosicion(new Coordenada(2,2)));
        assertEquals(soldado2.getCasillero(), tablero.getCasilleroEnPosicion(new Coordenada(2,3)));
        assertEquals(soldado3.getCasillero(), tablero.getCasilleroEnPosicion(new Coordenada(2,4)));
    }
}