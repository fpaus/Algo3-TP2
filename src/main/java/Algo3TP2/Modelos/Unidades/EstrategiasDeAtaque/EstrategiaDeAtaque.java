package Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque;

import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Modelos.Jugador;
import Algo3TP2.Modelos.UnidadInvalidaException;
import Algo3TP2.Modelos.Unidades.Unidad;

public abstract class EstrategiaDeAtaque {

    public abstract void atacar(Unidad unidadAtacante, Unidad unidadVictima)
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion, UnidadInvalidaException, CasilleroVacioExcepcion;

    public abstract void validarAtaque(Unidad unidadAtacante, Unidad unidadVictima)
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion;

    protected void unidadVictimaEsEnemigaDeUnidadAtacante(Unidad unidadAtacante, Unidad unidadVictima)
            throws UnidadAtacadaEsAliadaExcepcion {

        Jugador jugadorAtacante = unidadAtacante.getBando().getDuenio();
        Jugador jugadorVictima = unidadVictima.getBando().getDuenio();
        if (jugadorAtacante == jugadorVictima) {
            throw new UnidadAtacadaEsAliadaExcepcion();
        }
    }
}
