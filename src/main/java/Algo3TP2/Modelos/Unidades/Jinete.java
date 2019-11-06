package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.EstrategiaDeAtaque;
import Algo3TP2.Properties;

public class Jinete extends UnidadMovible implements IUnidadDeAtaque {

    private EstrategiaDeAtaque estrategiaDeAtaque;

    public Jinete(Bando bando) {
        this.costo = Properties.costoJinete;
        this.vida = new Salud(Properties.vidaJinete);
        this.duenio = bando;
    }

    @Override
    public void atacar(Unidad unidadVictima) throws UnidadAtacadaEsAliadaExcepcion, DistanciaDeAtaqueIncorrectaExcepcion {
        estrategiaDeAtaque.atacar(this, unidadVictima);
    }

    @Override
    public void mover(Casillero casillero) {

    }

    public void setEstrategiaDeAtaque(EstrategiaDeAtaque estragia) {
        this.estrategiaDeAtaque = estragia;
    }

}
