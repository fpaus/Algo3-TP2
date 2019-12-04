package Algo3TP2.UnidadAbstractFactory;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Jugador.ExcepcionesJugador.UnidadInvalidaException;
import Algo3TP2.Modelos.Unidades.*;
import Algo3TP2.Vistas.PanelDeControlUnidadView.PanelDeControlCatapultaView;
import Algo3TP2.Vistas.PanelDeControlUnidadView.PanelDeControlCuranderoView;
import Algo3TP2.Vistas.PanelDeControlUnidadView.PanelDeControlJineteView;
import Algo3TP2.Vistas.PanelDeControlUnidadView.PanelDeControlSoldadoView;
import Algo3TP2.Vistas.UnidadesView.CatapultaView.CatapultaRojaView;
import Algo3TP2.Vistas.UnidadesView.CuranderoView.CuranderoRojoView;
import Algo3TP2.Vistas.UnidadesView.JineteView.JineteRojoView;
import Algo3TP2.Vistas.UnidadesView.SoldadoView.SoldadoRojoView;
import Algo3TP2.Vistas.UnidadesViewEnJuego;

public class UnidadEquipoRojoFactory implements UnidadFactory {

    public Unidad getUnidad(String unidadTipo, Bando bando) throws UnidadInvalidaException {
        UnidadesViewEnJuego unidadesViewEnJuego = UnidadesViewEnJuego.getUnidadView();
        Unidad unidad;

        if (unidadTipo.equalsIgnoreCase("Soldado")){
            unidad = new Soldado(bando);
            unidadesViewEnJuego.setUnidadView(unidad, new SoldadoRojoView());
            unidadesViewEnJuego.setUnidadPanelDeControlView(unidad, new PanelDeControlSoldadoView(unidad));
        }else if (unidadTipo.equalsIgnoreCase("Jinete")){
            unidad = new Jinete(bando);
            unidadesViewEnJuego.setUnidadView(unidad, new JineteRojoView());
            unidadesViewEnJuego.setUnidadPanelDeControlView(unidad, new PanelDeControlJineteView(unidad));
        }else if (unidadTipo.equalsIgnoreCase("Curandero")){
            unidad = new Curandero(bando);
            unidadesViewEnJuego.setUnidadView(unidad, new CuranderoRojoView());
            unidadesViewEnJuego.setUnidadPanelDeControlView(unidad, new PanelDeControlCuranderoView(unidad));
        }else if (unidadTipo.equalsIgnoreCase("Catapulta")){
            unidad = new Catapulta(bando);
            unidadesViewEnJuego.setUnidadView(unidad, new CatapultaRojaView());
            unidadesViewEnJuego.setUnidadPanelDeControlView(unidad, new PanelDeControlCatapultaView(unidad));
        }else {
            throw new UnidadInvalidaException();
        }
        return unidad;
    }
}