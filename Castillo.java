
package castillo;


public class Castillo {
    private double vida;

    public Castillo() {
        this.vida = 10;
    }
    
    public double RecibirDanio(double danio){
    
        if (vida<=0) {
            return vida;
        } else {
        
            while(vida!=0){
                vida=vida-danio;
               
            }
        
        } return vida;
    
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

