
package Algo3TP2.Modelos;

import Algo3TP2.Modelos.Jugador.ExcepcionesJugador.JugadorSinUnidadesExcepcion;
import Algo3TP2.Modelos.Jugador.Jugador;
import Algo3TP2.Modelos.Tablero.Tablero;

public class Juego {

    Tablero tablero;
    Jugador jugador1, jugador2;
    Turnador turnador;

    public Juego(){
        this.tablero = Tablero.getTablero();
    }

    public void inicializarJuego(String jugador1, String jugador2,int tamanioTablero){
        this.jugador1 = new Jugador(jugador1);
        this.jugador2 = new Jugador(jugador2);
        tablero.inicializarTablero(tamanioTablero, tamanioTablero, this.jugador1, this.jugador2);
        this.turnador = new Turnador(this.jugador1, this.jugador2);
    }

    public Tablero getTablero(){
        return this.tablero;
    }

    public void avanzarTurno() throws JugadorSinUnidadesExcepcion {
        this.turnador.avanzarTurno();
    }

    public Jugador getJugadorTurnoActual(){
        return this.turnador.getJugadorTurnoActual();
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }
}