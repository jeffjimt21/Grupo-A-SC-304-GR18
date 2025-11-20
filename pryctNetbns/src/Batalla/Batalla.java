package batalla;

import ColaBatalla.Cola;
import jugadores.Player;
import jugadores.CPU;
import tropas.Arquero;
import tropas.Caballero;
import tropas.Mago;
import tropas.Tropa;

public class Batalla {
    private int numero;
    private int ronda;
    private Player jugador;
    private CPU cpu;
    

    
    private Cola camino1Jugador = new Cola();
    private Cola camino2Jugador = new Cola();
    private Cola camino1CPU  = new Cola();
    private Cola camino2CPU  = new Cola();

    public Batalla(Player jugador, CPU cpu) {
        this.numero = 1;
        this.jugador = jugador;
        this.cpu = cpu;
        this.ronda = 1;
    }
    
    
    //Tambien se movio jugador
    
    public void prepararJugador(int caminos, Tropa tropa){
        
       

        if (caminos == 1) {
           camino1Jugador.encolar(tropa);
        } else {
          camino2Jugador.encolar(tropa);
    }
    }

        
        
        
    
    
    
    public Tropa seleccionarTropaAleatoria() {
        int decision = (int) (Math.random() * 3);  
      

        if (decision == 0) {
            return new Arquero();
        } else if (decision == 1) {
            return new Mago();
        } else if (decision==2) {
            return new Caballero();
        } else {
            return new Arquero();
        
        }

      
    }

    //Se movio aca, porque ahi toma directamente los caminos que se crean por aca
    
    
     public void prepararCPU() {
        int cantidad = Math.max(0, ronda); 
        int limiteCamino = (int)Math.floor(cantidad * 0.75);// no puede ser mayor al 75% de sus tropas y redondea
        if (limiteCamino < 1) //no puede ser decimal
            limiteCamino = cantidad;//rondas como 1

        int c1 = 0, c2 = 0;//contadores

        for (int i = 0; i < cantidad; i++) {
            Tropa tropa = seleccionarTropaAleatoria();
            boolean camino1 = Math.random() < 0.5;

            if (camino1 && c1 >= limiteCamino) camino1 = false; //si camino uno y contador son mayor que el limite entonces el uno no sera por el que sigue
            if (!camino1 && c2 >= limiteCamino) camino1 = true;//si es que en el camino dos hace eso, toma el 1

            if (camino1){
                camino1CPU.encolar(tropa); c1++; 
            }
            else{ 
                camino2CPU.encolar(tropa); c2++;
            }
        }
    }
     
     
   public void Enfrentamiento() throws Exception {
    

    //CAMINO 1
    if (!camino1Jugador.estaVacia() && !camino1CPU.estaVacia()) {//camino 1 no esta vacio
        Tropa j1 = camino1Jugador.frente();//frente camino 1, tropa de enfrente
        Tropa c1 = camino1CPU.frente();//frente camino 1, tropa de enfrente cpu

        

        if (j1.getFortaleza().equals(c1.getTipo())) {//fortaleza de jugador es igual al enemigo, por eso gana el jugador y la vida del castillo baja segun cuanto haga la tropa del jugador
            camino1CPU.desencolar(); // CPU pierde
            
             String mensaje = " Jugador gana en Camino 1";
            
             Tropa atacante = camino1Jugador.desencolar();//cumplio porque va pegar
             
             cpu.getCastillo().recibirDanio(atacante.getDanio());
             
        } 
        else if (c1.getFortaleza().equals(j1.getTipo())) {
            camino1Jugador.desencolar(); // Jugador pierde
            
             String mensaje = " CPU gana en Camino 1";
            
             Tropa atacante = camino1CPU.desencolar();
             
             jugador.getCastillo().recibirDanio(atacante.getDanio());
        } 
        else {
            
            camino1Jugador.desencolar();
            camino1CPU.desencolar();
            
            String mensaje = "️ Empate en Camino 1";
           
        }
    } 
    else if (!camino1Jugador.estaVacia() && camino1CPU.estaVacia()) {//cuando solo un camino esta solo
        // Jugador ataca castillo CPU
        
        Tropa atacante = camino1Jugador.desencolar();//se tiene que quitar esta tropa ya ataco
        
        cpu.getCastillo().recibirDanio(atacante.getDanio());
    
    } 
    
    //igual anterior a este
    else if (camino1Jugador.estaVacia() && !camino1CPU.estaVacia()) {
        // CPU ataca castillo jugador
        Tropa atacante = camino1CPU.desencolar();
        jugador.getCastillo().recibirDanio(atacante.getDanio());
        
    }


    //CAMINO 2, igual camino 1
    if (!camino2Jugador.estaVacia() && !camino2CPU.estaVacia()) {
        Tropa jugador2 = camino2Jugador.frente();
        Tropa cpu2 = camino2CPU.frente();

       

        if (jugador2.getFortaleza().equals(cpu2.getTipo())) {
            camino2CPU.desencolar();
            
            String mensaje=" Jugador gana en el Camino 2";
            
            
            Tropa atacante = camino2Jugador.desencolar();
            
            cpu.getCastillo().recibirDanio(atacante.getDanio());
        } 
        else if (cpu2.getFortaleza().equals(jugador2.getTipo())) {
            camino2Jugador.desencolar();
            
            String mensaje="CPU gana";
            
         
            
            Tropa atacante = camino2CPU.desencolar();
            
            jugador.getCastillo().recibirDanio(atacante.getDanio());
        } 
        else {
            camino2Jugador.desencolar();
            
            camino2CPU.desencolar();
            
           String mensaje="empate";
           
           
           
        }
    } 
    else if (!camino2Jugador.estaVacia() && camino2CPU.estaVacia()) {
        Tropa atacante = camino2Jugador.desencolar();
        
        cpu.getCastillo().recibirDanio(atacante.getDanio());
       
    } 
    else if (camino2Jugador.estaVacia() && !camino2CPU.estaVacia()) {
        Tropa atacante = camino2CPU.desencolar();
        
        jugador.getCastillo().recibirDanio(atacante.getDanio());
        
    }
    
    
    
    
    
    
}
   
   public boolean rondaTerminada() {
       
    return camino1Jugador.estaVacia() && camino2Jugador.estaVacia() &&camino1CPU.estaVacia() && camino2CPU.estaVacia();//devolver todo vacio
    
   }
   
   public void AumentarRonda(){
   
       ronda++;
       
   
   }
   
  


    public boolean batallaTerminada() {
        
    return jugador.getCastillo().getVida() <= 0 || cpu.getCastillo().getVida() <= 0;
    
    
    }
    
//La vida de cada castillo dicta quien gano
    public String resultadoBatalla() {
        
     if (jugador.getCastillo().getVida() <= 0)
         return "Derrota";
     
     if (cpu.getCastillo().getVida() <= 0)
         
        return "Victoria";
        return "En curso";
    }   
    
  
   


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }

    public Player getJugador() {
        return jugador;
    }

    public void setJugador(Player jugador) {
        this.jugador = jugador;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public Cola getCamino1Jugador() {
        return camino1Jugador;
    }

    public void setCamino1Jugador(Cola camino1Jugador) {
        this.camino1Jugador = camino1Jugador;
    }

    public Cola getCamino2Jugador() {
        return camino2Jugador;
    }

    public void setCamino2Jugador(Cola camino2Jugador) {
        this.camino2Jugador = camino2Jugador;
    }

    public Cola getCamino1CPU() {
        return camino1CPU;
    }

    public void setCamino1CPU(Cola camino1CPU) {
        this.camino1CPU = camino1CPU;
    }

    public Cola getCamino2CPU() {
        return camino2CPU;
    }

    public void setCamino2CPU(Cola camino2CPU) {
        this.camino2CPU = camino2CPU;
    }

 

     
    
    
}
    
     
     
     


   
   
    
    

