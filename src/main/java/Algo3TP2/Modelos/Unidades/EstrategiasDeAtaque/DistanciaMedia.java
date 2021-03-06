package Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Tablero.Distancia;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Properties;

public abstract class DistanciaMedia extends EstrategiaDeAtaque {

    public void validarAtaque(Unidad unidadAtacante, Unidad unidadVictima)
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion {

        this.unidadVictimaEsEnemigaDeUnidadAtacante(unidadAtacante, unidadVictima);

        Casillero casilleroAtacante = unidadAtacante.getCasillero();
        Casillero casilleroVictima = unidadVictima.getCasillero();
        Distancia distancia = casilleroAtacante.getCoordenada().distanciaACoordenada(casilleroVictima.getCoordenada());

        boolean condicionDistanciaMaxima = (distancia.getValor() <= Properties.alcanceMaxDistanciaMedia);
        boolean condicionDistanciaMinima = (distancia.getValor() >= Properties.alcanceMinDistanciaMedia);

        // Si no cumple las condiciones de distancia lanzo excepcion
        if (!condicionDistanciaMinima || !condicionDistanciaMaxima) {
            throw new DistanciaDeAtaqueIncorrectaExcepcion();
        }
    }
}

