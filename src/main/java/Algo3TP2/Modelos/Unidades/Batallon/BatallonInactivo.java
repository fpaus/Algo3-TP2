package Algo3TP2.Modelos.Unidades.Batallon;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Tablero.Direccion.Direccion;
import Algo3TP2.Modelos.Unidades.Soldado;
import Algo3TP2.Modelos.Unidades.Unidad;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class BatallonInactivo implements BatallonEstado {

    @Override
    public void anadirSoldadoABatallon(Batallon batallon, Soldado soldado) throws ElSoldadoNoSeEncuentraContiguoAlBatallonExcepcion{
        validarCercaniaDelSoldado(batallon, soldado);
        batallon.batallonIntegrantes.add(soldado);
        soldado.incorporarABatallon(batallon);
        if (batallon.batallonIntegrantes.size() == 3) {
            batallon.estado = new BatallonActivo();
        }
    }

    private void validarCercaniaDelSoldado(Batallon batallon, Soldado soldado) throws ElSoldadoNoSeEncuentraContiguoAlBatallonExcepcion {
        ArrayList<Soldado> soldadoAAnadir = new ArrayList<Soldado>();
        batallon.batallonIntegrantes.forEach(integrante ->{
            ArrayList<Casillero> casilleros = integrante.getCasillero().getTodosLosCasillerosVecinos();
            casilleros.forEach(casilleroVecino -> {
                try {
                    Unidad unidadVecina = casilleroVecino.getUnidad();
                    if (unidadVecina == soldado){
                        soldadoAAnadir.add(soldado);
                    }
                } catch (CasilleroVacioExcepcion ex) {}
            });
        });
        if(soldadoAAnadir.isEmpty()){
            throw new ElSoldadoNoSeEncuentraContiguoAlBatallonExcepcion();
        }
    }

    @Override
    public void moverBatallon(Batallon batallon, Direccion horizontal, Direccion vertical) throws BatallonIncompletoExcepcion {
        throw new BatallonIncompletoExcepcion();
    }
    @Override
    public void desintegrar(Batallon batallon) throws BatallonIncompletoExcepcion {
        throw new BatallonIncompletoExcepcion();
    }
}