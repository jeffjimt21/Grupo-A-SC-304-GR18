package jugadores;

import tropas.Tropa;

public class CPU extends Jugadores {

    public CPU(String nombre) {
        super(nombre);
    }

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

    public String seleccionarTropaAleatoria(int ronda) {
        int decision = (int) (Math.random() * 3);  
        String tropaSeleccionada = "";

        if (decision == 0) {
            tropaSeleccionada = "Soldado";
        } else if (decision == 1) {
            tropaSeleccionada = "Tanque";
        } else {
            tropaSeleccionada = "Aereo";
        }

        int cantidad = ronda + 1;
        return tropaSeleccionada + " cantidad: " + cantidad;
    }

    public void tomarDecision(int ronda) {
        String tropaElegida = seleccionarTropaAleatoria(ronda);
        System.out.println("La CPU ha decidido enviar: " + tropaElegida);
    }
}
