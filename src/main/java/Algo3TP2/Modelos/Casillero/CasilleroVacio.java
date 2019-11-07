package Algo3TP2.Modelos.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.*;
import Algo3TP2.Modelos.Unidades.Unidad;

public class CasilleroVacio implements CasilleroEstado {

    public CasilleroVacio() {
    }

    @Override
    public void setUnidad(Casillero casillero, Unidad unidad) {
        CasilleroEstado estado = new CasilleroOcupado(unidad);
        casillero.setEstado(estado);
    }

    @Override
    public Unidad getUnidad() throws CasilleroVacioExcepcion {
        throw new CasilleroVacioExcepcion();
    }

    @Override
    public void quitarUnidad(Casillero casillero) throws CasilleroVacioExcepcion {
        throw new CasilleroVacioExcepcion();
    }
}