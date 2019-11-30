package Algo3TP2.Vistas.UnidadesView.SoldadoView;

import Algo3TP2.Vistas.UnidadesView.UnidadView;
import javafx.scene.image.Image;

public class SoldadoRojoView extends UnidadView {

    public SoldadoRojoView(){
        super();
        Image soldadoAzulImage = new Image("file:src/resources/Unidades/Soldado_rojo.png");
        this.setImage(soldadoAzulImage);
    }
}
