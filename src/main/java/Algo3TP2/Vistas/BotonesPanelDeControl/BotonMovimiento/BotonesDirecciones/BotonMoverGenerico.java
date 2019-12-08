package Algo3TP2.Vistas.BotonesPanelDeControl.BotonMovimiento.BotonesDirecciones;

import Algo3TP2.Controladores.MoverUnidadHandler;
import Algo3TP2.Modelos.Juego;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.ViewProperties;
import javafx.scene.image.Image;

public abstract class BotonMoverGenerico {
    protected Unidad unidad;
    protected String imagePath = ViewProperties.imagePath;
    protected Juego juego;

    public BotonMoverGenerico(Unidad unidad, Juego juego){
        this.unidad = unidad;
        this.juego = juego;
    }

    public abstract MoverUnidadHandler moverUnidadHandler();

    public abstract Image imagePath();
}