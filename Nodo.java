/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColaBatalla;

/**
 *
 * @author lucas
 */
import tropas.Tropa;

public class Nodo {
    private Tropa dato;
    private Nodo siguiente= null;

    public Nodo(Tropa dato) {
        this.dato = dato;
        this.siguiente=null;
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
