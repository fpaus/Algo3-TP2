package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.EstrategiaDeAtaque;

public abstract class Unidad {

    private Casillero casillero;
    protected int costo;
    protected Bando duenio;
    protected EstrategiaDeAtaque estrategiaDeAtaque;

    protected Salud vida;

    protected int vidaMaxima;

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

    public void generarDanio(int danio) {
        vida.generarDanio(danio);
    }

    public void curar(int vida) {
        this.vida.curar(vida);
    }

    public int getVida() {
        return this.vida.getPuntosDeVida();
    }

}
