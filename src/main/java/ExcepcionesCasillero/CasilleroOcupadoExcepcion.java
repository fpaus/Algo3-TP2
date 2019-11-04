package ExcepcionesCasillero;

public class CasilleroOcupadoExcepcion extends Exception{
    public CasilleroOcupadoExcepcion(){
        super("El casillero se encuentra ocupado");
    }
}
