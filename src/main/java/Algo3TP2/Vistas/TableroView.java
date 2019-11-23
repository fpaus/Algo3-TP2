
package Algo3TP2.Vistas;

import Algo3TP2.Properties;
import Algo3TP2.ViewProperties;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.Node;

public class TableroView extends Group {

    private GridPane table;
    private CasilleroView[][] casilleros;

    public TableroView(Tablero tablero) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {
        table = new GridPane();
        casilleros = new CasilleroView[ViewProperties.cantidadDeCasilleros][ViewProperties.cantidadDeCasilleros];
        for (int x = 0; x < ViewProperties.cantidadDeCasilleros; x++) {
            for (int y = 0; y < ViewProperties.cantidadDeCasilleros; y++) {
                CasilleroView casillero = new CasilleroView(tablero, new Coordenada(x, y));
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