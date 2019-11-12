package Algo3TP2.Modelos.Unidades;

public class Salud {

    private int vida;

    private int vidaMaxima;

    public Salud(int vida) {
        this.vida = vida;
        this.vidaMaxima = vida;
    }



    public void recibirDanio(int danio) {
        if (this.vida > danio) {
            this.vida -= danio;
        } else {
            this.vida = 0;
        }
    }

    public void recibirCuracion(int vida) {
        if (this.vidaMaxima - this.vida > vida) {
            this.vida += vida;
        } else {
            this.vida = this.vidaMaxima;
        }

    }

    public int getPuntosDeVida() {
        return this.vida;
    }

    public int getPuntosVidaMaxima() {
        return this.vidaMaxima;
    }
}
