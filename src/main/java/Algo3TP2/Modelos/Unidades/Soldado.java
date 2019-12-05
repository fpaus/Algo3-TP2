package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Observable;
import Algo3TP2.Observador;
import Algo3TP2.Properties;
import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Jugador.ExcepcionesJugador.UnidadInvalidaException;
import Algo3TP2.Modelos.Tablero.Direccion.Abajo;
import Algo3TP2.Modelos.Tablero.Direccion.Arriba;
import Algo3TP2.Modelos.Tablero.Direccion.Derecha;
import Algo3TP2.Modelos.Tablero.Direccion.Direccion;
import Algo3TP2.Modelos.Tablero.Direccion.Fija;
import Algo3TP2.Modelos.Tablero.Direccion.Izquierda;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.AtaqueDeSoldado;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.EstrategiaDeAtaque;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesBatallon.BatallonIncompletoExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesBatallon.BatallonNoFormadoException;

import java.util.ArrayList;

public class Soldado extends UnidadMovible implements IUnidadDeAtaque, Observable {

    private EstrategiaDeAtaque estrategiaDeAtaque;
    private Batallon batallonMovimiento;
    private ArrayList<Observador> observadoresBatallon;

    public Soldado(Bando bando) {
        this.costo = Properties.costoSoldado;
        this.vida = new Salud(Properties.vidaSoldado);
        this.estrategiaDeAtaque = new AtaqueDeSoldado();
        this.bando = bando;
        this.batallonMovimiento = new BatallonDisuelto();
        this.observadoresBatallon = new ArrayList<Observador>();
    }

    @Override
    public void atacar(Unidad unidadVictima)
            throws UnidadAtacadaEsAliadaExcepcion, DistanciaDeAtaqueIncorrectaExcepcion, UnidadInvalidaException {
        estrategiaDeAtaque.atacar(this, unidadVictima);
    }

    // protected ArrayList<Soldado> reunirBatallonConVecino() {
    // return batallonMovimiento.reunirBatallonConVecino(this, this.casillero);
    // }

    public void moverComoBatallonHaciaArriba() throws BatallonIncompletoExcepcion, BatallonNoFormadoException {
        this.batallonMovimiento.moverComoBatallon(this, new Fija(), new Arriba());
    }

    public void moverComoBatallonHaciaAbajo() throws BatallonIncompletoExcepcion, BatallonNoFormadoException {
        this.batallonMovimiento.moverComoBatallon(this, new Fija(), new Abajo());
    }

    public void moverComoBatallonHaciaLaDerecha() throws BatallonIncompletoExcepcion, BatallonNoFormadoException {
        this.batallonMovimiento.moverComoBatallon(this, new Derecha(), new Fija());
    }

    public void moverComoBatallonHaciaLaIzquierda() throws BatallonIncompletoExcepcion, BatallonNoFormadoException {
        this.batallonMovimiento.moverComoBatallon(this, new Izquierda(), new Fija());
    }

    public void moverComoBatallonHaciaLaIzquierdaAbajo()
            throws BatallonIncompletoExcepcion, BatallonNoFormadoException {
        this.batallonMovimiento.moverComoBatallon(this, new Izquierda(), new Abajo());
    }

    public void moverComoBatallonHaciaLaIzquierdaArriba()
            throws BatallonIncompletoExcepcion, BatallonNoFormadoException {
        this.batallonMovimiento.moverComoBatallon(this, new Izquierda(), new Arriba());
    }

    public void moverComoBatallonHaciaLaDerechaAbajo() throws BatallonIncompletoExcepcion, BatallonNoFormadoException {
        this.batallonMovimiento.moverComoBatallon(this, new Derecha(), new Abajo());
    }

    public void moverComoBatallonHaciaLaDerechaArriba() throws BatallonIncompletoExcepcion, BatallonNoFormadoException {
        this.batallonMovimiento.moverComoBatallon(this, new Derecha(), new Arriba());
    }

    public void formarBatallon() {
        this.batallonMovimiento = new BatallonFormado();
        this.notificarObservadores();
    }

    public void disolverBatallon() {
        this.batallonMovimiento = new BatallonDisuelto();
        this.notificarObservadores();
    }

    public void verificarBatallonFormado() throws BatallonNoFormadoException {
        this.batallonMovimiento.verificarBatallonFormado();
    }

    @Override
    public void moverHaciaArriba() throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion, BatallonIncompletoExcepcion {
        try {
            this.moverComoBatallonHaciaArriba();
        } catch (BatallonNoFormadoException e) {
            super.moverHaciaArriba();
        }
        this.disolverBatallon();
    }

    @Override
    public void moverHaciaAbajo() throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion, BatallonIncompletoExcepcion {
        try {
            this.moverComoBatallonHaciaAbajo();
        } catch (BatallonNoFormadoException e) {
            super.moverHaciaAbajo();
        }
        this.disolverBatallon();
    }

    @Override
    public void moverHaciaLaDerecha() throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion, BatallonIncompletoExcepcion {
        try {
            this.moverComoBatallonHaciaLaDerecha();
        } catch (BatallonNoFormadoException e) {
            super.moverHaciaLaDerecha();
        }
        this.disolverBatallon();
    }

    @Override
    public void moverHaciaLaIzquierda()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion, BatallonIncompletoExcepcion {
        try {
            this.moverComoBatallonHaciaLaIzquierda();
        } catch (BatallonNoFormadoException e) {
            super.moverHaciaLaIzquierda();
        }
        this.disolverBatallon();
    }

    @Override
    public void moverHaciaLaDerechaArriba()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion, BatallonIncompletoExcepcion {
        try {
            this.moverComoBatallonHaciaLaDerechaArriba();
        } catch (BatallonNoFormadoException e) {
            super.moverHaciaLaDerechaArriba();
        }
        this.disolverBatallon();
    }

    @Override
    public void moverHaciaLaDerechaAbajo()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion, BatallonIncompletoExcepcion {
        try {
            this.moverComoBatallonHaciaLaDerechaAbajo();
        } catch (BatallonNoFormadoException e) {
            super.moverHaciaLaDerechaAbajo();
        }
        this.disolverBatallon();
    }

    @Override
    public void moverHaciaLaIzquierdaArriba()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion, BatallonIncompletoExcepcion {
        try {
            this.moverComoBatallonHaciaLaIzquierdaArriba();
        } catch (BatallonNoFormadoException e) {
            super.moverHaciaLaIzquierdaArriba();
        }
        this.disolverBatallon();
    }

    @Override
    public void moverHaciaLaIzquierdaAbajo()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion, BatallonIncompletoExcepcion {
        try {
            this.moverComoBatallonHaciaLaIzquierdaAbajo();
        } catch (BatallonNoFormadoException e) {
            super.moverHaciaLaIzquierdaAbajo();
        }
        this.disolverBatallon();
    }

    @Override
    public void moverEnDireccion(Direccion horizontal, Direccion vertical)
            throws CasilleroOcupadoExcepcion, CasilleroFueraDelLosLimitesDelTableroExcepcion, BatallonIncompletoExcepcion {
        try {
            this.batallonMovimiento.moverComoBatallon(this, horizontal, vertical);
        } catch (BatallonNoFormadoException e) {
            super.moverEnDireccion(horizontal, vertical);
        }
        this.disolverBatallon();
    }

    public void enlazarobservadorBatallon(Observador observador){
        this.observadoresBatallon.add(observador);
    }

    @Override
    public void notificarObservadores() {
        this.observadoresBatallon.forEach(observador -> observador.actualizar());
    }
}