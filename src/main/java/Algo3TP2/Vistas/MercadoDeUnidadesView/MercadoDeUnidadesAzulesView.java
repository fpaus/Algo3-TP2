package Algo3TP2.Vistas.MercadoDeUnidadesView;

import Algo3TP2.Controladores.BotonFinalizarComprarDeUnidadesAzulesHandler;
import Algo3TP2.Controladores.ComprarUnidadHandler;
import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Juego;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Vistas.BotonesPanelDeControl.BotonComprarUnidad;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

public class MercadoDeUnidadesAzulesView extends MercadoDeUnidadesView {

    private String colorEquipo = "EquipoAzul";

    public MercadoDeUnidadesAzulesView(Bando bando, Juego juego) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {
        super(bando, juego);

        // Botones
        Image botonUnidad1Image = new Image("file:src/resources/Mercado/boton_comprar_soldado_azul.png");
        ComprarUnidadHandler botonUnidad1Handler = new ComprarUnidadHandler(colorEquipo, "Soldado", bando, juego);
        Button botonUnidad1 = new BotonComprarUnidad(botonUnidad1Handler, botonUnidad1Image);

        Image botonUnidad2Image = new Image("file:src/resources/Mercado/boton_comprar_jinete_azul.png");
        ComprarUnidadHandler botonUnidad2Handler = new ComprarUnidadHandler(colorEquipo, "Jinete", bando, juego);
        Button botonUnidad2 = new BotonComprarUnidad(botonUnidad2Handler, botonUnidad2Image);

        Image botonUnidad3Image = new Image("file:src/resources/Mercado/boton_comprar_curandero_azul.png");
        ComprarUnidadHandler botonUnidad3Handler = new ComprarUnidadHandler(colorEquipo, "Curandero", bando, juego);
        Button botonUnidad3 = new BotonComprarUnidad(botonUnidad3Handler, botonUnidad3Image);

        Image botonUnidad4Image = new Image("file:src/resources/Mercado/boton_comprar_catapulta_azul.png");
        ComprarUnidadHandler botonUnidad4Handler = new ComprarUnidadHandler(colorEquipo, "Catapulta", bando, juego);
        Button botonUnidad4 = new BotonComprarUnidad(botonUnidad4Handler, botonUnidad4Image);

        this.getChildren().addAll(botonUnidad1, botonUnidad2, botonUnidad3, botonUnidad4);

        this.botonFinalizarCompra.setOnAction(new BotonFinalizarComprarDeUnidadesAzulesHandler());
    }
}
