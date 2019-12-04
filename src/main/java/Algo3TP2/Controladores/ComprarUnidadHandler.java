package Algo3TP2.Controladores;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Jugador.ExcepcionesJugador.UnidadInvalidaException;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.UnidadAbstractFactory.UnidadFactory;
import Algo3TP2.UnidadAbstractFactory.UnidadesAbstractFactory;
import Algo3TP2.Vistas.JuegoView;
import Algo3TP2.Vistas.TableroView;
import Algo3TP2.Vistas.UnidadesViewEnJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ComprarUnidadHandler implements EventHandler<ActionEvent> {

    UnidadFactory unidadFactory;
    String tipoDeUnidad;
    Bando bando;

    public ComprarUnidadHandler(String colorEquipo, String tipoDeUnidad, Bando bando){
        this.unidadFactory = UnidadesAbstractFactory.getFactory(colorEquipo);
        this.tipoDeUnidad = tipoDeUnidad;
        this.bando = bando;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        TableroView tableroView = JuegoView.getJuegoView().getTableroView();
        UnidadesViewEnJuego unidadesViewEnJuego = UnidadesViewEnJuego.getUnidadView();

        try {
            Unidad unidad = unidadFactory.getUnidad(this.tipoDeUnidad, this.bando);
            tableroView.cambiarAModoSetearUnidad(unidad, unidadesViewEnJuego.getUnidadView(unidad));
        } catch (UnidadInvalidaException e) {
            e.printStackTrace();
        }
    }
}
