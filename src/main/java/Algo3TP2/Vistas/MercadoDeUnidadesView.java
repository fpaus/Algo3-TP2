package Algo3TP2.Vistas;

import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.ViewProperties;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class MercadoDeUnidadesView extends GridPane {

    public MercadoDeUnidadesView() throws CasilleroFueraDelLosLimitesDelTableroExcepcion {

        this.setAlignment(Pos.CENTER);
        Image imagen = new Image("file:src/resources/Fondos/Mercado_fondo.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(1000,1000, false, false, false, false));
        this.setBackground(new Background(imagenDeFondo));
        this.setPadding(new Insets(40, 40, 40, 40));

        Label mercadoLabel = new Label("Mercado");
        mercadoLabel.setStyle("-fx-font-size: 25px; -fx-font-family: 'Arial Black'; -fx-font-weight: 900; -fx-text-fill: black");
        this.add(mercadoLabel, 1, 0);

        Label deLabel = new Label("     de");
        deLabel.setStyle("-fx-font-size: 25px; -fx-font-family: 'Arial Black'; -fx-font-weight: 900; -fx-text-fill: black");
        this.add(deLabel, 1, 1);

        Label unidadesLabel = new Label("unidades");
        unidadesLabel.setStyle("-fx-font-size: 25px; -fx-font-family: 'Arial Black'; -fx-font-weight: 900; -fx-text-fill: black");
        this.add(unidadesLabel, 1, 2);

        // Solo a modo de relleno
        for (int i = 3; i< ViewProperties.tamanioTablero; i++){
            CasilleroView casillero = new CasilleroView(Tablero.getTablero(), new Coordenada(1, i));
            this.add(casillero, 1, i);
        }
    }

}
