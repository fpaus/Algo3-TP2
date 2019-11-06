package Algo3TP2.Modelos.Unidades.EstrategiasDeAtaque.ExcepcionesAtaque;

public class UnidadAtacadaEsAliadaExcepcion extends Exception {
    public UnidadAtacadaEsAliadaExcepcion() {
        super("Esta unidad no puede atacar unidades aliadas");
    }
}
