package Algo3TP2.Modelos.Unidades;

public class Salud {

    private int vida;

    public Salud(int vida) {
        this.vida = vida;
    }

    public void generarDanio(int danio) {
        this.vida -= danio;
    }

    public void curar(int vida) {
        this.vida += vida;
    }

    public int getPuntosDeVida() {
        return this.vida;
    }
}
