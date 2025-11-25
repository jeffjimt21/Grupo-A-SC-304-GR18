package Formularios;

import batalla.RegistroBatalla;
import java.awt.*;
import java.util.List;
import javax.swing.*;

public class FrmDetalleBatalla extends JFrame {

    private RegistroBatalla registro;
    private JComboBox<Integer> cmbRondas;
    private JTextArea txtEventos;

    public FrmDetalleBatalla(RegistroBatalla registro) {
        this.registro = registro;
        setTitle("Detalle de la Batalla por Ronda");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Selector de rondas
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(new JLabel("Seleccionar ronda:"));
        cmbRondas = new JComboBox<>();
        cmbRondas.addActionListener(e -> mostrarEventosDeRonda());
        topPanel.add(cmbRondas);
        add(topPanel, BorderLayout.NORTH);


        txtEventos = new JTextArea();
        txtEventos.setEditable(false);
        txtEventos.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
        txtEventos.setLineWrap(true);
        txtEventos.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(txtEventos);
        add(scroll, BorderLayout.CENTER);

        // Botón cerrar
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(btnCerrar);
        add(bottomPanel, BorderLayout.SOUTH);

        actualizarRegistro(); // inicializa al abrir
    }


    public void actualizarRegistro() {
        cmbRondas.removeAllItems();
        for (int ronda : registro.obtenerRondasRegistradas()) {
            cmbRondas.addItem(ronda);
        }

        if (cmbRondas.getItemCount() > 0) {
           
            cmbRondas.setSelectedIndex(cmbRondas.getItemCount() - 1);
            mostrarEventosDeRonda();
        } else {
            txtEventos.setText("No hay rondas registradas.");
        }
    }

    private void mostrarEventosDeRonda() {
        Integer rondaSeleccionada = (Integer) cmbRondas.getSelectedItem();
        if (rondaSeleccionada == null) {
            txtEventos.setText("No hay rondas seleccionadas.");
            return;
        }

        List<String> eventos = registro.obtenerEventosDeRonda(rondaSeleccionada);
        if (eventos.isEmpty()) {
            txtEventos.setText("No hay eventos registrados en esta ronda.");
        } else {
            txtEventos.setText("• " + String.join("\n• ", eventos));
        }
    }
}
