package Algo3TP2.Modelos;

public class Casillero {

    private int x;
    private int y;
    private Unidad unidadEnCasillero;
    private Bando duenio;

    public Casillero(int x, int y, Jugador jugador){
        this.x = x;
        this.y = y;
        this.duenio.setDuenio(jugador);
    }
    public void setUnidad(Unidad unidad){
        this.unidadEnCasillero = unidad;
    }
    public Unidad getUnidad() {
        return unidadEnCasillero;
    }


}
