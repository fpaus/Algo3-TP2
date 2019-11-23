package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Tablero.Distancia;
import Algo3TP2.Modelos.Unidades.ExcepcionesCurar.AliadoConSaludCompletaNoSePuedeCurarExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesCurar.CatapultaNoPuedeSerCuradaExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesCurar.DistanciaParaCurarIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesCurar.UnidadCuradaEsEnemigaExcepcion;
import Algo3TP2.Properties;

public class Curandero extends UnidadMovible {

    public Curandero(Bando bando) {
        this.costo = Properties.costoCurandero;
        this.bando = bando;
        this.vida = new Salud(Properties.vidaCurandero);
    }

    private void validarCuracion(Unidad unidadACurar)
            throws DistanciaParaCurarIncorrectaExcepcion, AliadoConSaludCompletaNoSePuedeCurarExcepcion
            , UnidadCuradaEsEnemigaExcepcion {
        if (!this.bando.equals(unidadACurar.bando)) {
            throw new UnidadCuradaEsEnemigaExcepcion();
        }

        Casillero casilleroCurandero = this.getCasillero();
        Casillero casilleroACurar = unidadACurar.getCasillero();
        Distancia distancia = casilleroCurandero.getCoordenada().distanciaACoordenada(casilleroACurar.getCoordenada());
        boolean condicionDistancia = (distancia.getValor() <= Properties.alcanceMaxDistanciaCorta);
        if (!condicionDistancia) {
            throw new DistanciaParaCurarIncorrectaExcepcion();
        }
        if (unidadACurar.getVida() == unidadACurar.getVidaMaxima()) {
            throw new AliadoConSaludCompletaNoSePuedeCurarExcepcion();
        }
    }

    public void curar(UnidadMovible unidadACurar)
            throws  AliadoConSaludCompletaNoSePuedeCurarExcepcion,
            DistanciaParaCurarIncorrectaExcepcion, UnidadCuradaEsEnemigaExcepcion {
        this.validarCuracion(unidadACurar);
        unidadACurar.recibirCuracion(Properties.curacionCurandero);

    }

    //Curar Solo para catapultas
    public void curar(Unidad unidadACurar)
            throws CatapultaNoPuedeSerCuradaExcepcion {
        throw new CatapultaNoPuedeSerCuradaExcepcion();
    }

}
