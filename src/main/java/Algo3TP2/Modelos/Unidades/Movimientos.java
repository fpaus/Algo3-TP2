package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Unidades.ExcepcionesMovimientos.MovimientoInvalidoExcepcion;

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

    private void validarMovimiento(Casillero origen, Casillero destino) throws MovimientoInvalidoExcepcion {
        int distanciaEnX = this.medirDistanciaEnX(origen, destino);
        int distanciaEnY = this.medirDistanciaEnY(origen, destino);
        boolean condicionDistancia = (distanciaEnX <= 1 && distanciaEnY <= 1);
        if (!condicionDistancia) {
            throw new MovimientoInvalidoExcepcion();
        }
    }

    public void ejecutarMovimiento(Unidad unidad, Casillero destino)
            throws MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
        Casillero origen = unidad.getCasillero();
        validarMovimiento(origen, destino);
        destino.setUnidad(unidad);
        try {
            origen.quitarUnidad();
        }catch (CasilleroVacioExcepcion ex){
            // Nunca deberia de suceder, no me gusta la idea de que mover pueda retornar un Excepcion de este tipo
        }
        unidad.colocarEnCasillero(destino);
    }

    public void ejecutarMovimientoHaciaLaIzquierda(Unidad unidad)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
        int coordActualEnX = unidad.getCasillero().getCoordenadaX();
        int coordActualEnY = unidad.getCasillero().getCoordenadaY();
        Casillero casilleroDestino = Tablero.getTablero().getCasilleroEnPosicion(coordActualEnX-1,coordActualEnY);
        this.ejecutarMovimiento(unidad, casilleroDestino);
    }

    public void ejecutarMovimientoHaciaLaDerecha(Unidad unidad)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
        int coordActualEnX = unidad.getCasillero().getCoordenadaX();
        int coordActualEnY = unidad.getCasillero().getCoordenadaY();
        Casillero casilleroDestino = Tablero.getTablero().getCasilleroEnPosicion(coordActualEnX+1,coordActualEnY);
        this.ejecutarMovimiento(unidad, casilleroDestino);
    }

    public void ejecutarMovimientoHaciaArriba(Unidad unidad)
        throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
            int coordActualEnX = unidad.getCasillero().getCoordenadaX();
            int coordActualEnY = unidad.getCasillero().getCoordenadaY();
            Casillero casilleroDestino = Tablero.getTablero().getCasilleroEnPosicion(coordActualEnX,coordActualEnY+1);
            this.ejecutarMovimiento(unidad, casilleroDestino);
    }

    public void ejecutarMovimientoHaciaAbajo(Unidad unidad)
        throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
            int coordActualEnX = unidad.getCasillero().getCoordenadaX();
            int coordActualEnY = unidad.getCasillero().getCoordenadaY();
            Casillero casilleroDestino = Tablero.getTablero().getCasilleroEnPosicion(coordActualEnX,coordActualEnY-1);
            this.ejecutarMovimiento(unidad, casilleroDestino);
    }

    public void ejecutarMovimientoHaciaLaIzquierdaAbajo(Unidad unidad)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
        int coordActualEnX = unidad.getCasillero().getCoordenadaX();
        int coordActualEnY = unidad.getCasillero().getCoordenadaY();
        Casillero casilleroDestino = Tablero.getTablero().getCasilleroEnPosicion(coordActualEnX-1,coordActualEnY-1);
        this.ejecutarMovimiento(unidad, casilleroDestino);
    }

    public void ejecutarMovimientoHaciaLaIzquierdaArriba(Unidad unidad)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
        int coordActualEnX = unidad.getCasillero().getCoordenadaX();
        int coordActualEnY = unidad.getCasillero().getCoordenadaY();
        Casillero casilleroDestino = Tablero.getTablero().getCasilleroEnPosicion(coordActualEnX-1,coordActualEnY+1);
        this.ejecutarMovimiento(unidad, casilleroDestino);
    }

    public void ejecutarMovimientoHaciaLaDerechaAbajo(Unidad unidad)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
        int coordActualEnX = unidad.getCasillero().getCoordenadaX();
        int coordActualEnY = unidad.getCasillero().getCoordenadaY();
        Casillero casilleroDestino = Tablero.getTablero().getCasilleroEnPosicion(coordActualEnX+1,coordActualEnY-1);
        this.ejecutarMovimiento(unidad, casilleroDestino);
    }

    public void ejecutarMovimientoHaciaLaDerechaArriba(Unidad unidad)
            throws CasilleroFueraDelLosLimitesDelTableroExcepcion, MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
        int coordActualEnX = unidad.getCasillero().getCoordenadaX();
        int coordActualEnY = unidad.getCasillero().getCoordenadaY();
        Casillero casilleroDestino = Tablero.getTablero().getCasilleroEnPosicion(coordActualEnX+1,coordActualEnY+1);
        this.ejecutarMovimiento(unidad, casilleroDestino);
    }
}
