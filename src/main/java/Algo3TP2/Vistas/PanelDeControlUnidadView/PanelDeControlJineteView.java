package Algo3TP2.Vistas.PanelDeControlUnidadView;

import Algo3TP2.Modelos.Juego;
import Algo3TP2.Modelos.Unidades.IUnidadDeAtaque;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Vistas.BotonesPanelDeControl.BotonDeAtaque;
import javafx.scene.image.Image;

public class PanelDeControlJineteView extends PanelDeControlUnidadMovibleView {

    public PanelDeControlJineteView(Unidad unidad, Juego juego) {
        super(unidad, juego);
        Image armaImage = new Image("file:src/resources/PanelDeControl/BotonesAcciones/ataque_jinete_media.png");
        BotonDeAtaque botonDeAtaque = new BotonDeAtaque((IUnidadDeAtaque) unidad, armaImage);
        this.add(botonDeAtaque, 2,0);
    }
}
