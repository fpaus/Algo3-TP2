package Algo3TP2.Vistas.BotonesPanelDeControl.BotonMovimiento.BotonesDirecciones;

import Algo3TP2.Controladores.MoverUnidadHandler;
import Algo3TP2.Modelos.Tablero.Direccion.Abajo;
import Algo3TP2.Modelos.Tablero.Direccion.Izquierda;
import Algo3TP2.Modelos.Unidades.Unidad;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BotonMoverHaciaAbajoIzquierda extends Button {

    public BotonMoverHaciaAbajoIzquierda(Unidad unidad){
        MoverUnidadHandler moverUnidadHandlerHaciaDerecha = new MoverUnidadHandler(unidad, new Izquierda(), new Abajo());
        this.setOnAction(moverUnidadHandlerHaciaDerecha);
        //this.setOnAction(e -> System.out.println("Oooo  i love it when u touch me there....."));

        this.setPrefSize(25,25);
        ImageView flecha_imageView = new ImageView(new Image("file:src/resources/PanelDeControl/FlechasDirecciones/Flecha_abajo.png"));
        flecha_imageView.setFitHeight(25);
        flecha_imageView.setFitWidth(25);
        this.setGraphic(flecha_imageView);
    }
}
