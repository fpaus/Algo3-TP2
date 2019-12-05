package Algo3TP2.Controladores;

import Algo3TP2.Modelos.Jugador.Jugador;
import Algo3TP2.Vistas.JuegoView.JuegoView;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FinDelJuegoAlert {

    public static void display(Jugador jugadorGanador){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL); // Impede que podamos interactuar con otro stage sin cerrar este
        window.setTitle("Fin del juego");
        window.setMinWidth(250);

        Label label = new Label();
        label.setText("Felicitaciones " +jugadorGanador.toString() + " has ganado el juego!!");
        Button closeButton = new Button("Terminar juego");
        closeButton.setOnAction(e -> {
            window.close();
            JuegoView.getJuegoView().close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
