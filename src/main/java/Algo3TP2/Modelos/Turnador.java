package Algo3TP2.Modelos;

import Algo3TP2.Modelos.Jugador.Jugador;
import Algo3TP2.Modelos.Jugador.ExcepcionesJugador.JugadorSinUnidadesExcepcion;

public class Turnador {

    Jugador jugador1, jugador2;
    int turno;

    public Turnador(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.turno = 0;
    }

    public Jugador getJugadorSiguienteTurno() throws JugadorSinUnidadesExcepcion {
        turno++;
        if(turno % 2 == 0){
            jugador2.controlarCondicionDePerdida();
            return this.jugador2;
        }else {
            jugador1.controlarCondicionDePerdida();
            return this.jugador1;
        }
    }
}
