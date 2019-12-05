package Algo3TP2.Controladores;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Juego;
import Algo3TP2.Modelos.Jugador.ExcepcionesJugador.JugadorSinUnidadesExcepcion;
import Algo3TP2.Modelos.Jugador.ExcepcionesJugador.UnidadInvalidaException;
import Algo3TP2.Modelos.Jugador.Jugador;
import Algo3TP2.Modelos.Unidades.Curandero;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesCurar.AliadoConSaludCompletaNoSePuedeCurarExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesCurar.CatapultaNoPuedeSerCuradaExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesCurar.DistanciaParaCurarIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesCurar.UnidadCuradaEsEnemigaExcepcion;
import Algo3TP2.Modelos.Unidades.IUnidadDeAtaque;
import Algo3TP2.Vistas.JuegoView;
import Algo3TP2.Vistas.TableroView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ClickCuracionCasilleroHandler implements EventHandler<MouseEvent> {

    private Curandero curandero;
    private Casillero casilleroUnidadACurar;
    private Juego juego;

    public  ClickCuracionCasilleroHandler(Curandero curandero, Casillero casilleroUnidadACurar,  Juego juego){
        this.casilleroUnidadACurar = casilleroUnidadACurar;
        this.curandero = curandero;
        this.juego = juego;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        Jugador jugadorTurnoActual = juego.getJugadorTurnoActual();

        try {
            jugadorTurnoActual.curarConCuranderoACasillero(curandero, casilleroUnidadACurar);
            juego.avanzarTurno();
        } catch (CasilleroVacioExcepcion | AliadoConSaludCompletaNoSePuedeCurarExcepcion | DistanciaParaCurarIncorrectaExcepcion
                | UnidadCuradaEsEnemigaExcepcion | CatapultaNoPuedeSerCuradaExcepcion e) {
            AlertBox.display("Alert",e.getMessage());
        } catch (JugadorSinUnidadesExcepcion e){
            FinDelJuegoAlert.display(jugadorTurnoActual);
        } finally {
            TableroView tableroView = JuegoView.getJuegoView().getTableroView();
            tableroView.cambiarAModoSeleccionDeUnidad();
        }
    }
}