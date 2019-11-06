package Algo3TP2.Modelos;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Unidades.PuntosInsuficientesExcepcion;
import Algo3TP2.Modelos.Unidades.Unidad;

public class Jugador {

    private Puntos puntos;

    public Jugador() {
        this.puntos = new Puntos();
    }

    public void colocarUnidadEnCasillero(Unidad unidad, Casillero casillero) throws PuntosInsuficientesExcepcion {
        puntos.comprarUnidad(unidad).colocarEnCasillero(casillero);
    }

}
