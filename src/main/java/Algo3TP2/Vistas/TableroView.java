
package Algo3TP2.Vistas;

import Algo3TP2.Modelos.Unidades.IUnidadDeAtaque;
import Algo3TP2.ViewProperties;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Vistas.CasilleroView.CasilleroView;
import Algo3TP2.Vistas.CasilleroView.CasilleroViewAzul;
import Algo3TP2.Vistas.CasilleroView.CasilleroViewRojo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.HashMap;

public class TableroView extends GridPane {

    HashMap<Coordenada, CasilleroView> casillerosView;

    public TableroView(Tablero tablero) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {

        this.setAlignment(Pos.CENTER);
        Image imagen = new Image("file:src/resources/Fondos/Mapa_1.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(1000,1000, false, false, false, false));
        this.setBackground(new Background(imagenDeFondo));
        this.setPadding(new Insets(20, 20, 20, 20));

        this.casillerosView = new HashMap<Coordenada, CasilleroView>();

        for (int i=0; i<ViewProperties.tamanioTablero; i++){
            for (int j=0; j<ViewProperties.tamanioTablero; j++){
                CasilleroView casillero;
                Coordenada coordenada = new Coordenada(i, j);
                if (j < ViewProperties.tamanioTablero / 2) {
                    casillero = new CasilleroViewRojo(tablero, coordenada);
                }else {
                    casillero = new CasilleroViewAzul(tablero, coordenada);
                }
                this.add(casillero, i, j);
                this.casillerosView.put(coordenada, casillero);
            }
        }
    }

    public CasilleroView getCasilleroView(Coordenada coordenada){
        CasilleroView casilleroView = casillerosView.get(coordenada);
        return casilleroView;
    }

    public void cambiarSetOnMouseClickedAModoAtaque(IUnidadDeAtaque unidadDeAtaque) {
        casillerosView.forEach((coordenada, casilleroView) -> casilleroView.cambiarSetOnMouseClickedAModoAtaque(unidadDeAtaque));
    }

    public void cambiarSetOnMouseClickedAModoSeleccionDeUnidad(){
        casillerosView.forEach((coordenada, casilleroView) -> casilleroView.cambiarSetOnMouseClickedAModoSeleccionDeUnidad());
    }
}