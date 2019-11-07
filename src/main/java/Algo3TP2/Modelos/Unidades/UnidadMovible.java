package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesMovimientos.MovimientoInvalidoExcepcion;

public abstract class UnidadMovible extends Unidad {

    Movimientos movimientos = new Movimientos();

    public void mover(Casillero destino) throws MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
        movimientos.ejecutarMovimiento(this, destino);
    }
    
    public void curar(int vida) {
        this.vida.curar(vida);
    }
}
