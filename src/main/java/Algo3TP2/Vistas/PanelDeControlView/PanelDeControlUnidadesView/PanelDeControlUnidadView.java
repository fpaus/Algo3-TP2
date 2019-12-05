package Algo3TP2.Vistas.PanelDeControlView.PanelDeControlUnidadesView;

import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Observers.Observador;
import Algo3TP2.Vistas.PanelDeControlView.PanelDeControlView;
import Algo3TP2.Vistas.UnidadesView.UnidadView;
import Algo3TP2.Vistas.UnidadesViewEnJuego;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PanelDeControlUnidadView extends PanelDeControlView implements Observador {

    private Text vidaText = new Text();
    private Unidad unidad;
    private String unidadVidaInicial;

    public PanelDeControlUnidadView(Unidad unidad){

        this.unidad = unidad;
        unidad.enlazarObservadorVida(this);

        StackPane stackPaneUnidadActual = new StackPane(); // StackPane para el marco y la unidad que se ve dentro.
        VBox contenedorUnidadYVida = new VBox();
        contenedorUnidadYVida.setAlignment(Pos.CENTER);

        this.vidaText.setFont(Font.loadFont("file:src/resources/Fonts/fuente_medieval.ttf", 20));
        this.vidaText.setFill(Paint.valueOf("#ffcc39"));

        UnidadView imagenUnidad = UnidadesViewEnJuego.getUnidadView().getUnidadView(unidad);
        ImageView imagenUnidadSeleccioanda = new ImageView(imagenUnidad.getImage());
        imagenUnidadSeleccioanda.setFitWidth(80);
        imagenUnidadSeleccioanda.setFitHeight(80);
        imagenUnidadSeleccioanda.setPreserveRatio(true);

        ImageView marcoUnidadSeleccionada = new ImageView (new Image("file:src/resources/PanelDeControl/marco_unidad.png"));

        this.unidadVidaInicial = unidad.getVidaString();
        this.setVidaActualText(unidadVidaInicial);
        contenedorUnidadYVida.getChildren().addAll(this.vidaText, imagenUnidadSeleccioanda);
        stackPaneUnidadActual.getChildren().addAll(marcoUnidadSeleccionada, contenedorUnidadYVida);

        this.add(stackPaneUnidadActual, 0 ,0);
    }

    public void setVidaActualText(String vidaActual){
        this.vidaText.setText(vidaActual+"/"+this.unidadVidaInicial);
    }

    @Override
    public void actualizar() {
        this.setVidaActualText(this.unidad.getVidaString());
    }
}
