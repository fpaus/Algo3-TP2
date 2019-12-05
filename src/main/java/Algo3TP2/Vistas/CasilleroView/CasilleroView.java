
package Algo3TP2.Vistas.CasilleroView;

import Algo3TP2.Controladores.ClickAtaqueCasilleroHandler;
import Algo3TP2.Controladores.ClickCasilleroSeleccionarHandler;
import Algo3TP2.Controladores.ClickColocarUnidadEnCasilleroHandler;
import Algo3TP2.Modelos.Juego;
import Algo3TP2.Modelos.Unidades.IUnidadDeAtaque;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Observers.ObservadorCasillero;
import Algo3TP2.ViewProperties;
import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Vistas.UnidadesView.UnidadView;
import Algo3TP2.Vistas.UnidadesViewEnJuego;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;


public class CasilleroView extends StackPane implements ObservadorCasillero {

    private int largoDelCasillero;
    private int anchoDelCasillero;
    private Casillero casillero;
    private CasilleroViewEstado estado;

    public CasilleroView(Tablero tablero, Coordenada coordenada) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {
        this.estado = new CasilleroViewVacio(this);
        this.largoDelCasillero = ViewProperties.largoDelCasillero;
        this.anchoDelCasillero = ViewProperties.anchoDelCasillero;
        this.casillero = tablero.getCasilleroEnCoordenada(coordenada);
        this.casillero.enlazarObservador(this);

        this.setAlignment(Pos.CENTER);
        this.setPrefSize(this.largoDelCasillero, this.anchoDelCasillero); // Para que los casilleros vacíos tengan tamaño mínimo.
        this.setMaxSize(this.largoDelCasillero, this.anchoDelCasillero); // Para que no se agranden.
    }

    protected void setEstado(CasilleroViewEstado estado){
        this.estado = estado;
    }

    @Override
    public void actualizar(Unidad unidad) {
        UnidadesViewEnJuego unidadesViewEnJuego = UnidadesViewEnJuego.getUnidadView();
        UnidadView unidadView = unidadesViewEnJuego.getUnidadView(unidad);
        this.estado.actualizar(unidadView);
    }

    public void cambiarSetOnMouseClickedAModoAtaque(IUnidadDeAtaque unidadAtacante, Juego juego){
        this.setOnMouseClicked(new ClickAtaqueCasilleroHandler(unidadAtacante, this.casillero, juego));
    }

    public void cambiarSetOnMouseClickedAModoSeleccionDeUnidad(Juego juego){
        this.setOnMouseClicked(new ClickCasilleroSeleccionarHandler(this.casillero, juego));
    }

    public void cambiarSetOnMouseClickedAaccionPasiva(){
        this.setOnMouseClicked(null);
    }

    public void cambiarAModoSetearUnidad(Unidad unidad) {
        this.setOnMouseClicked(new ClickColocarUnidadEnCasilleroHandler(this.casillero, unidad, casillero.getBando()));
    }
}