package EntidadesTests;

import Algo3TP2.Modelos.*;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class TableroTest {

    @Test
    public void correctaInicializacionDelTablero (){
        Tablero tablero = new Tablero(20 ,20, new Jugador(), new Jugador());
        Unidad unidad = new Soldado();
        Casillero casillero;

        casillero = tablero.getCasilleroEnPosicion(0,0);
        unidad.colocarEnCasillero(casillero);
        assertTrue(casillero != null);
        assertEquals(unidad, casillero.getUnidad());
    }
    @Test
    public void noSePuedeColocarUnaPiezaAliadaEnUnCasilleroDelSectorAliadoOcupadoTest (){}
    @Test
    public void noSePuedeColocarUnaPiezaAliadaEnUnCasilleroDelSectorEnemigoTest (){}
    @Test
    public void seColocaUnaPiezaAliadaEnUnCasilleroDelSectorAliadoVacioConExitoTest (){}

}
