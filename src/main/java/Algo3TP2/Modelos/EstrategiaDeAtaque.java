package Algo3TP2.Modelos;

import Algo3TP2.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;

public abstract class EstrategiaDeAtaque {

    public abstract void atacar(Unidad unidadAtacante,Unidad unidadVictima) throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion;

    public abstract void validarAtaque(Unidad unidadAtacante,Unidad unidadVictima) throws DistanciaDeAtaqueIncorrectaExcepcion, UnidadAtacadaEsAliadaExcepcion;

    protected int medirDistanciaEnX(Unidad unidadAtacante, Unidad unidadVictima) {
        int unidadAtacanteCoordenadaX = unidadAtacante.getCasillero().getCoordenadaX();
        int unidadVictimaCoordenadaX = unidadVictima.getCasillero().getCoordenadaX();
        return (int)(Math.abs(unidadVictimaCoordenadaX - unidadAtacanteCoordenadaX));
    }

    protected int medirDistanciaEnY(Unidad unidadAtacante, Unidad unidadVictima) {
        int unidadAtacanteCoordenadaY = unidadAtacante.getCasillero().getCoordenadaY();
        int unidadVictimaCoordenadaY = unidadVictima.getCasillero().getCoordenadaY();
        return (int)(Math.abs(unidadVictimaCoordenadaY - unidadAtacanteCoordenadaY));
    }

    protected void unidadVictimaEsEnemigaDeUnidadAtacante(Unidad unidadAtacante, Unidad unidadVictima) throws UnidadAtacadaEsAliadaExcepcion{
        Jugador jugadorAtacante = unidadAtacante.getBando().getDuenio();
        Jugador jugadorVictima = unidadVictima.getBando().getDuenio();
        if(jugadorAtacante == jugadorVictima){
            throw new UnidadAtacadaEsAliadaExcepcion();
        }
    }
}
