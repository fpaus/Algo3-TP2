package Algo3TP2.Modelos.Unidades;

import java.util.ArrayList;

import Algo3TP2.Properties;
import Algo3TP2.Modelos.Tablero.Direccion.Direccion;
import Algo3TP2.Modelos.Unidades.ExcepcionesBatallon.BatallonIncompletoExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesBatallon.BatallonNoFormadoException;
import java.util.Iterator;

public class BatallonDisuelto extends Batallon {
    @Override
    protected void moverComoBatallon(Soldado soldado, Direccion vertical, Direccion horizontal)
            throws BatallonIncompletoExcepcion, BatallonNoFormadoException {
        throw new BatallonNoFormadoException();
    }

    @Override
    public void verificarBatallonFormado() throws BatallonNoFormadoException {
        throw new BatallonNoFormadoException();
    }

    @Override
    public void verificarSiSePuedeFormarBatallon(Soldado soldado) throws BatallonIncompletoExcepcion {
        ArrayList<Soldado> soldadosParaBatallon = this.reunirBatallonConVecino(soldado, soldado.getCasillero());
        soldadosParaBatallon.add(soldado);

        if (soldadosParaBatallon.size() == Properties.tamanioDeBatallon) {
            return;
        }

        if (soldadosParaBatallon.size() == 2) {
            // Busco Soldados Aliados vecinos al soldado vecino ya agregado.
            Iterator<Soldado> soldadosParaBatallonIter = soldadosParaBatallon.iterator();
            Soldado soldadoNext = soldadosParaBatallonIter.next();
            ArrayList<Soldado> soldados = this.reunirBatallonConVecino(soldadoNext, soldadoNext.getCasillero());
            for (Soldado soldadoCandidato : soldados) {
                // Si el soldado vecino no se encuentra ya en el batallon, lo añado
                if (!soldadosParaBatallon.contains(soldadoCandidato)) {
                    soldadosParaBatallon.add(soldadoCandidato);
                }
            }
        }

        if (soldadosParaBatallon.size() < Properties.tamanioDeBatallon) {
            throw new BatallonIncompletoExcepcion();
        }

    }
}
