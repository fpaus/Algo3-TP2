package Algo3TP2.Modelos;

import Algo3TP2.Modelos.Unidades.Unidad;

public class Bando {

    private Jugador duenio;

    public Bando(Jugador duenio) {
        this.duenio = duenio;
    }

    public Jugador getDuenio() {
        return duenio;
    }

	public void matarUnidad(Unidad unidad) throws UnidadInvalidaException {
        this.duenio.matarUnidad(unidad);
	}
}