package Algo3TP2.Controladores;

import Algo3TP2.Modelos.Casillero.Casillero;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Juego;
import Algo3TP2.Modelos.Jugador.ExcepcionesJugador.JugadorSinUnidadesExcepcion;
import Algo3TP2.Modelos.Jugador.ExcepcionesJugador.UnidadInvalidaException;
import Algo3TP2.Modelos.Jugador.Jugador;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.DistanciaDeAtaqueIncorrectaExcepcion;
import Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque.UnidadAtacadaEsAliadaExcepcion;
import Algo3TP2.Modelos.Unidades.IUnidadDeAtaque;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Vistas.JuegoView.JuegoView;
import Algo3TP2.Vistas.TableroView;
import Algo3TP2.Vistas.UnidadesViewEnJuego;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ClickAtaqueCasilleroHandler implements EventHandler<MouseEvent> {

    private IUnidadDeAtaque unidadAtacante;
    private Casillero casilleroVictima;
    private Juego juego;

    public  ClickAtaqueCasilleroHandler(IUnidadDeAtaque unidadAtacante, Casillero casilleroVictima,  Juego juego){
        this.casilleroVictima = casilleroVictima;
        this.unidadAtacante = unidadAtacante;
        this.juego = juego;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        Jugador jugadorTurnoActual = juego.getJugadorTurnoActual();

        try {
            jugadorTurnoActual.atacarConUnidadACasillero(unidadAtacante, casilleroVictima);
            JuegoView.getJuegoView().setPanelDeControlViewEnBlanco();
            juego.avanzarTurno();
        } catch (CasilleroVacioExcepcion | DistanciaDeAtaqueIncorrectaExcepcion | UnidadInvalidaException | UnidadAtacadaEsAliadaExcepcion  e) {
            AlertBox.display("Alert",e.getMessage());
        } catch (JugadorSinUnidadesExcepcion e){
            FinDelJuegoAlert.display(jugadorTurnoActual);
        } finally {
            TableroView tableroView = JuegoView.getJuegoView().getTableroView();
            tableroView.cambiarAModoSeleccionDeUnidad();
        }
    }
}
