package Algo3TP2.Modelos.Unidades.Batallon;

import Algo3TP2.Modelos.Tablero.Direccion.Direccion;
import Algo3TP2.Modelos.Unidades.Soldado;

public interface BatallonEstado{

    void anadirSoldadoABatallon(Batallon batallon, Soldado soldado) throws BatallonCompletoExcepcion;

    void moverBatallon(Batallon batallon, Direccion vertical, Direccion horizontal) throws BatallonIncompletoExcepcion;

    void desintegrar(Batallon batallon) throws BatallonIncompletoExcepcion;
}
