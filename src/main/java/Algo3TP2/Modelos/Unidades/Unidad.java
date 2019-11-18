package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.UnidadInvalidaException;
import Algo3TP2.Modelos.Casillero.Casillero;

public abstract class Unidad {

    protected Casillero casillero;
    protected int costo;
    protected Bando duenio;

    protected Salud vida;
    private boolean estaViva = true;

    public void colocarEnCasillero(Casillero casillero) {
        this.casillero = casillero;
    }

    public Casillero getCasillero() {
        return casillero;
    }

    public int getCosto() {
        return costo;
    }

    public Bando getBando() {
        return this.duenio;
    }

    public void recibirDanio(int danio) throws UnidadInvalidaException {
        vida.recibirDanio(danio);
        if(vida.getPuntosDeVida() == 0){
            duenio.matarUnidad(this);
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
