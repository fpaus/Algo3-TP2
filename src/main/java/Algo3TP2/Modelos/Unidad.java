package Algo3TP2.Modelos;

public abstract class Unidad {

    private Casillero casillero;
    protected int costo;

    protected Salud vida;

    public void colocarEnCasillero(Casillero casillero) {
        this.casillero = casillero;
    }

    public Casillero getCasillero() {
        return casillero;
    }
    public int getCosto(){
        return costo;
    };
}
