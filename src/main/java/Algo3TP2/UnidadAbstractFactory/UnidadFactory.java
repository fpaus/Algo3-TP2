package Algo3TP2.UnidadAbstractFactory;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Juego;
import Algo3TP2.Modelos.Jugador.ExcepcionesJugador.UnidadInvalidaException;
import Algo3TP2.Modelos.Unidades.Unidad;

public interface UnidadFactory {

    Unidad getUnidad(String unidadTipo, Bando bando, Juego juego) throws UnidadInvalidaException;
}
