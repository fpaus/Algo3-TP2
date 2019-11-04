package Algo3TP2.Modelos;

public class Jugador {

    private Puntos puntos;
    public Jugador(){
        this.puntos = new Puntos();
    }

    public void colocarUnidadEnCasillero(Unidad unidad, Casillero casillero){
        puntos.comprarUnidad(unidad).colocarEnCasillero(casillero);
    }

}
