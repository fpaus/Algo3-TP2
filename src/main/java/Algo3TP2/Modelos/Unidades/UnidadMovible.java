package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesMovimientos.MovimientoNoContiguoExcepcion;

public abstract class UnidadMovible extends Unidad {

    Movimientos movimientos = new Movimientos();

    public void mover(Casillero destino) throws MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        movimientos.ejecutarMovimiento(this, destino);
    }

    public void moverHaciaArriba() throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoNoContiguoExcepcion,
            CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        movimientos.ejecutarMovimientoHaciaArriba(this, this.casillero);
    }

    public void moverHaciaAbajo() throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoNoContiguoExcepcion,
            CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        movimientos.ejecutarMovimientoHaciaAbajo(this, this.casillero);
    }

    public void moverHaciaLaDerecha() throws CasilleroFueraDelLosLimitesDelTableroExcepcion,
            MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        movimientos.ejecutarMovimientoHaciaLaDerecha(this, this.casillero);
    }

    public void moverHaciaLaIzquierda() throws CasilleroFueraDelLosLimitesDelTableroExcepcion,
            MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        movimientos.ejecutarMovimientoHaciaLaIzquierda(this, this.casillero);
    }

    public void moverHaciaLaDerechaArriba() throws CasilleroFueraDelLosLimitesDelTableroExcepcion,
            MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        movimientos.ejecutarMovimientoHaciaLaDerechaArriba(this, this.casillero);
    }

    public void moverHaciaLaDerechaAbajo() throws CasilleroFueraDelLosLimitesDelTableroExcepcion,
            MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        movimientos.ejecutarMovimientoHaciaLaDerechaAbajo(this, this.casillero);
    }

    public void moverHaciaLaIzquierdaArriba() throws CasilleroFueraDelLosLimitesDelTableroExcepcion,
            MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        movimientos.ejecutarMovimientoHaciaLaIzquierdaArriba(this, this.casillero);
    }

    public void moverHaciaLaIzquierdaAbajo() throws CasilleroFueraDelLosLimitesDelTableroExcepcion,
            MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        movimientos.ejecutarMovimientoHaciaLaIzquierdaAbajo(this, this.casillero);
    }

    public void recibirCuracion(int vida) {
        this.vida.recibirCuracion(vida);
    }

    public void moverACasillero(Casillero casillero) throws CasilleroVacioExcepcion {

        this.casillero.quitarUnidad();
        this.casillero = casillero;

	}
}
