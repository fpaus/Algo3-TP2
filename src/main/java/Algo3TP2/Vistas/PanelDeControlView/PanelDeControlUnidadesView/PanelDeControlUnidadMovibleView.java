package Algo3TP2.Vistas.PanelDeControlView.PanelDeControlUnidadesView;

import Algo3TP2.Modelos.Juego;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Vistas.BotonesPanelDeControl.BotonMovimiento.BotoneraMovimiento;
import javafx.geometry.Pos;

public class PanelDeControlUnidadMovibleView extends PanelDeControlUnidadView {

    public PanelDeControlUnidadMovibleView(Unidad unidad, Juego juego) {
        super(unidad);

        BotoneraMovimiento botoneraMovimiento = new BotoneraMovimiento(unidad, juego);
        botoneraMovimiento.setAlignment(Pos.CENTER);
        this.add(botoneraMovimiento,1,0);
    }
}
