package Algo3TP2.Modelos.Casillero;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroEnemigoExcepcion;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Jugador.Jugador;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.Direccion.Direccion;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Modelos.Unidades.UnidadMovible;
import Algo3TP2.Observers.ObservableCasillero;
import Algo3TP2.Observers.ObservadorCasillero;

import java.util.ArrayList;

public class Casillero implements ObservableCasillero {

    private Coordenada coordenada;
    private Bando bando;
    private CasilleroEstado estado; //Patron de diseño State
    private ArrayList<ObservadorCasillero> observadores;

    public Casillero(Coordenada coordenada, Jugador jugador) {
        this.observadores = new ArrayList<ObservadorCasillero>();
        this.coordenada = coordenada;
        this.bando = new Bando(jugador);
        estado = new CasilleroVacio();
    }

    protected void setEstado(CasilleroEstado estado) {
        this.estado = estado;
        this.notificarObservadores();
    }

    public void setUnidad(Unidad unidad) throws CasilleroOcupadoExcepcion {
        estado.setUnidad(this, unidad);
    }

    public void setUnidadAlInicioDelJuego(Unidad unidad)
            throws CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion {
        if (!this.bando.equals(unidad.getBando())) {
            throw new CasilleroEnemigoExcepcion();
        }
        unidad.colocarEnCasillero(this);
    }

    public Unidad getUnidad() throws CasilleroVacioExcepcion {
        return estado.getUnidad();
    }

    public void quitarUnidad() throws CasilleroVacioExcepcion {
        estado.quitarUnidad(this);
    }

    public Bando getBando() {
        return this.bando;
    }

    public Coordenada getCoordenada() {
        return this.coordenada;
    }

    public void aceptarUnidad(UnidadMovible unidad) throws CasilleroOcupadoExcepcion {

        this.setUnidad(unidad);
        unidad.moverACasillero(this);

    }

    public Casillero getCasilleroVecino(Direccion horizontal, Direccion vertical) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {
        return Tablero.getTablero().getCasilleroEnCoordenada(new Coordenada(this.coordenada, horizontal, vertical));

    }

    public ArrayList<Casillero> getTodosLosCasillerosVecinos() {
        ArrayList<Casillero> casilleros = new ArrayList<Casillero>();
        for (Coordenada coordenada : this.coordenada.getTodasLasCoordenadasVecinas()) {
            try {
                casilleros.add(Tablero.getTablero().getCasilleroEnCoordenada(coordenada));
            } catch (CasilleroFueraDelLosLimitesDelTableroExcepcion e) {
            }
        }
        return casilleros;
    }

    @Override
    public String toString() {
        return coordenada.toString();
    }

    public void enlazarObservador(ObservadorCasillero observadorCasillero){
        this.observadores.add(observadorCasillero);
    }

    @Override
    public void notificarObservadores() {
        this.estado.notificarObservadores(this.observadores);
    }
}
