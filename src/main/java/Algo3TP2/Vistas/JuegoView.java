package Algo3TP2.Vistas;
import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroVacioExcepcion;
import Algo3TP2.Modelos.Jugador.ExcepcionesJugador.UnidadInvalidaException;
import Algo3TP2.Modelos.Jugador.Jugador;
import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Tablero.Tablero;
import Algo3TP2.Modelos.Unidades.Soldado;
import Algo3TP2.Properties;
import Algo3TP2.Vistas.CasilleroView.CasilleroView;
import Algo3TP2.Vistas.UnidadesView.CatapultaView.CatapultaAzulView;
import Algo3TP2.Vistas.UnidadesView.CatapultaView.CatapultaRojaView;
import Algo3TP2.Vistas.UnidadesView.CuranderoView.CuranderoAzulView;
import Algo3TP2.Vistas.UnidadesView.CuranderoView.CuranderoRojoView;
import Algo3TP2.Vistas.UnidadesView.JineteView.JineteAzulView;
import Algo3TP2.Vistas.UnidadesView.JineteView.JineteRojoView;
import Algo3TP2.Vistas.UnidadesView.SoldadoView.SoldadoAzulView;
import Algo3TP2.Vistas.UnidadesView.SoldadoView.SoldadoRojoView;
import javafx.scene.PointLight;
import javafx.scene.layout.BorderPane;

public class JuegoView extends BorderPane {
    /* Dentro de esta view entran todas las otras views que vamos a tener
     a nuestra disposición mientras jugamos.

     TableroView debería ser parte de JuegoView.

     */
    public JuegoView(Tablero tablero) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {
        TableroView tableroView = new TableroView(tablero);
        MercadoDeUnidadesView mercadoDeUnidadesViewDerecha = new MercadoDeUnidadesView();
        MercadoDeUnidadesView mercadoDeUnidadesViewIzquierda = new MercadoDeUnidadesView();

        // Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado
        // Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado

        UnidadesViewEnJuego unidadesViewEnJuego = UnidadesViewEnJuego.getUnidadesViewEnJuego();
        Soldado soldado = new Soldado(new Bando(new Jugador("Nazareno")));
        SoldadoAzulView soldadoAzulView = new SoldadoAzulView();
        unidadesViewEnJuego.setUnidadView(soldado, soldadoAzulView);
        try {
            tablero.posicionarUnidad(soldado, new Coordenada(0, 0));
        } catch (CasilleroOcupadoExcepcion ex){
            // LALA
        }

        Soldado soldado2 = new Soldado(new Bando(new Jugador("Nazareno")));
        SoldadoRojoView soldadoRojoView = new SoldadoRojoView();
        unidadesViewEnJuego.setUnidadView(soldado2, soldadoRojoView);

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

        try{
            soldado2.recibirDanio(Properties.vidaSoldado);
        } catch (UnidadInvalidaException ex){

        }

        // Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado
        // Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado
/*
        Soldado soldado = new Soldado(new Bando(new Jugador("Jugador2")));
        try{
            tablero.posicionarUnidad(soldado, new Coordenada(0,0));
        } catch (CasilleroOcupadoExcepcion ex ){
            System.out.println("Todo mal amigo");
        }

        SoldadoAzulView soldadoAzulView = new SoldadoAzulView();
        CasilleroView casilleroView = tableroView.getCasilleroView(new Coordenada(0,0));
        casilleroView.setUnidadView(soldadoAzulView);

        try{
            soldado.recibirDanio(Properties.vidaSoldado);
        } catch (UnidadInvalidaException ex){
            System.out.println("Todo re mal amigo");
        }




        SoldadoRojoView soldadoRojoView = new SoldadoRojoView();
        CasilleroView casilleroView2 = tableroView.getCasilleroView(new Coordenada(1,0));
        casilleroView2.setUnidadView(soldadoRojoView);

        JineteAzulView jineteAzulView = new JineteAzulView();
        CasilleroView casilleroView3 = tableroView.getCasilleroView(new Coordenada(2,0));
        casilleroView3.setUnidadView(jineteAzulView);

        JineteRojoView jineteRojoView= new JineteRojoView();
        CasilleroView casilleroView4 = tableroView.getCasilleroView(new Coordenada(3,0));
        casilleroView4.setUnidadView(jineteRojoView);

        CatapultaAzulView catapultaAzulView = new CatapultaAzulView();
        CasilleroView casilleroView5 = tableroView.getCasilleroView(new Coordenada(4,0));
        casilleroView5.setUnidadView(catapultaAzulView);

        CatapultaRojaView catapultaRojaView = new CatapultaRojaView();
        CasilleroView casilleroView6 =  tableroView.getCasilleroView(new Coordenada(5,0));
        casilleroView6.setUnidadView(catapultaRojaView);

        CuranderoAzulView curanderoAzulView = new CuranderoAzulView();
        CasilleroView casilleroView7 =  tableroView.getCasilleroView(new Coordenada(6,0));
        casilleroView7.setUnidadView(curanderoAzulView);

        CuranderoRojoView curanderoRojoView = new CuranderoRojoView();
        CasilleroView casilleroView8 =  tableroView.getCasilleroView(new Coordenada(7,0));
        casilleroView8.setUnidadView(curanderoRojoView);
*/

        // Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado
        // Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado Hardcodeado

        this.setCenter(tableroView);
        this.setRight(mercadoDeUnidadesViewDerecha);
        this.setLeft(mercadoDeUnidadesViewIzquierda);
    }
}
