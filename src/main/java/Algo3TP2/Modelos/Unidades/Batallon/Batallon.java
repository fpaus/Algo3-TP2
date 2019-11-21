package Algo3TP2.Modelos.Unidades.Batallon;

import Algo3TP2.Modelos.Tablero.Direccion.Direccion;
import Algo3TP2.Modelos.Unidades.Soldado;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Modelos.Unidades.UnidadMovible;

import java.util.ArrayList;

public class Batallon {

    ArrayList<Soldado> batallonIntegrantes = new ArrayList<Soldado>();
    protected BatallonEstado estado;

    public Batallon(){
        estado = new BatallonInactivo();
    }

    public Batallon(Soldado soldado) {
        batallonIntegrantes.add(soldado);
        this.estado = new BatallonInactivo();
    }

    public void anadirSoldadoABatallon(Soldado soldado) throws BatallonCompletoExcepcion {
        estado.anadirSoldadoABatallon(this, soldado);
    }

    public void moverBatallon(Direccion vertical, Direccion horizontal) throws BatallonIncompletoExcepcion {
        estado.moverBatallon(this, vertical, horizontal);
    }

    public void quitarSoldadoDeBatallon(Soldado soldado){
        estado.quitarSoldadoDelBatallon(this, soldado);
    }
/*
    public void moverBatallonHaciaArriba() throws BatallonIncompletoExcepcion {
        estado.moverBatallonHaciaArriba(this);
    }

    public void moverBatallonHaciaAbajo() throws BatallonIncompletoExcepcion {
        estado.moverBatallonHaciaAbajo(this);
    }

    public void moverBatallonHaciaLaDerecha() throws BatallonIncompletoExcepcion {
        estado.moverBatallonHaciaLaDerecha(this);
    }

    public void moverBatallonHaciaLaIzquierda() throws BatallonIncompletoExcepcion {
        estado.moverBatallonHaciaLaIzquierda(this);
    }

 */
}
