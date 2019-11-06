package Algo3TP2.Modelos;

import Algo3TP2.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Properties;

public abstract class DistanciaLarga extends EstrategiaDeAtaque {

    public void validarAtaque(Unidad unidadAtacante, Unidad unidadVictima)
            throws DistanciaDeAtaqueIncorrectaExcepcion {
        int distanciaEnX = this.medirDistanciaEnX(unidadAtacante, unidadVictima);
        int distanciaEnY = this.medirDistanciaEnY(unidadAtacante, unidadVictima);
        boolean condicionDistancia = (distanciaEnX >= Properties.alcanceMinDistanciaLarga &&
                distanciaEnY >= Properties.alcanceMinDistanciaLarga);
        if (!condicionDistancia) {
            throw new DistanciaDeAtaqueIncorrectaExcepcion();
        }
    }
}