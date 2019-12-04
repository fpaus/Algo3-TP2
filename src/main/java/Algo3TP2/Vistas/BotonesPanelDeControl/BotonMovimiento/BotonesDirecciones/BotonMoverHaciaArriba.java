package Algo3TP2.Vistas.BotonesPanelDeControl.BotonMovimiento.BotonesDirecciones;

import Algo3TP2.Controladores.MoverUnidadHandler;
import Algo3TP2.Modelos.Tablero.Direccion.Arriba;
import Algo3TP2.Modelos.Tablero.Direccion.Fija;
import Algo3TP2.Modelos.Unidades.Unidad;
import javafx.scene.image.Image;

public class BotonMoverHaciaArriba extends BotonMoverGenerico {

    public BotonMoverHaciaArriba(Unidad unidad) {
        super(unidad);
    }

    @Override
    public MoverUnidadHandler moverUnidadHandler() {
        return new MoverUnidadHandler(unidad, new Fija(), new Arriba());
    }

    @Override
    public Image imagePath() {
        return new Image(imagePath + "boton_arriba.png");
    }
}