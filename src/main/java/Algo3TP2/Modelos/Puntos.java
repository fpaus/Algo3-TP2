package Algo3TP2.Modelos;

import Algo3TP2.Modelos.Unidades.Unidad;

public class Puntos {
    private int puntosDisponibles;

    public Unidad comprarUnidad(Unidad unidad) throws PuntosInsuficientesExcepcion {
        if (unidad.getCosto() > puntosDisponibles) {
            throw new PuntosInsuficientesExcepcion();
        }
        return unidad;
    }
    public boolean quedanPuntos(){
        return puntosDisponibles != 0;
    }
}
