package TableroTests;

import Algo3TP2.Modelos.Casillero;
import Algo3TP2.Modelos.Tablero;
import Algo3TP2.Modelos.Unidad;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class TableroTest {

    @Test
    public void correctaInicializacionDelTablero (){
        Tablero tablero = new Tablero();
        Unidad unidad = new Unidad();
        Casillero casillero;

        casillero = tablero.getCasilleroEn(0,0);
        unidad.ColocarEnCasillero(casillero);
        assertTrue(casillero != null);
        assertEquals(unidad, casillero.getUnidad());
    }
}
