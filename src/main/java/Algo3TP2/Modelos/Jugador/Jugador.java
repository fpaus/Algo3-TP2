package Algo3TP2.Modelos.Jugador;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroEnemigoExcepcion;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Jugador.ExcepcionesJugador.JugadorSinUnidadesExcepcion;
import Algo3TP2.Modelos.Jugador.ExcepcionesJugador.PuntosInsuficientesExcepcion;
import Algo3TP2.Modelos.Jugador.ExcepcionesJugador.UnidadInvalidaException;
import Algo3TP2.Modelos.Tablero.Direccion.Direccion;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesBatallon.BatallonIncompletoExcepcion;
import Algo3TP2.Modelos.Unidades.IUnidadDeAtaque;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Modelos.Unidades.UnidadMovible;
import Algo3TP2.ObservableCasillero;
import Algo3TP2.ObservablePuntosJugador;
import Algo3TP2.ObservadorPuntos;

import java.util.ArrayList;
import java.util.List;

public class Jugador implements ObservablePuntosJugador {

    private String nombre;
    private Puntos puntos;
    private List<Unidad> unidadesDeJugador;
    private ArrayList<ObservadorPuntos> observadores;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntos = new Puntos();
        this.unidadesDeJugador = new ArrayList<Unidad>();
        this.observadores = new ArrayList<ObservadorPuntos>();
    }

    public void colocarUnidadEnCasillero(Unidad unidad, Casillero casillero) throws PuntosInsuficientesExcepcion, CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion {
        puntos.comprarUnidad(unidad, this);
        casillero.setUnidadAlInicioDelJuego(unidad);
    }

    public void moverUnidadACasillero(UnidadMovible unidad, Direccion horizontal, Direccion vertical)
            throws CasilleroOcupadoExcepcion, CasilleroFueraDelLosLimitesDelTableroExcepcion, UnidadInvalidaException, BatallonIncompletoExcepcion {
        if (!unidadesDeJugador.contains(unidad)) {
            throw new UnidadInvalidaException();
        }
        unidad.moverEnDireccion(horizontal, vertical);
    }

    public void atacarConUnidadACasillero(IUnidadDeAtaque unidad, Casillero casillero) throws UnidadInvalidaException,
            UnidadAtacadaEsAliadaExcepcion, DistanciaDeAtaqueIncorrectaExcepcion, CasilleroVacioExcepcion {
        if (!unidadesDeJugador.contains(unidad)) {
            throw new UnidadInvalidaException();
        }
        unidad.atacar(casillero.getUnidad());
    }

    public void matarUnidad(Unidad unidad) throws UnidadInvalidaException {
        if (!unidadesDeJugador.contains(unidad)) {
            throw new UnidadInvalidaException();
        }
        unidadesDeJugador.remove(unidad);
    }

    public void controlarCondicionDePerdida() throws JugadorSinUnidadesExcepcion {
        if (this.unidadesDeJugador.isEmpty()) {
            throw new JugadorSinUnidadesExcepcion(this.nombre);
        }
    }

    public void anadirUnidad(Unidad unidad) {
        this.unidadesDeJugador.add(unidad);
    }

    public Unidad getUnidadEnCasillero(Casillero casillero) throws CasilleroVacioExcepcion, UnidadInvalidaException {
        Unidad unidad = casillero.getUnidad();
        if (!unidadesDeJugador.contains(unidad)) {
            throw new UnidadInvalidaException();
        }
        return unidad;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    public void enlazarObservador(ObservadorPuntos observadorPuntos){
        this.observadores.add(observadorPuntos);
    }

    @Override
    public void notificarObservadores(int puntos) {
        this.observadores.forEach(observadorPuntos -> observadorPuntos.actualizar(puntos));
    }
}
