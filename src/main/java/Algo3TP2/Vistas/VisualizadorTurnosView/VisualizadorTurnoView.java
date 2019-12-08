package Algo3TP2.Vistas.VisualizadorTurnosView;

import Algo3TP2.Modelos.Bando;
import Algo3TP2.Modelos.Juego;
import Algo3TP2.Controladores.Observers.Observador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class VisualizadorTurnoView extends VBox implements Observador {

    private ImageView imagenEsTuTurno = new ImageView();
    private StackPane stackPaneImagenTurno = new StackPane();
    private boolean jugoElUltimoTurno;

    public VisualizadorTurnoView(Bando bando, Juego juego){

        imagenEsTuTurno.setImage(new Image("file:src/resources/VisualizadorTurnos/es_tu_turno.png"));

        juego.enlazarObservadorDeTurno(this);
        this.jugoElUltimoTurno = juego.getJugadorTurnoActual() == bando.getDuenio();
        if(jugoElUltimoTurno){this.mostrarMensajeTurno();}

        this.setAlignment(Pos.CENTER);
        this.setSpacing(5);
        Image imagen = new Image("file:src/resources/Mercado/fondo_mercado.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(183, 640, false, false, false, false));
        this.setBackground(new Background(imagenDeFondo));
        this.setPrefSize(191, 640);
        this.setPadding(new Insets(5, 5, 0, 5));

        // Nombre Jugador
        StackPane stackPaneNombreJugador = new StackPane();

        ImageView imagenMarcoNombre = new ImageView(new Image("file:src/resources/Mercado/marco_nombre_jugador.png"));

        Text textNombreJugador = new Text();
        textNombreJugador.setText(bando.getDuenio().toString());
        textNombreJugador.setFont(Font.loadFont("file:src/resources/Fonts/fuente_medieval.ttf", 20));
        textNombreJugador.setFill(Color.WHITE);

        stackPaneNombreJugador.getChildren().addAll(imagenMarcoNombre, textNombreJugador);

        // Imagen vacia que da lugar al turno.
        stackPaneImagenTurno.setPrefHeight(100); // Le seteo un tamaño para hacer espacio para la futura imagen.

        this.getChildren().addAll(stackPaneNombreJugador, stackPaneImagenTurno);
    }
    public void mostrarMensajeTurno(){
        stackPaneImagenTurno.getChildren().add(imagenEsTuTurno);
    }
    public void removerMensajeTurno(){
        stackPaneImagenTurno.getChildren().remove(imagenEsTuTurno);
    }

    @Override
    public void actualizar() {
        if(jugoElUltimoTurno){
            removerMensajeTurno();
            jugoElUltimoTurno = false;
        }else {
            mostrarMensajeTurno();
            jugoElUltimoTurno = true;
        }
    }
}
