
package jugadores;

import ColaBatalla.Cola;
import castillo.Castillo;

import tropas.Tropa;


public class Jugadores {
    private String nombre;
    private Castillo castillo;
   
    
    
    //Esto es porque en el metodo constructor dentro se crean nuevos datos, si les paso algo los va ignorar

    public Jugadores(String nombre) {
        this.nombre = nombre;
        this.castillo = new Castillo();
      
      
    }

    public Jugadores() {
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

  

  
    
    
    
    
    
    
    
    
}
