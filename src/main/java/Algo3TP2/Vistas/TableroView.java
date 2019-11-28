
package Algo3TP2.Vistas;

import Algo3TP2.Properties;
import Algo3TP2.ViewProperties;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.Node;

public class TableroView extends GridPane {

    public TableroView(Tablero tablero) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {
        //GridPane gridPane = new GridPane();

        this.setAlignment(Pos.CENTER);
        Image imagen = new Image("file:src/resources/Fondos/Mapa_1.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(1000,1000, false, false, false, false));
        this.setBackground(new Background(imagenDeFondo));

        for (int i=0; i<ViewProperties.tamanioTablero; i++){
            for (int j=0; j<ViewProperties.tamanioTablero; j++){
                CasilleroView casillero;
                if (j < ViewProperties.tamanioTablero / 2) {
                    casillero = new casilleroViewRojo(tablero, new Coordenada(i, j));
                }else {
                    casillero = new casilleroViewAzul(tablero, new Coordenada(i, j));
                }
                this.add(casillero, i, j);
            }
        }
    }

}