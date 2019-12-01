package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Tablero.Direccion.Direccion;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;

public abstract class UnidadMovible extends Unidad {

    Movimientos movimientos = new Movimientos();

    public void mover(Casillero destino) throws CasilleroOcupadoExcepcion {
        movimientos.ejecutarMovimiento(this, destino);
    }

    public void moverEnDireccion(Direccion horizontal, Direccion vertical)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion {
        movimientos.ejecutarMovimientoEnDireccion(this, this.casillero, horizontal, vertical);
    }

    public void moverHaciaArriba() throws CasilleroFueraDelLosLimitesDelTableroExcepcion,
            CasilleroOcupadoExcepcion {
        movimientos.ejecutarMovimientoHaciaArriba(this, this.casillero);
    }

    public void moverHaciaAbajo() throws CasilleroFueraDelLosLimitesDelTableroExcepcion,
            CasilleroOcupadoExcepcion {
        movimientos.ejecutarMovimientoHaciaAbajo(this, this.casillero);
    }

    public void moverHaciaLaDerecha() throws CasilleroFueraDelLosLimitesDelTableroExcepcion
            , CasilleroOcupadoExcepcion {
        movimientos.ejecutarMovimientoHaciaLaDerecha(this, this.casillero);
    }

    public void moverHaciaLaIzquierda() throws CasilleroFueraDelLosLimitesDelTableroExcepcion
            , CasilleroOcupadoExcepcion {
        movimientos.ejecutarMovimientoHaciaLaIzquierda(this, this.casillero);
    }

    public void moverHaciaLaDerechaArriba() throws CasilleroFueraDelLosLimitesDelTableroExcepcion
            , CasilleroOcupadoExcepcion {
        movimientos.ejecutarMovimientoHaciaLaDerechaArriba(this, this.casillero);
    }

    public void moverHaciaLaDerechaAbajo() throws CasilleroFueraDelLosLimitesDelTableroExcepcion
            , CasilleroOcupadoExcepcion {
        movimientos.ejecutarMovimientoHaciaLaDerechaAbajo(this, this.casillero);
    }

    public void moverHaciaLaIzquierdaArriba() throws CasilleroFueraDelLosLimitesDelTableroExcepcion
            , CasilleroOcupadoExcepcion {
        movimientos.ejecutarMovimientoHaciaLaIzquierdaArriba(this, this.casillero);
    }

    public void moverHaciaLaIzquierdaAbajo() throws CasilleroFueraDelLosLimitesDelTableroExcepcion
            , CasilleroOcupadoExcepcion {
        movimientos.ejecutarMovimientoHaciaLaIzquierdaAbajo(this, this.casillero);
    }

    public void recibirCuracion(float vida) {
        this.vida.recibirCuracion(vida);
    }

    public void moverACasillero(Casillero casillero) {

        try {
            this.casillero.quitarUnidad();
        } catch (CasilleroVacioExcepcion ex){
            // Nunca estara Vacio
        }
        this.casillero = casillero;

    }
}
