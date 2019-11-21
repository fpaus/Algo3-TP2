package Algo3TP2.Modelos.Unidades.Batallon;

import Algo3TP2.Modelos.Tablero.Direccion.Direccion;
import Algo3TP2.Modelos.Unidades.Soldado;

public interface BatallonEstado{

    void anadirSoldadoABatallon(Batallon batallon, Soldado soldado) throws BatallonCompletoExcepcion;

    void quitarSoldadoDelBatallon(Batallon batallon, Soldado soldado);

    void moverBatallon(Batallon batallon, Direccion vertical, Direccion horizontal) throws BatallonIncompletoExcepcion;

}
