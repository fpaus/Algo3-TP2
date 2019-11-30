package Algo3TP2.Vistas.UnidadesView.SoldadoView;

import Algo3TP2.Vistas.UnidadesView.UnidadView;
import javafx.scene.image.Image;

public class SoldadoAzulView extends UnidadView {

    public SoldadoAzulView(){
        super();
        Image soldadoAzulImage = new Image("file:src/resources/Unidades/Soldado_azul.png");
        this.setImage(soldadoAzulImage);
    }
}
