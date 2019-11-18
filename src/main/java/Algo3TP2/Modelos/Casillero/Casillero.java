package Algo3TP2.Modelos.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.*;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.Direccion.Direccion;
import Algo3TP2.Modelos.Tablero.Direccion.Fija;
import Algo3TP2.Modelos.Tablero.Direccion.Izquierda;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Jugador;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Modelos.Unidades.UnidadMovible;

public class Casillero {

    private Coordenada coordenada;
    private Unidad unidadEnCasillero;
    private Bando duenio;
    private CasilleroEstado estado; //Patron de diseño State

    public Casillero(Coordenada coordenada, Jugador jugador) {
        this.coordenada = coordenada;
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

    public Coordenada getCoordenada(){
        return this.coordenada;
    }

	public void aceptarUnidad(UnidadMovible unidad) throws CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {

        this.setUnidad(unidad);
        unidad.moverACasillero(this);

	}

    public Casillero getCasilleroVecino(Direccion horizontal, Direccion vertical) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {
        return Tablero.getTablero().getCasilleroEnPosicion(new Coordenada(this.coordenada, horizontal, vertical));

    }

}
