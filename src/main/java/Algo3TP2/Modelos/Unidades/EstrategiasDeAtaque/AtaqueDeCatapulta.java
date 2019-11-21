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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AtaqueDeCatapulta extends DistanciaLarga {

    public AtaqueDeCatapulta() {
    }

    @Override
    public void atacar(Unidad unidadAtacante, Unidad unidadVictima)
            throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadInvalidaException, CasilleroVacioExcepcion {
        try{
            this.validarAtaque(unidadAtacante, unidadVictima);
        } catch (UnidadAtacadaEsAliadaExcepcion ex){
            // Permito el ataque, ya que una catapulta puede atacar aliados
        }

        //unidadVictima.recibirDanio(Properties.danioCatapultaDistancia);

        atacarUnidadesContiguas(unidadVictima);
    }

    private void atacarUnidadesContiguas(Unidad unidadInicial) throws UnidadInvalidaException, CasilleroVacioExcepcion {
        Queue<Unidad> q = new LinkedList<>();
        ArrayList<Unidad> unidades_visitadas = new ArrayList<>();
        q.add(unidadInicial);

        while (q.size() != 0) {

            Unidad unidad = q.poll();
            if (!unidades_visitadas.contains(unidad)) {

                unidades_visitadas.add(unidad);
                ArrayList<Casillero> casillerosVecinos = unidad.getCasillero().getTodosLosCasillerosVecinos();
                for (Casillero casillero : casillerosVecinos) {
                    try{
                        q.add(casillero.getUnidad());
                    }
                    catch (CasilleroVacioExcepcion e) {}
                }
            }
        }
        for(Unidad unidad : unidades_visitadas) {
            unidad.recibirDanio(Properties.danioCatapultaDistancia);
        }
    }

}
