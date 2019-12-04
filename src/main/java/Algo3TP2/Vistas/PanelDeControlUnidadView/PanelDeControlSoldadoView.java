package Algo3TP2.Vistas.PanelDeControlUnidadView;

import Algo3TP2.Modelos.Juego;
import Algo3TP2.Modelos.Unidades.IUnidadDeAtaque;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Vistas.BotonesPanelDeControl.BotonDeAtaque;
import javafx.scene.image.Image;

public class PanelDeControlSoldadoView extends PanelDeControlUnidadMovibleView{

    public PanelDeControlSoldadoView(Unidad unidad, Juego juego) {
        super(unidad, juego);
        Image armaImage = new Image("file:src/resources/PanelDeControl/BotonesAcciones/ataque_soldado.png");
        BotonDeAtaque botonDeAtaque = new BotonDeAtaque((IUnidadDeAtaque) unidad, armaImage);
        /*BotonFormarBatallon botonFormarBatallon = new BotonFormarBatallon(); */ // Falta implementar.
        this.add(botonDeAtaque, 2,0);
        // this.add(botonFormarBatallon, 2,1);
    }

}
