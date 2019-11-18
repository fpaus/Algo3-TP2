package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Tablero.Direccion.*;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Unidades.ExcepcionesMovimientos.MovimientoNoContiguoExcepcion;

public class Movimientos {

    private int medirDistanciaEnX(Casillero origen, Casillero destino) {
        int origenCoordenadaX = origen.getCoordenadaX();
        int destinoCoordenadaX = destino.getCoordenadaX();
        return (Math.abs(origenCoordenadaX - destinoCoordenadaX));
    }

    private int medirDistanciaEnY(Casillero origen, Casillero destino) {
        int origenCoordenadaY = origen.getCoordenadaY();
        int destinoCoordenadaY = destino.getCoordenadaY();
        return (Math.abs(origenCoordenadaY - destinoCoordenadaY));
    }

    private void validarMovimiento(Casillero origen, Casillero destino) throws MovimientoNoContiguoExcepcion {
        int distanciaEnX = this.medirDistanciaEnX(origen, destino);
        int distanciaEnY = this.medirDistanciaEnY(origen, destino);
        boolean condicionDistancia = (distanciaEnX <= 1 && distanciaEnY <= 1);
        if (!condicionDistancia) {
            throw new MovimientoNoContiguoExcepcion();
        }
    }

    public void ejecutarMovimiento(Unidad unidad, Casillero destino)
            throws MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion {
        destino.aceptarUnidad(unidad);
        
        
                // Casillero origen = unidad.getCasillero();
        // validarMovimiento(origen, destino);
        // destino.setUnidad(unidad);
        // try {
        //     origen.quitarUnidad();
        // }catch (CasilleroVacioExcepcion ex){
        //     // Nunca deberia de suceder, no me gusta la idea de que mover pueda retornar un Excepcion de este tipo
        // }
        // unidad.colocarEnCasillero(destino);
    }

    public void ejecutarMovimientoHaciaLaIzquierda(Unidad unidad, Casillero casilleroActual)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoNoContiguoExcepcion, CasilleroOcupadoExcepcion {
        this.ejecutarMovimiento(unidad, casilleroActual.getCasilleroVecino(new Fija(), new Izquierda()));


        //this.ejecutarMovimiento(unidad, casilleroActual.casilleroALaIzquierda());
        
        
                // int coordActualEnX = unidad.getCasillero().getCoordenadaX();
        // int coordActualEnY = unidad.getCasillero().getCoordenadaY();
        // Casillero casilleroDestino = Tablero.getTablero().getCasilleroEnPosicion(coordActualEnX-1,coordActualEnY);
        // this.ejecutarMovimiento(unidad, casilleroDestino);
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
