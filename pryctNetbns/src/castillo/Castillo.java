
package castillo;


public class Castillo {
    private double vida;

    public Castillo() {
        this.vida = 10;
    }
    
   
    
    public void recibirDanio(double danio) {
            if (vida <= 0)
                return; 
            
            vida -= danio;
                
            if (vida < 0)
                vida=0;
                
        }   

    
    
    
    public String Vivo(){
        
        String mensaje="";
        
        if (vida>0) {
            return mensaje="El castillo sigue con vida";
        } else {
            
            return mensaje="El castillo fue derrumbado";
            
        }
    
    
    }
    

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    
    
    
}

