package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Tablero.Direccion.*;
import Algo3TP2.Modelos.Unidades.Batallon.Batallon;
import Algo3TP2.Modelos.Unidades.Batallon.BatallonCompletoExcepcion;
import Algo3TP2.Modelos.Unidades.Batallon.BatallonInactivo;
import Algo3TP2.Modelos.Unidades.Batallon.BatallonIncompletoExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.UnidadInvalidaException;
import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
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
        this.batallon = new Batallon(this);
    }

    @Override
    public void atacar(Unidad unidadVictima)
            throws UnidadAtacadaEsAliadaExcepcion, DistanciaDeAtaqueIncorrectaExcepcion, UnidadInvalidaException {
        estrategiaDeAtaque.atacar(this, unidadVictima);
    }

    public void incorporarABatallon(Batallon batallon) {
        this.batallon = batallon;
    }

    public void conformarBatallonCon(Soldado soldado1, Soldado soldado2) throws BatallonCompletoExcepcion {
        batallon.anadirSoldadoABatallon(soldado1);
        batallon.anadirSoldadoABatallon(soldado2);
    }

    public void moverBatallon(Direccion vertical, Direccion horizontal) throws BatallonIncompletoExcepcion {
        batallon.moverBatallon(vertical, horizontal);
    }

    public void desintegrarBatallon() throws BatallonIncompletoExcepcion {
        batallon.desintegrar();
    }

    public void setBatallon(Batallon batallon) {
        this.batallon = batallon;
    }

    public void moverBatallonHaciaArriba() throws BatallonIncompletoExcepcion {
        this.batallon.moverBatallon(new Fija(), new Arriba());
    }

    public void moverBatallonHaciaAbajo() throws BatallonIncompletoExcepcion {
        this.batallon.moverBatallon(new Fija(), new Abajo());
    }

    public void moverBatallonHaciaLaDerecha() throws BatallonIncompletoExcepcion {
        this.batallon.moverBatallon(new Derecha(), new Fija());
    }

    public void moverBatallonHaciaLaIzquierda() throws BatallonIncompletoExcepcion {
        this.batallon.moverBatallon(new Izquierda(), new Fija());
    }

    public void moverBatallonHaciaLaIzquierdaAbajo() throws BatallonIncompletoExcepcion {
        this.batallon.moverBatallon(new Izquierda(), new Abajo());
    }

    public void moverBatallonHaciaLaIzquierdaArriba() throws BatallonIncompletoExcepcion {
        this.batallon.moverBatallon(new Izquierda(), new Arriba());
    }

    public void moverBatallonHaciaLaDerechaAbajo() throws BatallonIncompletoExcepcion {
        this.batallon.moverBatallon(new Derecha(), new Abajo());
    }

    public void moverBatallonHaciaLaDerechaArriba() throws BatallonIncompletoExcepcion {
        this.batallon.moverBatallon(new Derecha(), new Arriba());
    }
}
