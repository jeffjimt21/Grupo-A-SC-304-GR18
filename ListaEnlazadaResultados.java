package Invasion;


public class ListaEnlazadaResultados {
 
    private NodoResultado cabeza;

    public ListaEnlazadaResultados() {
        cabeza = null;
    }
    
    //decidimos hacer listas con victorias porque al contar batallas puede haber una derrota y no funcionar, por ello la creacion de ese atributo de resutlado batalla
    public void agregar(Invasion.ResultadoBatalla resultado) {
        NodoResultado nuevo = new NodoResultado(resultado);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoResultado actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
    }

    
    public int contarBatallas() {
        int contador = 0;
        NodoResultado actual = cabeza;

        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }

   
    public int contarVictorias() {
        int contador = 0;
        NodoResultado actual = cabeza;

        while (actual != null) {
            if (actual.getResultado() == Invasion.ResultadoBatalla.VICTORIA) {
                contador++;
            }
            actual = actual.getSiguiente();
        }
        return contador;
    }

    public boolean esEmperador() {
        return contarVictorias() >= 3;
    }

    public NodoResultado getCabeza() {
        return cabeza;
    }

    public void limpiar() {
        cabeza = null;
    }
}