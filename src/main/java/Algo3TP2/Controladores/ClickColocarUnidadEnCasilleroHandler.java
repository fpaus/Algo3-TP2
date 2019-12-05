package Algo3TP2.Controladores;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroEnemigoExcepcion;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Jugador.ExcepcionesJugador.PuntosInsuficientesExcepcion;
import Algo3TP2.Modelos.Jugador.Jugador;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Vistas.JuegoView.JuegoView;
import Algo3TP2.Vistas.TableroView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ClickColocarUnidadEnCasilleroHandler implements EventHandler<MouseEvent> {

    private Casillero casillero;
    private Unidad unidadASetearEnCasillero;
    private Bando bando;

    public ClickColocarUnidadEnCasilleroHandler(Casillero casillero, Unidad unidad, Bando bando){
        this.casillero = casillero;
        this.unidadASetearEnCasillero = unidad;
        this.bando = bando;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        Jugador jugador = bando.getDuenio();
        try {
            jugador.colocarUnidadEnCasillero(this.unidadASetearEnCasillero, this.casillero);
        } catch (CasilleroOcupadoExcepcion | CasilleroEnemigoExcepcion e) {
            AlertBox.display("Alert", e.getMessage());
        } catch (PuntosInsuficientesExcepcion puntosInsuficientesExcepcion) {
            AlertBox.display("Alert",puntosInsuficientesExcepcion.getMessage());
        } finally {
            TableroView tableroView = JuegoView.getJuegoView().getTableroView();
            tableroView.cambiarAModoSeleccionDeUnidad();
        }
    }
}
