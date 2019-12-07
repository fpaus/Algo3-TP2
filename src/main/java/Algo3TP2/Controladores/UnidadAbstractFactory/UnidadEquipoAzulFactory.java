package Algo3TP2.Controladores.UnidadAbstractFactory;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Juego;
import Algo3TP2.Modelos.Jugador.ExcepcionesJugador.UnidadInvalidaException;
import Algo3TP2.Modelos.Unidades.*;
import Algo3TP2.Vistas.PanelDeControlView.PanelDeControlUnidadesView.*;
import Algo3TP2.Vistas.UnidadesView.CatapultaView.CatapultaAzulView;
import Algo3TP2.Vistas.UnidadesView.CuranderoView.CuranderoAzulView;
import Algo3TP2.Vistas.UnidadesView.JineteView.JineteAzulView;
import Algo3TP2.Vistas.UnidadesView.SoldadoView.SoldadoAzulView;
import Algo3TP2.Vistas.UnidadesViewEnJuego;

public class UnidadEquipoAzulFactory implements UnidadFactory {

    public Unidad getUnidad(String tipoDeUnidad, Bando bando, Juego juego) throws UnidadInvalidaException {
        UnidadesViewEnJuego unidadesViewEnJuego = UnidadesViewEnJuego.getUnidadView();
        Unidad unidad;

        if (tipoDeUnidad.equalsIgnoreCase("Soldado")){
            unidad = new Soldado(bando);
            unidadesViewEnJuego.setUnidadView(unidad, new SoldadoAzulView());
            unidadesViewEnJuego.setUnidadPanelDeControlView(unidad, new PanelDeControlSoldadoView(unidad, juego));
            unidadesViewEnJuego.setUnidadPanelSinControlesView(unidad, new PanelDeControlUnidadView(unidad));
        }else if (tipoDeUnidad.equalsIgnoreCase("Jinete")){
            unidad = new Jinete(bando);
            unidadesViewEnJuego.setUnidadView(unidad, new JineteAzulView());
            unidadesViewEnJuego.setUnidadPanelDeControlView(unidad, new PanelDeControlJineteView(unidad, juego));
            unidadesViewEnJuego.setUnidadPanelSinControlesView(unidad, new PanelDeControlUnidadView(unidad));
        }else if (tipoDeUnidad.equalsIgnoreCase("Curandero")){
            unidad = new Curandero(bando);
            unidadesViewEnJuego.setUnidadView(unidad, new CuranderoAzulView());
            unidadesViewEnJuego.setUnidadPanelDeControlView(unidad, new PanelDeControlCuranderoView(unidad, juego));
            unidadesViewEnJuego.setUnidadPanelSinControlesView(unidad, new PanelDeControlUnidadView(unidad));
        }else if (tipoDeUnidad.equalsIgnoreCase("Catapulta")){
            unidad = new Catapulta(bando);
            unidadesViewEnJuego.setUnidadView(unidad, new CatapultaAzulView());
            unidadesViewEnJuego.setUnidadPanelDeControlView(unidad, new PanelDeControlCatapultaView(unidad));
            unidadesViewEnJuego.setUnidadPanelSinControlesView(unidad, new PanelDeControlUnidadView(unidad));
        }else {
            throw new UnidadInvalidaException();
        }
        return unidad;
    }
}
