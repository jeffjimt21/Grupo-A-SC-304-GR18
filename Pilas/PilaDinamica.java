
package Pilas;

import tropas.Tropa;



public class PilaDinamica {
    private Nodo cima;
    
    public PilaDinamica(){
        this.cima=null;
    }
    
    public void push(Tropa tropa){
        Nodo nuevoNodo = new Nodo(tropa);
        nuevoNodo.setSiguiente(cima);
        cima = nuevoNodo;
    }
    
    public Tropa pop(){
        if(cima==null){
            System.out.println("Subdesbordamiento");
            return null;
        }
        Tropa tropa = cima.getTropa();
        cima = cima.getSiguiente();
        return tropa;
    }
    
    public void mostrar(){
        if(cima == null){
            System.out.println("La Pila esta vacia");
            return;
        } 
        Nodo actual = cima;
        System.out.println("Contenido de la pila:");
        while(actual != null){
            System.out.println(actual.getTropa());
            actual = actual.getSiguiente();
        
        }
    }
    //Hacer por mi cuenta
    //HACER EJERCICIOS
    public boolean tomardato(Tropa busqueda){
        
        if (cima==null){
            return false;
        }
        Nodo actual = cima;
        while  (actual!=null){
            if(actual.getTropa()== busqueda){
                return true;
            }
            actual = actual.getSiguiente();
        }
    
    return false;
    } 

    public Nodo getCima() {
        return cima;
    }

    public void setCima(Nodo cima) {
        this.cima = cima;
    }
  
    
    
    
}

