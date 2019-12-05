package Algo3TP2.Controladores;

import Algo3TP2.Modelos.Unidades.Curandero;
import Algo3TP2.Vistas.JuegoView.JuegoView;
import Algo3TP2.Vistas.TableroView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CuracionDeUnidadHandler implements EventHandler<ActionEvent> {

    Curandero curandero;

    public CuracionDeUnidadHandler(Curandero unidad){
        this.curandero = unidad;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        TableroView tableroView = JuegoView.getJuegoView().getTableroView();
        tableroView.cambiarAModoRealizarCuracion(this.curandero);
    }
}
