package Algo3TP2.Modelos;

import Algo3TP2.Modelos.Unidades.Unidad;

public class Puntos {
    private int puntosDisponibles;

    public Unidad comprarUnidad(Unidad unidad) {
        if (unidad.getCosto() < puntosDisponibles) {
            return unidad;
        } else {
            return null;
        }
    }
}
