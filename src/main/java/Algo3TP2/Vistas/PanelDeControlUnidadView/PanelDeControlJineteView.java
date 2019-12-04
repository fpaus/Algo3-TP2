package Algo3TP2.Vistas.PanelDeControlUnidadView;

import Algo3TP2.Modelos.Juego;
import Algo3TP2.Modelos.Unidades.IUnidadDeAtaque;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Vistas.BotonesPanelDeControl.BotonDeAtaque;
import javafx.scene.image.Image;

public class PanelDeControlJineteView extends PanelDeControlUnidadMovibleView {

    public PanelDeControlJineteView(Unidad unidad, Juego juego) {
        super(unidad, juego);
        Image armaImage = new Image("file: aca tendremos que saber de que arma tiene como estrategia el Jinete");
        BotonDeAtaque botonDeAtaque = new BotonDeAtaque((IUnidadDeAtaque) unidad, armaImage);
        this.add(botonDeAtaque, 5,0);
    }
}
