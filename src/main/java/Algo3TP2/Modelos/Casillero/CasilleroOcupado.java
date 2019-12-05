package Algo3TP2.Modelos.Casillero;

import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Observers.ObservadorCasillero;

import java.util.ArrayList;

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
    public Unidad getUnidad() {
        return this.unidadEnCasillero;
    }

    @Override
    public void quitarUnidad(Casillero casillero) {
        CasilleroEstado estado = new CasilleroVacio();
        casillero.setEstado(estado);
    }

    @Override
    public void notificarObservadores(ArrayList<ObservadorCasillero> observadores) {
        observadores.forEach(observador -> observador.actualizar(this.unidadEnCasillero));
    }
}
