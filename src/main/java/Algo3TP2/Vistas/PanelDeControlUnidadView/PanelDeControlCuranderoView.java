package Algo3TP2.Vistas.PanelDeControlUnidadView;

import Algo3TP2.Modelos.Juego;
import Algo3TP2.Modelos.Unidades.Curandero;
import Algo3TP2.Modelos.Unidades.IUnidadDeAtaque;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Vistas.BotonesPanelDeControl.BotonDeAtaque;
import Algo3TP2.Vistas.BotonesPanelDeControl.BotonDeCuracion;
import javafx.scene.image.Image;

public class PanelDeControlCuranderoView extends PanelDeControlUnidadMovibleView{

    public PanelDeControlCuranderoView(Unidad unidad, Juego juego) {
        super(unidad, juego);
        Image armaImage = new Image("file:src/resources/PanelDeControl/BotonesAcciones/curar_curandero.png");
        BotonDeCuracion botonDeCuracion = new BotonDeCuracion((Curandero) unidad, armaImage);
        this.add(botonDeCuracion, 2,0);
    }
}
