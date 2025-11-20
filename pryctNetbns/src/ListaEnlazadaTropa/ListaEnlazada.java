
package ListaEnlazadaTropa;

import tropas.Tropa;


public class ListaEnlazada {
    private NodoTropa cabeza;

    public ListaEnlazada() {
        this.cabeza = null;
    }
    
    public void InsertarInicio(Tropa valor){
    
        NodoTropa nuevo = new NodoTropa(valor);
       
        nuevo.setSiguiente(cabeza);
        
        cabeza = nuevo;
        
    
    }
    
    
    public void EliminarNodo(Tropa valor){
        NodoTropa actual = cabeza;
        NodoTropa anterior = null;
        
        while (actual!= null && actual.getDato() != valor){
        
            anterior=actual;
            actual=anterior.getSiguiente();
        
        }
        
        if (actual==null) {
            return;
        }
        
        if (anterior == null) {
            cabeza=actual.getSiguiente();
        } else {
        
            anterior.setSiguiente(actual.getSiguiente());
        
        }
        
        
    
    
    
    }
    
   public boolean buscar(Tropa valor) {
    NodoTropa actual = cabeza;

    while (actual != null) {
        if (actual.getDato() == valor) {
            return true; 
        }
        actual = actual.getSiguiente(); 
    }

    return false; 
}

    public void recorrer (){
    
        
        NodoTropa actual =cabeza;
        while (actual != null){
        
            System.out.println(actual.getDato()+ " -> ");
            actual= actual.getSiguiente();
        
        }
        
        System.out.println("NULL");
        
    
    }
    
    public void InsertarOrdenadamente(Tropa valor){
    
        NodoTropa nuevo = new NodoTropa(valor);
        NodoTropa actual = cabeza;
        NodoTropa anterior = null;
        
        
        if (cabeza == null) {
            
            cabeza = nuevo;
            return;
            
        } else if (cabeza.getNumeroTropas()<=nuevo.getNumeroTropas()) {
            nuevo.setSiguiente(cabeza);
            cabeza=nuevo;
            return;
        
        }
        
        
        while (actual!=null){
        
            anterior=actual;
            actual=anterior.getSiguiente();
            
            if (actual!= null &&anterior.getNumeroTropas() >= nuevo.getNumeroTropas() && nuevo.getNumeroTropas()>=actual.getNumeroTropas()) {
                
                nuevo.setSiguiente(actual);
                anterior.setSiguiente(nuevo);
                
                return;
                
            }if (actual== null && anterior.getNumeroTropas() >=nuevo.getNumeroTropas()){
            
               anterior.setSiguiente(nuevo);
               nuevo.setSiguiente(null);
                
                return;
            
            
            }             
        
        
        } 
        
        
        
       
        
        
    
    }

    public NodoTropa getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoTropa cabeza) {
        this.cabeza = cabeza;
    }
    
    
    
}
