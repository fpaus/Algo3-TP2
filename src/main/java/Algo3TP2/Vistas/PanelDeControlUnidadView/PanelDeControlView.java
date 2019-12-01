package Algo3TP2.Vistas.PanelDeControlUnidadView;

import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Vistas.BotonesPanelDeControl.BotonesDirecciones.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class PanelDeControlView extends GridPane {

    public PanelDeControlView() {

        this.setPadding(new Insets(40, 40, 40, 40));
        this.setGridLinesVisible(true);
        this.prefHeight(600);
        this.prefWidth(600);
    }
}
