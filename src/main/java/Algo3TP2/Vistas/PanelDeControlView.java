package Algo3TP2.Vistas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class PanelDeControlView extends GridPane {

    public PanelDeControlView() {

        //this.setGridLinesVisible(true);

        this.setAlignment(Pos.CENTER);
        this.setPrefHeight(200);
        this.setHgap(10);
        this.setPadding(new Insets(0, 0, 0, 0));

        Image imagen = new Image("file:src/resources/PanelDeControl/fondo_piedra_con_banner.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1006,200, false, false, false, false));
        this.setBackground(new Background(imagenDeFondo));
    }
}
