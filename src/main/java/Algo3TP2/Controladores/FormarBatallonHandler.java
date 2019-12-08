package Algo3TP2.Controladores;

import Algo3TP2.Modelos.Unidades.Soldado;
import Algo3TP2.Modelos.Unidades.ExcepcionesBatallon.BatallonIncompletoExcepcion;
import Algo3TP2.Modelos.Unidades.ExcepcionesBatallon.BatallonNoFormadoException;
import Algo3TP2.Vistas.BotonesPanelDeControl.BotonDeBatallon;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class FormarBatallonHandler implements EventHandler<ActionEvent> {

    private Soldado soldadoParaBatallon;
    private BotonDeBatallon boton;

    public FormarBatallonHandler(Soldado soldado, BotonDeBatallon botonDeBatallon) {
        this.soldadoParaBatallon = soldado;
        this.boton = botonDeBatallon;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            this.toggleBatallon();
        } catch (BatallonIncompletoExcepcion e) {
            AlertBox.display("Alert", e.getMessage());
        }
    }

    private void toggleBatallon() throws BatallonIncompletoExcepcion {
        try {
            soldadoParaBatallon.verificarBatallonFormado();
            soldadoParaBatallon.disolverBatallon();

        } catch (BatallonNoFormadoException e) {
            soldadoParaBatallon.formarBatallon();

        }
        // this.boton.setImage(this.soldadoParaBatallon);
    }

}