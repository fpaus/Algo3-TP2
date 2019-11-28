package Algo3TP2.Vistas;

import Algo3TP2.Controladores.BotonJugarHandler;
import Algo3TP2.Modelos.Juego;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class InitializerView extends VBox {

    public Stage stage;
    private Juego juego;

    public InitializerView(Stage stage, Juego juego){

        super();

        this.stage = stage;
        this.juego = juego;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        Image imagen = new Image("file:src/resources/Fondos/The300.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        //Jugador uno Name label
        Label jugadorUnoNombreLabel = new Label("Nombre jugador 1:");
        jugadorUnoNombreLabel.setFont(Font.font("Arial", 20));
        //Jugador uno Name input
        TextField jugadorUnoNombreInput = new TextField("Jugador1");// Default text
        //jugadorUnoNombreInput.setPromptText("Nombre del jugador 1");

        //Jugador uno Nombre label
        Label jugadorDosNombreLabel = new Label("Nombre jugador 2:");
        jugadorDosNombreLabel.setFont(Font.font("Arial", 20));
        //Jugador uno Nombre input
        TextField jugadorDosNombreInput = new TextField("Jugador2");// Default text

        Button botonJugar = new Button("Jugar");
        botonJugar.setMaxSize(200, 400);

        BotonJugarHandler botonJugarHandler = new BotonJugarHandler(this.stage, this.juego, jugadorUnoNombreInput, jugadorDosNombreInput);
        botonJugar.setOnAction(botonJugarHandler);

        this.getChildren().addAll(jugadorUnoNombreLabel, jugadorUnoNombreInput, jugadorDosNombreLabel, jugadorDosNombreInput, botonJugar);
    }

}