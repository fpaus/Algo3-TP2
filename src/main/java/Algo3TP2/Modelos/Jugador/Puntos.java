package Algo3TP2.Modelos.Jugador;

import Algo3TP2.Modelos.Jugador.ExcepcionesJugador.PuntosInsuficientesExcepcion;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Properties;

public class Puntos {
    private int puntosDisponibles;

    public Puntos(){
        this.puntosDisponibles = Properties.puntosInicialesDisponibles;
    }

    public void comprarUnidad(Unidad unidad, Jugador jugador) throws PuntosInsuficientesExcepcion {
        if (unidad.getCosto() > puntosDisponibles) {
            throw new PuntosInsuficientesExcepcion();
        }
        this.puntosDisponibles -= unidad.getCosto();
        jugador.anadirUnidad(unidad);
        jugador.notificarObservadores(this.puntosDisponibles);
    }

    public boolean quedanPuntos() {
        return puntosDisponibles != 0;
    }
}
