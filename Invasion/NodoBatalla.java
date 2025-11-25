package Invasion;

import batalla.Batalla;

public class NodoBatalla {
    private Batalla dato;
    private NodoBatalla siguiente;

    public NodoBatalla(Batalla dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Batalla getDato() {
        return dato;
    }

    public void setDato(Batalla dato) {
        this.dato = dato;
    }

    public NodoBatalla getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoBatalla siguiente) {
        this.siguiente = siguiente;
    }
}
