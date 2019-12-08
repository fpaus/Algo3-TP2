package Algo3TP2.Vistas.CasilleroView;

import Algo3TP2.Vistas.UnidadesView.UnidadView;

public class CasilleroViewVacio implements CasilleroViewEstado {

    private CasilleroView casilleroView;

    public CasilleroViewVacio(CasilleroView casilleroView){
        this.casilleroView = casilleroView;
    }

    @Override
    public void actualizar(UnidadView unidadView) {
        this.setUnidadView(unidadView);
    }

    @Override
    public void setUnidadView(UnidadView unidadView) {
        this.casilleroView.getChildren().add(unidadView);
        this.casilleroView.setEstado(new CasilleroViewOcupado(this.casilleroView, unidadView));
    }

    @Override
    public void quitarUnidadView() {
        // Ahora vemo que hacemo
    }
}
