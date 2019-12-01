package Algo3TP2.Vistas.PanelDeControlUnidadView;

import Algo3TP2.Modelos.Unidades.IUnidadDeAtaque;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Vistas.BotonesPanelDeControl.BotonDeAtaque;
import Algo3TP2.Vistas.BotonesPanelDeControl.BotonMovimiento.BotoneraMovimiento;
import javafx.geometry.Insets;

public class PanelDeControlUnidadMovibleView extends PanelDeControlView {

    public PanelDeControlUnidadMovibleView(Unidad unidad) {

        this.setPadding(new Insets(40, 40, 40, 40));
        this.setGridLinesVisible(true);

        BotoneraMovimiento botoneraMovimiento = new BotoneraMovimiento(unidad);
        this.add(botoneraMovimiento,1,1);

        BotonDeAtaque botonDeAtaque = new BotonDeAtaque((IUnidadDeAtaque) unidad);
        this.add(botonDeAtaque, 5,1);

    }
}
