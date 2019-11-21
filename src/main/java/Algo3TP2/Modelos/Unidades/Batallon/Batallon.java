package Algo3TP2.Modelos.Unidades.Batallon;

import Algo3TP2.Modelos.Tablero.Direccion.*;
import Algo3TP2.Modelos.Unidades.Soldado;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Modelos.Unidades.UnidadMovible;

import java.util.ArrayList;

public class Batallon {

    ArrayList<Soldado> batallonIntegrantes = new ArrayList<Soldado>();
    protected BatallonEstado estado;

    public Batallon(Soldado soldado) {
        this.estado = new BatallonInactivo();
        batallonIntegrantes.add(soldado);
    }

    public void anadirSoldadoABatallon(Soldado soldado) throws BatallonCompletoExcepcion {
        estado.anadirSoldadoABatallon(this, soldado);
    }

    public void desintegrar() throws BatallonIncompletoExcepcion {
        estado.desintegrar(this);
    }

    public void moverBatallon(Direccion vertical, Direccion horizontal) throws BatallonIncompletoExcepcion {
        estado.moverBatallon(this, vertical, horizontal);
    }

}
