package Algo3TP2.Modelos;
import Algo3TP2.ExcepcionesCasillero.*;

public class CasilleroOcupado implements CasilleroEstado {

    private Unidad unidadEnCasillero;

    public CasilleroOcupado(Unidad unidad) {
        this.unidadEnCasillero = unidad;
    }

    @Override
    public void setUnidad(Casillero casillero, Unidad unidad) throws CasilleroOcupadoExcepcion {
        throw new CasilleroOcupadoExcepcion();
    }

    @Override
    public Unidad getUnidad() throws CasilleroVacioExcepcion {
        return this.unidadEnCasillero;
    }

    @Override
    public void quitarUnidad(Casillero casillero) {
        CasilleroEstado estado = new CasilleroVacio();
        casillero.setEstado(estado);
    }
}
