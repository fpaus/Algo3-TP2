package Algo3TP2.Vistas.JuegoView;

import Algo3TP2.Modelos.Juego;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Vistas.CasilleroView.CasilleroView;

import java.util.HashMap;

public class JuegoViewEstadoFaseBatalla implements JuegoViewEstado {

    @Override
    public void cambiarAModoSeleccionDeUnidad(HashMap<Coordenada, CasilleroView> casillerosView, Juego juego) {
        casillerosView.forEach((coordenada, casilleroView) -> casilleroView.cambiarSetOnMouseClickedAModoSeleccionDeUnidad(juego));
    }
}
