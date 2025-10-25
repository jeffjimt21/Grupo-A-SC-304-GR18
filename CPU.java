
package jugadores;

import tropas.Tropa;


public class CPU extends Jugadores {
    
    public CPU(String nombre) {
        super(nombre);
    }
    
    //Hay que hacerlo random
    
    public String IngresarTropa(int cantidad, Tropa tropa, int ronda) {
     
        String mensaje="";
         int maximo = ronda + 1;
         if (cantidad > maximo) {
                mensaje="Estas excediendo la cantidad de tropas por ronda";
                 return mensaje;
              }

        
         if (tropa == null) {
                mensaje="No se puede agregar una tropa nula.";
                return mensaje;
            }

            int contador = 0;
            while (contador < cantidad) {
               this.getPila().push(tropa);//este this es para saber que se esta refiriendo a la clase Jugador
               contador++;
                 }
            mensaje=("Se ingresaron " + cantidad + " tropas del tipo " + tropa.getTipo());

            return mensaje;
}
    
     //Hay que hacerlo random
    
  
    
    
    
}
