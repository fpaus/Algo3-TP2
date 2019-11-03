package EntidadesTests;
import static org.junit.Assert.assertTrue;

import Algo3TP2.Modelos.Tablero;
import Algo3TP2.Modelos.Unidad;
import Algo3TP2.Modelos.Casillero;
import org.junit.Assert;
import org.junit.Test;

public class UnidadTest {

    @Test
    public void unidadMovibleSePuedeMoverEnTodasDireccionesTest(){

        Tablero tablero = new Tablero();

        Unidad unidad = new Unidad();
        Casillero casillero = tablero.getCasilleroEn(2,2);
        unidad.colocarEnPosicion(casillero);
        //me muevo hacia arriba
        unidad.mover(tablero.getCasilleroEn(2,3));
        assertTrue(unidad.getCasillero() == tablero.getCasilleroEn(2,3));
        //me muevo hacia abajo
        unidad.mover(tablero.getCasilleroEn(2,2));
        assertTrue(unidad.getCasillero() == tablero.getCasilleroEn(2,2));
        //me muevo hacia la izquierda
        unidad.mover(tablero.getCasilleroEn(1,2));
        assertTrue(unidad.getCasillero() == tablero.getCasilleroEn(1,2));
        //me muevo hacia la derecha
        unidad.mover(tablero.getCasilleroEn(1,1));
        assertTrue(unidad.getCasillero() == tablero.getCasilleroEn(2,2));
        //me muevo hacia arriba - izquierda
        unidad.mover(tablero.getCasilleroEn(1,2));
        assertTrue(unidad.getCasillero() == tablero.getCasilleroEn(2,2));
        //me muevo hacia abajo, derecha
        unidad.mover(tablero.getCasilleroEn(1,3));
        assertTrue(unidad.getCasillero() == tablero.getCasilleroEn(1,3));
        ////me muevo hacia arriba - derecha
        unidad.mover(tablero.getCasilleroEn(2,2));
        assertTrue(unidad.getCasillero() == tablero.getCasilleroEn(2,2));
        //me muevo hacia abajo - izquierda
        unidad.mover(tablero.getCasilleroEn(3,3));
        assertTrue(unidad.getCasillero() == tablero.getCasilleroEn(3,3));

    }

}
