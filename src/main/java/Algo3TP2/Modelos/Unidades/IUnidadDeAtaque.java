package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.UnidadInvalidaException;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;

public interface IUnidadDeAtaque {

    public abstract void atacar(Unidad unidadVictima) throws UnidadAtacadaEsAliadaExcepcion, DistanciaDeAtaqueIncorrectaExcepcion, UnidadInvalidaException;

}
