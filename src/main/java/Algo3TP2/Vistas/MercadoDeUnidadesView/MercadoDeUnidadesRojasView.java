package Algo3TP2.Vistas.MercadoDeUnidadesView;

import Algo3TP2.Controladores.ComprarUnidadHandler;
import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Juego;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MercadoDeUnidadesRojasView extends MercadoDeUnidadesView {

    private String colorEquipo = "EquipoRojo";

    public MercadoDeUnidadesRojasView(Bando bando, Juego juego) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {
        super(bando, juego);

        // Botones placeholders
        Button botonUnidad1 = new Button();
        botonUnidad1.setGraphic(new ImageView(new Image("file:src/resources/Mercado/boton_comprar_soldado_rojo.png")));
        botonUnidad1.setOnAction(new ComprarUnidadHandler(colorEquipo, "Soldado", bando, juego));

        Button botonUnidad2 = new Button();
        botonUnidad2.setGraphic(new ImageView(new Image("file:src/resources/Mercado/boton_comprar_jinete_rojo.png")));
        botonUnidad2.setOnAction(new ComprarUnidadHandler(colorEquipo, "Jinete", bando, juego));

        Button botonUnidad3 = new Button();
        botonUnidad3.setGraphic(new ImageView(new Image("file:src/resources/Mercado/boton_comprar_curandero_rojo.png")));
        botonUnidad3.setOnAction(new ComprarUnidadHandler(colorEquipo, "Curandero", bando, juego));

        Button botonUnidad4 = new Button();
        botonUnidad4.setGraphic(new ImageView(new Image("file:src/resources/Mercado/boton_comprar_catapulta_roja.png")));
        botonUnidad4.setOnAction(new ComprarUnidadHandler(colorEquipo, "Catapulta", bando, juego));

        this.getChildren().addAll(botonUnidad1, botonUnidad2, botonUnidad3, botonUnidad4);
    }
}
