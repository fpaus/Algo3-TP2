
package Algo3TP2.Vistas;

import Algo3TP2.ViewProperties;
import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class CasilleroView extends Pane {

    private int largoDelCasillero;
    private int anchoDelCasillero;
    private Casillero casillero;

    public CasilleroView(Tablero tablero, Coordenada coordenada) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {

        this.largoDelCasillero = ViewProperties.largoDelCasillero;
        this.anchoDelCasillero = ViewProperties.anchoDelCasillero;
        this.casillero = tablero.getCasilleroEnCoordenada(coordenada);
        this.setMinWidth(this.anchoDelCasillero);
        this.setMinHeight(this.largoDelCasillero);


        this.setStyle("-fx-border-width: 5; -fx-border-width: 1; -fx-border-color: black;");
        //this.getStylesheets().add("file:src/main/java/Algo3TP2/Vistas/casillero.css");
    }  

}