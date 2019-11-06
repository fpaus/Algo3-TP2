package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;

public abstract class UnidadMovible extends Unidad {

    Movimientos movimientos = new Movimientos();

    public void mover(Casillero destino) throws MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
        movimientos.mover(this, destino);
    }

}
