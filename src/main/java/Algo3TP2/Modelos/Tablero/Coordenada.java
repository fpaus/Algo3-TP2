package Algo3TP2.Modelos.Tablero;

public class Coordenada {
    private int posicionX;
    private int posicionY;

    public Coordenada(int x, int y) {
        this.posicionX = x;
        this.posicionY = y;
    }

    public Distancia distanciaACoordenada(Coordenada otraCoordenada) {

        int distanciaX = Math.abs(this.posicionX - otraCoordenada.posicionX);

        int distanciaY = Math.abs(this.posicionY - otraCoordenada.posicionY);

        return new Distancia(Math.max(distanciaX, distanciaY));
    }

    @Override
    public boolean equals(Object o) {
        Coordenada other = (Coordenada) o;

        return (this.posicionX == other.posicionX && this.posicionY == other.posicionY);
    }

    @Override
    public int hashCode() {
        int tmp = (this.posicionY + ((this.posicionX + 1) / 2));
        return this.posicionX + (tmp * tmp);
    }

}
