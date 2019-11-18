package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesMovimientos.MovimientoNoContiguoExcepcion;

public abstract class UnidadMovible extends Unidad {

    Movimientos movimientos = new Movimientos();

    public void mover(Casillero destino) throws MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion {
        movimientos.ejecutarMovimiento(this, destino);
    }

    public void moverHaciaArriba()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion {
        movimientos.ejecutarMovimientoHaciaArriba(this, this.casillero);
    }

    public void moverHaciaAbajo()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion {
        movimientos.ejecutarMovimientoHaciaAbajo(this, this.casillero);
    }

    public void moverHaciaLaDerecha()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion {
        movimientos.ejecutarMovimientoHaciaLaDerecha(this, this.casillero);
    }

    public void moverHaciaLaIzquierda()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion {
        movimientos.ejecutarMovimientoHaciaLaIzquierda(this, this.casillero);
    }

    public void moverHaciaLaDerechaArriba()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion {
        movimientos.ejecutarMovimientoHaciaLaDerechaArriba(this, this.casillero);
    }

    public void moverHaciaLaDerechaAbajo()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion {
        movimientos.ejecutarMovimientoHaciaLaDerechaAbajo(this, this.casillero);
    }

    public void moverHaciaLaIzquierdaArriba()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion {
        movimientos.ejecutarMovimientoHaciaLaIzquierdaArriba(this, this.casillero);
    }

    public void moverHaciaLaIzquierdaAbajo()
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion {
        movimientos.ejecutarMovimientoHaciaLaIzquierdaAbajo(this, this.casillero);
    }

    public void recibirCuracion(int vida) {
        this.vida.recibirCuracion(vida);
    }
}
