package Invasion;

import batalla.Batalla;

public class ListaBatallas {
    private NodoBatalla cabeza;
    private NodoBatalla cola;
    private int size;

    public ListaBatallas() {
        this.cabeza = null;
        this.cola = null;
        this.size = 0;
    }

    public void agregarFinal(Batalla b) {
        NodoBatalla nuevo = new NodoBatalla(b);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.setSiguiente(nuevo);
            cola = nuevo;
        }
        size++;
    }

    public NodoBatalla getCabeza() {
        return cabeza;
    }

    public int getSize() {
        return size;
    }
}
