package Algo3TP2.Vistas.CasilleroView;

import Algo3TP2.Vistas.UnidadesView.UnidadView;

public interface CasilleroViewEstado {
    void actualizar(UnidadView unidadView);

    void setUnidadView(UnidadView unidadView);

    void quitarUnidadView();
}
