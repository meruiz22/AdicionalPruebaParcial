package presentacion;

import javax.swing.*;
import java.awt.*;

public class MenuTurnos extends JFrame {
    private JButton btnAgregarPropietario;
    private JButton btnAgregarVehiculo;
    private JButton btnAgregarTurno;
    private JButton btnSalir;
    private JPanel panelBotones;

    public MenuTurnos() {
        setTitle("Menú de Gestión de Turnos");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel para los botones
        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4, 1, 10, 10));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        btnAgregarPropietario = new JButton("Agregar Propietario y Turno");
        btnAgregarVehiculo = new JButton("Agregar Vehículo");
        btnAgregarTurno = new JButton("Agregar Turno");
        btnSalir = new JButton("Salir");

        btnAgregarPropietario.addActionListener(e -> new AgregarPropietario());
        btnAgregarVehiculo.addActionListener(e -> new AgregarVehiculo());
        btnAgregarTurno.addActionListener(e -> new AgregarTurno());
        btnSalir.addActionListener(e -> System.exit(0));

        panelBotones.add(btnAgregarPropietario);
        panelBotones.add(btnAgregarVehiculo);
        panelBotones.add(btnAgregarTurno);
        panelBotones.add(btnSalir);

        add(panelBotones, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuTurnos();
    }
}