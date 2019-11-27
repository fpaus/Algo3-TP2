package Algo3TP2.Modelos.Jugador;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Jugador.ExcepcionesJugador.JugadorSinUnidadesExcepcion;
import Algo3TP2.Modelos.Jugador.ExcepcionesJugador.PuntosInsuficientesExcepcion;
import Algo3TP2.Modelos.Jugador.ExcepcionesJugador.UnidadInvalidaException;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Modelos.Unidades.IUnidadDeAtaque;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Modelos.Unidades.UnidadMovible;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private String nombre;
    private Puntos puntos;
    private List<Unidad> unidadesDeJugador;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntos = new Puntos();
        this.unidadesDeJugador = new ArrayList<Unidad>();
    }

    public void colocarUnidadEnCasillero(Unidad unidad, Casillero casillero) throws PuntosInsuficientesExcepcion, CasilleroOcupadoExcepcion {
        puntos.comprarUnidad(unidad).colocarEnCasillero(casillero);
        unidadesDeJugador.add(unidad);
    }

    public void moverUnidadACasillero(UnidadMovible unidad, Casillero casillero)
            throws UnidadInvalidaException, CasilleroOcupadoExcepcion,
            CasilleroVacioExcepcion {
        if (!unidadesDeJugador.contains(unidad)) {
            throw new UnidadInvalidaException();
        }
        unidad.mover(casillero);
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

}
