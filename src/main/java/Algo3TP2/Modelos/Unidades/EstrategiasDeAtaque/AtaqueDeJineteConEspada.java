package Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque;

import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Modelos.UnidadInvalidaException;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Properties;

public class AtaqueDeJineteConEspada extends DistaciaCorta {

    public AtaqueDeJineteConEspada() {
    }

    @Override
    public void atacar(Unidad unidadAtacante, Unidad unidadVictima)
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion, UnidadInvalidaException {
        this.validarAtaque(unidadAtacante, unidadVictima);
        unidadVictima.generarDanio(Properties.danioJineteCaC);
    }
}