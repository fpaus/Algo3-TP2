package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Tablero.Direccion.*;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesBatallon.BatallonIncompletoExcepcion;

public abstract class UnidadMovible extends Unidad {

    public void mover(Casillero destino) throws CasilleroOcupadoExcepcion {
        this.ejecutarMovimiento(this, destino);
    }

    private void ejecutarMovimiento(UnidadMovible unidad, Casillero destino)
            throws CasilleroOcupadoExcepcion {
        destino.aceptarUnidad(unidad);
    }

    private void ejecutarMovimientoEnDireccion(UnidadMovible unidad, Casillero casilleroActual ,Direccion horizontal, Direccion vertical)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion {
        this.ejecutarMovimiento(unidad, casilleroActual.getCasilleroVecino(horizontal, vertical));
    }

    public void moverEnDireccion(Direccion horizontal, Direccion vertical)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, CasilleroOcupadoExcepcion, BatallonIncompletoExcepcion {
        this.ejecutarMovimientoEnDireccion(this, this.casillero, horizontal, vertical);
    }

    public void moverHaciaArriba() throws CasilleroFueraDelLosLimitesDelTableroExcepcion,
            CasilleroOcupadoExcepcion, BatallonIncompletoExcepcion {
        this.ejecutarMovimientoEnDireccion(this, this.casillero, new Fija(), new Arriba());
    }

    public void moverHaciaAbajo() throws CasilleroFueraDelLosLimitesDelTableroExcepcion,
            CasilleroOcupadoExcepcion, BatallonIncompletoExcepcion {
        this.ejecutarMovimientoEnDireccion(this, this.casillero, new Fija(), new Abajo());
    }

    public void moverHaciaLaDerecha() throws CasilleroFueraDelLosLimitesDelTableroExcepcion
            , CasilleroOcupadoExcepcion, BatallonIncompletoExcepcion {
        this.ejecutarMovimientoEnDireccion(this, this.casillero, new Derecha(), new Fija());
    }

    public void moverHaciaLaIzquierda() throws CasilleroFueraDelLosLimitesDelTableroExcepcion
            , CasilleroOcupadoExcepcion, BatallonIncompletoExcepcion {
        this.ejecutarMovimientoEnDireccion(this, this.casillero, new Izquierda(), new Fija());
    }

    public void moverHaciaLaDerechaArriba() throws CasilleroFueraDelLosLimitesDelTableroExcepcion
            , CasilleroOcupadoExcepcion, BatallonIncompletoExcepcion {
        this.ejecutarMovimientoEnDireccion(this, this.casillero, new Derecha(), new Arriba());
    }

    public void moverHaciaLaDerechaAbajo() throws CasilleroFueraDelLosLimitesDelTableroExcepcion
            , CasilleroOcupadoExcepcion, BatallonIncompletoExcepcion {
        this.ejecutarMovimientoEnDireccion(this, this.casillero, new Derecha(), new Abajo());
    }

    public void moverHaciaLaIzquierdaArriba() throws CasilleroFueraDelLosLimitesDelTableroExcepcion
            , CasilleroOcupadoExcepcion, BatallonIncompletoExcepcion {
        this.ejecutarMovimientoEnDireccion(this, this.casillero, new Izquierda(), new Arriba());
    }

    public void moverHaciaLaIzquierdaAbajo() throws CasilleroFueraDelLosLimitesDelTableroExcepcion
            , CasilleroOcupadoExcepcion, BatallonIncompletoExcepcion {
        this.ejecutarMovimientoEnDireccion(this, this.casillero, new Izquierda(), new Abajo());
    }

    public void recibirCuracion(float vida) {
        this.vida.recibirCuracion(vida, this);
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
