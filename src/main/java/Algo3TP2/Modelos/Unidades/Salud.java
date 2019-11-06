package Algo3TP2.Modelos.Unidades;

public class Salud {

    private int vida;

    private int vidaMaxima;

    public Salud(int vida) {
        this.vida = vida;
        this.vidaMaxima = vida;
    }

    public void generarDanio(int danio) {
        this.vida -= danio;
    }

    public void curar(int vida) {
        this.vida += vida;
    }

    public void curarVidaCompleta() { this.vida = vidaMaxima; }

    public int getPuntosDeVida() {
        return this.vida;
    }

    public int getPuntosVidaMaxima() { return this.vidaMaxima; }
}
