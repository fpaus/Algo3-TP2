package Algo3TP2.Controladores;

import Algo3TP2.Modelos.Unidades.IUnidadDeAtaque;
import Algo3TP2.Vistas.JuegoView.JuegoView;
import Algo3TP2.Vistas.TableroView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AtaqueDeUnidadHandler implements EventHandler<ActionEvent> {

    IUnidadDeAtaque unidadAtacante;

    public AtaqueDeUnidadHandler(IUnidadDeAtaque unidad){
        this.unidadAtacante = unidad;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        TableroView tableroView = JuegoView.getJuegoView().getTableroView();
        tableroView.cambiarAModoRealizarAtaque(this.unidadAtacante);
    }
}
