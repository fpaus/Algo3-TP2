package Algo3TP2.Vistas.BotonesPanelDeControl;

import Algo3TP2.Controladores.BotonFinalizarComprarDeUnidadesAzulesHandler;
import Algo3TP2.Controladores.BotonFinalizarComprarDeUnidadesRojasHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BotonFinalizarCompra extends Button {
    public BotonFinalizarCompra(){
        this.setStyle("-fx-background-color:transparent ; " +
                "-fx-background-radius:0; " +
                "-fx-border-color:transparent; " +
                "-fx-border-width: 0 3 3 0;");
        this.setGraphic(new ImageView(new Image("file:src/resources/Mercado/boton_finalizar.png")));
        this.setOnAction(new BotonFinalizarComprarDeUnidadesRojasHandler()); // Falta implementar
    }
}
