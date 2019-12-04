package Algo3TP2.Vistas.BotonesPanelDeControl.BotonMovimiento.BotonesDirecciones;

import Algo3TP2.Controladores.MoverUnidadHandler;
import Algo3TP2.Modelos.Tablero.Direccion.Abajo;
import Algo3TP2.Modelos.Tablero.Direccion.Izquierda;
import Algo3TP2.Modelos.Unidades.Unidad;
import javafx.scene.image.Image;

public class BotonMoverHaciaAbajoIzquierda extends BotonMoverGenerico {

    public BotonMoverHaciaAbajoIzquierda(Unidad unidad) {
        super(unidad);
    }

    @Override
    public MoverUnidadHandler moverUnidadHandler() {
        return new MoverUnidadHandler(unidad, new Izquierda(), new Abajo());
    }

    @Override
    public Image imagePath() {
        return new Image(imagePath + "boton_abajo_izquierda.png");
    }
}