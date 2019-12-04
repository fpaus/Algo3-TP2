package Algo3TP2.Vistas;

import Algo3TP2.Controladores.ComprarUnidadHandler;
import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class MercadoDeUnidadesView extends VBox {

    public MercadoDeUnidadesView(String colorEquipo, Bando bando) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {

        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(5);
        Image imagen = new Image("file:src/resources/Mercado/fondo_mercado.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(183,640, false, false, false, false));
        this.setBackground(new Background(imagenDeFondo));
        this.setPadding(new Insets(20, 5, 0, 5));

        ImageView imageViewMercadoTitulo = new ImageView(new Image("file:src/resources/Mercado/titulo_mercado.png"));


        StackPane stackPaneBilletera = new StackPane();
        Label labelOroRestante = new Label("20");
        labelOroRestante.setStyle(" -fx-font-size:20px; " +
                "                   -fx-text-fill: #ffcc39;" +
                "                   -fx-font-weight: bold;");
        stackPaneBilletera.getChildren().add(new ImageView(new Image("file:src/resources/Mercado/marco_billetera.png")));
        stackPaneBilletera.getChildren().add(labelOroRestante);

        // Botones placeholders
        Button botonUnidad1 = new Button();
        botonUnidad1.setGraphic(new ImageView(new Image("file:src/resources/Mercado/boton_comprar_soldado_1.png")));
        botonUnidad1.setOnAction(new ComprarUnidadHandler(colorEquipo, "Soldado", bando));

        Button botonUnidad2 = new Button();
        botonUnidad2.setGraphic(new ImageView(new Image("file:src/resources/Mercado/boton_comprar_jinete_1.png")));
        botonUnidad2.setOnAction(new ComprarUnidadHandler(colorEquipo, "Jinete", bando));

        Button botonUnidad3 = new Button();
        botonUnidad3.setGraphic(new ImageView(new Image("file:src/resources/Mercado/boton_comprar_curandero_1.png")));
        botonUnidad3.setOnAction(new ComprarUnidadHandler(colorEquipo, "Curandero", bando));

        Button botonUnidad4 = new Button();
        botonUnidad4.setGraphic(new ImageView(new Image("file:src/resources/Mercado/boton_comprar_catapulta_1.png")));
        botonUnidad4.setOnAction(new ComprarUnidadHandler(colorEquipo, "Catapulta", bando));

        this.getChildren().addAll(imageViewMercadoTitulo, stackPaneBilletera, botonUnidad1, botonUnidad2, botonUnidad3, botonUnidad4);
    }
}

//TODO: recibir el contenido del oro inicial por algún medio.