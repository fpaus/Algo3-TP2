package Algo3TP2.EntidadesTests;

public class Punto {

    private int x;
    private int y;

	public Punto(int i, int j) {
        this.x= i;
        this.y = j;
    
    }



	public Object distaDe(Punto b) {

        int distX = Math.abs(this.x - b.x);
        
        int distY = Math.abs(this.y - b.y);
        

        return new Distancia(Math.sqrt(Math.pow(distX, 2) + Math.pow(distY, 2)));
	}

    


}
