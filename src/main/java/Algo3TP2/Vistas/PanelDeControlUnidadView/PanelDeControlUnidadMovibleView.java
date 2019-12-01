package Algo3TP2.Vistas.PanelDeControlUnidadView;

import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Vistas.BotonesPanelDeControl.BotonesDirecciones.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

public class PanelDeControlUnidadMovibleView extends PanelDeControlView {

    public PanelDeControlUnidadMovibleView(Unidad unidad) {

        this.setPadding(new Insets(40, 40, 40, 40));
        this.setGridLinesVisible(true);

        // /* Botonera Movimiento
        Button botonMoverHaciaDerecha = new BotonMoverHaciaDerecha(unidad);
        Button botonMoverHaciaIzquierda = new BotonMoverHaciaIzquierda(unidad);
        Button botonMoverHaciaArriba = new BotonMoverHaciaArriba(unidad);
        Button botonMoverHaciaAbajo = new BotonMoverHaciaAbajo(unidad);
        Button botonMoverHaciaArribaIzquierda = new ButonMoverHaciaArribaIzquierda(unidad);
        Button botonMoverHaciaArribaDerecha = new BotonMoverHaciaArribaDerecha(unidad);
        Button botonMoverHaciaAbajoIzquierda = new BotonMoverHaciaAbajoIzquierda(unidad);
        Button botonMoverHaciaAbajoDerecha = new BotonMoverHaciaAbajoDerecha(unidad);

        this.add(botonMoverHaciaArribaIzquierda,0,0);
        this.add(botonMoverHaciaArriba, 1,0);
        this.add(botonMoverHaciaArribaDerecha,2,0);
        this.add(botonMoverHaciaDerecha,2,1);
        this.add(botonMoverHaciaIzquierda, 0,1);
        this.add(botonMoverHaciaAbajoIzquierda,0,2);
        this.add(botonMoverHaciaAbajo,1,2);
        this.add(botonMoverHaciaAbajoDerecha,2,2);
        //          Botonera Movimiento */

    }
}
