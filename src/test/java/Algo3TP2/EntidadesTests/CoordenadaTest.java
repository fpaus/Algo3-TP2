package Algo3TP2.EntidadesTests;

import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.Distancia;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class CoordenadaTest {
    @Test
    public void distanciaEntreCoordenadas() {
        // Arrange
        Coordenada a = new Coordenada(0, 0);
        Coordenada b = new Coordenada(0, 1);

        // Act


        // Assert
        assertEquals(new Distancia(1), a.distanciaACoordenada(b));
    }

    @Test
    public void getTodasLasCoordenadasVecinas() {
        // Arrange
        int posicionX = 2, posicionY = 2;
        Coordenada coordenada = new Coordenada(2, 2);

        // Act
        ArrayList<Coordenada> coordenadasVecinas = coordenada.getTodasLasCoordenadasVecinas();

        // Assert
        Iterator<Coordenada> iter = coordenadasVecinas.iterator();
        for (int i = posicionX - 1; i <= posicionX + 1; i++) {
            for (int j = posicionY - 1; j <= posicionY + 1; j++) {
                if (!(posicionX == i && posicionY == j)) {
                    assertEquals(new Coordenada(i, j), iter.next());
                }
            }
        }
    }
}
