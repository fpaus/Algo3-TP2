package Algo3TP2;

import Algo3TP2.Controladores.SalirConfirmBox;
import Algo3TP2.Modelos.Juego;
import Algo3TP2.Vistas.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AlgoChess extends Application {

    private Stage stage;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;

        this.stage.setTitle("Trabajo Practico 2");
        this.stage.setOnCloseRequest(e ->{
            e.consume();
            closeProgram();
        });

        Juego juego = new Juego();

        InitializerView initializerView = new InitializerView(stage, juego);
        Scene escenaBienvenidos = new Scene(initializerView, 800,600);

        stage.setScene(escenaBienvenidos);
        stage.show();
    }

    private void closeProgram(){
        Boolean answer = SalirConfirmBox.display("Cerrar juego alert","¿Esta seguro que desea salir del juego?");
        if(answer)
            this.stage.close();
    }

}
