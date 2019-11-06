package Algo3TP2.Modelos;

import Algo3TP2.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Properties;

public class Catapulta extends Unidad implements IUnidadDeAtaque{

    //private EstrategiaDeAtaque estrategiaDeAtaque;

    public Catapulta(Bando bando){
        this.costo = Properties.costoCatapulta;
        this.vida = new Salud(Properties.vidaCatapulta);
        this.estrategiaDeAtaque = new AtaqueDeCatapulta();
        this.duenio = bando;
    }

    @Override
    public void atacar(Unidad unidadVictima) throws UnidadAtacadaEsAliadaExcepcion, DistanciaDeAtaqueIncorrectaExcepcion {
        estrategiaDeAtaque.atacar(this, unidadVictima);
    }

}
