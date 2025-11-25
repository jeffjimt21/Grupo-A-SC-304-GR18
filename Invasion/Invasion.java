package Invasion;

import batalla.Batalla;
import batalla.RegistroBatalla;
import jugadores.Player;
import jugadores.CPU;
import tropas.Tropa;

public class Invasion {
    private Player jugador;
    private CPU cpu;
    private Batalla batalla;
    private boolean terminada;

    public Invasion(Player jugador, CPU cpu) {
        this.jugador = jugador;
        this.cpu = cpu;
        this.batalla = new Batalla(jugador, cpu);
        this.terminada = false;
    }

    public void asignarTropaJugador(int camino, Tropa tropa) {
        batalla.prepararJugador(camino, tropa);
    }

    public void prepararCPU() {
        batalla.prepararCPU();
    }

 
    public void ejecutarTurno() {
        try {
            batalla.Enfrentamiento();
        } catch (Exception e) {
            // No romper flujo
        }
        if (batalla.batallaTerminada()) {
            terminada = true;
        }
    }

    public void ejecutarTurnoCompleto() {
        try {
            while (!batalla.rondaTerminada() && !batalla.batallaTerminada()) {
                batalla.Enfrentamiento();
            }
        } catch (Exception e) {
           
        }
        if (batalla.batallaTerminada()) {
            terminada = true;
        }
    }

    public RegistroBatalla getRegistro() {
        return batalla.getRegistro();
    }


    public Integer siguienteRondaSiTermino() {
        if (batalla.rondaTerminada() && !batalla.batallaTerminada()) {
            int rondaTerminada = batalla.getRonda(); 
            batalla.AumentarRonda();                 
            return rondaTerminada;                   
        }
        return null; // si no terminó ninguna ronda
    }
    public String estadoInvasion() {
        if (terminada) {
            return "Resultado: " + batalla.resultadoBatalla();
        }
        return "En curso - Ronda " + batalla.getRonda();
    }

    public boolean invasionTerminada() { 
        return terminada; 
    }

    public Batalla obtenerBatallaActual() { 
        return batalla; 
    }

    public Player getJugador() { 
        return jugador; 
    }

    public CPU getCpu() { 
        return cpu; 
    }
}
