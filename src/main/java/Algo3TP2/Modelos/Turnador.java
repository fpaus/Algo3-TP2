package Algo3TP2.Modelos;

import Algo3TP2.Modelos.Jugador.Jugador;
import Algo3TP2.Modelos.Jugador.ExcepcionesJugador.JugadorSinUnidadesExcepcion;

public class Turnador {

    private Jugador jugador1, jugador2;
    private Jugador jugadorActual;
    private int turno;

    public Turnador(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.jugadorActual = Math.random() >= 0.5 ? this.jugador1 : this.jugador2;
        this.turno = 0;
    }

    public void avanzarTurno() throws JugadorSinUnidadesExcepcion {
        turno++;
        if (this.jugadorActual == this.jugador1) {
            this.jugadorActual = this.jugador2;
        } else {
            this.jugadorActual = this.jugador1;
        }
        this.jugadorActual.controlarCondicionDePerdida();
        System.out.println("Turno avanzado");
    }

    public Jugador getJugadorTurnoActual() {
        System.out.println("Turno actual " + this.jugadorActual.toString());
        return this.jugadorActual;
    }
}
