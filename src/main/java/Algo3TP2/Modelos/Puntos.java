package Algo3TP2.Modelos;

public class Puntos {
    private int puntosDisponibles;
    public Unidad comprarUnidad(Unidad unidad){
        if(unidad.getCosto() < puntosDisponibles){
            return unidad;
        }else{
            return null;
        }
    }
}
