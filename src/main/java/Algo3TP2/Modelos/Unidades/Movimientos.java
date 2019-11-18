package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Tablero.Direccion.*;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesMovimientos.MovimientoNoContiguoExcepcion;

public class Movimientos {

    public void ejecutarMovimiento(UnidadMovible unidad, Casillero destino)
            throws MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        destino.aceptarUnidad(unidad);
    }

    public void ejecutarMovimientoHaciaLaIzquierda(UnidadMovible unidad, Casillero casilleroActual)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        this.ejecutarMovimiento(unidad, casilleroActual.getCasilleroVecino(new Fija(), new Izquierda()));
    }

    public void ejecutarMovimientoHaciaLaDerecha(UnidadMovible unidad, Casillero casilleroActual)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        this.ejecutarMovimiento(unidad, casilleroActual.getCasilleroVecino(new Fija(), new Derecha()));
    }

    public void ejecutarMovimientoHaciaArriba(UnidadMovible unidad, Casillero casilleroActual)
        throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        this.ejecutarMovimiento(unidad, casilleroActual.getCasilleroVecino(new Arriba(), new Fija()));
    }

    public void ejecutarMovimientoHaciaAbajo(UnidadMovible unidad, Casillero casilleroActual)
        throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        this.ejecutarMovimiento(unidad, casilleroActual.getCasilleroVecino(new Abajo(), new Fija()));
    }

    public void ejecutarMovimientoHaciaLaIzquierdaAbajo(UnidadMovible unidad, Casillero casilleroActual)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        this.ejecutarMovimiento(unidad, casilleroActual.getCasilleroVecino(new Abajo(), new Izquierda()));
    }

    public void ejecutarMovimientoHaciaLaIzquierdaArriba(UnidadMovible unidad, Casillero casilleroActual)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        this.ejecutarMovimiento(unidad, casilleroActual.getCasilleroVecino(new Arriba(), new Izquierda()));
    }

    public void ejecutarMovimientoHaciaLaDerechaAbajo(UnidadMovible unidad, Casillero casilleroActual)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        this.ejecutarMovimiento(unidad, casilleroActual.getCasilleroVecino(new Abajo(), new Derecha()));
    }

    public void ejecutarMovimientoHaciaLaDerechaArriba(UnidadMovible unidad, Casillero casilleroActual)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        this.ejecutarMovimiento(unidad, casilleroActual.getCasilleroVecino(new Arriba(), new Derecha()));
    }
}
