package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Tablero.Direccion.Direccion;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesBatallon.BatallonIncompletoExcepcion;

public abstract class UnidadMovible extends Unidad {

    Movimientos movimientos = new Movimientos();

    public void mover(Casillero destino) throws CasilleroOcupadoExcepcion {
        movimientos.ejecutarMovimiento(this, destino);
    }

    public void moverEnDireccion(Direccion horizontal, Direccion vertical)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion, BatallonIncompletoExcepcion {
        movimientos.ejecutarMovimientoEnDireccion(this, this.casillero, horizontal, vertical);
    }

    public void moverHaciaArriba() throws CasilleroFueraDelLosLimitesDelTableroExcepcion,
            CasilleroOcupadoExcepcion, BatallonIncompletoExcepcion {
        movimientos.ejecutarMovimientoHaciaArriba(this, this.casillero);
    }

    public void moverHaciaAbajo() throws CasilleroFueraDelLosLimitesDelTableroExcepcion,
            CasilleroOcupadoExcepcion, BatallonIncompletoExcepcion {
        movimientos.ejecutarMovimientoHaciaAbajo(this, this.casillero);
    }

    public void moverHaciaLaDerecha() throws CasilleroFueraDelLosLimitesDelTableroExcepcion
            , CasilleroOcupadoExcepcion, BatallonIncompletoExcepcion {
        movimientos.ejecutarMovimientoHaciaLaDerecha(this, this.casillero);
    }

    public void moverHaciaLaIzquierda() throws CasilleroFueraDelLosLimitesDelTableroExcepcion
            , CasilleroOcupadoExcepcion, BatallonIncompletoExcepcion {
        movimientos.ejecutarMovimientoHaciaLaIzquierda(this, this.casillero);
    }

    public void moverHaciaLaDerechaArriba() throws CasilleroFueraDelLosLimitesDelTableroExcepcion
            , CasilleroOcupadoExcepcion, BatallonIncompletoExcepcion {
        movimientos.ejecutarMovimientoHaciaLaDerechaArriba(this, this.casillero);
    }

    public void moverHaciaLaDerechaAbajo() throws CasilleroFueraDelLosLimitesDelTableroExcepcion
            , CasilleroOcupadoExcepcion, BatallonIncompletoExcepcion {
        movimientos.ejecutarMovimientoHaciaLaDerechaAbajo(this, this.casillero);
    }

    public void moverHaciaLaIzquierdaArriba() throws CasilleroFueraDelLosLimitesDelTableroExcepcion
            , CasilleroOcupadoExcepcion, BatallonIncompletoExcepcion {
        movimientos.ejecutarMovimientoHaciaLaIzquierdaArriba(this, this.casillero);
    }

    public void moverHaciaLaIzquierdaAbajo() throws CasilleroFueraDelLosLimitesDelTableroExcepcion
            , CasilleroOcupadoExcepcion, BatallonIncompletoExcepcion {
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
