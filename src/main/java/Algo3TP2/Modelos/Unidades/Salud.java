package Algo3TP2.Modelos.Unidades;

public class Salud {

    private float vida;

    private float vidaMaxima;

    public Salud(float vida) {
        this.vida = vida;
        this.vidaMaxima = vida;
    }


    public void recibirDanio(float danio, Unidad unidad) {
        if (this.vida > danio) {
            this.vida -= danio;
        } else {
            this.vida = 0;
        }
        unidad.notificarObservadoresUnidadVida();
    }

    public void recibirCuracion(float vida, Unidad unidad) {
        if (this.vidaMaxima - this.vida > vida) {
            this.vida += vida;
        } else {
            this.vida = this.vidaMaxima;
        }
        unidad.notificarObservadoresUnidadVida();
    }

    public float getPuntosDeVida() {
        return this.vida;
    }

    public float getPuntosVidaMaxima() {
        return this.vidaMaxima;
    }

    public String toString(){
        return Integer.toString((int)Math.ceil(this.vida));
    }
}
