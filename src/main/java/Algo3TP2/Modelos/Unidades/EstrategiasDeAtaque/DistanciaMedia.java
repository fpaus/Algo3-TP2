package Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque;

import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Properties;

public abstract class DistanciaMedia extends EstrategiaDeAtaque {

    public void validarAtaque(Unidad unidadAtacante, Unidad unidadVictima)
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion {

        this.unidadVictimaEsEnemigaDeUnidadAtacante(unidadAtacante, unidadVictima);

        int distanciaEnX = this.medirDistanciaEnX(unidadAtacante, unidadVictima);
        int distanciaEnY = this.medirDistanciaEnY(unidadAtacante, unidadVictima);
        boolean condicionDistanciaMaxima = (distanciaEnX <= Properties.alcanceMaxDistanciaMedia &&
                distanciaEnY <= Properties.alcanceMaxDistanciaMedia);
        boolean condicionDistanciaMinima = (distanciaEnX >= Properties.alcanceMinDistanciaMedia &&
                distanciaEnY >= Properties.alcanceMinDistanciaMedia);

        // Si no cumple las condiciones de distancia lanzo excepcion
        if (!condicionDistanciaMinima || !condicionDistanciaMaxima) {
            throw new DistanciaDeAtaqueIncorrectaExcepcion();
        }
    }
}

