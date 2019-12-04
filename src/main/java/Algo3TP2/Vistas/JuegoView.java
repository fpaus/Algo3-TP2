package Algo3TP2.Vistas;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Jugador.Jugador;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Vistas.PanelDeControlUnidadView.PanelDeControlViewCasilleroVacio;
import javafx.scene.ImageCursor;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

public class JuegoView extends BorderPane {
    /* Dentro de esta view entran todas las otras views que vamos a tener
     a nuestra disposición mientras jugamos.

     TableroView debería ser parte de JuegoView.

     */
    private static JuegoView juegoView;
    private TableroView tableroView;
    private MercadoDeUnidadesView mercadoDeUnidadesViewDerecha;
    private MercadoDeUnidadesView mercadoDeUnidadesViewIzquierda;
    private PanelDeControlView panelDeControlView;


    public static JuegoView getJuegoView() {
        return juegoView;
    }

    public static void inicializarJuegoView(Tablero tablero, Jugador jugador1, Jugador jugador2) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {
        juegoView = new JuegoView(tablero, jugador1, jugador2);
    }

    protected JuegoView(Tablero tablero, Jugador jugador1, Jugador jugador2) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {
        this.tableroView = new TableroView(tablero);
        this.mercadoDeUnidadesViewDerecha = new MercadoDeUnidadesView("EquipoRojo", new Bando(jugador1));
        this.mercadoDeUnidadesViewIzquierda = new MercadoDeUnidadesView("EquipoAzul",new Bando(jugador2));
        this.panelDeControlView = new PanelDeControlViewCasilleroVacio();

        this.setCenter(tableroView);
        this.setRight(mercadoDeUnidadesViewDerecha);
        this.setLeft(mercadoDeUnidadesViewIzquierda);
        this.setBottom(this.panelDeControlView);

        this.setCursor(new ImageCursor(new Image("file:src/resources/Punteros/cursor.png")));
    }

    public void setPanelDeControlView(PanelDeControlView panelDeControlSoldadoView) {
        this.panelDeControlView = panelDeControlSoldadoView;
        this.setBottom(panelDeControlSoldadoView);
    }

    public TableroView getTableroView() {
        return this.tableroView;
    }
}
