package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Tablero.Direccion.*;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesMovimientos.MovimientoNoContiguoExcepcion;

public class Movimientos {

    public void ejecutarMovimiento(Unidad unidad, Casillero destino)
            throws MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion {
        destino.aceptarUnidad(unidad);
    }

    public void ejecutarMovimientoHaciaLaIzquierda(Unidad unidad, Casillero casilleroActual)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion {
        this.ejecutarMovimiento(unidad, casilleroActual.getCasilleroVecino(new Fija(), new Izquierda()));
    }

    public void ejecutarMovimientoHaciaLaDerecha(Unidad unidad, Casillero casilleroActual)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion {
        this.ejecutarMovimiento(unidad, casilleroActual.getCasilleroVecino(new Fija(), new Derecha()));
    }

    public void ejecutarMovimientoHaciaArriba(Unidad unidad, Casillero casilleroActual)
        throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion {
        this.ejecutarMovimiento(unidad, casilleroActual.getCasilleroVecino(new Arriba(), new Fija()));
    }

    public void ejecutarMovimientoHaciaAbajo(Unidad unidad, Casillero casilleroActual)
        throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion {
        this.ejecutarMovimiento(unidad, casilleroActual.getCasilleroVecino(new Abajo(), new Fija()));
    }

    public void ejecutarMovimientoHaciaLaIzquierdaAbajo(Unidad unidad, Casillero casilleroActual)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion {
        this.ejecutarMovimiento(unidad, casilleroActual.getCasilleroVecino(new Abajo(), new Izquierda()));
    }

    public void ejecutarMovimientoHaciaLaIzquierdaArriba(Unidad unidad, Casillero casilleroActual)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion {
        this.ejecutarMovimiento(unidad, casilleroActual.getCasilleroVecino(new Arriba(), new Izquierda()));
    }

    public void ejecutarMovimientoHaciaLaDerechaAbajo(Unidad unidad, Casillero casilleroActual)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion {
        this.ejecutarMovimiento(unidad, casilleroActual.getCasilleroVecino(new Abajo(), new Derecha()));
    }

    public void ejecutarMovimientoHaciaLaDerechaArriba(Unidad unidad, Casillero casilleroActual)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion {
        this.ejecutarMovimiento(unidad, casilleroActual.getCasilleroVecino(new Arriba(), new Derecha()));
    }
}
