package Algo3TP2.Vistas.PanelDeControlUnidadView;

import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Vistas.PanelDeControlView;
import Algo3TP2.Vistas.UnidadesView.UnidadView;
import Algo3TP2.Vistas.UnidadesViewEnJuego;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class PanelDEControlUnidadView extends PanelDeControlView {

    public PanelDEControlUnidadView(Unidad unidad){
        Image imagen = new Image("file:src/resources/PanelDeControl/fondo_piedra_con_banner.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen,
                BackgroundRepeat.ROUND,
                BackgroundRepeat.ROUND,
                BackgroundPosition.CENTER,
                new BackgroundSize(1006,200, false, false, false, false));
        this.setBackground(new Background(imagenDeFondo));

        UnidadView unidadImage = UnidadesViewEnJuego.getUnidadView().getUnidadView(unidad);

        ImageView imagenUnidadSeleccionada = new ImageView(unidadImage.getImage());
        imagenUnidadSeleccionada.setFitWidth(100);
        imagenUnidadSeleccionada.setFitHeight(100);

        this.getChildren().add(imagenUnidadSeleccionada);
    }
}
