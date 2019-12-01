package Algo3TP2.Vistas.PanelDeControlUnidadView;

import Algo3TP2.Modelos.Unidades.IUnidadDeAtaque;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Vistas.BotonesPanelDeControl.BotonDeAtaque;
import Algo3TP2.Vistas.BotonesPanelDeControl.BotonMovimiento.BotoneraMovimiento;
import Algo3TP2.Vistas.PanelDeControlView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class PanelDeControlUnidadMovibleView extends PanelDeControlView {

    public PanelDeControlUnidadMovibleView(Unidad unidad) {

        this.setPadding(new Insets(40, 40, 40, 40));
        this.setGridLinesVisible(true);

        BotoneraMovimiento botoneraMovimiento = new BotoneraMovimiento(unidad);
        botoneraMovimiento.setAlignment(Pos.CENTER);
        this.add(botoneraMovimiento,1,0);

        BotonDeAtaque botonDeAtaque = new BotonDeAtaque((IUnidadDeAtaque) unidad);
        this.add(botonDeAtaque, 5,0);

    }
}
