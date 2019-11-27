package Algo3TP2;

import Algo3TP2.Vistas.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AlgoChess extends Application {
    private TableroView tableroView;
    
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Trabajo Practico 2");

        InitializerView initializerView = new InitializerView(stage);
        Scene escenaBienvenidos = new Scene(initializerView, 800,600);
        /*
        Tablero tablero = Tablero.getTablero();
        tablero.inicializarTablero(ViewProperties.largoDelCasillero, ViewProperties.largoDelCasillero, new Jugador(), new Jugador());
        this.tableroView = new TableroView(tablero);


        VBox vbox = new VBox();
        vbox.getChildren().add(tableroView);
        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();
         */
        stage.setScene(escenaBienvenidos);
        stage.show();
    }



}
