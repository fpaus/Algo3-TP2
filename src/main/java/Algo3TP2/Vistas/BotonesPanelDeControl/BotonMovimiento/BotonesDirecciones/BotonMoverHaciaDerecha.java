package Algo3TP2.Vistas.BotonesPanelDeControl.BotonMovimiento.BotonesDirecciones;

import Algo3TP2.Controladores.MoverUnidadHandler;
import Algo3TP2.Modelos.Juego;
import Algo3TP2.Modelos.Tablero.Direccion.Derecha;
import Algo3TP2.Modelos.Tablero.Direccion.Fija;
import Algo3TP2.Modelos.Unidades.Unidad;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
        return new Image("file:src/resources/PanelDeControl/FlechasDirecciones/Flecha_derecha.png");
    }
}
