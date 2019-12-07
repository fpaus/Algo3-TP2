package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Jugador.ExcepcionesJugador.UnidadInvalidaException;
import Algo3TP2.Controladores.Observers.ObservableUnidadVida;
import Algo3TP2.Controladores.Observers.Observador;

import java.util.ArrayList;

public abstract class Unidad implements ObservableUnidadVida {

    protected Casillero casillero;
    protected int costo;
    protected Bando bando;
    private ArrayList<Observador> observadoresVida = new ArrayList<Observador>();

    protected Salud vida;

    public void colocarEnCasillero(Casillero casillero) throws CasilleroOcupadoExcepcion {
        this.casillero = casillero;
        casillero.setUnidad(this);
    }

    public Casillero getCasillero() {
        return casillero;
    }

    public int getCosto() {
        return costo;
    }

    public Bando getBando() {
        return this.bando;
    }

    public void recibirDanio(float danio) throws UnidadInvalidaException {
        if(!this.bando.equals( this.casillero.getBando()) ) {
            danio += (danio*5)/100;
        }
        vida.recibirDanio(danio, this);
        if (vida.getPuntosDeVida() == 0) {
            bando.matarUnidad(this);
            try{
                this.casillero.quitarUnidad();
            } catch (CasilleroVacioExcepcion ex){
                // Nada
            }
        }
    }

    public float getVida() {
        return this.vida.getPuntosDeVida();
    }

    public String getVidaString(){
        return this.vida.toString();
    }

    public float getVidaMaxima() {
        return this.vida.getPuntosVidaMaxima();
    }

    public void enlazarObservadorVida(Observador observadorVida){
        this.observadoresVida.add(observadorVida);
    }

    @Override
    public void notificarObservadoresUnidadVida() {
        this.observadoresVida.forEach(observadorVida -> observadorVida.actualizar());
    }
}
