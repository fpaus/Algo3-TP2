package Algo3TP2.Modelos;

import Algo3TP2.Properties;

public class Catapulta extends Unidad implements IUnidadDeAtaque{

    public Catapulta(){
        this.costo = Properties.costoCatapulta;
        this.vida = new Salud(Properties.vidaCatapulta);
    }

    @Override
    public void atacar() {

    }
}
