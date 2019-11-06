package Algo3TP2.Modelos.Unidades.ExcepcionesCurar;

public class AliadoConSaludCompletaNoSePuedeCurarExcepcion extends Exception {
    public AliadoConSaludCompletaNoSePuedeCurarExcepcion() {
        super("La unidad aliada no se puede curar porque se encuentra con salud maxima");
    }
}
