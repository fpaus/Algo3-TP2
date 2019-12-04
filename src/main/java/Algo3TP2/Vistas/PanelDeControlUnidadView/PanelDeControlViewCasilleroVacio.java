package Algo3TP2.Vistas.PanelDeControlUnidadView;

import Algo3TP2.Vistas.PanelDeControlView;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class PanelDeControlViewCasilleroVacio extends PanelDeControlView {

    public PanelDeControlViewCasilleroVacio(){
        Image imagen = new Image("file:src/resources/PanelDeControl/fondo_piedra.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1006,200, false, false, false, false));
        this.setBackground(new Background(imagenDeFondo));
    }
}
