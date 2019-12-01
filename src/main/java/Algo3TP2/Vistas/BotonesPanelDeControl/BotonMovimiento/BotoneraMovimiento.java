package Algo3TP2.Vistas.BotonesPanelDeControl.BotonMovimiento;

import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Vistas.BotonesPanelDeControl.BotonMovimiento.BotonesDirecciones.*;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class BotoneraMovimiento extends GridPane {



    public BotoneraMovimiento(Unidad unidad){
        Button botonMoverHaciaDerecha = new BotonDireccion(new BotonMoverHaciaDerecha(unidad));
        Button botonMoverHaciaIzquierda = new BotonDireccion(new BotonMoverHaciaIzquierda(unidad));
        Button botonMoverHaciaArriba = new BotonDireccion(new BotonMoverHaciaArriba(unidad));
        Button botonMoverHaciaAbajo = new BotonDireccion(new BotonMoverHaciaAbajo(unidad));
        Button botonMoverHaciaArribaIzquierda = new BotonDireccion(new BotonMoverHaciaArribaIzquierda(unidad));
        Button botonMoverHaciaArribaDerecha = new BotonDireccion(new BotonMoverHaciaArribaDerecha(unidad));
        Button botonMoverHaciaAbajoIzquierda = new BotonDireccion(new BotonMoverHaciaAbajoIzquierda(unidad));
        Button botonMoverHaciaAbajoDerecha = new BotonDireccion(new BotonMoverHaciaAbajoDerecha(unidad));

        this.add(botonMoverHaciaArribaIzquierda,0,0);
        this.add(botonMoverHaciaArriba, 1,0);
        this.add(botonMoverHaciaArribaDerecha,2,0);
        this.add(botonMoverHaciaDerecha,2,1);
        this.add(botonMoverHaciaIzquierda, 0,1);
        this.add(botonMoverHaciaAbajoIzquierda,0,2);
        this.add(botonMoverHaciaAbajo,1,2);
        this.add(botonMoverHaciaAbajoDerecha,2,2);
    }
}
