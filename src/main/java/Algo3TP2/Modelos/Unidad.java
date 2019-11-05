package Algo3TP2.Modelos;

public abstract class Unidad {

    private Casillero casillero;
    protected int costo;
    protected Bando duenio;
    protected EstrategiaDeAtaque estrategiaDeAtaque;

    protected Salud vida;

    public void colocarEnCasillero(Casillero casillero) {
        this.casillero = casillero;
    }

    public Casillero getCasillero() {
        return casillero;
    }

    public int getCosto() {
        return costo;
    }

    public Bando getBando(){
        return this.duenio;
    }

    public void generarDanio(int danio){
        vida.generarDanio(danio);
    }

    public void curar(int vida){
        this.vida.curar(vida);
    }

}
