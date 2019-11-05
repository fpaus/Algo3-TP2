package Algo3TP2.Modelos;
import Algo3TP2.ExcepcionesCasillero.*;

public class Casillero {

    private int x;
    private int y;
    private Unidad unidadEnCasillero;
    private Bando duenio;
    private CasilleroEstado estado; //Patron de diseño State

    public Casillero(int x, int y, Jugador jugador) {
        this.x = x;
        this.y = y;
        this.duenio = new Bando(jugador);
        estado = new CasilleroVacio();
    }

    protected void setEstado(CasilleroEstado estado) {
        this.estado = estado;
    }

    public void setUnidad(Unidad unidad) throws CasilleroOcupadoExcepcion {
        estado.setUnidad(this, unidad);
    }

    public Unidad getUnidad() throws CasilleroVacioExcepcion {
        return estado.getUnidad();
    }

    public void quitarUnidad() throws CasilleroVacioExcepcion {
        estado.quitarUnidad(this);
    }

    public Bando getBando(){
        return this.duenio;
    }
}
