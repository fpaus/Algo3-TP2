package Algo3TP2.Vistas.MercadoDeUnidadesView;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Juego;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Observers.ObservadorPuntos;
import Algo3TP2.Properties;
import Algo3TP2.Vistas.BotonesPanelDeControl.BotonFinalizarCompra;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MercadoDeUnidadesView extends VBox implements ObservadorPuntos {

    private Text textOroRestante;
    protected BotonFinalizarCompra botonFinalizarCompra;

    public MercadoDeUnidadesView(Bando bando, Juego juego) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {

        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(5);
        Image imagen = new Image("file:src/resources/Mercado/fondo_mercado.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(183, 640, false, false, false, false));
        this.setBackground(new Background(imagenDeFondo));
        this.setPadding(new Insets(5, 5, 0, 5));

        // Nombre Jugador
        StackPane stackPaneNombreJugador = new StackPane();

        ImageView imagenMarcoNombre = new ImageView(new Image("file:src/resources/Mercado/marco_nombre_jugador.png"));

        Text textNombreJugador = new Text();
        textNombreJugador.setText(bando.getDuenio().toString());
        textNombreJugador.setFont(Font.loadFont("file:src/resources/Fonts/fuente_medieval.ttf", 20));
        textNombreJugador.setFill(Color.WHITE);

        stackPaneNombreJugador.getChildren().addAll(imagenMarcoNombre, textNombreJugador);

        // Billetera Jugador
        bando.getDuenio().enlazarObservador(this);
        StackPane stackPaneBilletera = new StackPane();

        ImageView imagenMarcoBilletera = new ImageView(new Image("file:src/resources/Mercado/marco_billetera.png"));
        this.textOroRestante = new Text();
        this.textOroRestante.setText(Integer.toString(Properties.puntosInicialesDisponibles));
        this.textOroRestante.setFont(Font.loadFont("file:src/resources/Fonts/fuente_medieval.ttf", 25));
        this.textOroRestante.setFill(Paint.valueOf("#ffcc39"));

        stackPaneBilletera.getChildren().addAll(imagenMarcoBilletera, textOroRestante);

        // Boton Finalizar
        this.botonFinalizarCompra = new BotonFinalizarCompra();

        this.getChildren().addAll(stackPaneNombreJugador, stackPaneBilletera, botonFinalizarCompra);
    }

    @Override
    public void actualizar(int puntos) {
        this.textOroRestante.setText(Integer.toString(puntos));
    }
}

//TODO: recibir el contenido del oro inicial por algún medio.