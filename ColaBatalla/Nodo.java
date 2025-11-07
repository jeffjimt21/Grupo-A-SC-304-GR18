package ColaBatalla;

import tropas.Tropa;

public class Nodo {
    private Tropa dato;
    private Nodo siguiente;

    public Nodo(Tropa dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Tropa getDato() {
        return dato;
    }

    public void setDato(Tropa dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}


