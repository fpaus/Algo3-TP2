package Algo3TP2.Controladores;

import Algo3TP2.Vistas.JuegoView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonFinalizarComprarDeUnidadesAzulesHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        JuegoView.getJuegoView().iniciarBatallaEquipoAzul();
    }
}
