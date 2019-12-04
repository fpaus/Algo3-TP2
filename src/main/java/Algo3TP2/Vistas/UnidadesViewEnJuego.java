package Algo3TP2.Vistas;

import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Vistas.UnidadesView.UnidadView;

import java.util.HashMap;

public class UnidadesViewEnJuego {

    private static UnidadesViewEnJuego unidadesViewsEnJuego;
    private HashMap<Unidad, UnidadView> unidadesViews;
    private HashMap<Unidad, PanelDeControlView> unidadPanelDeControlView;

    private UnidadesViewEnJuego(){
        this.unidadesViews = new HashMap<Unidad, UnidadView>();
        this.unidadPanelDeControlView = new HashMap<Unidad, PanelDeControlView>();
    }

    public static UnidadesViewEnJuego getUnidadView(){
        if (unidadesViewsEnJuego == null){
            unidadesViewsEnJuego = new UnidadesViewEnJuego();
        }
        return unidadesViewsEnJuego;
    }


    public UnidadView getUnidadView(Unidad unidad){
        return this.unidadesViews.get(unidad);
    }

    public void setUnidadView(Unidad unidad, UnidadView unidadView){
        this.unidadesViews.put(unidad, unidadView);
    }

    public void setUnidadPanelDeControlView(Unidad unidad, PanelDeControlView panelDeControlView){
        this.unidadPanelDeControlView.put(unidad, panelDeControlView);
    }

    public PanelDeControlView getUnidadPanelDeControlView(Unidad unidad){
        return this.unidadPanelDeControlView.get(unidad);
    }
}
