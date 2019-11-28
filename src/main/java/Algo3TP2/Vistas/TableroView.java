
package Algo3TP2.Vistas;

import Algo3TP2.Properties;
import Algo3TP2.ViewProperties;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.Node;
import javafx.scene.paint.Color;

public class TableroView extends Group {

    private GridPane table;
    private CasilleroView[][] casilleros;

    public TableroView(Tablero tablero) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {
        // Style
        table = new GridPane();
        table.setGridLinesVisible(true);
        Image imagen = new Image("file:src/resources/Mapa_1.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(1000,1000, false, false, false, false));
        table.setBackground(new Background(imagenDeFondo));

        // Instanciacion de los casillerosView
        casilleros = new CasilleroView[ViewProperties.tamanioTablero][ViewProperties.tamanioTablero];
        for (int x = 0; x < ViewProperties.tamanioTablero; x++) {
            for (int y = 0; y < ViewProperties.tamanioTablero; y++) {
                CasilleroView casillero;
                if (y < ViewProperties.tamanioTablero / 2) {
                    casillero = new casilleroViewRojo(tablero, new Coordenada(x, y));
                }else {
                    casillero = new casilleroViewAzul(tablero, new Coordenada(x, y));
                }
                casilleros[x][y] = casillero;
                table.add(casillero, x, y);
            }
        }

        this.addView(table);

    }

    public void addView(Node view) {
        this.getChildren().add(view);
    }
}