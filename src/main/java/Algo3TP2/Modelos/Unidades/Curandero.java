package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Properties;

public class Curandero extends UnidadMovible {

    public Curandero() {
        this.costo = Properties.costoCurandero;
        this.vida = new Salud(Properties.vidaCurandero);
    }

    @Override
    public void mover(Casillero casillero) {

    }
}
