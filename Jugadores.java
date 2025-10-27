package jugadores;

import ColaBatalla.Cola;
import castillo.Castillo;
import pilas.PilaDinamica;
import tropas.Tropa;

public class Jugadores {
    private String nombre;
    private Castillo castillo;
    private PilaDinamica pila;

    public Jugadores(String nombre) {
        this.nombre = nombre;
        this.castillo = new Castillo();
        this.pila = new PilaDinamica();
    }

    public boolean CastilloVida() {
        return castillo.getVida() > 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Castillo getCastillo() {
        return castillo;
    }

    public void setCastillo(Castillo castillo) {
        this.castillo = castillo;
    }

    public PilaDinamica getPila() {
        return pila;
    }

    public void setPila(PilaDinamica pila) {
        this.pila = pila;
    }
}
