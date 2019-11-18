package Algo3TP2.Modelos.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.*;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Jugador;
import Algo3TP2.Modelos.Unidades.Unidad;

public class Casillero {

    private int x;
    private int y;
    private Unidad unidadEnCasillero;
    private Bando duenio;
    private CasilleroEstado estado; //Patron de diseño State
    private Coordenada coordenada;

    public Casillero(int x, int y, Jugador jugador) {
        this.x = x;
        this.y = y;
        this.coordenada = new Coordenada(x, y);
        this.duenio = new Bando(jugador);
        estado = new CasilleroVacio();
    }

    protected void setEstado(CasilleroEstado estado) {
        this.estado = estado;
    }

    public void setUnidad(Unidad unidad) throws CasilleroOcupadoExcepcion {
        estado.setUnidad(this, unidad);
    }

    public void setUnidadAlInicioDelJuego(Unidad unidad) throws CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion {
        if(unidad.getBando().getDuenio() != this.duenio.getDuenio()){
            throw new CasilleroEnemigoExcepcion();
        }
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

    public int getCoordenadaX(){
        return this.x;
    }

    public int getCoordenadaY(){
        return this.y;
    }

	public void aceptarUnidad(Unidad unidad) throws CasilleroOcupadoExcepcion {

        this.setUnidad(unidad);
        unidad.colocarEnCasillero(this);

	}

	public Casillero casilleroALaIzquierda() {
		return Tablero.getTablero().getCasilleroConCoordenada(new Coordenada(this.x - 1, this.y));
	}
}
