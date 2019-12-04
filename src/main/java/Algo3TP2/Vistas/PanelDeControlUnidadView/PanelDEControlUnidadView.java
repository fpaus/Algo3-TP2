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

        StackPane stackPaneUnidadActual = new StackPane(); // StackPane para el marco y la unidad que se ve dentro

        UnidadView imagenUnidad = UnidadesViewEnJuego.getUnidadView().getUnidadView(unidad);
        ImageView imagenUnidadSeleccioanda = new ImageView(imagenUnidad.getImage());
        imagenUnidadSeleccioanda.setFitWidth(100);
        imagenUnidadSeleccioanda.setFitHeight(100);

        ImageView marcoUnidadSeleccionada = new ImageView (new Image("file:src/resources/PanelDeControl/marco_unidad.png"));

        stackPaneUnidadActual.getChildren().addAll(marcoUnidadSeleccionada, imagenUnidadSeleccioanda);

        this.getChildren().add(stackPaneUnidadActual);
    }
}
