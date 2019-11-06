package Algo3TP2.Modelos;

import java.util.List;
import java.util.ArrayList;
import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Unidades.IUnidadDeAtaque;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Modelos.Unidades.UnidadMovible;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesMovimientos.MovimientoInvalidoExcepcion;

public class Jugador {

    private Puntos puntos;
    private boolean sigueEnJuego;
    private List<Unidad> unidadesDeJugador;

    public Jugador() {
        this.puntos = new Puntos();
        this.unidadesDeJugador = new ArrayList<Unidad>();
        this.sigueEnJuego = true;
    }

    public void colocarUnidadEnCasillero(Unidad unidad, Casillero casillero) throws PuntosInsuficientesExcepcion {
        puntos.comprarUnidad(unidad).colocarEnCasillero(casillero);
        unidadesDeJugador.add(unidad);
    }

    public void moverUnidadACasillero(UnidadMovible unidad, Casillero casillero)
            throws UnidadInvalidaException, MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
        if (!unidadesDeJugador.contains(unidad)) {
            throw new UnidadInvalidaException();
        }
        unidad.mover(casillero);
    }

    public void atacarConUnidadCasillero(IUnidadDeAtaque unidad, Casillero casillero) throws UnidadInvalidaException,
            UnidadAtacadaEsAliadaExcepcion, DistanciaDeAtaqueIncorrectaExcepcion, CasilleroVacioExcepcion {
        if(!unidadesDeJugador.contains(unidad)){
            throw new UnidadInvalidaException();
        }
        unidad.atacar(casillero.getUnidad());;
    }

	public void matarUnidad(Unidad unidad) throws UnidadInvalidaException {
        if(!unidadesDeJugador.contains(unidad)){
            throw new UnidadInvalidaException();
        }
        unidadesDeJugador.remove(unidad);
        this.controlarCondicionDePerdida();
	}

    private void controlarCondicionDePerdida() {
        if(!puntos.quedanPuntos() && this.unidadesDeJugador.isEmpty()){
            this.perder();
        }
    }

    private void perder() {
        this.sigueEnJuego = false;
    }

    public boolean sigueEnJuego() {
        return this.sigueEnJuego;
    }

}
