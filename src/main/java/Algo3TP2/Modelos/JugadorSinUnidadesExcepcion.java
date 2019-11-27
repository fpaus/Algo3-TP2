package Algo3TP2.Modelos;

public class JugadorSinUnidadesExcepcion extends Exception {
    public JugadorSinUnidadesExcepcion(String nombre){
        super("El jugador "+ nombre + "ha perdido todas sus unidades");
    }
}
