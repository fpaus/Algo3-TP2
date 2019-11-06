package Algo3TP2.Modelos;

import Algo3TP2.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Properties;

public class AtaqueDeJIneteConArcoYFlecha extends DistanciaMedia {

    public AtaqueDeJIneteConArcoYFlecha(){}

    @Override
    public void atacar(Unidad unidadAtacante, Unidad unidadVictima)
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion {
        this.validarAtaque(unidadAtacante, unidadVictima);
        unidadVictima.generarDanio(Properties.danioJineteDistancia);
    }
}
