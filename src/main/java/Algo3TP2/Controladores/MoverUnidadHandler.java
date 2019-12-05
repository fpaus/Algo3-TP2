package Algo3TP2.Controladores;

import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Juego;
import Algo3TP2.Modelos.Jugador.ExcepcionesJugador.JugadorSinUnidadesExcepcion;
import Algo3TP2.Modelos.Jugador.ExcepcionesJugador.UnidadInvalidaException;
import Algo3TP2.Modelos.Jugador.Jugador;
import Algo3TP2.Modelos.Tablero.Direccion.Direccion;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesBatallon.BatallonIncompletoExcepcion;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Modelos.Unidades.UnidadMovible;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MoverUnidadHandler implements EventHandler<ActionEvent> {

    private UnidadMovible unidadMovible;
    private Direccion horizontal;
    private Direccion vertical;
    private Juego juego;

    public MoverUnidadHandler(Unidad unidad, Direccion horizontal, Direccion vertical,  Juego juego) {
        this.unidadMovible = (UnidadMovible) unidad;
        this.horizontal = horizontal;
        this.vertical = vertical;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent event) {
        this.mover();
    }

    public void mover() {
        Jugador jugadorTurnoActual = juego.getJugadorTurnoActual();
        try {
            jugadorTurnoActual.moverUnidadACasillero(unidadMovible, this.horizontal, this.vertical);
            this.juego.avanzarTurno();
        } catch (CasilleroFueraDelLosLimitesDelTableroExcepcion | CasilleroOcupadoExcepcion | UnidadInvalidaException | BatallonIncompletoExcepcion ex){
            AlertBox.display("Alert", ex.getMessage());
        } catch (JugadorSinUnidadesExcepcion ex) {
            ex.printStackTrace();
        }
    }
}
