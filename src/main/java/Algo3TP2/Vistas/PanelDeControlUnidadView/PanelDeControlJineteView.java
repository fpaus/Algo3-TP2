package Algo3TP2.Vistas.PanelDeControlUnidadView;

import Algo3TP2.Modelos.Unidades.IUnidadDeAtaque;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Vistas.BotonesPanelDeControl.BotonDeAtaque;
import javafx.scene.image.Image;

public class PanelDeControlJineteView extends PanelDeControlUnidadMovibleView {

    public PanelDeControlJineteView(Unidad unidad) {
        super(unidad);
        Image armaImage = new Image("file:src/resources/Punteros/cursor_ataque.png");
        BotonDeAtaque botonDeAtaque = new BotonDeAtaque((IUnidadDeAtaque) unidad, armaImage);
        this.add(botonDeAtaque, 5,0);
    }
}
