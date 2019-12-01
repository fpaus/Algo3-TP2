package Algo3TP2.Vistas.CasilleroView;

import Algo3TP2.Vistas.UnidadesView.UnidadView;

public class CasilleroViewOcupado implements CasilleroViewEstado {

    private UnidadView unidadViewEnCasillero;
    private CasilleroView casilleroView;

    public CasilleroViewOcupado(CasilleroView casilleroView ,UnidadView unidadViewEnCasillero){
        this.casilleroView = casilleroView;
        this.unidadViewEnCasillero = unidadViewEnCasillero;
    }

    @Override
    public void actualizar(UnidadView unidadView) {
        this.quitarUnidadView();
    }

    @Override
    public void setUnidadView(UnidadView unidadView) {
        // Que hacemo
    }

    @Override
    public void quitarUnidadView() {
        this.casilleroView.getChildren().remove(this.unidadViewEnCasillero);
        this.casilleroView.setEstado(new CasilleroViewVacio(this.casilleroView));
    }
}
