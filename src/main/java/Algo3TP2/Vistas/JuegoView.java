package Algo3TP2.Vistas;
import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Juego;
import Algo3TP2.Modelos.Jugador.Jugador;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Unidades.Soldado;
import Algo3TP2.Vistas.PanelDeControlUnidadView.PanelDeControlSoldadoView;
import Algo3TP2.Vistas.PanelDeControlUnidadView.PanelDeControlViewCasilleroVacio;
import Algo3TP2.Vistas.UnidadesView.SoldadoView.SoldadoAzulView;
import Algo3TP2.Vistas.UnidadesView.SoldadoView.SoldadoRojoView;
import javafx.scene.layout.BorderPane;

public class JuegoView extends BorderPane {
    /* Dentro de esta view entran todas las otras views que vamos a tener
     a nuestra disposición mientras jugamos.

     TableroView debería ser parte de JuegoView.

     */
    private static JuegoView juegoView;
    private Juego juego;
    private TableroView tableroView;
    private MercadoDeUnidadesView mercadoDeUnidadesViewDerecha;
    private MercadoDeUnidadesView mercadoDeUnidadesViewIzquierda;
    private PanelDeControlView panelDeControlView;


    public static JuegoView getJuegoView() {
        return juegoView;
    }

    public static void inicializarJuegoView(Juego juego) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {
        juegoView = new JuegoView(juego);
    }

    protected JuegoView(Juego juego) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {
        this.tableroView = new TableroView(juego);
        this.mercadoDeUnidadesViewDerecha = new MercadoDeUnidadesView("EquipoRojo", new Bando(juego.getJugador1()), juego);
        this.mercadoDeUnidadesViewIzquierda = new MercadoDeUnidadesView("EquipoAzul",new Bando(juego.getJugador2()), juego);
        this.panelDeControlView = new PanelDeControlViewCasilleroVacio();

        this.setCenter(tableroView);
        this.setRight(mercadoDeUnidadesViewDerecha);
        this.setLeft(mercadoDeUnidadesViewIzquierda);
        this.setBottom(this.panelDeControlView);
    }

    public void setPanelDeControlView(PanelDeControlView panelDeControlSoldadoView) {
        this.panelDeControlView = panelDeControlSoldadoView;
        this.setBottom(panelDeControlSoldadoView);
    }

    public TableroView getTableroView() {
        return this.tableroView;
    }
}
