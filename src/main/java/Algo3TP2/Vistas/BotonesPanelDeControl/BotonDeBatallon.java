package Algo3TP2.Vistas.BotonesPanelDeControl;

import Algo3TP2.Controladores.FormarBatallonHandler;

import Algo3TP2.Modelos.Unidades.Soldado;
import Algo3TP2.Modelos.Unidades.ExcepcionesBatallon.BatallonNoFormadoException;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BotonDeBatallon extends Button {
    Image formarBatallon = new Image("file:src/resources/PanelDeControl/BotonesAcciones/batallon_formar_rojo.png");
    // Image disolverBatallonAzul = new
    // Image("file:src/resources/PanelDeControl/BotonesAcciones/batallon_formar_azul.png");
    Image disolverBatallon = new Image("file:src/resources/PanelDeControl/BotonesAcciones/batallon_disolver_rojo.png");

    // Image formarBatalonAzul = new
    // Image("file:src/resources/PanelDeControl/BotonesAcciones/batallon_disolver_azul.png");
    public BotonDeBatallon(Soldado soldado) {
        this.setStyle("-fx-background-color:transparent ; " + "-fx-background-radius:0; "
                + "-fx-border-color:transparent; " + "-fx-border-width: 0 3 3 0;");
        this.setImage(soldado);
        this.setOnAction(new FormarBatallonHandler(soldado, this));
    }

    public void setImage(Soldado soldado) {
        try {
            soldado.verificarBatallonFormado();
            this.setGraphic(new ImageView(disolverBatallon));
        } catch (BatallonNoFormadoException e) {
            this.setGraphic(new ImageView(formarBatallon));
        }
    }
}
