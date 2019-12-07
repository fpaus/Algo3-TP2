package Algo3TP2.Modelos.Casillero;

import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Controladores.Observers.ObservadorCasillero;

import java.util.ArrayList;

public interface CasilleroEstado {
    public void setUnidad(Casillero casillero, Unidad unidad) throws CasilleroOcupadoExcepcion;

    public Unidad getUnidad() throws CasilleroVacioExcepcion;

    public void quitarUnidad(Casillero casillero) throws CasilleroVacioExcepcion;

    void notificarObservadores(ArrayList<ObservadorCasillero> observadores);
}

