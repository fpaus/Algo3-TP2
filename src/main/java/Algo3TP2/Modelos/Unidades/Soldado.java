package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Unidades.Batallon.Batallon;
import Algo3TP2.Modelos.Unidades.Batallon.BatallonInactivo;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.UnidadInvalidaException;
import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Tablero.Direccion.Arriba;
import Algo3TP2.Modelos.Tablero.Direccion.Direccion;
import Algo3TP2.Modelos.Tablero.Direccion.Fija;
import Algo3TP2.Modelos.Tablero.Direccion.Horizontal;
import Algo3TP2.Modelos.Tablero.Direccion.Vertical;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.AtaqueDeSoldado;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.EstrategiaDeAtaque;

import java.util.ArrayList;

import Algo3TP2.Properties;

public class Soldado extends UnidadMovible implements IUnidadDeAtaque {

    private EstrategiaDeAtaque estrategiaDeAtaque;
    private Batallon batallon;

    public Soldado(Bando bando) {
        this.costo = Properties.costoSoldado;
        this.vida = new Salud(Properties.vidaSoldado);
        this.estrategiaDeAtaque = new AtaqueDeSoldado();
        this.duenio = bando;
    }

    @Override
    public void atacar(Unidad unidadVictima)
            throws UnidadAtacadaEsAliadaExcepcion, DistanciaDeAtaqueIncorrectaExcepcion, UnidadInvalidaException {
        estrategiaDeAtaque.atacar(this, unidadVictima);
    }

    public void incorporarABatallon(Batallon batallon){
        this.batallon = batallon;
    }

    public void quitarDeBatallon(){
        this.batallon = new Batallon(this);
    }
    /*
    public void moverComoBatallon(Direccion horizontal, Direccion vertical){
        ArrayList<Casillero> casilleros = this.casillero.getTodosLosCasillerosVecinos();
        casilleros.forEach((c) -> buscarOtrosSoldados(c));
    }

    public void moverComoBatallon(Horizontal horizontal){
        moverComoBatallon(horizontal, new Fija());
    }

	public void moverComoBatallon(Vertical vertical) {
        moverComoBatallon(new Fija(), vertical);
	}

    private void buscarOtrosSoldados(Casillero casillero){
        try {
            casillero.getUnidad();
        } catch (CasilleroVacioExcepcion e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

     */

}   
