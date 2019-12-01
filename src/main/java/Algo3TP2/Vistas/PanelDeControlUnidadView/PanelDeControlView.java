package Algo3TP2.Vistas.PanelDeControlUnidadView;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class PanelDeControlView extends GridPane {

    public PanelDeControlView() {

        this.setPadding(new Insets(40, 40, 40, 40));
        this.setGridLinesVisible(true);
        this.prefHeight(600);
        this.prefWidth(600);
    }
}
