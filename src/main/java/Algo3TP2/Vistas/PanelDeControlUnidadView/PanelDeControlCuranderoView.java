package Algo3TP2.Vistas.PanelDeControlUnidadView;

import Algo3TP2.Modelos.Unidades.Unidad;
import javafx.scene.image.Image;

public class PanelDeControlCuranderoView extends PanelDeControlUnidadMovibleView{

    public PanelDeControlCuranderoView(Unidad unidad) {
        super(unidad);
        Image armaImage = new Image("file: oraculo/baston");
    }
}
