package Algo3TP2.Modelos;

import Algo3TP2.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Properties;

public class Soldado extends UnidadMovible implements IUnidadDeAtaque {

    private EstrategiaDeAtaque estrategiaDeAtaque;

    public Soldado(Bando bando){
        this.costo = Properties.costoSoldado;
        this.vida = new Salud(Properties.vidaSoldado);
        this.estrategiaDeAtaque = new AtaqueDeSoldado();
        this.duenio = bando;
    }

    @Override
    public void mover(Casillero casillero) {

    }

    @Override
    public void atacar(Unidad unidadVictima) throws UnidadAtacadaEsAliadaExcepcion, DistanciaDeAtaqueIncorrectaExcepcion {
        estrategiaDeAtaque.atacar(this, unidadVictima);
    }

}
