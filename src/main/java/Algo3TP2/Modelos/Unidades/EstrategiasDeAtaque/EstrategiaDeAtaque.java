package Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque;

import Algo3TP2.Modelos.Jugador.ExcepcionesJugador.UnidadInvalidaException;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Modelos.Unidades.Unidad;

public abstract class EstrategiaDeAtaque {

    public abstract void atacar(Unidad unidadAtacante, Unidad unidadVictima)
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion, UnidadInvalidaException;

    public abstract void validarAtaque(Unidad unidadAtacante, Unidad unidadVictima)
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion;

    protected void unidadVictimaEsEnemigaDeUnidadAtacante(Unidad unidadAtacante, Unidad unidadVictima)
            throws UnidadAtacadaEsAliadaExcepcion {

        if (unidadAtacante.getBando().equals(unidadVictima.getBando())) {
            throw new UnidadAtacadaEsAliadaExcepcion();
        }
    }
}
