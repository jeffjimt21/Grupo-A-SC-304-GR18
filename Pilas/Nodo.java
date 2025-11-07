
package Pilas;

import tropas.Tropa;


public class Nodo {
    //Atributos
    private Tropa tropa;
    private Nodo siguiente;

    public Nodo(Tropa tropa) {
        this.tropa = tropa;
        this.siguiente = null;
    }

    public Tropa getTropa() {
        return tropa;
    }

    public void setTropa(Tropa tropa) {
        this.tropa = tropa;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
}

  