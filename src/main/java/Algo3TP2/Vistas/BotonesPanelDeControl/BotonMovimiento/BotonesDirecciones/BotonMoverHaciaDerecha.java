package Algo3TP2.Vistas.BotonesPanelDeControl.BotonMovimiento.BotonesDirecciones;

import Algo3TP2.Controladores.MoverUnidadHandler;
import Algo3TP2.Modelos.Juego;
import Algo3TP2.Modelos.Tablero.Direccion.Derecha;
import Algo3TP2.Modelos.Tablero.Direccion.Fija;
import Algo3TP2.Modelos.Unidades.Unidad;
import javafx.scene.image.Image;

public class BotonMoverHaciaDerecha extends BotonMoverGenerico {

    public BotonMoverHaciaDerecha(Unidad unidad, Juego juego) {
        super(unidad, juego);
    }

    @Override
    public MoverUnidadHandler moverUnidadHandler() {
        return new MoverUnidadHandler(unidad, new Derecha(), new Fija(), this.juego);
    }

    @Override
    public Image imagePath() {
        return new Image(imagePath + "boton_derecha.png");
    }
}
