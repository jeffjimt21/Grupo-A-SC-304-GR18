
package Batalla;

import ColaBatalla.Cola;
import jugadores.CPU;
import jugadores.Player;

public class Batalla {

    private Cola colaPlayerCamino1;
    private Cola colaPlayerCamino2;
    private Cola colaCpuCamino1;
    private Cola colaCpuCamino2;

    public Batalla(Player jugador, CPU cpu) {
        colaPlayerCamino1 = new Cola();
        colaPlayerCamino2 = new Cola();
        colaCpuCamino1 = new Cola();
        colaCpuCamino2 = new Cola();
    }
}

