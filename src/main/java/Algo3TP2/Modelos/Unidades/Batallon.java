package Algo3TP2.Modelos.Unidades;

import java.util.ArrayList;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Tablero.Direccion.Direccion;
import Algo3TP2.Modelos.Unidades.ExcepcionesBatallon.BatallonIncompletoExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesBatallon.BatallonNoFormadoException;

public abstract class Batallon {

    protected abstract void moverComoBatallon(Soldado soldado, Direccion vertical, Direccion horizontal)
            throws BatallonIncompletoExcepcion, BatallonNoFormadoException;

    public void verificarBatallonFormado() throws BatallonNoFormadoException {
    }

    protected ArrayList<Soldado> reunirBatallonConVecino(Soldado soldado, Casillero casilleroSoldado) {
        ArrayList<Soldado> soldadosParaBatallon = new ArrayList<Soldado>();
        ArrayList<Casillero> casillerosVecinos = casilleroSoldado.getTodosLosCasillerosVecinos();

        casillerosVecinos.forEach(casillero -> {
            try {
                Unidad unidad = casillero.getUnidad();
                if (unidad.getBando().equals(soldado.getBando())) {
                    if (unidad.getClass() == Soldado.class) {
                        if (!soldadosParaBatallon.contains((Soldado) unidad)) {
                            soldadosParaBatallon.add((Soldado) unidad);
                        }
                    }
                }
            } catch (CasilleroVacioExcepcion ex) {
            }
        });

        return soldadosParaBatallon;
    }

	public void verificarSiSePuedeFormarBatallon(Soldado soldado) throws BatallonIncompletoExcepcion{
	}

}
