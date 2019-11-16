package Algo3TP2.Modelos.Tablero;

public class Distancia implements Comparable {

    private int valor;

	public Distancia(int distancia) {
        this.valor = distancia;
    }

    @Override
    public boolean equals(Object o){
        Distancia other = (Distancia) o;

        return this.valor == other.valor;

    }

    @Override
    public int compareTo(Object o) {
        Distancia other = (Distancia) o;

        return Math.abs(this.valor - other.valor);
    }

}
