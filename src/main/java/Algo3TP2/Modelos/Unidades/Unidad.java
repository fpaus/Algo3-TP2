package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.UnidadInvalidaException;
import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;

public abstract class Unidad {

    protected Casillero casillero;
    protected int costo;
    protected Bando bando;

    protected Salud vida;
    private boolean estaViva = true;

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

    public void recibirDanio(int danio) throws UnidadInvalidaException {
        vida.recibirDanio(danio);
        if(vida.getPuntosDeVida() == 0){
            bando.matarUnidad(this);
        }
    }

    public int getVida() {
        return this.vida.getPuntosDeVida();
    }

    public int getVidaMaxima(){
        return this.vida.getPuntosVidaMaxima();
    }

	public void morir() {
        this.estaViva = false;
    }
    
    public boolean estaViva(){
        return this.estaViva;
    }

}
