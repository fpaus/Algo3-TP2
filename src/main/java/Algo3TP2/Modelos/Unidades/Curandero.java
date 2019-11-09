package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Tablero.Tablero;
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

    private void validarCuracion(Unidad unidadACurar)
            throws DistanciaParaCurarIncorrectaExcepcion, AliadoConSaludCompletaNoSePuedeCurarExcepcion,
            CatapultaNoPuedeSerCuradaExcepcion, UnidadCuradaEsEnemigaExcepcion {
        if (this.duenio.getDuenio() != unidadACurar.duenio.getDuenio()) {
            throw new UnidadCuradaEsEnemigaExcepcion();
        }

        Casillero casilleroCurandero = this.getCasillero();
        Casillero casilleroACurar = unidadACurar.getCasillero();
        int distanciaEnX = Tablero.getTablero().medirDistanciaEnXDeCasilleroACasillero(casilleroCurandero,casilleroACurar);
        int distanciaEnY = Tablero.getTablero().medirDistanciaEnYDeCasilleroACasillero(casilleroCurandero,casilleroACurar);
        boolean condicionDistancia = (distanciaEnX <= Properties.alcanceMaxDistanciaCorta
                && distanciaEnY <= Properties.alcanceMaxDistanciaCorta);
        if (!condicionDistancia) {
            throw new DistanciaParaCurarIncorrectaExcepcion();
        }
        if (unidadACurar.getVida() == unidadACurar.getVidaMaxima()) {
            throw new AliadoConSaludCompletaNoSePuedeCurarExcepcion();
        }
    }

    public void curar(UnidadMovible unidadACurar)
            throws CatapultaNoPuedeSerCuradaExcepcion, AliadoConSaludCompletaNoSePuedeCurarExcepcion,
            DistanciaParaCurarIncorrectaExcepcion, UnidadCuradaEsEnemigaExcepcion {
        this.validarCuracion(unidadACurar);
        unidadACurar.recibirCuracion(Properties.curacionCurandero);

    }

}
