package batalla;

import ColaBatalla.Cola;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public Cola camino1Jugador = new Cola();
    public Cola camino2Jugador = new Cola();
    public Cola camino1CPU  = new Cola();
    public Cola camino2CPU  = new Cola();

    // Registro de eventos por ronda
    private RegistroBatalla registro = new RegistroBatalla();

    public Batalla(Player jugador, CPU cpu) {
        this.numero = 1;
        this.jugador = jugador;
        this.cpu = cpu;
        this.ronda = 1;
        registro.registrarEvento(ronda, "— Inicio de ronda " + ronda + " —");
    }

    // Registrar evento en la ronda actual
    private void evento(String texto) {
        registro.registrarEvento(ronda, texto);
    }

    public RegistroBatalla getRegistro() {
        return registro;
    }

    public void prepararJugador(int caminos, Tropa tropa){
        if (caminos == 1) {
           camino1Jugador.encolar(tropa);
           evento("Jugador coloca " + tropa.getClass().getSimpleName() + " en Camino 1");
        } else {
           camino2Jugador.encolar(tropa);
           evento("Jugador coloca " + tropa.getClass().getSimpleName() + " en Camino 2");
        }
    }

    public Tropa seleccionarTropaAleatoria() {
        int d = (int) (Math.random() * 3);
        if (d == 0) return new Arquero();
        if (d == 1) return new Mago();
        return new Caballero();
    }

    public void prepararCPU() {
        int cantidad = Math.max(1, ronda); // al menos 1 tropa por ronda
        for (int i = 0; i < cantidad; i++) {
            Tropa tropa = seleccionarTropaAleatoria();
            boolean aCamino1 = Math.random() < 0.5;
            if (aCamino1) {
                camino1CPU.encolar(tropa);
                evento("CPU coloca " + tropa.getClass().getSimpleName() + " en Camino 1");
            } else {
                camino2CPU.encolar(tropa);
                evento("CPU coloca " + tropa.getClass().getSimpleName() + " en Camino 2");
            }
        }
    }

    public void Enfrentamiento() throws Exception {
        // CAMINO 1
        if (!camino1Jugador.estaVacia() && !camino1CPU.estaVacia()) {
            Tropa j1 = camino1Jugador.frente();
            Tropa c1 = camino1CPU.frente();

            if (j1.getFortaleza().equals(c1.getTipo())) {
                camino1CPU.desencolar();
                Tropa atacante = camino1Jugador.desencolar();
                cpu.getCastillo().recibirDanio(atacante.getDanio());
                evento("Jugador gana en Camino 1 con " + atacante.getClass().getSimpleName()
                       + " y hace " + atacante.getDanio() + " de daño al castillo CPU");
            } else if (c1.getFortaleza().equals(j1.getTipo())) {
                camino1Jugador.desencolar();
                Tropa atacante = camino1CPU.desencolar();
                jugador.getCastillo().recibirDanio(atacante.getDanio());
                evento("CPU gana en Camino 1 con " + atacante.getClass().getSimpleName()
                       + " y hace " + atacante.getDanio() + " de daño al castillo Jugador");
            } else {
                camino1Jugador.desencolar();
                camino1CPU.desencolar();
                evento("Empate en Camino 1 (ambas tropas se eliminan)");
            }
        } else if (!camino1Jugador.estaVacia() && camino1CPU.estaVacia()) {
            Tropa atacante = camino1Jugador.desencolar();
            cpu.getCastillo().recibirDanio(atacante.getDanio());
            evento("Jugador ataca castillo CPU desde Camino 1 con "
                   + atacante.getClass().getSimpleName() + " por " + atacante.getDanio());
        } else if (camino1Jugador.estaVacia() && !camino1CPU.estaVacia()) {
            Tropa atacante = camino1CPU.desencolar();
            jugador.getCastillo().recibirDanio(atacante.getDanio());
            evento("CPU ataca castillo Jugador desde Camino 1 con "
                   + atacante.getClass().getSimpleName() + " por " + atacante.getDanio());
        } else {
            evento("Sin acción en Camino 1 (ambos vacíos)");
        }

        // CAMINO 2
        if (!camino2Jugador.estaVacia() && !camino2CPU.estaVacia()) {
            Tropa j2 = camino2Jugador.frente();
            Tropa c2 = camino2CPU.frente();

            if (j2.getFortaleza().equals(c2.getTipo())) {
                camino2CPU.desencolar();
                Tropa atacante = camino2Jugador.desencolar();
                cpu.getCastillo().recibirDanio(atacante.getDanio());
                evento("Jugador gana en Camino 2 con " + atacante.getClass().getSimpleName()
                       + " y hace " + atacante.getDanio() + " de daño al castillo CPU");
            } else if (c2.getFortaleza().equals(j2.getTipo())) {
                camino2Jugador.desencolar();
                Tropa atacante = camino2CPU.desencolar();
                jugador.getCastillo().recibirDanio(atacante.getDanio());
                evento("CPU gana en Camino 2 con " + atacante.getClass().getSimpleName()
                       + " y hace " + atacante.getDanio() + " de daño al castillo Jugador");
            } else {
                camino2Jugador.desencolar();
                camino2CPU.desencolar();
                evento("Empate en Camino 2 (ambas tropas se eliminan)");
            }
        } else if (!camino2Jugador.estaVacia() && camino2CPU.estaVacia()) {
            Tropa atacante = camino2Jugador.desencolar();
            cpu.getCastillo().recibirDanio(atacante.getDanio());
            evento("Jugador ataca castillo CPU desde Camino 2 con "
                   + atacante.getClass().getSimpleName() + " por " + atacante.getDanio());
        } else if (camino2Jugador.estaVacia() && !camino2CPU.estaVacia()) {
            Tropa atacante = camino2CPU.desencolar();
            jugador.getCastillo().recibirDanio(atacante.getDanio());
            evento("CPU ataca castillo Jugador desde Camino 2 con "
                   + atacante.getClass().getSimpleName() + " por " + atacante.getDanio());
        } else {
            evento("Sin acción en Camino 2 (ambos vacíos)");
        }
    }

    public boolean rondaTerminada() {
        return camino1Jugador.estaVacia() && camino2Jugador.estaVacia()
                && camino1CPU.estaVacia() && camino2CPU.estaVacia();
    }

    public void AumentarRonda(){
        ronda++;
        registro.registrarEvento(ronda, "— Inicio de ronda " + ronda + " —");
    }

    public boolean batallaTerminada() {
        return jugador.getCastillo().getVida() <= 0 || cpu.getCastillo().getVida() <= 0;
    }

    public String resultadoBatalla() {
        if (jugador.getCastillo().getVida() <= 0) return "Derrota";
        if (cpu.getCastillo().getVida() <= 0) return "Victoria";
        return "En curso";
    }

    // getters básicos
    public int getNumero() { return numero; }
    public int getRonda() { return ronda; }
    public Player getJugador() { return jugador; }
    public CPU getCpu() { return cpu; }

    // ✅ Métodos agregados para obtener tropas en cada camino usando las colas
    public Tropa getTropaJugador(int camino) {
        if (camino == 1 && !camino1Jugador.estaVacia()) {
            try {
                return (Tropa) camino1Jugador.frente();
            } catch (Exception ex) {
                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (camino == 2 && !camino2Jugador.estaVacia()) {
            try {
                return (Tropa) camino2Jugador.frente();
            } catch (Exception ex) {
                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public Tropa getTropaCPU(int camino) {
        if (camino == 1 && !camino1CPU.estaVacia()) {
            try {
                return (Tropa) camino1CPU.frente();
            } catch (Exception ex) {
                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (camino == 2 && !camino2CPU.estaVacia()) {
            try {
                return (Tropa) camino2CPU.frente();
            } catch (Exception ex) {
                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public int getCantidadTropasJugador(int camino) {
        return contar(camino == 1 ? camino1Jugador : camino2Jugador);
    }

    public int getCantidadTropasCPU(int camino) {
        return contar(camino == 1 ? camino1CPU : camino2CPU);
    }

    // 🔓 Getters de las colas completas (para análisis en FrmBatalla)
    public Cola getCaminoJugador(int camino) {
        return (camino == 1) ? camino1Jugador : camino2Jugador;
    }

    public Cola getCaminoCPU(int camino) {
        return (camino == 1) ? camino1CPU : camino2CPU;
    }

    // Método auxiliar para contar elementos en una Cola sin perderlos
    private int contar(Cola cola) {
        if (cola == null) return 0;
        int n = 0;
        Cola temp = new Cola();
        while (!cola.estaVacia()) {
            try {
                Tropa t = (Tropa) cola.desencolar(); // 👈 conversión explícita
                temp.encolar(t);
                n++;
            } catch (Exception ex) {
                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        while (!temp.estaVacia()) {
            try {
                cola.encolar(temp.desencolar());
            } catch (Exception ex) {
                Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return n;
    }
}


