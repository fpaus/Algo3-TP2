package Algo3TP2.Vistas;

import Algo3TP2.Controladores.BotonMoverUnidadHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class PanelDeControlView extends GridPane {

    public PanelDeControlView() {

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(40, 40, 40, 40));

        Button buttonA = new Button("Boton");
        buttonA.setPrefSize(200,200);

        Image imagen = new Image("file:src/resources/PanelDEControl/FlechasDirecciones/Flecha_derecha.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(200,200, false, false, false, false));
        buttonA.setBackground(new Background(imagenDeFondo));

        buttonA.setOnAction(e -> System.out.println("Oooo  i love it when u touch me there....."));

        this.add(buttonA, 0,0);
    }
}
