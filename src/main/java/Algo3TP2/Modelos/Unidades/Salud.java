package Algo3TP2.Modelos.Unidades;

public class Salud {

    private float vida;

    private float vidaMaxima;

    public Salud(float vida) {
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

    public float getPuntosDeVida() {
        return this.vida;
    }

    public float getPuntosVidaMaxima() {
        return this.vidaMaxima;
    }
}
