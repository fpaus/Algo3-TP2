package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Tablero.Direccion.Direccion;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesBatallon.BatallonIncompletoExcepcion;
import Algo3TP2.Properties;

import java.util.ArrayList;
import java.util.Iterator;

public class Batallon {

    protected void moverComoBatallon(Soldado soldado, Direccion vertical, Direccion horizontal) throws BatallonIncompletoExcepcion {
        ArrayList<Soldado> soldadosParaBatallon = reunirBatallon(soldado);
        ejecutarMovimientoDeBatallon(soldadosParaBatallon, vertical, horizontal);
    }

    private void ejecutarMovimientoDeBatallon(ArrayList<Soldado> soldadosParaBatallon, Direccion vertical, Direccion horizontal){
        for (int i=0; i<Properties.tamanioDeBatallon; i++) {
            ArrayList<Soldado> soldadosAMover = new ArrayList<>(soldadosParaBatallon);
            Iterator<Soldado> soldadosIter = soldadosAMover.iterator();
            for (int j = 0; j < Properties.tamanioDeBatallon; j++) {
                if(soldadosIter.hasNext()){
                    Soldado soldadoIterActual = soldadosIter.next();
                    try {
                        Casillero casilleroDestino = soldadoIterActual.getCasillero().getCasilleroVecino(vertical, horizontal);
                        try {
                            soldadoIterActual.mover(casilleroDestino);
                            soldadosParaBatallon.remove(soldadoIterActual);
                        } catch (CasilleroOcupadoExcepcion | CasilleroVacioExcepcion ex) {
                        }
                    } catch (CasilleroFueraDelLosLimitesDelTableroExcepcion ex) {
                    }
                }
            }
        }
    }

    protected ArrayList<Soldado> reunirBatallon(Soldado soldado) throws BatallonIncompletoExcepcion {
        ArrayList<Soldado> soldadosParaBatallon = soldado.reunirBatallonConVecino();
        soldadosParaBatallon.add(soldado);

        if(soldadosParaBatallon.size() == Properties.tamanioDeBatallon){
            return soldadosParaBatallon;
        }

        if(soldadosParaBatallon.size() == 2){
            // Busco Soldados Aliados vecinos al soldado vecino ya agregado.
            Iterator<Soldado> soldadosParaBatallonIter = soldadosParaBatallon.iterator();
            ArrayList<Soldado> soldados = soldadosParaBatallonIter.next().reunirBatallonConVecino();
            for (Soldado soldadoCandidato : soldados) {
                // Si el soldado vecino no se encuentra ya en el batallon, lo añado
                if (!soldadosParaBatallon.contains(soldadoCandidato)) {
                    soldadosParaBatallon.add(soldadoCandidato);
                }
            }
        }

        if(soldadosParaBatallon.size() < Properties.tamanioDeBatallon){
            throw new BatallonIncompletoExcepcion();
        }
        return soldadosParaBatallon;
    }

    protected ArrayList<Soldado> reunirBatallonConVecino(Soldado soldado, Casillero casilleroSoldado){
        ArrayList<Soldado> soldadosParaBatallon = new ArrayList<Soldado>();
        ArrayList<Casillero> casillerosVecinos = casilleroSoldado.getTodosLosCasillerosVecinos();

        casillerosVecinos.forEach(casillero -> {
            try {
                Unidad unidad = casillero.getUnidad();
                if (unidad.getBando().equals(soldado.getBando())){
                    if(unidad.getClass() == Soldado.class){
                        if(!soldadosParaBatallon.contains((Soldado) unidad)){
                            soldadosParaBatallon.add((Soldado) unidad);
                        }
                    }
                }
            }catch (CasilleroVacioExcepcion ex) {}
        });

        return soldadosParaBatallon;
    }

}
