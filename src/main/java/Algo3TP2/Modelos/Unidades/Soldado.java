package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Tablero.Direccion.*;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.UnidadInvalidaException;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.AtaqueDeSoldado;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.EstrategiaDeAtaque;

import java.util.ArrayList;

import Algo3TP2.Properties;

public class Soldado extends UnidadMovible implements IUnidadDeAtaque {

    private EstrategiaDeAtaque estrategiaDeAtaque;
    private Batallon batallonMovimiento;

    public Soldado(Bando bando) {
        this.costo = Properties.costoSoldado;
        this.vida = new Salud(Properties.vidaSoldado);
        this.estrategiaDeAtaque = new AtaqueDeSoldado();
        this.duenio = bando;
        this.batallonMovimiento = new Batallon();
    }

    @Override
    public void atacar(Unidad unidadVictima)
            throws UnidadAtacadaEsAliadaExcepcion, DistanciaDeAtaqueIncorrectaExcepcion, UnidadInvalidaException {
        estrategiaDeAtaque.atacar(this, unidadVictima);
    }

    protected ArrayList<Soldado> reunirBatallonConVecino(){
        return batallonMovimiento.reunirBatallonConVecino(this, this.casillero);
    }

    public void moverComomBatallonHaciaArriba() throws BatallonIncompletoExcepcion {
        this.batallonMovimiento.moverComoBatallon(this , new Fija(), new Arriba());
    }

    public void moverComoBatallonHaciaAbajo() throws BatallonIncompletoExcepcion {
        this.batallonMovimiento.moverComoBatallon(this, new Fija(), new Abajo());
    }

    public void moverComoBatallonHaciaLaDerecha() throws BatallonIncompletoExcepcion {
        this.batallonMovimiento.moverComoBatallon(this, new Derecha(), new Fija());
    }

    public void moverComoBatallonHaciaLaIzquierda() throws BatallonIncompletoExcepcion {
        this.batallonMovimiento.moverComoBatallon(this, new Izquierda(), new Fija());
    }

    public void moverComoBatallonHaciaLaIzquierdaAbajo() throws BatallonIncompletoExcepcion {
        this.batallonMovimiento.moverComoBatallon(this, new Izquierda(), new Abajo());
    }

    public void moverComoBatallonHaciaLaIzquierdaArriba() throws BatallonIncompletoExcepcion {
        this.batallonMovimiento.moverComoBatallon(this, new Izquierda(), new Arriba());
    }

    public void moverComoBatallonHaciaLaDerechaAbajo() throws BatallonIncompletoExcepcion {
        this.batallonMovimiento.moverComoBatallon(this, new Derecha(), new Abajo());
    }

    public void moverComoBatallonHaciaLaDerechaArriba() throws BatallonIncompletoExcepcion {
        this.batallonMovimiento.moverComoBatallon(this, new Derecha(), new Arriba());
    }
}
