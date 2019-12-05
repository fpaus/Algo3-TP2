package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Tablero.Direccion.Direccion;
import Algo3TP2.Modelos.Unidades.ExcepcionesBatallon.BatallonIncompletoExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesBatallon.BatallonNoFormadoException;

public class BatallonDisuelto extends Batallon {
    @Override
    protected void moverComoBatallon(Soldado soldado, Direccion vertical, Direccion horizontal)
            throws BatallonIncompletoExcepcion, BatallonNoFormadoException {
        throw new BatallonNoFormadoException();
    }

    @Override
    public void verificarBatallonFormado() throws BatallonNoFormadoException {
        throw new BatallonNoFormadoException();
    }

}
