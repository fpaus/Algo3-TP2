
package Algo3TP2.Vistas;

import Algo3TP2.ViewProperties;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class TableroView extends GridPane {

    public TableroView(Tablero tablero) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {
        //GridPane gridPane = new GridPane();

        this.setAlignment(Pos.CENTER);
        Image imagen = new Image("file:src/resources/Fondos/Mapa_1.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(1000,1000, false, false, false, false));
        this.setBackground(new Background(imagenDeFondo));
        this.setPadding(new Insets(20, 20, 20, 20));

        for (int i=0; i<ViewProperties.tamanioTablero; i++){
            for (int j=0; j<ViewProperties.tamanioTablero; j++){
                CasilleroView casillero;
                if (j < ViewProperties.tamanioTablero / 2) {
                    casillero = new CasilleroViewRojo(tablero, new Coordenada(i, j));
                }else {
                    casillero = new CasilleroViewAzul(tablero, new Coordenada(i, j));
                }
                this.add(casillero, i, j);
            }
        }
    }

}