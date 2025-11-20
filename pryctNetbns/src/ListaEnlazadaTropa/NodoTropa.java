
package ListaEnlazadaTropa;

import tropas.Tropa;


public class NodoTropa {
    
    private Tropa dato;
    private int numeroTropas;
    private NodoTropa siguiente;

    public NodoTropa(Tropa tropa) {
        this.dato = tropa;
        this.siguiente = null;
    }

    public Tropa getDato() {
        return dato;
    }

    public void setDato(Tropa dato) {
        this.dato = dato;
    }

    public NodoTropa getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoTropa siguiente) {
        this.siguiente = siguiente;
    }

    public int getNumeroTropas() {
        return numeroTropas;
    }

    public void setNumeroTropas(int numeroTropas) {
        this.numeroTropas = numeroTropas;
    }
    
    
    
    
    
    
}
