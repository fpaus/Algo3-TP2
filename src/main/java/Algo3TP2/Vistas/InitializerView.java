package Algo3TP2.Vistas;

import Algo3TP2.Controladores.BotonJugarHandler;
import Algo3TP2.Modelos.Juego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.ImageCursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class InitializerView extends VBox {

    public Stage stage;
    private Juego juego;

    public InitializerView(Stage stage, Juego juego){

        super();

        this.stage = stage;
        this.juego = juego;

        this.setAlignment(Pos.BOTTOM_CENTER);
        this.setSpacing(35);
        this.setPadding(new Insets(0,0,30,0));
        Image imagen = new Image("file:src/resources/Fondos/inicio_caratula.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        this.setCursor(new ImageCursor(new Image("file:src/resources/Punteros/cursor.png")));

        //Jugador uno Name input
        TextField jugadorUnoNombreInput = new TextField("Jugador1");// Default text
        jugadorUnoNombreInput.setMaxWidth(200);
        //jugadorUnoNombreInput.setPromptText("Nombre del jugador 1");

        //Jugador uno Nombre input
        TextField jugadorDosNombreInput = new TextField("Jugador2");// Default text
        jugadorDosNombreInput.setMaxWidth(200);

        Button botonJugar = new Button("Jugar");
        botonJugar.setMaxSize(200, 400);

        BotonJugarHandler botonJugarHandler = new BotonJugarHandler(this.stage, this.juego, jugadorUnoNombreInput, jugadorDosNombreInput);
        botonJugar.setOnAction(botonJugarHandler);

        this.getChildren().addAll(jugadorUnoNombreInput, jugadorDosNombreInput, botonJugar);
    }

}