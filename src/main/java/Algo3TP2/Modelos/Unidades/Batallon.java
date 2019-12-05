package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Tablero.Direccion.Direccion;
import Algo3TP2.Modelos.Unidades.ExcepcionesBatallon.BatallonIncompletoExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesBatallon.BatallonNoFormadoException;

public abstract class Batallon {

    protected abstract void moverComoBatallon(Soldado soldado, Direccion vertical, Direccion horizontal)
            throws BatallonIncompletoExcepcion, BatallonNoFormadoException;

    public void verificarBatallonFormado() throws BatallonNoFormadoException {
    }

}
