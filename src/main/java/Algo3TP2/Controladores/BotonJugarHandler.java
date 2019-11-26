package Algo3TP2.Controladores;

import Algo3TP2.Modelos.Jugador;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.ViewProperties;
import Algo3TP2.Vistas.InitializerView;
import Algo3TP2.Vistas.TableroView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class BotonJugarHandler implements EventHandler<ActionEvent> {

    private InitializerView initializerView;

    public BotonJugarHandler(InitializerView initializerView){
        this.initializerView = initializerView;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Tablero tablero = Tablero.getTablero();

        Jugador jugadorUno = new Jugador(initializerView.jugadorUnoNombreInput.getText());
        Jugador jugadorDos = new Jugador(initializerView.jugadorDosNombreInput.getText());
        tablero.inicializarTablero(ViewProperties.cantidadDeCasilleros, ViewProperties.cantidadDeCasilleros,jugadorUno,jugadorDos);
        try {
           TableroView tableroView = new TableroView(tablero);
            Scene siguienteEscena = new Scene(tableroView);
            initializerView.stage.setScene(siguienteEscena);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
