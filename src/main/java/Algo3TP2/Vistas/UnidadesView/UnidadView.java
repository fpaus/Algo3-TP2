package Algo3TP2.Vistas.UnidadesView;

import Algo3TP2.ViewProperties;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class UnidadView extends ImageView {

    protected Image unidadImage;

    public UnidadView(){
        this.setFitWidth(ViewProperties.anchoUnidadView);
        this.setFitHeight(ViewProperties.largoUnidadView);
    }

    protected void setUnidadImage(Image unidadImage){
        this.unidadImage = unidadImage;
        this.setImage(unidadImage);
    }
}
