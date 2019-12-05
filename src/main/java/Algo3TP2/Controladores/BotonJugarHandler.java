
package Algo3TP2.Controladores;

import Algo3TP2.Modelos.Juego;
import Algo3TP2.ViewProperties;
import Algo3TP2.Vistas.JuegoView.JuegoView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BotonJugarHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private Juego juego;
    private TextField jugadorUnoNombreInput;
    private TextField jugadorDosNombreInput;

    public BotonJugarHandler(Stage stage, Juego juego, TextField jugadorDosNombreInput, TextField jugadorUnoNombreInput){
        this.stage = stage;
        this.juego = juego;
        this.jugadorUnoNombreInput = jugadorUnoNombreInput;
        this.jugadorDosNombreInput = jugadorDosNombreInput;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        this.juego.inicializarJuego(jugadorUnoNombreInput.getText(), jugadorDosNombreInput.getText(), ViewProperties.tamanioTablero);

        try {
            JuegoView.inicializarJuegoView(this.juego, this.stage);
            JuegoView juegoView = JuegoView.getJuegoView();
            Scene siguienteEscena = new Scene(juegoView);
            this.stage.setScene(siguienteEscena);
            this.stage.centerOnScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
