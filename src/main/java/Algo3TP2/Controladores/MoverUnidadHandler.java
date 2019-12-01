package Algo3TP2.Controladores;

import Algo3TP2.Modelos.Casillero.ExcepcionesCasillero.CasilleroOcupadoExcepcion;
import Algo3TP2.Modelos.Tablero.Direccion.Direccion;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Unidades.Unidad;
import Algo3TP2.Modelos.Unidades.UnidadMovible;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MoverUnidadHandler implements EventHandler<ActionEvent> {

    private UnidadMovible unidadMovible;
    private Direccion horizontal;
    private Direccion vertical;

    public MoverUnidadHandler(Unidad unidad, Direccion horizontal, Direccion vertical) {
        this.unidadMovible = (UnidadMovible) unidad;
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    @Override
    public void handle(ActionEvent event) {
        this.mover();
    }

    public void mover() {
        try {
            this.unidadMovible.moverEnDireccion(this.horizontal, this.vertical);
        } catch (CasilleroFueraDelLosLimitesDelTableroExcepcion | CasilleroOcupadoExcepcion ex){
            AlertBox.display("Alert", ex.getMessage());
        }
    }
}