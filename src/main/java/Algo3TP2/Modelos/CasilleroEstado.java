package Algo3TP2.Modelos;
import Algo3TP2.ExcepcionesCasillero.*;

public interface CasilleroEstado {
    public void setUnidad(Casillero casillero, Unidad unidad) throws CasilleroOcupadoExcepcion;

    public Unidad getUnidad() throws CasilleroVacioExcepcion;

    public void quitarUnidad(Casillero casillero) throws CasilleroVacioExcepcion;
}

