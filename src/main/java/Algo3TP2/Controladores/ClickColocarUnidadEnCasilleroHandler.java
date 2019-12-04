package Algo3TP2.Controladores;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroEnemigoExcepcion;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Juego;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Vistas.JuegoView;
import Algo3TP2.Vistas.TableroView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ClickColocarUnidadEnCasilleroHandler implements EventHandler<MouseEvent> {

    private Casillero casillero;
    private Unidad unidadASetearEnCasillero;

    public ClickColocarUnidadEnCasilleroHandler(Casillero casillero, Unidad unidad){
        this.casillero = casillero;
        this.unidadASetearEnCasillero = unidad;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        try {
            Tablero.getTablero().posicionarUnidadAlInicioDelJuego(this.unidadASetearEnCasillero, this.casillero.getCoordenada());
        } catch (CasilleroOcupadoExcepcion | CasilleroFueraDelLosLimitesDelTableroExcepcion | CasilleroEnemigoExcepcion e) {
            AlertBox.display("Alert", e.getMessage());
        } finally {
            TableroView tableroView = JuegoView.getJuegoView().getTableroView();
            tableroView.cambiarAModoSeleccionDeUnidad();
        }
    }
}
