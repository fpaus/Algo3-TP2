package Algo3TP2.Modelos.Unidades.Batallon;

import Algo3TP2.Modelos.Tablero.Direccion.Direccion;
import Algo3TP2.Modelos.Unidades.Soldado;

public class BatallonInactivo implements BatallonEstado {

    @Override
    public void anadirSoldadoABatallon(Batallon batallon, Soldado soldado) {
        batallon.batallonIntegrantes.add(soldado);
        soldado.incorporarABatallon(batallon);
        if (batallon.batallonIntegrantes.size() == 3) {
            batallon.estado = new BatallonActivo();
        }
    }

    @Override
    public void quitarSoldadoDelBatallon(Batallon batallon, Soldado soldado) {
        // Try?
        batallon.batallonIntegrantes.remove(soldado);
        soldado.quitarDeBatallon();
    }

    @Override
    public void moverBatallon(Batallon batallon, Direccion horizontal, Direccion vertical) throws BatallonIncompletoExcepcion {
        throw new BatallonIncompletoExcepcion();
    }
}