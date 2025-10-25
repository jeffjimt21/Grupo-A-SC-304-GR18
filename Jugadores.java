
package jugadores;

import ColaBatalla.Cola;
import castillo.Castillo;
import pilas.PilaDinamica;
import tropas.Tropa;


public class Jugadores {
    private String nombre;
    private Castillo castillo;
    private PilaDinamica pila;
    
    
    //Esto es porque en el metodo constructor dentro se crean nuevos datos, si les paso algo los va ignorar

    public Jugadores(String nombre) {
        this.nombre = nombre;
        this.castillo = new Castillo();
        this.pila = new PilaDinamica();
      
    }
    
    public boolean CastilloVida(){
    
        if (castillo.getVida()>0) {
            return true;
            
        } else {
                return false;
                
                }
        
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Castillo getCastillo() {
        return castillo;
    }

    public void setCastillo(Castillo castillo) {
        this.castillo = castillo;
    }

    public PilaDinamica getPila() {
        return pila;
    }

    public void setPila(PilaDinamica pila) {
        this.pila = pila;
    }

  
    
    
    
    
    
    
    
    
}
