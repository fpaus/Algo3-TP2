package Algo3TP2.Controladores;

import Algo3TP2.Modelos.Unidades.IUnidadDeAtaque;
import Algo3TP2.Vistas.JuegoView;
import Algo3TP2.Vistas.TableroView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.image.Image;

public class AtaqueDeUnidadHandler implements EventHandler<ActionEvent> {

    IUnidadDeAtaque unidadAtacante;
    Image armaImage;

    public AtaqueDeUnidadHandler(IUnidadDeAtaque unidad, Image armaImage){
        this.unidadAtacante = unidad;
        this.armaImage = armaImage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        TableroView tableroView = JuegoView.getJuegoView().getTableroView();
        tableroView.cambiarAModoRealizarAtaque(this.unidadAtacante, this.armaImage);
    }
}
