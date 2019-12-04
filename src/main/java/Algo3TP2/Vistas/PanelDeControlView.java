package Algo3TP2.Vistas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class PanelDeControlView extends GridPane {

    public PanelDeControlView() {

        this.setAlignment(Pos.CENTER);
        this.setPrefHeight(225);
        this.setHgap(30);
        this.setPadding(new Insets(0, 0, 0, 0));
    }
}
