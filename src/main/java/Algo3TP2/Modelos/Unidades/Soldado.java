package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Tablero.Direccion.*;
import Algo3TP2.Modelos.Unidades.Batallon.*;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.UnidadInvalidaException;
import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.AtaqueDeSoldado;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.EstrategiaDeAtaque;

import java.util.ArrayList;
import java.util.Iterator;

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

    public void conformarBatallonCon(Soldado soldado1) throws BatallonCompletoExcepcion, ElSoldadoNoSeEncuentraContiguoAlBatallonExcepcion {
        batallon.anadirSoldadoABatallon(soldado1);
    }

    public void desintegrarBatallon() throws BatallonIncompletoExcepcion {
        batallon.desintegrar();
    }

    public void setBatallon(Batallon batallon) {
        this.batallon = batallon;
    }

    private void moverComoBatallon(Direccion vertical, Direccion horizontal) throws BatallonIncompletoExcepcion {
        batallon.moverBatallon(vertical, horizontal);
    }

    public ArrayList<Soldado> reunirBatallon(){
        ArrayList<Soldado> soldadosParaBatallon = this.reunirBatallonConVecino();
        soldadosParaBatallon.add(this);
        if(soldadosParaBatallon.size() == 3){
            return soldadosParaBatallon;
        }
        if(soldadosParaBatallon.size() > 1 && soldadosParaBatallon.size() < 3){
            Iterator<Soldado> soldados = soldadosParaBatallon.iterator();
            ArrayList<Soldado> soldados1 = soldados.next().reunirBatallonConVecino();
            soldados1.forEach(soldado -> {
                if(!soldadosParaBatallon.contains(soldado)){
                    soldadosParaBatallon.add(soldado);
                }
            });
        }
        return soldadosParaBatallon;
    }

    protected ArrayList<Soldado> reunirBatallonConVecino(){
        ArrayList<Soldado> soldadosParaBatallon = new ArrayList<Soldado>();
        ArrayList<Casillero> casillerosVecinos = this.casillero.getTodosLosCasillerosVecinos();
        casillerosVecinos.forEach(casillero -> {
            try {
                Unidad unidad = casillero.getUnidad();
                if (unidad.getBando().getDuenio() == this.duenio.getDuenio()){
                    if(unidad.getClass() == Soldado.class){
                        if(!soldadosParaBatallon.contains((Soldado) unidad)){
                            soldadosParaBatallon.add((Soldado) unidad);
                        }
                    }
                }
            }catch (CasilleroVacioExcepcion ex) {}
        });
        return soldadosParaBatallon;
    }

    public void moverComomBatallonHaciaArriba() throws BatallonIncompletoExcepcion {
        this.moverComoBatallon(new Fija(), new Arriba());
    }

    public void moverComoBatallonHaciaAbajo() throws BatallonIncompletoExcepcion {
        this.moverComoBatallon(new Fija(), new Abajo());
    }

    public void moverComoBatallonHaciaLaDerecha() throws BatallonIncompletoExcepcion {
        this.moverComoBatallon(new Derecha(), new Fija());
    }

    public void moverComoBatallonHaciaLaIzquierda() throws BatallonIncompletoExcepcion {
        this.moverComoBatallon(new Izquierda(), new Fija());
    }

    public void moverComoBatallonHaciaLaIzquierdaAbajo() throws BatallonIncompletoExcepcion {
        this.moverComoBatallon(new Izquierda(), new Abajo());
    }

    public void moverComoBatallonHaciaLaIzquierdaArriba() throws BatallonIncompletoExcepcion {
        this.moverComoBatallon(new Izquierda(), new Arriba());
    }

    public void moverComoBatallonHaciaLaDerechaAbajo() throws BatallonIncompletoExcepcion {
        this.moverComoBatallon(new Derecha(), new Abajo());
    }

    public void moverComoBatallonHaciaLaDerechaArriba() throws BatallonIncompletoExcepcion {
        this.moverComoBatallon(new Derecha(), new Arriba());
    }
}
