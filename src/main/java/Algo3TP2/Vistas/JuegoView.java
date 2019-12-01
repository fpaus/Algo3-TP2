package Algo3TP2.Vistas;
import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
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
    private TableroView tableroView;
    private MercadoDeUnidadesView mercadoDeUnidadesViewDerecha;
    private MercadoDeUnidadesView mercadoDeUnidadesViewIzquierda;
    private PanelDeControlView panelDeControlView;


    public static JuegoView getJuegoView() {
        return juegoView;
    }

    public static void inicializarJuegoView(Tablero tablero) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {
        juegoView = new JuegoView(tablero);
    }

    protected JuegoView(Tablero tablero) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {
        this.tableroView = new TableroView(tablero);
        this.mercadoDeUnidadesViewDerecha = new MercadoDeUnidadesView();
        this.mercadoDeUnidadesViewIzquierda = new MercadoDeUnidadesView();
        this.panelDeControlView = new PanelDeControlViewCasilleroVacio();

        // Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado
        // Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado

        UnidadesViewEnJuego unidadesViewEnJuego = UnidadesViewEnJuego.getUnidadesViewEnJuego();
        Soldado soldado = new Soldado(new Bando(new Jugador("Nazareno")));
        SoldadoAzulView soldadoAzulView = new SoldadoAzulView();
        unidadesViewEnJuego.setUnidadView(soldado, soldadoAzulView);
        PanelDeControlView panelDeControlView = new PanelDeControlSoldadoView(soldado);
        unidadesViewEnJuego.setUnidadPanelDeControlView(soldado, panelDeControlView);

        try {
            tablero.posicionarUnidad(soldado, new Coordenada(0, 0));
        } catch (CasilleroOcupadoExcepcion ex){
            // LALA
        }

        Soldado soldado2 = new Soldado(new Bando(new Jugador("Nazareno")));
        SoldadoRojoView soldadoRojoView = new SoldadoRojoView();
        unidadesViewEnJuego.setUnidadView(soldado2, soldadoRojoView);
        PanelDeControlView panelDeControlView2 = new PanelDeControlSoldadoView(soldado2);
        unidadesViewEnJuego.setUnidadPanelDeControlView(soldado2, panelDeControlView2);

        try {
            tablero.posicionarUnidad(soldado2, new Coordenada(0, 1));
        } catch (CasilleroOcupadoExcepcion ex){
            // LALA
        }

        // JUJUJU
        try{
            soldado.moverHaciaAbajo();
        } catch (CasilleroOcupadoExcepcion | CasilleroFueraDelLosLimitesDelTableroExcepcion ex){
            // Lala
        }

        try{
            soldado.moverHaciaLaDerecha();
        } catch (CasilleroOcupadoExcepcion | CasilleroFueraDelLosLimitesDelTableroExcepcion ex){
            // Lala
        }



        // Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado
        // Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado

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
