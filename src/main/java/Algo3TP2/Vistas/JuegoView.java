package Algo3TP2.Vistas;
import Algo3TP2.Modelos.Juego;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Tablero.Tablero;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.awt.*;

public class JuegoView extends BorderPane {
    /* Dentro de esta view entran todas las otras views que vamos a tener
     a nuestra disposición mientras jugamos.

     TableroView debería ser parte de JuegoView.

     */
    public JuegoView(Tablero tablero) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {
        TableroView tableroView = new TableroView(tablero);
        TableroView tableroView2 = new TableroView(tablero);

        VBox vbox = new VBox(0, tableroView, tableroView2);
        vbox.setAlignment(Pos.BASELINE_LEFT);

        //this.getChildren().addAll(vbox);
        this.setCenter(tableroView);
    }
}
