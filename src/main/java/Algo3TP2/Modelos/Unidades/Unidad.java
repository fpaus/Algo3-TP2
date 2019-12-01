package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Jugador.ExcepcionesJugador.UnidadInvalidaException;

public abstract class Unidad {

    protected Casillero casillero;
    protected int costo;
    protected Bando bando;

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
        vida.recibirDanio(danio);
        if (vida.getPuntosDeVida() == 0) {
            //bando.matarUnidad(this);
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

    public float getVidaMaxima() {
        return this.vida.getPuntosVidaMaxima();
    }

}
