
package Algo3TP2.Vistas.CasilleroView;

import Algo3TP2.Controladores.ClickCasilleroHandler;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.ObservadorCasillero;
import Algo3TP2.ViewProperties;
import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Vistas.JuegoView;
import Algo3TP2.Vistas.PanelDeControlUnidadView.PanelDeControlUnidadMovibleView;
import Algo3TP2.Vistas.PanelDeControlUnidadView.PanelDeControlView;
import Algo3TP2.Vistas.UnidadesView.UnidadView;
import Algo3TP2.Vistas.UnidadesViewEnJuego;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;


public class CasilleroView extends Pane implements ObservadorCasillero {

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
        this.setMinWidth(this.anchoDelCasillero);
        this.setMinHeight(this.largoDelCasillero);

        this.setOnMouseClicked(new ClickCasilleroHandler(this.casillero));
    }

    protected void setEstado(CasilleroViewEstado estado){
        this.estado = estado;
    }

    @Override
    public void actualizar(Unidad unidad) {
        UnidadesViewEnJuego unidadesViewEnJuego = UnidadesViewEnJuego.getUnidadesViewEnJuego();
        UnidadView unidadView = unidadesViewEnJuego.getUnidadView(unidad);
        this.estado.actualizar(unidadView);
    }
}