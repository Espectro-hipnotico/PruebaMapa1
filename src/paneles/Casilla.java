package paneles;

import java.sql.Array;

public class Casilla {

    private String tipo;

    public Casilla(String tipo) {
        this.tipo = tipo;
    }

    public int[] getTipo() {
        int[] posicion = new int[2];
        switch (tipo) {
            case "A":
                posicion[0] = 256;
                posicion[1] = 32;
                return posicion;
            case "T0":
                posicion[0] = 32;
                posicion[1] = 32;
                return posicion;

        }
        return null;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
