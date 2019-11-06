package Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque;

import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Properties;

public class AtaqueDeCatapulta extends DistanciaLarga {

    public AtaqueDeCatapulta() {
    }

    @Override
    public void atacar(Unidad unidadAtacante, Unidad unidadVictima) throws DistanciaDeAtaqueIncorrectaExcepcion {
        // Falta trabajarlo este metodo tdd segunda entrega
        unidadVictima.generarDanio(Properties.danioCatapultaDistancia);
    }
}
