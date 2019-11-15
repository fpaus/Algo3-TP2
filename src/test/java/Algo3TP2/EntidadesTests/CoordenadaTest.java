package Algo3TP2.EntidadesTests;

import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.*;
import Algo3TP2.Modelos.*;
import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Unidades.Soldado;
import Algo3TP2.Modelos.Unidades.Unidad;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CoordenadaTest {
    @Test
    public void distanciaEntreCoordenadas() {
        // Arrenge
        Punto a = new Punto(0,0);
        Punto b = new Punto(0,1);

        // Act
    

        // Assert
        assertEquals(new Distancia(1.0), a.distaDe(b));
    }
}
