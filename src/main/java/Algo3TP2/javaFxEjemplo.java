package Algo3TP2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class javaFxEjemplo extends Application {

    Stage window;
    Button button;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("theNewBoston");
        button = new Button("Click me");

        ChoiceBox<String> choiceBox = new ChoiceBox<>();

        //GetItems returns the observableList object which you can add items to
        choiceBox.getItems().add("Apples");
        choiceBox.getItems().add("Bananas");
        choiceBox.getItems().add("Oranges");
        choiceBox.setValue("Apples");

        //Listen for selection changes
        choiceBox.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> System.out.println(newValue));

        //Layaout
        VBox layaout = new VBox(10);
        layaout.setPadding(new Insets(20,20,20,20));
        layaout.getChildren().addAll(choiceBox, button);

        Scene scene = new Scene(layaout, 500,500);
        window.setScene(scene);
        window.show();
    }

}
