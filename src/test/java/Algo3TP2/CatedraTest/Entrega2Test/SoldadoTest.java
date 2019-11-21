package Algo3TP2.CatedraTest.Entrega2Test;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Jugador;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Unidades.Batallon.BatallonCompletoExcepcion;
import Algo3TP2.Modelos.Unidades.Batallon.BatallonIncompletoExcepcion;
import Algo3TP2.Modelos.Unidades.Batallon.ElSoldadoNoSeEncuentraContiguoAlBatallonExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesMovimientos.MovimientoNoContiguoExcepcion;
import Algo3TP2.Modelos.Unidades.Soldado;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SoldadoTest {

    @Test
    /*se verifica que 3 soldados contiguos pueden moverse al mismo
    tiempo en la misma dirección con una sola acción.
    */
    public void tresSoldadosContiguosPuedenMoverseEnUnaSolaAccion()
            throws CasilleroOcupadoExcepcion, CasilleroFueraDelLosLimitesDelTableroExcepcion, BatallonCompletoExcepcion,
            ElSoldadoNoSeEncuentraContiguoAlBatallonExcepcion, MovimientoNoContiguoExcepcion, CasilleroVacioExcepcion {
        // Arrange
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

        // Act
        soldado1.conformarBatallonCon(soldado2);
        soldado1.conformarBatallonCon(soldado3);
        soldado1.moverHaciaAbajo();

        // Assert
        assertEquals(soldado1.getCasillero(), tablero.getCasilleroEnPosicion(new Coordenada(2,0)));
        assertEquals(soldado2.getCasillero(), tablero.getCasilleroEnPosicion(new Coordenada(2,2)));
        assertEquals(soldado3.getCasillero(), tablero.getCasilleroEnPosicion(new Coordenada(2,3)));
    }
    @Test
    /*Teniendo 3 soldados contiguos, y un obstáculo (una entidad distinta
    a los otros dos soldados) obstruyendo a uno de los 3, se verifica que
    al mover el Batallón, se mueven 2 soldados y uno se queda quieto.*/
    public void tresSoldadosContiguosSeMuevenPeroUnoQuedaObstaculizado()
            throws CasilleroOcupadoExcepcion, CasilleroFueraDelLosLimitesDelTableroExcepcion, BatallonCompletoExcepcion,
            BatallonIncompletoExcepcion, ElSoldadoNoSeEncuentraContiguoAlBatallonExcepcion {
        // Arrange
        Jugador jugador = new Jugador();
        Bando bando = new Bando(jugador);
        Soldado soldado1 = new Soldado(bando);
        Soldado soldado2 = new Soldado(bando);
        Soldado soldado3 = new Soldado(bando);
        Soldado soldadoObstaculo = new Soldado(bando);
        Tablero tablero = Tablero.getTablero();
        tablero.inicializarTablero(20, 20, jugador, new Jugador());
        soldado1.colocarEnCasillero(tablero.getCasilleroEnPosicion(new Coordenada(1,1)));
        soldado2.colocarEnCasillero(tablero.getCasilleroEnPosicion(new Coordenada(1,2)));
        soldado3.colocarEnCasillero(tablero.getCasilleroEnPosicion(new Coordenada(1,3)));
        soldadoObstaculo.colocarEnCasillero(tablero.getCasilleroEnPosicion(new Coordenada(2,1)));

        // Act
        soldado1.conformarBatallonCon(soldado2);
        soldado1.conformarBatallonCon(soldado3);
        soldado1.moverBatallonHaciaLaDerecha();

        // Arrange
        assertEquals(soldado1.getCasillero(), tablero.getCasilleroEnPosicion(new Coordenada(1,1)));
        assertEquals(soldado2.getCasillero(), tablero.getCasilleroEnPosicion(new Coordenada(2,2)));
        assertEquals(soldado3.getCasillero(), tablero.getCasilleroEnPosicion(new Coordenada(2,3)));
    }

    @Test
    /*(En la situación anterior) Se verifica que
    el Batallón se disuelve, al quedar separados
    los 3 soldados.*/
    public void batallonObstaculizadoSeDisuelve(){

    }

    @Test(expected = BatallonCompletoExcepcion.class)
    /*habiendo 4 soldados contiguos, se verifica que al
    mover un Batallón se mueven únicamente 3.*/
    public void batallonMueveSoloTresSoldadosYNoCuatro()
            throws CasilleroOcupadoExcepcion, CasilleroFueraDelLosLimitesDelTableroExcepcion, BatallonCompletoExcepcion,
                 ElSoldadoNoSeEncuentraContiguoAlBatallonExcepcion {
            // Arrange
            Jugador jugador = new Jugador();
            Bando bando = new Bando(jugador);
            Soldado soldado1 = new Soldado(bando);
            Soldado soldado2 = new Soldado(bando);
            Soldado soldado3 = new Soldado(bando);
            Soldado soldado4 = new Soldado(bando);
            Tablero tablero = Tablero.getTablero();
            tablero.inicializarTablero(20, 20, jugador, new Jugador());
            soldado1.colocarEnCasillero(tablero.getCasilleroEnPosicion(new Coordenada(2,1)));
            soldado2.colocarEnCasillero(tablero.getCasilleroEnPosicion(new Coordenada(2,2)));
            soldado3.colocarEnCasillero(tablero.getCasilleroEnPosicion(new Coordenada(2,3)));
            soldado4.colocarEnCasillero(tablero.getCasilleroEnPosicion(new Coordenada(2,4)));

            // Act
            soldado1.conformarBatallonCon(soldado2);
            soldado1.conformarBatallonCon(soldado3);

            // Assert
            soldado1.conformarBatallonCon(soldado4);
    }

}
