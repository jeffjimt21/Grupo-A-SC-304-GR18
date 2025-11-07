
package jugadores;

import tropas.Tropa;


public class Player extends Jugadores {
    
    private int cantidad;
    
    public Player(String nombre) {
        super(nombre);
    }
    
    //Segun el documento:
    /*Al inicio de cada ronda el jugador elige el tipo de tropa y la cantidad de cada tipo de
    tropa que enviara por cada camino.
    • La cantidad de tropas que puede colocar el jugador esta limitada por la siguiente
    ecuación:
    o 𝐶𝑎𝑛𝑡𝑖𝑑𝑎𝑑 𝑑𝑒 𝑡𝑟𝑜𝑝𝑎𝑠 = 𝑛𝑢𝑚𝑒𝑟𝑜 𝑑𝑒 𝑟𝑜𝑛𝑑𝑎 + 1*/
    
    
    
    public String IngresarTropa(int cantidad, Tropa tropa, int ronda) {
        String mensaje = "";
        int maximo = ronda + 1;

        if (cantidad > maximo) {
            mensaje = "Estás excediendo la cantidad de tropas por ronda";
            return mensaje;
        }

        if (tropa == null) {
            mensaje = "No se puede agregar una tropa nula.";
            return mensaje;
        }

        int contador = 0;
        while (contador < cantidad) {
            this.getPila().push(tropa); 
            contador++;
        }
        mensaje = ("Se ingresaron " + cantidad + " tropas del tipo " + tropa.getTipo());

        return mensaje;
    }

    // Método para seleccionar el camino
    public int SeleccionarCamino(int caminos) {
        if (caminos == 1) {
            return 1;
        } else if (caminos == 2) {
            return 2;
        } else {
            return 0;  // Si no hay caminos válidos
        }
    }
}
