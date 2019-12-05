package Algo3TP2.Modelos.Unidades;

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

public class Soldado extends UnidadMovible implements IUnidadDeAtaque {

    private EstrategiaDeAtaque estrategiaDeAtaque;
    private Batallon batallonMovimiento;

    public Soldado(Bando bando) {
        this.costo = Properties.costoSoldado;
        this.vida = new Salud(Properties.vidaSoldado);
        this.estrategiaDeAtaque = new AtaqueDeSoldado();
        this.bando = bando;
        this.batallonMovimiento = new BatallonDisuelto();
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
    }

    public void disolverBatallon() {
        this.batallonMovimiento = new BatallonDisuelto();
    }

    public void verificarBatallonFormado() throws BatallonNoFormadoException {
        this.batallonMovimiento.verificarBatallonFormado();
    }

    @Override
    public void moverHaciaArriba() throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion {
        try {
            this.moverComoBatallonHaciaArriba();
        } catch (BatallonNoFormadoException e) {
            super.moverHaciaArriba();
        } catch (BatallonIncompletoExcepcion e) {
            // magia?
        }
        this.disolverBatallon();
    }

    @Override
    public void moverHaciaAbajo() throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion {
        try {
            this.moverComoBatallonHaciaAbajo();
        } catch (BatallonNoFormadoException e) {
            super.moverHaciaAbajo();
        } catch (BatallonIncompletoExcepcion e) {
            // magia?
        }
        this.disolverBatallon();
    }

    @Override
    public void moverHaciaLaDerecha() throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion {
        try {
            this.moverComoBatallonHaciaLaDerecha();
        } catch (BatallonNoFormadoException e) {
            super.moverHaciaLaDerecha();
        } catch (BatallonIncompletoExcepcion e) {
            // magia?
        }
        this.disolverBatallon();
    }

    @Override
    public void moverHaciaLaIzquierda()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion {
        try {
            this.moverComoBatallonHaciaLaIzquierda();
        } catch (BatallonNoFormadoException e) {
            super.moverHaciaLaIzquierda();
        } catch (BatallonIncompletoExcepcion e) {
            // magia?
        }
        this.disolverBatallon();
    }

    @Override
    public void moverHaciaLaDerechaArriba()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion {
        try {
            this.moverComoBatallonHaciaLaDerechaArriba();
        } catch (BatallonNoFormadoException e) {
            super.moverHaciaLaDerechaArriba();
        } catch (BatallonIncompletoExcepcion e) {
            // magia?
        }
        this.disolverBatallon();
    }

    @Override
    public void moverHaciaLaDerechaAbajo()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion {
        try {
            this.moverComoBatallonHaciaLaDerechaAbajo();
        } catch (BatallonNoFormadoException e) {
            super.moverHaciaLaDerechaAbajo();
        } catch (BatallonIncompletoExcepcion e) {
            // magia?
        }
        this.disolverBatallon();
    }

    @Override
    public void moverHaciaLaIzquierdaArriba()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion {
        try {
            this.moverComoBatallonHaciaLaIzquierdaArriba();
        } catch (BatallonNoFormadoException e) {
            super.moverHaciaLaIzquierdaArriba();
        } catch (BatallonIncompletoExcepcion e) {
            // magia?
        }
        this.disolverBatallon();
    }

    @Override
    public void moverHaciaLaIzquierdaAbajo()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion {
        try {
            this.moverComoBatallonHaciaLaIzquierdaAbajo();
        } catch (BatallonNoFormadoException e) {
            super.moverHaciaLaIzquierdaAbajo();
        } catch (BatallonIncompletoExcepcion e) {
            // magia?
        }
        this.disolverBatallon();
    }

    @Override
    public void moverEnDireccion(Direccion horizontal, Direccion vertical)
            throws CasilleroOcupadoExcepcion, CasilleroFueraDelLosLimitesDelTableroExcepcion {
        try {
            this.batallonMovimiento.moverComoBatallon(this, horizontal, vertical);
        } catch (BatallonNoFormadoException e) {
            super.moverEnDireccion(horizontal, vertical);
        } catch (BatallonIncompletoExcepcion e) {
            // magia?
        }
        this.disolverBatallon();
    }

}