package Algo3TP2.Vistas.BotonesPanelDeControl;

import Algo3TP2.Modelos.Unidades.ExcepcionesJinete.JineteAtacaConArcoException;
import Algo3TP2.Modelos.Unidades.IUnidadDeAtaque;
import Algo3TP2.Modelos.Unidades.Jinete;
import Algo3TP2.Observers.Observador;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BotonDeAtaqueJinete extends BotonDeAtaque implements Observador {

    private Image ataqueEspadaImage = new Image("file:src/resources/PanelDeControl/BotonesAcciones/ataque_jinete_corta.png");
    private Image ataqueArcoImage = new Image("file:src/resources/PanelDeControl/BotonesAcciones/ataque_jinete_media.png");
    private Jinete jinete;

    public BotonDeAtaqueJinete(IUnidadDeAtaque unidad, Image armaDeAtaqueImage) {
        super(unidad, armaDeAtaqueImage);
    }
    public void setImage(Jinete jinete) {
        this.jinete = jinete;
        try {
            jinete.verificarJineteAtacaConEspada();
            this.setGraphic(new ImageView(ataqueEspadaImage));
        } catch (JineteAtacaConArcoException e) {
            this.setGraphic(new ImageView(ataqueArcoImage));
        }
    }
    @Override
    public void actualizar() {
        this.setImage(this.jinete);
    }
}
