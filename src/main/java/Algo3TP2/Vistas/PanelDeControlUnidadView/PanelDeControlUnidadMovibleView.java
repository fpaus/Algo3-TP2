package Algo3TP2.Vistas.PanelDeControlUnidadView;

import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Vistas.BotonesPanelDeControl.BotonesDirecciones.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

public class PanelDeControlUnidadMovibleView extends PanelDeControlView {

    public PanelDeControlUnidadMovibleView(Unidad unidad) {

        this.setPadding(new Insets(40, 40, 40, 40));
        this.setGridLinesVisible(true);

        BotoneraMovimiento botoneraMovimiento = new BotoneraMovimiento(unidad);
        this.add(botoneraMovimiento,1,1);

    }
}
