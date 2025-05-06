package presentacion;

import logica.TurnoLogica;
import logica.VehiculoLogica;
import clases.Turno;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class AgregarTurno extends JFrame {
    private JTextField txtAnden, txtPlacaVehiculo;
    private JSpinner dateSpinner, spinnerHora, spinnerMinutos;
    private JButton btnGuardar, btnCancelar;

    private TurnoLogica turnoLogica;
    private VehiculoLogica vehiculoLogica;

    public AgregarTurno() {
        setTitle("Agregar Turno");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        turnoLogica = new TurnoLogica();
        vehiculoLogica = new VehiculoLogica();

        // Panel principal con GridLayout
        JPanel mainPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        mainPanel.add(new JLabel("Andén:"));
        txtAnden = new JTextField(15);
        mainPanel.add(txtAnden);

        mainPanel.add(new JLabel("Placa del Vehículo:"));
        txtPlacaVehiculo = new JTextField(15);
        mainPanel.add(txtPlacaVehiculo);

        mainPanel.add(new JLabel("Fecha:"));
        dateSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy");
        dateSpinner.setEditor(dateEditor);
        mainPanel.add(dateSpinner);

        mainPanel.add(new JLabel("Hora:"));
        JPanel horaPanel = new JPanel(new FlowLayout());
        spinnerHora = new JSpinner(new SpinnerNumberModel(0, 0, 23, 1));
        spinnerMinutos = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
        horaPanel.add(spinnerHora);
        horaPanel.add(new JLabel(":"));
        horaPanel.add(spinnerMinutos);
        mainPanel.add(horaPanel);

        // Panel para botones
        JPanel buttonPanel = new JPanel(new FlowLayout());
        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");
        buttonPanel.add(btnGuardar);
        buttonPanel.add(btnCancelar);

        // Acción del botón Guardar
        btnGuardar.addActionListener(e -> {
            try {
                int anden = Integer.parseInt(txtAnden.getText());
                String placaVehiculo = txtPlacaVehiculo.getText();
                int idVehi = vehiculoLogica.obtenerIdPorPlaca(placaVehiculo);
                if (idVehi == -1) {
                    throw new IllegalArgumentException("No existe un vehículo con la placa: " + placaVehiculo);
                }

                Date date = (Date) dateSpinner.getValue();
                LocalDate dia = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int hora = (int) spinnerHora.getValue();
                int minutos = (int) spinnerMinutos.getValue();
                LocalTime time = LocalTime.of(hora, minutos);

                Turno turno = new Turno(0, anden, dia, time, idVehi);
                turnoLogica.agregarTurno(turno);

                JOptionPane.showMessageDialog(this, "Turno agregado con éxito.");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        // Acción del botón Cancelar
        btnCancelar.addActionListener(e -> dispose());

        // Añadir paneles al frame
        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}