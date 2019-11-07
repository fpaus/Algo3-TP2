package Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque;

import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Properties;

public abstract class DistaciaCorta extends EstrategiaDeAtaque {

    public void validarAtaque(Unidad unidadAtacante, Unidad unidadVictima)
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion {
        this.unidadVictimaEsEnemigaDeUnidadAtacante(unidadAtacante, unidadVictima);
        int distanciaEnX = this.medirDistanciaEnX(unidadAtacante, unidadVictima);
        int distanciaEnY = this.medirDistanciaEnY(unidadAtacante, unidadVictima);
        boolean condicionDistancia = (distanciaEnX <= Properties.alcanceMaxDistanciaCorta &&
                distanciaEnY <= Properties.alcanceMaxDistanciaCorta);
        if (!condicionDistancia) {
            throw new DistanciaDeAtaqueIncorrectaExcepcion();
        }
    }
}
