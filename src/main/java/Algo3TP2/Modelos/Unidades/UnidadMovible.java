package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesMovimientos.MovimientoInvalidoExcepcion;

public abstract class UnidadMovible extends Unidad {

    Movimientos movimientos = new Movimientos();

    public void mover(Casillero destino) throws MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
        movimientos.ejecutarMovimiento(this, destino);
    }

    public void moverHaciaArriba()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
        movimientos.ejecutarMovimientoHaciaArriba(this);
    }

    public void moverHaciaAbajo()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
        movimientos.ejecutarMovimientoHaciaAbajo(this);
    }

    public void moverHaciaLaDerecha()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
        movimientos.ejecutarMovimientoHaciaLaDerecha(this);
    }

    public void moverHaciaLaIzquierda()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
        movimientos.ejecutarMovimientoHaciaLaIzquierda(this);
    }

    public void moverHaciaLaDerechaArriba()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
        movimientos.ejecutarMovimientoHaciaLaDerechaArriba(this);
    }

    public void moverHaciaLaDerechaAbajo()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
        movimientos.ejecutarMovimientoHaciaLaDerechaAbajo(this);
    }

    public void moverHaciaLaIzquierdaArriba()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
        movimientos.ejecutarMovimientoHaciaLaIzquierdaArriba(this);
    }

    public void moverHaciaLaIzquierdaAbajo()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
        movimientos.ejecutarMovimientoHaciaLaIzquierdaAbajo(this);
    }

    public void recibirCuracion(int vida) {
        this.vida.curar(vida);
    }
}
