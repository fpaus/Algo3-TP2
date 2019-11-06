package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
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
}
