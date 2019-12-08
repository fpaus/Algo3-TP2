package Algo3TP2.Vistas.BotonesPanelDeControl;

import Algo3TP2.Controladores.ComprarUnidadHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class BotonComprarUnidad extends Button {

    public BotonComprarUnidad(ComprarUnidadHandler comprarUnidadHandler, Image buttonImage){
        this.setStyle("-fx-background-color:transparent ; " +
                "-fx-background-radius:0; " +
                "-fx-border-color:transparent; " +
                "-fx-border-width: 0 3 3 0;");
        this.setGraphic(new ImageView(buttonImage));
        this.setOnAction(comprarUnidadHandler);
    }
}
