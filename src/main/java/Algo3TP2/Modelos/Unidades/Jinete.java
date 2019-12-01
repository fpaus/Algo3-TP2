package Algo3TP2.Modelos.Unidades;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Jugador.ExcepcionesJugador.UnidadInvalidaException;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.AtaqueDeJIneteConArcoYFlecha;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.AtaqueDeJineteConEspada;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.EstrategiaDeAtaque;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Observable;
import Algo3TP2.ObservadorEstrategiaDeAtaqueDeJinete;
import Algo3TP2.Properties;

import java.util.ArrayList;

public class Jinete extends UnidadMovible implements IUnidadDeAtaque, Observable {

    private EstrategiaDeAtaque estrategiaDeAtaque;
    private ArrayList<ObservadorEstrategiaDeAtaqueDeJinete> observadores;


    public Jinete(Bando bando) {
        this.costo = Properties.costoJinete;
        this.vida = new Salud(Properties.vidaJinete);
        this.bando = bando;
    }

    @Override
    public void atacar(Unidad unidadVictima)
            throws UnidadAtacadaEsAliadaExcepcion, DistanciaDeAtaqueIncorrectaExcepcion, UnidadInvalidaException {
        this.definirEstragegiaDeAtaque();
        estrategiaDeAtaque.atacar(this, unidadVictima);
    }

    private void setEstrategiaDeAtaque(EstrategiaDeAtaque estragia) {
        this.estrategiaDeAtaque = estragia;
        this.notificarObservadores();
    }

    private void definirEstragegiaDeAtaque() {
        ArrayList<Casillero> casilleros = this.casillero.getTodosLosCasillerosVecinos();
        ArrayList<Casillero> casillerosDistanciaCercana = new ArrayList<Casillero>();
        // Me hago con todos los casilleros a distancia cercana 2
        for (Casillero casillero : casilleros) {
            casillerosDistanciaCercana.addAll(casillero.getTodosLosCasillerosVecinos());
        }
        // Busco si en los casilleros que se encuentran a distancia 2 hay alguna unidad enemiga,
        // de ser asi seteo la estrategia de ataque en AtaqueDeJineteConEspada
        for (Casillero casillero : casillerosDistanciaCercana) {
            try {
                Unidad unidadCercana = casillero.getUnidad();
                if (this.bando != unidadCercana.bando) {
                    this.setEstrategiaDeAtaque(new AtaqueDeJineteConEspada());
                    return;
                }
            } catch (CasilleroVacioExcepcion e) {
            }
        }
        this.setEstrategiaDeAtaque(new AtaqueDeJIneteConArcoYFlecha());
    }

    public void enlazarObservador(ObservadorEstrategiaDeAtaqueDeJinete observador){
        this.observadores.add(observador);
    }

    @Override
    public void notificarObservadores() {
        this.observadores.forEach(observador -> observador.actualizar(this.estrategiaDeAtaque));
    }
}
