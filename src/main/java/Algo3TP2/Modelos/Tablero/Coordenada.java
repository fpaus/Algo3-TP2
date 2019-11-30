package Algo3TP2.Modelos.Tablero;

import Algo3TP2.Modelos.Tablero.Direccion.Direccion;

import java.util.ArrayList;

public class Coordenada {
    private int posicionX;
    private int posicionY;

    public Coordenada(int x, int y) {
        this.posicionX = x;
        this.posicionY = y;
    }

    public Coordenada(Coordenada coordenada, Direccion horizontal, Direccion vertical) {
        this.posicionX = coordenada.posicionX + horizontal.getDireccion();
        this.posicionY = coordenada.posicionY + vertical.getDireccion();
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

    public ArrayList<Coordenada> getTodasLasCoordenadasVecinas() {
        ArrayList<Coordenada> coordenadas = new ArrayList<Coordenada>();
        for (int i = this.posicionX - 1; i <= this.posicionX + 1; i++) {
            for (int j = this.posicionY - 1; j <= this.posicionY + 1; j++) {
                if (!(this.posicionX == i && this.posicionY == j)) {
                    coordenadas.add(new Coordenada(i, j));
                }
            }
        }
        return coordenadas;
    }

    @Override
    public String toString() {
        return "(" + posicionX + "," + posicionY + ")";
    }
}
