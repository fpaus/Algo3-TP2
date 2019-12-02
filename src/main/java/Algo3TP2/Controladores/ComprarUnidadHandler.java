package Algo3TP2.Controladores;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Jugador.Jugador;
import Algo3TP2.Modelos.Unidades.Soldado;
import Algo3TP2.Vistas.JuegoView;
import Algo3TP2.Vistas.PanelDeControlUnidadView.PanelDeControlSoldadoView;
import Algo3TP2.Vistas.PanelDeControlView;
import Algo3TP2.Vistas.TableroView;
import Algo3TP2.Vistas.UnidadesView.SoldadoView.SoldadoAzulView;
import Algo3TP2.Vistas.UnidadesViewEnJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ComprarUnidadHandler implements EventHandler<ActionEvent> {

    public ComprarUnidadHandler(){
        // Super hardcodeada solo compra un soldado de mierda azul y ni siquiera se lo asigna a un jugador
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        UnidadesViewEnJuego unidadesViewEnJuego = UnidadesViewEnJuego.getUnidadesViewEnJuego();
        Soldado soldado = new Soldado(new Bando(new Jugador("Nazareno")));
        SoldadoAzulView soldadoAzulView = new SoldadoAzulView();
        unidadesViewEnJuego.setUnidadView(soldado, soldadoAzulView);
        PanelDeControlView panelDeControlView = new PanelDeControlSoldadoView(soldado);
        unidadesViewEnJuego.setUnidadPanelDeControlView(soldado, panelDeControlView);

        TableroView tableroView = JuegoView.getJuegoView().getTableroView();
        tableroView.cambiarAModoSetearUnidad(soldado);
    }
}
