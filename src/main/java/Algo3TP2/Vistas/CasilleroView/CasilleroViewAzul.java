package Algo3TP2.Vistas.CasilleroView;

import Algo3TP2.Modelos.Tablero.Coordenada;
import Algo3TP2.Modelos.Tablero.ExcepcionesTablero.CasilleroFueraDelLosLimitesDelTableroExcepcion;
import Algo3TP2.Modelos.Tablero.Tablero;

public class CasilleroViewAzul extends CasilleroView{
    public CasilleroViewAzul(Tablero tablero, Coordenada coordenada) throws CasilleroFueraDelLosLimitesDelTableroExcepcion {
        super(tablero, coordenada);
        this.setStyle("-fx-background-color: rgba(0, 0, 255, 0.35); -fx-border-width: 5; -fx-border-width: 1; -fx-border-color: black;");
    }
}