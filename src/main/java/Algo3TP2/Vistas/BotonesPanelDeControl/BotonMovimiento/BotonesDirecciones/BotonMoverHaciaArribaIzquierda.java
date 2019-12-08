package Algo3TP2.Vistas.BotonesPanelDeControl.BotonMovimiento.BotonesDirecciones;

import Algo3TP2.Controladores.MoverUnidadHandler;
import Algo3TP2.Modelos.Juego;
import Algo3TP2.Modelos.Tablero.Direccion.Arriba;
import Algo3TP2.Modelos.Tablero.Direccion.Izquierda;
import Algo3TP2.Modelos.Unidades.Unidad;
import javafx.scene.image.Image;

public class BotonMoverHaciaArribaIzquierda extends BotonMoverGenerico {

    public BotonMoverHaciaArribaIzquierda(Unidad unidad, Juego juego) {
        super(unidad, juego);
    }

    @Override
    public MoverUnidadHandler moverUnidadHandler() {
        return new MoverUnidadHandler(unidad, new Izquierda(), new Arriba(), this.juego);
    }

    @Override
    public Image imagePath() {
        return new Image(imagePath + "boton_arriba_izquierda.png");
    }
}