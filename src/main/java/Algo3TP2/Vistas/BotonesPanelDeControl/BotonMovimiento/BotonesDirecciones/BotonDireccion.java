package Algo3TP2.Vistas.BotonesPanelDeControl.BotonMovimiento.BotonesDirecciones;

import Algo3TP2.Controladores.MoverUnidadHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class BotonDireccion extends Button {
    BotonMoverGenerico direccionButton;

    public BotonDireccion(BotonMoverGenerico direccionButton){
        this.direccionButton = direccionButton;
        MoverUnidadHandler moverUnidadHandler = direccionButton.moverUnidadHandler();
        this.setOnAction(moverUnidadHandler);
        //this.setOnAction(e -> System.out.println("Oooo  i love it when u touch me there....."));

        //this.setPrefSize(25,25); // Por ahora no hace falta cambiar el tamaño, lo dejamos así.
        ImageView flecha_imageView = new ImageView(direccionButton.imagePath());
        /*flecha_imageView.setFitHeight(25);
        flecha_imageView.setFitWidth(25);*/ //Por ahora no hace falta cambiar el tamaño, lo dejamos así.
        this.setGraphic(flecha_imageView);
        this.setStyle("-fx-background-color:transparent ; " +
                "-fx-background-radius:0; " +
                "-fx-border-color:white; " +
                "-fx-border-width: 0 0 0 0;");
    }
}

