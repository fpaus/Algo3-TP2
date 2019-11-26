package Algo3TP2;

import Algo3TP2.Modelos.Jugador;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Vistas.*;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
public class AlgoChess extends Application {
    private TableroView tableroView;
    
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Trabajo Practico 2");
        Tablero tablero = Tablero.getTablero();
        tablero.inicializarTablero(ViewProperties.largoDelCasillero, ViewProperties.largoDelCasillero, new Jugador(), new Jugador());
        this.tableroView = new TableroView(tablero);


        VBox vbox = new VBox();
        vbox.getChildren().add(tableroView);
        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();
    }



}

 */