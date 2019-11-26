package Algo3TP2.Vistas;

import Algo3TP2.Controladores.BotonJugarHandler;
import Algo3TP2.Modelos.Jugador;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.ViewProperties;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class InitializerView extends VBox {

    public Stage stage;
    private TableroView tableroView;

    public TextField jugadorUnoNombreInput;
    public TextField jugadorDosNombreInput;


    public InitializerView(Stage stage){

        super();

        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        Image imagen = new Image("file:src/main/java/Algo3TP2/Recursos/The300.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        //Jugador uno Name label
        Label jugadorUnoNombreLabel = new Label("Nombre jugador 1:");
        jugadorUnoNombreLabel.setFont(Font.font("Arial", 20));
        //Jugador uno Name input
        this.jugadorUnoNombreInput = new TextField("Jugador1");// Default text

        //Jugador uno Nombre label
        Label jugadorDosNombreLabel = new Label("Nombre jugador 2:");
        jugadorDosNombreLabel.setFont(Font.font("Arial", 20));
        //Jugador uno Nombre input
        this.jugadorDosNombreInput = new TextField("Jugador2");// Default text

        Button botonJugar = new Button("Jugar");
        botonJugar.setMaxSize(200, 400);

        BotonJugarHandler botonJugarHandler = new BotonJugarHandler(this);
        botonJugar.setOnAction(botonJugarHandler);

        this.getChildren().addAll(jugadorUnoNombreLabel, jugadorUnoNombreInput, jugadorDosNombreLabel, jugadorDosNombreInput, botonJugar);
    }

}
