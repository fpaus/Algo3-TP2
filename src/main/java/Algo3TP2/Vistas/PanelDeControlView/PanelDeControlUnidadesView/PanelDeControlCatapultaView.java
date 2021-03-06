package Algo3TP2.Vistas.PanelDeControlView.PanelDeControlUnidadesView;

import Algo3TP2.Modelos.Unidades.IUnidadDeAtaque;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Vistas.BotonesPanelDeControl.BotonDeAtaque;
import javafx.scene.image.Image;

public class PanelDeControlCatapultaView extends PanelDeControlUnidadView {

    public PanelDeControlCatapultaView(Unidad unidad){
        super(unidad);
        Image armaImage = new Image("file:src/resources/PanelDeControl/BotonesAcciones/ataque_catapulta.png");
        BotonDeAtaque botonDeAtaque = new BotonDeAtaque((IUnidadDeAtaque) unidad, armaImage);
        this.add(botonDeAtaque, 2,0);
    }
}
