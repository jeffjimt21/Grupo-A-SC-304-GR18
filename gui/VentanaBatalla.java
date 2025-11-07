package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaBatalla extends JFrame {

    // Paneles principales
    private JPanel panelJugador;
    private JPanel panelCaminos;
    private JPanel panelCpu;

    // Slots de tropas jugador
    private JPanel slotTropaJ1;
    private JPanel slotTropaJ2;
    private JPanel slotTropaJ3;

    // Slots de tropas CPU
    private JPanel slotTropaC1;
    private JPanel slotTropaC2;
    private JPanel slotTropaC3;

    // “Casillas” de los caminos (3 por camino)
    private JPanel camino1Casilla1;
    private JPanel camino1Casilla2;
    private JPanel camino1Casilla3;

    private JPanel camino2Casilla1;
    private JPanel camino2Casilla2;
    private JPanel camino2Casilla3;

    // Castillos (por ahora solo etiquetas; luego les ponemos imagen)
    private JLabel castilloJugador;
    private JLabel castilloCpu;

    public VentanaBatalla() {
        setTitle("Batalla - Tower Defense");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 800);
        setLocationRelativeTo(null); // centrar pantalla

        initComponents();
    }

    private void initComponents() {
        // Usamos BorderLayout para todo el frame
        setLayout(new BorderLayout());

        crearPanelJugador();
        crearPanelCaminos();
        crearPanelCpu();

        add(panelJugador, BorderLayout.NORTH);
        add(panelCaminos, BorderLayout.CENTER);
        add(panelCpu, BorderLayout.SOUTH);
    }

    private void crearPanelJugador() {
    panelJugador = new JPanel();
    panelJugador.setLayout(new BorderLayout());
    panelJugador.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
    panelJugador.setPreferredSize(new Dimension(600, 200)); // menos alto

    // Panel de slots de tropas (arriba izquierda)
    JPanel panelTropasJugador = new JPanel();
    panelTropasJugador.setLayout(new GridLayout(1, 3, 10, 0));
    JLabel lblTropasJ = new JLabel("Tropas");

    JPanel contenedorIzq = new JPanel(new BorderLayout());
    contenedorIzq.setOpaque(false);
    contenedorIzq.add(lblTropasJ, BorderLayout.NORTH);

    slotTropaJ1 = crearSlotCuadrado(Color.WHITE, Color.BLUE);
    slotTropaJ2 = crearSlotCuadrado(Color.WHITE, Color.BLUE);
    slotTropaJ3 = crearSlotCuadrado(Color.WHITE, Color.BLUE);

    panelTropasJugador.add(slotTropaJ1);
    panelTropasJugador.add(slotTropaJ2);
    panelTropasJugador.add(slotTropaJ3);

    contenedorIzq.add(panelTropasJugador, BorderLayout.CENTER);

    // Castillo del jugador en un panel con FlowLayout para que no se estire
    castilloJugador = new JLabel("CASTILLO JUGADOR", JLabel.CENTER);
    castilloJugador.setPreferredSize(new Dimension(200, 80)); // más pequeño
    castilloJugador.setOpaque(true);
    castilloJugador.setBackground(new Color(230, 230, 230));
    castilloJugador.setBorder(BorderFactory.createLineBorder(Color.GRAY));

    JPanel panelCastilloCentro = new JPanel();
    panelCastilloCentro.setOpaque(false);
    panelCastilloCentro.add(castilloJugador); // respeta el preferredSize

    // Texto “Jugador” en un panel con padding para que no quede pegado
    JLabel lblJugador = new JLabel("Jugador");
    lblJugador.setForeground(new Color(0, 102, 204));
    JPanel panelEtiquetaJugador = new JPanel();
    panelEtiquetaJugador.setOpaque(false);
    panelEtiquetaJugador.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
    panelEtiquetaJugador.add(lblJugador);

    panelJugador.add(contenedorIzq, BorderLayout.WEST);
    panelJugador.add(panelCastilloCentro, BorderLayout.CENTER);
    panelJugador.add(panelEtiquetaJugador, BorderLayout.EAST);
}
    
    private void crearPanelCaminos() {
        panelCaminos = new JPanel();
        panelCaminos.setBorder(BorderFactory.createEmptyBorder(20, 150, 20, 150));
        panelCaminos.setLayout(new GridLayout(3, 2, 20, 40)); // 3 filas, 2 columnas

        // Camino 1 (columna azul)
        camino1Casilla1 = crearSlotCuadrado(new Color(204, 229, 255), Color.BLUE);
        camino1Casilla2 = crearSlotCuadrado(new Color(204, 229, 255), Color.BLUE);
        camino1Casilla3 = crearSlotCuadrado(new Color(204, 229, 255), Color.BLUE);

        // Camino 2 (columna naranja)
        camino2Casilla1 = crearSlotCuadrado(new Color(255, 229, 204), Color.ORANGE);
        camino2Casilla2 = crearSlotCuadrado(new Color(255, 229, 204), Color.ORANGE);
        camino2Casilla3 = crearSlotCuadrado(new Color(255, 229, 204), Color.ORANGE);

        // Primera fila: casilla1 camino1, casilla1 camino2
        panelCaminos.add(camino1Casilla1);
        panelCaminos.add(camino2Casilla1);
        // Segunda fila
        panelCaminos.add(camino1Casilla2);
        panelCaminos.add(camino2Casilla2);
        // Tercera fila
        panelCaminos.add(camino1Casilla3);
        panelCaminos.add(camino2Casilla3);
    }
    
    private void crearPanelCpu() {
    panelCpu = new JPanel();
    panelCpu.setLayout(new BorderLayout());
    panelCpu.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
    panelCpu.setPreferredSize(new Dimension(600, 200)); // menos alto

    // Texto “CPU” en un panel con padding
    JLabel lblCpu = new JLabel("CPU");
    lblCpu.setForeground(new Color(255, 102, 0));
    JPanel panelEtiquetaCpu = new JPanel();
    panelEtiquetaCpu.setOpaque(false);
    panelEtiquetaCpu.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
    panelEtiquetaCpu.add(lblCpu);

    // Castillo CPU en panel con FlowLayout
    castilloCpu = new JLabel("CASTILLO CPU", JLabel.CENTER);
    castilloCpu.setPreferredSize(new Dimension(200, 80)); // más pequeño
    castilloCpu.setOpaque(true);
    castilloCpu.setBackground(new Color(230, 230, 230));
    castilloCpu.setBorder(BorderFactory.createLineBorder(Color.GRAY));

    JPanel panelCastilloCentro = new JPanel();
    panelCastilloCentro.setOpaque(false);
    panelCastilloCentro.add(castilloCpu);

    // Panel de tropas CPU (abajo derecha)
    JPanel panelTropasCpu = new JPanel();
    panelTropasCpu.setLayout(new GridLayout(1, 3, 10, 0));
    JLabel lblTropasC = new JLabel("Tropas");

    slotTropaC1 = crearSlotCuadrado(Color.WHITE, Color.ORANGE);
    slotTropaC2 = crearSlotCuadrado(Color.WHITE, Color.ORANGE);
    slotTropaC3 = crearSlotCuadrado(Color.WHITE, Color.ORANGE);

    panelTropasCpu.add(slotTropaC1);
    panelTropasCpu.add(slotTropaC2);
    panelTropasCpu.add(slotTropaC3);

    JPanel contenedorDer = new JPanel(new BorderLayout());
    contenedorDer.setOpaque(false);
    contenedorDer.add(lblTropasC, BorderLayout.NORTH);
    contenedorDer.add(panelTropasCpu, BorderLayout.CENTER);

    panelCpu.add(panelEtiquetaCpu, BorderLayout.WEST);
    panelCpu.add(panelCastilloCentro, BorderLayout.CENTER);
    panelCpu.add(contenedorDer, BorderLayout.EAST);
}



// Crea un panel cuadrado con color de fondo y borde
    private JPanel crearSlotCuadrado(Color fondo, Color borde) {
        JPanel p = new JPanel();
        // antes era 50x50, ahora un poco más grande
        p.setPreferredSize(new Dimension(70, 70));
        p.setBackground(fondo);
        p.setBorder(BorderFactory.createLineBorder(borde));
        return p;
    }

    // Main SOLO para probar la ventana (luego llamamos desde tu main real)
    public static void main(String[] args) {
        VentanaBatalla v = new VentanaBatalla();
        v.setVisible(true);
    }
}
