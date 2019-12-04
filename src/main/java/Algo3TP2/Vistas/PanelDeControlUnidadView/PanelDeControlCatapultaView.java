package Algo3TP2.Vistas.PanelDeControlUnidadView;

import Algo3TP2.Modelos.Unidades.IUnidadDeAtaque;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Vistas.BotonesPanelDeControl.BotonDeAtaque;
import Algo3TP2.Vistas.PanelDeControlView;
import javafx.scene.image.Image;

public class PanelDeControlCatapultaView extends PanelDEControlUnidadView {

    public PanelDeControlCatapultaView(Unidad unidad){
        super(unidad);
        Image armaImage = new Image("file:src/resources/PanelDeControl/BotonesAcciones/ataque_catapulta.png");
        BotonDeAtaque botonDeAtaque = new BotonDeAtaque((IUnidadDeAtaque) unidad, armaImage);
        this.add(botonDeAtaque, 5,0);
    }
}
