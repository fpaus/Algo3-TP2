package Algo3TP2.Vistas.BotonesPanelDeControl;

import Algo3TP2.Controladores.FormarBatallonHandler;

import Algo3TP2.Modelos.Unidades.Soldado;
import Algo3TP2.Modelos.Unidades.ExcepcionesBatallon.BatallonNoFormadoException;
import Algo3TP2.Observador;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BotonDeBatallon extends Button implements Observador {
    Image formarBatallon = new Image("file:src/resources/PanelDeControl/BotonesAcciones/batallon_formar.png");
    // Image disolverBatallonAzul = new
    // Image("file:src/resources/PanelDeControl/BotonesAcciones/batallon_formar_azul.png");
    Image disolverBatallon = new Image("file:src/resources/PanelDeControl/BotonesAcciones/batallon_disolver.png");

    // Image formarBatalonAzul = new
    // Image("file:src/resources/PanelDeControl/BotonesAcciones/batallon_disolver_azul.png");
    Soldado soldado;
    public BotonDeBatallon(Soldado soldado) {
        this.soldado = soldado;
        this.setStyle("-fx-background-color:transparent ; " + "-fx-background-radius:0; "
                + "-fx-border-color:transparent; " + "-fx-border-width: 0 3 3 0;");
        this.setImage(soldado);
        this.setOnAction(new FormarBatallonHandler(soldado, this));
        soldado.enlazarobservadorBatallon(this);
    }

    public void setImage(Soldado soldado) {
        try {
            soldado.verificarBatallonFormado();
            this.setGraphic(new ImageView(disolverBatallon));
        } catch (BatallonNoFormadoException e) {
            this.setGraphic(new ImageView(formarBatallon));
        }
    }

    @Override
    public void actualizar() {
        this.setImage(this.soldado);
    }
}
