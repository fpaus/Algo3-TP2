package Algo3TP2.Vistas.JuegoView;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Juego;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Vistas.MercadoDeUnidadesView.MercadoDeUnidadesAzulesView;
import Algo3TP2.Vistas.MercadoDeUnidadesView.MercadoDeUnidadesRojasView;
import Algo3TP2.Vistas.MercadoDeUnidadesView.MercadoDeUnidadesView;
import Algo3TP2.Vistas.PanelDeControlView.PanelDeControlViewCasilleroVacio;
import Algo3TP2.Vistas.PanelDeControlView.PanelDeControlView;
import Algo3TP2.Vistas.TableroView;
import Algo3TP2.Vistas.VisualizadorTurnosView.VisualizadorTurnoView;
import javafx.scene.ImageCursor;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
    private VisualizadorTurnoView visualizadorTurnoViewDerecha;
    private VisualizadorTurnoView visualizadorTurnoViewIzquierda;
    private PanelDeControlView panelDeControlView;
    private boolean equipoAzulEnBatalla = false;
    private boolean equipoRojoEnBatalla = false;
    private Stage stagePrincipal;


    public static JuegoView getJuegoView() {
        return juegoView;
    }

    public static void inicializarJuegoView(Juego juego, Stage stagePrincipal) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {
        juegoView = new JuegoView(juego, stagePrincipal);
    }

    protected JuegoView(Juego juego, Stage stagePrincipal) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {
        this.stagePrincipal = stagePrincipal;
        this.tableroView = new TableroView(juego);
        this.mercadoDeUnidadesViewDerecha = new MercadoDeUnidadesRojasView(new Bando(juego.getJugador1()), juego);
        this.mercadoDeUnidadesViewIzquierda = new MercadoDeUnidadesAzulesView(new Bando(juego.getJugador2()), juego);
        this.visualizadorTurnoViewDerecha = new VisualizadorTurnoView(new Bando(juego.getJugador1()), juego);
        this.visualizadorTurnoViewIzquierda = new VisualizadorTurnoView(new Bando(juego.getJugador2()), juego);
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

    public void iniciarBatallaEquipoAzul(){
        this.setLeft(visualizadorTurnoViewIzquierda);
        this.equipoAzulEnBatalla = true;
        this.iniciarBatalla();
    }

    public void iniciarBatallaEquipoRojo(){
        this.setRight(visualizadorTurnoViewDerecha);
        this.equipoRojoEnBatalla = true;
        this.iniciarBatalla();
    }

    private void iniciarBatalla(){
        if(equipoAzulEnBatalla && equipoRojoEnBatalla){
            this.tableroView.setEstadoModoBatalla();
        }
    }

    public TableroView getTableroView() {
        return this.tableroView;
    }

    public void close(){
        this.stagePrincipal.close();
    }
}
