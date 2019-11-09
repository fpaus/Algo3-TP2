package Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Properties;

public abstract class DistaciaCorta extends EstrategiaDeAtaque {

    public void validarAtaque(Unidad unidadAtacante, Unidad unidadVictima)
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion {

        this.unidadVictimaEsEnemigaDeUnidadAtacante(unidadAtacante, unidadVictima);

        Casillero casilleroAtacante = unidadAtacante.getCasillero();
        Casillero casilleroVictima = unidadVictima.getCasillero();
        int distanciaEnX = Tablero.getTablero().medirDistanciaEnXDeCasilleroACasillero(casilleroAtacante,casilleroVictima);
        int distanciaEnY = Tablero.getTablero().medirDistanciaEnYDeCasilleroACasillero(casilleroAtacante,casilleroVictima);

        boolean condicionDistancia = (distanciaEnX <= Properties.alcanceMaxDistanciaCorta &&
                distanciaEnY <= Properties.alcanceMaxDistanciaCorta);

        if (!condicionDistancia) {
            throw new DistanciaDeAtaqueIncorrectaExcepcion();
        }
    }
}
