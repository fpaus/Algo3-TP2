package Algo3TP2.Vistas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class PanelDeControlView extends GridPane {

    public PanelDeControlView() {

        this.setAlignment(Pos.CENTER);
        this.setPrefHeight(200);
        this.setHgap(30);
        this.setPadding(new Insets(0, 0, 0, 0));

        Image imagen = new Image("file:src/resources/PanelDeControl/fondo_comandos.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(250,250, false, false, false, false));
        this.setBackground(new Background(imagenDeFondo));

        ImageView imagenUnidadSeleccionada = new ImageView(new Image("file:src/resources/Mercado/d.jpg"));
        imagenUnidadSeleccionada.setFitWidth(100);
        imagenUnidadSeleccionada.setFitHeight(100);

        this.getChildren().add(imagenUnidadSeleccionada);
    }
}