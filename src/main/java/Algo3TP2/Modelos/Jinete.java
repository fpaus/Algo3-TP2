package Algo3TP2.Modelos;

import Algo3TP2.Properties;

public class Jinete extends UnidadMovible implements IUnidadDeAtaque {

    public Jinete(){
        this.costo = Properties.costoJinete;
        this.vida = new Salud(Properties.vidaJinete);
    }

    @Override
    public void atacar() {
        System.out.println(Properties.danioJineteCaC);
        System.out.println(Properties.danioJineteDistancia);
    }

    @Override
    public void mover(Casillero casillero) {

    }
}
