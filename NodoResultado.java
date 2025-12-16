package Invasion;



public class NodoResultado {

    private Invasion.ResultadoBatalla resultado;
    private NodoResultado siguiente;

    public NodoResultado(Invasion.ResultadoBatalla resultado) {
        this.resultado = resultado;
        this.siguiente = null;
    }

    public Invasion.ResultadoBatalla getResultado() {
        return resultado;
    }

    public void setResultado(Invasion.ResultadoBatalla resultado) {
        this.resultado = resultado;
    }

    public NodoResultado getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoResultado siguiente) {
        this.siguiente = siguiente;
    }
}