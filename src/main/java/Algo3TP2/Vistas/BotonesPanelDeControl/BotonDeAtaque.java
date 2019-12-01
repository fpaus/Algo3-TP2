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
        espada_imageView.setFitWidth(80);
        this.setGraphic(espada_imageView);
        this.setOnAction(new AtaqueDeUnidadHandler(unidad, armaDeAtaqueImage));
    }
}
