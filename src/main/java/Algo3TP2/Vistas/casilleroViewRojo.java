package Algo3TP2.Vistas;

import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Tablero.Tablero;

public class casilleroViewRojo extends CasilleroView {
    public casilleroViewRojo(Tablero tablero, Coordenada coordenada) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {
        super(tablero, coordenada);
        this.setStyle("-fx-background-color: rgba(255, 0, 0, 0.35); -fx-border-width: 5; -fx-border-width: 1; -fx-border-color: black;");
    }
}