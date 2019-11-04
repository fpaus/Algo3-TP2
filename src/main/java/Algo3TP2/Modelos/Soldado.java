package Algo3TP2.Modelos;

import Algo3TP2.Properties;

public class Soldado extends UnidadMovible implements IUnidadDeAtaque {


    public Soldado(){
        this.costo = Properties.costoSoldado;
        this.vida = new Salud(Properties.vidaSoldado);
    }

    @Override
    public void mover(Casillero casillero) {

    }

    @Override
    public void atacar() {

    }
}
