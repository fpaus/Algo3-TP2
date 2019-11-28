
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

public class TableroView extends Group {

    public TableroView(Tablero tablero) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {
        GridPane gridPane = new GridPane();
        Pane[][] panes = new Pane[ViewProperties.tamanioTablero][ViewProperties.tamanioTablero];

        gridPane.gridLinesVisibleProperty().set(true); // Para que se vean los bordes de las celdas. Quitar luego.
        gridPane.setHgap(ViewProperties.tamanioTablero/11); // El número 11 es porque las celdas en el .png tienen 11 píxeles de tamanio.
        gridPane.setHgap(ViewProperties.tamanioTablero/11);
        gridPane.setAlignment(Pos.CENTER);

        int num = 1; // Para enumerar las celdas. Quitar luego.
        for (int i=0; i<ViewProperties.tamanioTablero; i++){
            for (int j=0; j<ViewProperties.tamanioTablero; j++){
                String string = Integer.toString(num); // Para enumerar las celdas. Quitar luego.

                Pane pane = new Pane();
                pane.setMinSize(ViewProperties.anchoDelCasillero, ViewProperties.largoDelCasillero);
                panes[j][i] = pane;

                Label label = new Label(string);
                pane.getChildren().add(label);

                GridPane.setConstraints(panes[j][i], j, i);
                gridPane.getChildren().add(panes[j][i]);
                num++;
            }
        }

        this.addView(gridPane);


        // Código viejo de Fabri:
/*        table = new GridPane();
        casilleros = new CasilleroView[ViewProperties.tamanioTablero][ViewProperties.tamanioTablero];
        for (int x = 0; x < ViewProperties.tamanioTablero; x++) {
            for (int y = 0; y < ViewProperties.tamanioTablero; y++) {
                CasilleroView casillero = new CasilleroView(tablero, new Coordenada(x, y));
                casilleros[x][y] = casillero;
                table.add(casillero, x, y);
            }
        }
        this.addView(table);
*/
    }

    public void addView(Node view) {
        this.getChildren().add(view);
    }
}