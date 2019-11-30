
package Algo3TP2.Vistas;

import Algo3TP2.ViewProperties;
import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Vistas.UnidadesView.UnidadView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;


public class CasilleroView extends Pane {

    private int largoDelCasillero;
    private int anchoDelCasillero;
    private Casillero casillero;
    private UnidadView unidadViewEnCasillero;

    public CasilleroView(Tablero tablero, Coordenada coordenada) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {

        this.largoDelCasillero = ViewProperties.largoDelCasillero;
        this.anchoDelCasillero = ViewProperties.anchoDelCasillero;
        this.casillero = tablero.getCasilleroEnCoordenada(coordenada);
        this.setMinWidth(this.anchoDelCasillero);
        this.setMinHeight(this.largoDelCasillero);

        final int[] num = {1}; // Para contar los clicks dentro de cada Pane.
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //System.out.println("Casillero clickeado " + (Integer.toString(num[0])) + " veces...");
                System.out.println(casillero.toString());
                num[0]++;
            }
        });

    }

    public void setUnidadView(UnidadView unidadView){
        this.unidadViewEnCasillero = unidadView;
        this.getChildren().add(unidadView);
    }
}