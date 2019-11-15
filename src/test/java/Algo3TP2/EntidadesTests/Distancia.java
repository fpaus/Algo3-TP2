package Algo3TP2.EntidadesTests;

public class Distancia {

    private Double valor;

	public Distancia(Double i) {
        this.valor = i;
    }

    @Override
    public boolean equals(Object o){
        Distancia other = (Distancia) o;

        return this.valor.equals(other.valor);


    }
}
