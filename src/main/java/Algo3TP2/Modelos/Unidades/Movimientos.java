package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Tablero.Direccion.*;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;

public class Movimientos {

    public void ejecutarMovimiento(UnidadMovible unidad, Casillero destino)
            throws CasilleroOcupadoExcepcion {
        destino.aceptarUnidad(unidad);
    }

    public void ejecutarMovimientoHaciaLaIzquierda(UnidadMovible unidad, Casillero casilleroActual)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion {
        this.ejecutarMovimiento(unidad, casilleroActual.getCasilleroVecino(new Izquierda(), new Fija()));
    }

    public void ejecutarMovimientoHaciaLaDerecha(UnidadMovible unidad, Casillero casilleroActual)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion {
        this.ejecutarMovimiento(unidad, casilleroActual.getCasilleroVecino(new Derecha(), new Fija()));
    }

    public void ejecutarMovimientoHaciaArriba(UnidadMovible unidad, Casillero casilleroActual)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion {
        this.ejecutarMovimiento(unidad, casilleroActual.getCasilleroVecino(new Fija(), new Arriba()));
    }

    public void ejecutarMovimientoHaciaAbajo(UnidadMovible unidad, Casillero casilleroActual)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion {
        this.ejecutarMovimiento(unidad, casilleroActual.getCasilleroVecino(new Fija(), new Abajo()));
    }

    public void ejecutarMovimientoHaciaLaIzquierdaAbajo(UnidadMovible unidad, Casillero casilleroActual)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion {
        this.ejecutarMovimiento(unidad, casilleroActual.getCasilleroVecino(new Izquierda(), new Abajo()));
    }

    public void ejecutarMovimientoHaciaLaIzquierdaArriba(UnidadMovible unidad, Casillero casilleroActual)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion {
        this.ejecutarMovimiento(unidad, casilleroActual.getCasilleroVecino(new Izquierda(), new Arriba()));
    }

    public void ejecutarMovimientoHaciaLaDerechaAbajo(UnidadMovible unidad, Casillero casilleroActual)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion {
        this.ejecutarMovimiento(unidad, casilleroActual.getCasilleroVecino(new Derecha(), new Abajo()));
    }

    public void ejecutarMovimientoHaciaLaDerechaArriba(UnidadMovible unidad, Casillero casilleroActual)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion {
        this.ejecutarMovimiento(unidad, casilleroActual.getCasilleroVecino(new Derecha(), new Arriba()));
    }

    public void ejecutarMovimientoEnDireccion(UnidadMovible unidad, Casillero casilleroActual ,Direccion horizontal, Direccion vertical)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion, CasilleroVacioExcepcion {
        this.ejecutarMovimiento(unidad, casilleroActual.getCasilleroVecino(horizontal, vertical));
    }
}
