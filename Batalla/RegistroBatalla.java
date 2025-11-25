package batalla;

import java.util.*;

public class RegistroBatalla {
    private Map<Integer, List<String>> rondas = new HashMap<>();

    public void registrarEvento(int ronda, String evento) {
        rondas.computeIfAbsent(ronda, k -> new ArrayList<>()).add(evento);
    }

    public List<String> obtenerEventosDeRonda(int ronda) {
        return rondas.getOrDefault(ronda, new ArrayList<>());
    }

    public List<Integer> obtenerRondasRegistradas() {
        List<Integer> ordenadas = new ArrayList<>(rondas.keySet());
        Collections.sort(ordenadas);
        return ordenadas;
    }

    public List<String> obtenerHistorialCompleto() {
        List<String> historial = new ArrayList<>();
        for (int ronda : obtenerRondasRegistradas()) {
            historial.add("— Ronda " + ronda + " —");
            historial.addAll(rondas.get(ronda));
        }
        return historial;
    }
}
