package ExcepcionesCasillero;

public class CasilleroVacioExcepcion extends Exception{
    public CasilleroVacioExcepcion(){
        super("El casillero se encuentra vacio");
    }
}
