package jugadores;

import castillo.Castillo;

public class Player {
    private String nombre;
    private Castillo castillo;

    public Player(String nombre) {
        this.nombre = nombre;
        this.castillo = new Castillo(); 
    }

    public String getNombre() {
        return nombre;
    }

    public Castillo getCastillo() {
        return castillo;
    }
}
