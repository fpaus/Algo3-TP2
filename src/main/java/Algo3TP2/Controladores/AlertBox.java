package Algo3TP2.Controladores;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

    public static void display(String titulo, String mensaje){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL); // Impede que podamos interactuar con otro stage sin cerrar este
        window.setTitle(titulo);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(mensaje);
        Button closeButton = new Button("Close the window");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}