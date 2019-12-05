package Algo3TP2.Controladores;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Juego;
import Algo3TP2.Modelos.Jugador.ExcepcionesJugador.UnidadInvalidaException;
import Algo3TP2.Modelos.Jugador.Jugador;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Vistas.JuegoView.JuegoView;
import Algo3TP2.Vistas.PanelDeControlUnidadView.PanelDeControlViewCasilleroVacio;
import Algo3TP2.Vistas.PanelDeControlView;
import Algo3TP2.Vistas.UnidadesViewEnJuego;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ClickCasilleroSeleccionarHandler implements EventHandler<MouseEvent> {

    private Casillero casillero;
    private Juego juego;

    public ClickCasilleroSeleccionarHandler(Casillero casillero, Juego juego){
        this.casillero = casillero;
        this.juego = juego;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        JuegoView juegoView = JuegoView.getJuegoView();
        Jugador jugadorTurnoActual = juego.getJugadorTurnoActual();

        try{
            Unidad unidad = jugadorTurnoActual.getUnidadEnCasillero(casillero);
            PanelDeControlView panelDeControlView =
                    UnidadesViewEnJuego.getUnidadView().getUnidadPanelDeControlView(unidad);
            juegoView.setPanelDeControlView(panelDeControlView);

        } catch (CasilleroVacioExcepcion casilleroVacioExcepcion) {
            System.out.println(casilleroVacioExcepcion.getMessage());
            PanelDeControlView panelDeControlView = new PanelDeControlViewCasilleroVacio();
            juegoView.setPanelDeControlView(panelDeControlView);
        } catch (UnidadInvalidaException e) {
            AlertBox.display("Alert",e.getMessage());
        }
    }
}
