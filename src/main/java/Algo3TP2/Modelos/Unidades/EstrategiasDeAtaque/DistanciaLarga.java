package Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Properties;

public abstract class DistanciaLarga extends EstrategiaDeAtaque {

    public void validarAtaque(Unidad unidadAtacante, Unidad unidadVictima)
            throws DistanciaDeAtaqueIncorrectaExcepcion {

        Casillero casilleroAtacante = unidadAtacante.getCasillero();
        Casillero casilleroVictima = unidadVictima.getCasillero();
        int distanciaEnX = Tablero.getTablero().medirDistanciaEnXDeCasilleroACasillero(casilleroAtacante,casilleroVictima);
        int distanciaEnY = Tablero.getTablero().medirDistanciaEnYDeCasilleroACasillero(casilleroAtacante,casilleroVictima);

        boolean condicionDistancia = (distanciaEnX >= Properties.alcanceMinDistanciaLarga &&
                distanciaEnY >= Properties.alcanceMinDistanciaLarga);
        if (!condicionDistancia) {
            throw new DistanciaDeAtaqueIncorrectaExcepcion();
        }
    }
}