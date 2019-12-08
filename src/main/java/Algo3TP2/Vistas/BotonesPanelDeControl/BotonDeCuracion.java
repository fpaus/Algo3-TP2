package Algo3TP2.Vistas.BotonesPanelDeControl;

import Algo3TP2.Controladores.AtaqueDeUnidadHandler;
import Algo3TP2.Controladores.CuracionDeUnidadHandler;
import Algo3TP2.Modelos.Unidades.Curandero;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BotonDeCuracion extends Button {

    public BotonDeCuracion(Curandero unidad, Image armaDeCuracionImage){
        this.setStyle("-fx-background-color:transparent ; " +
                "-fx-background-radius:0; " +
                "-fx-border-color:transparent; " +
                "-fx-border-width: 0 3 3 0;");
        ImageView espada_imageView = new ImageView(armaDeCuracionImage);
        this.setGraphic(espada_imageView);
        this.setOnAction(new CuracionDeUnidadHandler(unidad));
    }
}
