package Algo3TP2.Vistas.BotonesPanelDeControl.BotonMovimiento.BotonesDirecciones;

import Algo3TP2.Controladores.MoverUnidadHandler;
import Algo3TP2.Vistas.BotonesPanelDeControl.BotonMovimiento.BotonesDirecciones.BotonMoverHaciaAbajo;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class BotonDireccion extends Button {
    BotonMoverGenerico direccionButton;

    public BotonDireccion(BotonMoverGenerico direccionButton){
        this.direccionButton = direccionButton;
        MoverUnidadHandler moverUnidadHandler = direccionButton.moverUnidadHandler();
        this.setOnAction(moverUnidadHandler);
        //this.setOnAction(e -> System.out.println("Oooo  i love it when u touch me there....."));

        this.setPrefSize(25,25);
        ImageView flecha_imageView = new ImageView(direccionButton.imagePath());
        flecha_imageView.setFitHeight(25);
        flecha_imageView.setFitWidth(25);
        this.setGraphic(flecha_imageView);
    }
}

