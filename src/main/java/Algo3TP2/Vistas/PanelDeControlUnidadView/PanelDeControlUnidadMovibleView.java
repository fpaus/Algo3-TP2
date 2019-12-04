package Algo3TP2.Vistas.PanelDeControlUnidadView;

import Algo3TP2.Modelos.Juego;
import Algo3TP2.Modelos.Unidades.IUnidadDeAtaque;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Vistas.BotonesPanelDeControl.BotonDeAtaque;
import Algo3TP2.Vistas.BotonesPanelDeControl.BotonMovimiento.BotoneraMovimiento;
import Algo3TP2.Vistas.PanelDeControlView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class PanelDeControlUnidadMovibleView extends PanelDEControlUnidadView {

    public PanelDeControlUnidadMovibleView(Unidad unidad, Juego juego) {
        super(unidad);

        BotoneraMovimiento botoneraMovimiento = new BotoneraMovimiento(unidad, juego);
        botoneraMovimiento.setAlignment(Pos.CENTER);
        this.add(botoneraMovimiento,2,0);
    }
}
