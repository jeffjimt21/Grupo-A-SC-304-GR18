package ColaBatalla;

import tropas.Tropa;

/**
 *
 * @author lucas
 */
public class Cola {
    private Nodo frente;
    private Nodo ultimo;
    
    public Cola(){
        this.frente=null;
        this.ultimo=null;
    }
    
    public void encolar(Tropa dato){
        Nodo nuevo = new Nodo(dato);
        if (ultimo!=null){
            ultimo.setSiguiente(nuevo);
        
        }
        ultimo=nuevo;
        if (frente==null) {
            frente= nuevo;
        }
        
    
    }
    
    public String desencolar() throws Exception{
        if (frente==null) {
            throw new Exception("Cola vacia");
        }
        
        Tropa dato = frente.getDato();
        String tipo = dato.getTipo();
        frente=frente.getSiguiente();
        if (frente==null) {
            ultimo=null;
        }
        return tipo;
    
    }
    
    public String frente()throws Exception{
    
        if (frente==null) {
            throw new Exception ("Cola vacia");
        }
        
        return frente.getDato().getTipo();
        
    }
    
    public boolean estaVacia(){
        return frente==null;
    }
    
}
