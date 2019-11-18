package Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.UnidadInvalidaException;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Properties;

public class AtaqueDeCatapulta extends DistanciaLarga {

    public AtaqueDeCatapulta() {
    }

    @Override
    public void atacar(Unidad unidadAtacante, Unidad unidadVictima)
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadInvalidaException {
        try{
            this.validarAtaque(unidadAtacante, unidadVictima);
        } catch (UnidadAtacadaEsAliadaExcepcion ex){
            // Permito el ataque, ya que una catapulta puede atacar aliados
        }

        unidadVictima.recibirDanio(Properties.danioCatapultaDistancia);

        //atacarUnidadesContiguas(unidadVictima.getCasillero());
    }
/*
    private void atacarUnidadesContiguas(Casillero casilleroActual) throws UnidadInvalidaException{
        try {
            Casillero casilleroContiguo = Tablero.getTablero().
                    getCasilleroEnPosicion(casilleroActual.getCoordenadaX()-1, casilleroActual.getCoordenadaY());
            Unidad unidadContigua = casilleroContiguo.getUnidad();
            unidadContigua.recibirDanio(Properties.danioCatapultaDistancia);
            atacarUnidadesContiguas(casilleroContiguo);

        } catch (CasilleroFueraDelLosLimitesDelTableroExcepcion | CasilleroVacioExcepcion ex){
            // Freno la iteracion
        }
    }
}
*/