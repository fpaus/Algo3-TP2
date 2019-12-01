package Algo3TP2.Controladores;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Vistas.JuegoView;
import Algo3TP2.Vistas.PanelDeControlUnidadView.PanelDeControlUnidadMovibleView;
import Algo3TP2.Vistas.PanelDeControlUnidadView.PanelDeControlView;
import Algo3TP2.Vistas.UnidadesViewEnJuego;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ClickCasilleroHandler implements EventHandler<MouseEvent> {

    private Casillero casillero;

    public  ClickCasilleroHandler(Casillero casillero){
        this.casillero = casillero;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        JuegoView juegoView = JuegoView.getJuegoView();

        try{
            Unidad unidad = casillero.getUnidad();
            PanelDeControlView panelDeControlView =
                    UnidadesViewEnJuego.getUnidadesViewEnJuego().getUnidadPanelDeControlView(unidad);
            juegoView.setPanelDeControlView(panelDeControlView);

        } catch (CasilleroVacioExcepcion casilleroVacioExcepcion) {
            System.out.println(casilleroVacioExcepcion.getMessage());
            PanelDeControlView panelDeControlView = new PanelDeControlView();
            juegoView.setPanelDeControlView(panelDeControlView);
        }
    }
}
