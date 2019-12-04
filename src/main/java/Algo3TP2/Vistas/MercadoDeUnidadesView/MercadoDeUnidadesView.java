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

public class MercadoDeUnidadesView extends VBox {

    public MercadoDeUnidadesView(Bando bando, Juego juego) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {

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

        this.getChildren().addAll(imageViewMercadoTitulo, stackPaneBilletera);
    }
}

//TODO: recibir el contenido del oro inicial por algún medio.