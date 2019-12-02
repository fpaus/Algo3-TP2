package Algo3TP2.Vistas;

import Algo3TP2.Controladores.ComprarUnidadHandler;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class MercadoDeUnidadesView extends VBox {

    public MercadoDeUnidadesView() throws CasilleroFueraDelLosLimitesDelTableroExcepcion {

        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(30);
        Image imagen = new Image("file:src/resources/Mercado/Mercado_fondo_madera.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(500,500, false, false, false, false));
        this.setBackground(new Background(imagenDeFondo));
        this.setPadding(new Insets(20, 5, 0, 5));

        ImageView imageViewMercadoTitulo = new ImageView(new Image("file:src/resources/Mercado/titulo_mercado.png"));

        // Botones placeholders
        Button botonUnidad1 = new Button();
        botonUnidad1.setGraphic(new ImageView(new Image("file:src/resources/Mercado/boton_mercado_unidad_placeholder.jpg")));
        botonUnidad1.setOnAction(new ComprarUnidadHandler());

        Button botonUnidad2 = new Button();
        botonUnidad2.setGraphic(new ImageView(new Image("file:src/resources/Mercado/boton_mercado_unidad_placeholder.jpg")));
        Button botonUnidad3 = new Button();
        botonUnidad3.setGraphic(new ImageView(new Image("file:src/resources/Mercado/boton_mercado_unidad_placeholder.jpg")));
        Button botonUnidad4 = new Button();
        botonUnidad4.setGraphic(new ImageView(new Image("file:src/resources/Mercado/boton_mercado_unidad_placeholder.jpg")));



        this.getChildren().addAll(imageViewMercadoTitulo, botonUnidad1, botonUnidad2, botonUnidad3, botonUnidad4);
    }

}
