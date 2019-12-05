
package Algo3TP2.Modelos;

import Algo3TP2.Modelos.Jugador.ExcepcionesJugador.JugadorSinUnidadesExcepcion;
import Algo3TP2.Modelos.Jugador.Jugador;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Observable;
import Algo3TP2.Observador;

import java.util.ArrayList;

public class Juego implements Observable {

    Tablero tablero;
    Jugador jugador1, jugador2;
    Turnador turnador;
    ArrayList<Observador> observadoresDeTurno;

    public Juego(){
        this.tablero = Tablero.getTablero();
    }

    public void inicializarJuego(String jugador1, String jugador2,int tamanioTablero){
        this.jugador1 = new Jugador(jugador1);
        this.jugador2 = new Jugador(jugador2);
        tablero.inicializarTablero(tamanioTablero, tamanioTablero, this.jugador1, this.jugador2);
        this.turnador = new Turnador(this.jugador1, this.jugador2);
        this.observadoresDeTurno = new ArrayList<Observador>();
    }

    public Tablero getTablero(){
        return this.tablero;
    }

    public void avanzarTurno() throws JugadorSinUnidadesExcepcion {
        this.turnador.avanzarTurno();
        this.notificarObservadores();
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

    public void enlazarObservadorDeTurno(Observador observadorDeTurno){
        this.observadoresDeTurno.add(observadorDeTurno);
    }

    @Override
    public void notificarObservadores() {
        this.observadoresDeTurno.forEach(observador -> observador.actualizar());
    }
}