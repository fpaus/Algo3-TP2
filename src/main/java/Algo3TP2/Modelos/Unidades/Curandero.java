package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Unidades.ExcepcionesCurar.AliadoConSaludCompletaNoSePuedeCurarExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesCurar.CatapultaNoPuedeSerCuradaExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesCurar.DistanciaParaCurarIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesCurar.UnidadCuradaEsEnemigaExcepcion;
import Algo3TP2.Properties;

public class Curandero extends UnidadMovible {

    public Curandero(Bando bando) {
        this.costo = Properties.costoCurandero;
        this.duenio = bando;
        this.vida = new Salud(Properties.vidaCurandero);
    }

    @Override
    public void mover(Casillero casillero) {

    }

    private int medirDistanciaEnX(Unidad unidadActual, Unidad unidadAliada) {
        int unidadActualCoordenadaX = unidadActual.getCasillero().getCoordenadaX();
        int unidadAliadaCoordenadaX = unidadAliada.getCasillero().getCoordenadaX();
        return (Math.abs(unidadAliadaCoordenadaX - unidadActualCoordenadaX));
    }

    private int medirDistanciaEnY(Unidad unidadActual, Unidad unidadAliada) {
        int unidadActualCoordenadaY = unidadActual.getCasillero().getCoordenadaY();
        int unidadAliadaCoordenadaY = unidadAliada.getCasillero().getCoordenadaY();
        return (Math.abs(unidadAliadaCoordenadaY - unidadActualCoordenadaY));
    }

    private void validarCuracion(Unidad unidadAliada)
            throws DistanciaParaCurarIncorrectaExcepcion, AliadoConSaludCompletaNoSePuedeCurarExcepcion,
            CatapultaNoPuedeSerCuradaExcepcion, UnidadCuradaEsEnemigaExcepcion {
        if (this.duenio.getDuenio() != unidadAliada.duenio.getDuenio()) {
            throw new UnidadCuradaEsEnemigaExcepcion();
        }
        int distanciaEnX = this.medirDistanciaEnX(this, unidadAliada);
        int distanciaEnY = this.medirDistanciaEnY(this, unidadAliada);
        boolean condicionDistancia = (distanciaEnX <= Properties.alcanceMaxDistanciaCorta
                && distanciaEnY <= Properties.alcanceMaxDistanciaCorta);
        if (!condicionDistancia) {
            throw new DistanciaParaCurarIncorrectaExcepcion();
        }
        if (unidadAliada.getVida() == unidadAliada.getVidaMaxima()) {
            throw new AliadoConSaludCompletaNoSePuedeCurarExcepcion();
        }
    }

    public void curar(UnidadMovible unidadAliada)
            throws CatapultaNoPuedeSerCuradaExcepcion, AliadoConSaludCompletaNoSePuedeCurarExcepcion,
            DistanciaParaCurarIncorrectaExcepcion, UnidadCuradaEsEnemigaExcepcion {
        this.validarCuracion(unidadAliada);
        unidadAliada.curar(Properties.curacionCurandero);

    }

}
