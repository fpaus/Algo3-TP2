package Algo3TP2.Vistas.BotonesPanelDeControl;

import Algo3TP2.Controladores.AtaqueDeUnidadHandler;
import Algo3TP2.Modelos.Unidades.IUnidadDeAtaque;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BotonDeAtaque extends Button {

    public BotonDeAtaque(IUnidadDeAtaque unidad, Image armaDeAtaqueImage){
        this.setPrefSize(90,90);
        ImageView espada_imageView = new ImageView(armaDeAtaqueImage);
        espada_imageView.setFitHeight(80);
        espada_imageView.setFitWidth(140);
        this.setGraphic(espada_imageView);
        this.setOnAction(new AtaqueDeUnidadHandler(unidad, armaDeAtaqueImage));
        this.setStyle("-fx-background-color:transparent ; " +
                "-fx-background-radius:0; " +
                "-fx-border-color:transparent; " +
                "-fx-border-width: 0 3 3 0;");
    }
}
