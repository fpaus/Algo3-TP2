package Algo3TP2.Modelos.Unidades.Batallon;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Tablero.Direccion.Direccion;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesMovimientos.MovimientoNoContiguoExcepcion;
import Algo3TP2.Modelos.Unidades.Soldado;

public class BatallonActivo implements BatallonEstado {

    @Override
    public void anadirSoldadoABatallon(Batallon batallon, Soldado soldado) throws BatallonCompletoExcepcion {
        throw new BatallonCompletoExcepcion();
    }

    @Override
    public void moverBatallon(Batallon batallon, Direccion vertical, Direccion horizontal) {
        batallon.batallonIntegrantes.forEach(soldado -> {
            try {
                Casillero casilleroDestino = soldado.getCasillero().getCasilleroVecino(vertical, horizontal);
                try {
                    soldado.mover(casilleroDestino);
                } catch (CasilleroOcupadoExcepcion | CasilleroVacioExcepcion | MovimientoNoContiguoExcepcion ex) {}
            } catch (CasilleroFueraDelLosLimitesDelTableroExcepcion ex) {}
        });
    }

    @Override
    public void desintegrar(Batallon batallon) {
        batallon.batallonIntegrantes.forEach(integrante -> integrante.setBatallon(new Batallon(integrante)));
    }

}
