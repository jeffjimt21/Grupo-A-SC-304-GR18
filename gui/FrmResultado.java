package Formularios;

import javax.swing.*;

public class FrmResultado extends JFrame {

    private JLabel lblResultado;
    private JButton btnSalir;
    private JButton btnVolverJugar;

    public FrmResultado(String resultado) {
        initComponents();
        lblResultado.setText(resultado);
    }

    private void initComponents() {
        setTitle("Resultado de la Invasión");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        lblResultado = new JLabel("Resultado");
        lblResultado.setBounds(50, 50, 300, 40);
        lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
        lblResultado.setFont(new java.awt.Font("Tw Cen MT", 1, 24));
        add(lblResultado);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(60, 150, 100, 40);
        btnSalir.addActionListener(e -> dispose());
        add(btnSalir);

        btnVolverJugar = new JButton("Volver a jugar");
        btnVolverJugar.setBounds(200, 150, 150, 40);
        btnVolverJugar.addActionListener(e -> {
            FrmPrincipal principal = new FrmPrincipal();
            principal.setVisible(true);
            dispose();
        });
        add(btnVolverJugar);
    }
}
