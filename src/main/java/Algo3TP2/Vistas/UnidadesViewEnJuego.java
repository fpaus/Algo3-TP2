package Algo3TP2.Vistas;

import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Vistas.UnidadesView.UnidadView;

import java.util.HashMap;

public class UnidadesViewEnJuego {

    private static UnidadesViewEnJuego unidadesViewsEnJuego;
    private HashMap<Unidad, UnidadView> unidadesViews;

    private UnidadesViewEnJuego(){
        this.unidadesViews = new HashMap<Unidad, UnidadView>();
    }

    public static UnidadesViewEnJuego getUnidadesViewEnJuego(){
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
}
