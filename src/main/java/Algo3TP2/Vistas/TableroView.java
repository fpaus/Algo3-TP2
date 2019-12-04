
package Algo3TP2.Vistas;

import Algo3TP2.Modelos.Juego;
import Algo3TP2.Modelos.Unidades.IUnidadDeAtaque;
import Algo3TP2.Modelos.Unidades.Soldado;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.ViewProperties;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Vistas.CasilleroView.CasilleroView;
import Algo3TP2.Vistas.CasilleroView.CasilleroViewAzul;
import Algo3TP2.Vistas.CasilleroView.CasilleroViewRojo;
import Algo3TP2.Vistas.UnidadesView.UnidadView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.HashMap;

public class TableroView extends GridPane {

    HashMap<Coordenada, CasilleroView> casillerosView;
    private Juego juego;

    public TableroView(Juego juego) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {

        this.juego = juego;

        this.setAlignment(Pos.CENTER);
        Image imagen = new Image("file:src/resources/Fondos/Mapa_1.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(650,650, false, false, false, false));
        this.setBackground(new Background(imagenDeFondo));
        this.setPadding(new Insets(20, 20, 20, 20));

        Tablero tablero = juego.getTablero();
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
        this.cambiarAModoSeleccionDeUnidad();
    }

    public void cambiarAModoSeleccionDeUnidad(){
        casillerosView.forEach((coordenada, casilleroView) -> casilleroView.cambiarSetOnMouseClickedAModoSeleccionDeUnidad(this.juego));
        this.setCursor(Cursor.DEFAULT);
    }

    public void cambiarAModoRealizarAtaque(IUnidadDeAtaque unidadDeAtaque, Image armaImageCursor) {
        casillerosView.forEach((coordenada, casilleroView) -> casilleroView.cambiarSetOnMouseClickedAModoAtaque(unidadDeAtaque, this.juego));
        this.setCursor(new ImageCursor(armaImageCursor));
    }

    public void cambiarAModoSetearUnidad(Unidad unidad, UnidadView unidadImage) {
        casillerosView.forEach((coordenada, casilleroView) -> casilleroView.cambiarAModoSetearUnidad(unidad));
        this.setCursor(new ImageCursor(unidadImage.getImage()));
    }
}