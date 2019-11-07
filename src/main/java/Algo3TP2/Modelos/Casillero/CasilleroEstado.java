package Algo3TP2.Modelos.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.*;
import Algo3TP2.Modelos.Unidades.Unidad;

public interface CasilleroEstado {
    public void setUnidad(Casillero casillero, Unidad unidad) throws CasilleroOcupadoExcepcion;

    public Unidad getUnidad() throws CasilleroVacioExcepcion;

    public void quitarUnidad(Casillero casillero) throws CasilleroVacioExcepcion;
}

