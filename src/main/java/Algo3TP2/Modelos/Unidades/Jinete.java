package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.AtaqueDeJIneteConArcoYFlecha;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.AtaqueDeJineteConEspada;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.UnidadInvalidaException;
import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.EstrategiaDeAtaque;
import Algo3TP2.Properties;

import java.util.ArrayList;

public class Jinete extends UnidadMovible implements IUnidadDeAtaque {

    private EstrategiaDeAtaque estrategiaDeAtaque;

    public Jinete(Bando bando) {
        this.costo = Properties.costoJinete;
        this.vida = new Salud(Properties.vidaJinete);
        this.duenio = bando;
    }

    @Override
    public void atacar(Unidad unidadVictima)
            throws UnidadAtacadaEsAliadaExcepcion, DistanciaDeAtaqueIncorrectaExcepcion, UnidadInvalidaException {
        this.definirEstragegiaDeAtaque();
        estrategiaDeAtaque.atacar(this, unidadVictima);
    }

    private void setEstrategiaDeAtaque(EstrategiaDeAtaque estragia) {
        this.estrategiaDeAtaque = estragia;
    }

    private void definirEstragegiaDeAtaque(){
        ArrayList<Casillero> casilleros = this.casillero.getTodosLosCasillerosVecinos();
        for(Casillero casillero : casilleros){
            try{
                Unidad unidadCercana = casillero.getUnidad();
                if(this.duenio != unidadCercana.duenio){
                    this.setEstrategiaDeAtaque(new AtaqueDeJineteConEspada());
                    return;
                }
            } catch (CasilleroVacioExcepcion e){}
        }
        this.setEstrategiaDeAtaque(new AtaqueDeJIneteConArcoYFlecha());
    }
}
