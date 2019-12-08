package Algo3TP2.Vistas.JuegoView;

import Algo3TP2.Modelos.Juego;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Vistas.CasilleroView.CasilleroView;

import java.util.HashMap;

public interface JuegoViewEstado {

    void cambiarAModoSeleccionDeUnidad(HashMap<Coordenada, CasilleroView> casillerosView, Juego juego);
}
