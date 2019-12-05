
package Algo3TP2.Vistas;

import Algo3TP2.Modelos.Juego;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Unidades.IUnidadDeAtaque;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.ViewProperties;
import Algo3TP2.Vistas.CasilleroView.CasilleroView;
import Algo3TP2.Vistas.CasilleroView.CasilleroViewAzul;
import Algo3TP2.Vistas.CasilleroView.CasilleroViewRojo;
import Algo3TP2.Vistas.UnidadesView.UnidadView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.ImageCursor;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.HashMap;

public class TableroView extends GridPane {

    HashMap<Coordenada, CasilleroView> casillerosView;
    private Juego juego;
    private JuegoViewEstado estado;

    public TableroView(Juego juego) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {

        this.juego = juego;
        this.estado = new JuegoViewEstadoFaseSetUnidades();

        this.setAlignment(Pos.CENTER);
        Image imagen = new Image("file:src/resources/Fondos/mapa_tablero.png");
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
        this.estado.cambiarAModoSeleccionDeUnidad(this.casillerosView, this.juego);
        this.setCursor(new ImageCursor(new Image("file:src/resources/Punteros/cursor.png")));
    }

    public void cambiarAModoRealizarAtaque(IUnidadDeAtaque unidadDeAtaque) {
        casillerosView.forEach((coordenada, casilleroView) -> casilleroView.cambiarSetOnMouseClickedAModoAtaque(unidadDeAtaque, this.juego));
        this.setCursor(new ImageCursor(new Image("file:src/resources/Punteros/cursor_ataque.png")));
    }

    public void cambiarAModoSetearUnidad(Unidad unidad, UnidadView unidadImage) {
        casillerosView.forEach((coordenada, casilleroView) -> casilleroView.cambiarAModoSetearUnidad(unidad));
        ImageCursor imageCursor = new ImageCursor(unidadImage.getImage(), ViewProperties.anchoDelCasillero/2, ViewProperties.largoDelCasillero/2);
        this.setCursor(imageCursor);
    }

    public void setEstadoModoBatalla(){
        this.estado = new JuegoViewEstadoFaseBatalla();
        this.cambiarAModoSeleccionDeUnidad();
    }
}