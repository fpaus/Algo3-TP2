package Algo3TP2.Vistas.PanelDeControlUnidadView;

import Algo3TP2.Modelos.Juego;
import Algo3TP2.Modelos.Unidades.IUnidadDeAtaque;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Vistas.BotonesPanelDeControl.BotonDeAtaque;
import Algo3TP2.Vistas.BotonesPanelDeControl.BotonDeBatallon;
import javafx.scene.image.Image;
import Algo3TP2.Modelos.Unidades.Soldado;

public class PanelDeControlSoldadoView extends PanelDeControlUnidadMovibleView {

    public PanelDeControlSoldadoView(Unidad unidad, Juego juego) {
        super(unidad, juego);
        Image armaImage = new Image("file:src/resources/PanelDeControl/BotonesAcciones/ataque_soldado.png");
        // Image formarBatallonImage = new
        // Image("file:src/resources/PanelDeControl/BotonesAcciones/batallon_formar_rojo.png");

        BotonDeAtaque botonDeAtaque = new BotonDeAtaque((IUnidadDeAtaque) unidad, armaImage);
        BotonDeBatallon botonFormarBatallon = new BotonDeBatallon((Soldado) unidad);
        this.add(botonDeAtaque, 2, 0);
        this.add(botonFormarBatallon, 2, 1);
    }

}
