package Algo3TP2.Vistas.MercadoDeUnidadesView;

import Algo3TP2.Controladores.ComprarUnidadHandler;
import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Juego;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MercadoDeUnidadesView extends VBox {

    public MercadoDeUnidadesView(Bando bando, Juego juego) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {

        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(5);
        Image imagen = new Image("file:src/resources/Mercado/fondo_mercado.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(183, 640, false, false, false, false));
        this.setBackground(new Background(imagenDeFondo));
        this.setPadding(new Insets(5, 5, 0, 5));

        // Imagen Título del Mercado
        ImageView imageViewMercadoTitulo = new ImageView(new Image("file:src/resources/Mercado/titulo_mercado.png"));

        // Nombre Jugador
        StackPane stackPaneNombreJugador = new StackPane();

        ImageView imagenMarcoNombre = new ImageView(new Image("file:src/resources/Mercado/marco_nombre_jugador.png"));

        Text textNombreJugador = new Text();
        textNombreJugador.setText("Nombre");
        textNombreJugador.setFont(Font.loadFont("file:src/resources/Fonts/fuente_medieval.ttf", 20));
        textNombreJugador.setFill(Color.WHITE);

        stackPaneNombreJugador.getChildren().addAll(imagenMarcoNombre, textNombreJugador);

        // Billetera Jugador
        StackPane stackPaneBilletera = new StackPane();

        ImageView imagenMarcoBilletera = new ImageView(new Image("file:src/resources/Mercado/marco_billetera.png"));
        Text textOroRestante = new Text();
        textOroRestante.setText("20");
        textOroRestante.setFont(Font.loadFont("file:src/resources/Fonts/fuente_medieval.ttf", 25));
        textOroRestante.setFill(Paint.valueOf("#ffcc39"));
        /*text.setStroke(Color.BLACK); // El stroke queda feo porque invade el interiode la fuente.
        text.setStrokeWidth(1);*/

        // Implementación con Label en vez de Text.
        // Por alguna razón no mostraba bien la fuente a veces.
        /*Label labelOroRestante = new Label("20");

        labelOroRestante.setStyle(" -fx-font-size: 20;" +
                "                   -fx-text-fill: #ffcc39;" +
                "                   -fx-stroke: #000000;" +
                "                   -fx-stroke-width: 30px;");// No funciona el stroke
        labelOroRestante.setFont(Font.loadFont("file:src/resources/Fonts/fuente_medieval.ttf", 20));*/

        stackPaneBilletera.getChildren().addAll(imagenMarcoBilletera, textOroRestante);

        this.getChildren().addAll(imageViewMercadoTitulo, stackPaneNombreJugador, stackPaneBilletera);
    }
}

//TODO: recibir el contenido del oro inicial por algún medio.