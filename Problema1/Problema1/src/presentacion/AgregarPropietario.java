package presentacion;

import logica.PropietarioLogica;
import logica.VehiculoLogica;
import logica.TurnoLogica;
import clases.Propietario;
import clases.Vehiculo;
import clases.Turno;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class AgregarPropietario extends JFrame {
    private JTextField txtCedula, txtApellido, txtNombre;
    private JTextField txtPlaca, txtMarca, txtEstado;
    private JTextField txtAnden;
    private JSpinner dateSpinner, spinnerHora, spinnerMinutos;
    private JButton btnGuardar, btnCancelar;

    private PropietarioLogica propietarioLogica;
    private VehiculoLogica vehiculoLogica;
    private TurnoLogica turnoLogica;

    public AgregarPropietario() {
        setTitle("Agregar Propietario, Vehículo y Turno");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        propietarioLogica = new PropietarioLogica();
        vehiculoLogica = new VehiculoLogica();
        turnoLogica = new TurnoLogica();

        // Panel principal con GridLayout
        JPanel mainPanel = new JPanel(new GridLayout(9, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Campos para Propietario
        mainPanel.add(new JLabel("Cédula:"));
        txtCedula = new JTextField(15);
        mainPanel.add(txtCedula);

        mainPanel.add(new JLabel("Apellido:"));
        txtApellido = new JTextField(15);
        mainPanel.add(txtApellido);

        mainPanel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField(15);
        mainPanel.add(txtNombre);

        // Campos para Vehículo
        mainPanel.add(new JLabel("Placa del Vehículo:"));
        txtPlaca = new JTextField(15);
        mainPanel.add(txtPlaca);

        mainPanel.add(new JLabel("Marca:"));
        txtMarca = new JTextField(15);
        mainPanel.add(txtMarca);

        mainPanel.add(new JLabel("Estado:"));
        txtEstado = new JTextField(15);
        mainPanel.add(txtEstado);

        // Campos para Turno
        mainPanel.add(new JLabel("Andén:"));
        txtAnden = new JTextField(15);
        mainPanel.add(txtAnden);

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
                // Propietario
                String cedula = txtCedula.getText();
                String apellido = txtApellido.getText();
                String nombre = txtNombre.getText();
                Propietario propietario = new Propietario(0, cedula, apellido, nombre);
                int idProp = propietarioLogica.agregarPropietarioConId(propietario);
                if (idProp == -1) {
                    throw new IllegalStateException("No se pudo obtener el ID del propietario recién creado.");
                }

                // Vehículo
                String placa = txtPlaca.getText();
                String marca = txtMarca.getText();
                String estado = txtEstado.getText();
                Vehiculo vehiculo = new Vehiculo(0, placa, marca, estado, idProp);
                vehiculoLogica.agregarVehiculo(vehiculo);

                // Obtener el idVehi del vehículo recién creado
                int idVehi = vehiculoLogica.obtenerIdPorPlaca(placa);
                if (idVehi == -1) {
                    throw new IllegalStateException("No se pudo obtener el ID del vehículo recién creado.");
                }

                // Turno
                int anden = Integer.parseInt(txtAnden.getText());
                Date date = (Date) dateSpinner.getValue();
                LocalDate dia = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int hora = (int) spinnerHora.getValue();
                int minutos = (int) spinnerMinutos.getValue();
                LocalTime time = LocalTime.of(hora, minutos);
                Turno turno = new Turno(0, anden, dia, time, idVehi);

                turnoLogica.agregarTurno(turno);

                JOptionPane.showMessageDialog(this, "Propietario, Vehículo y Turno agregados con éxito.");
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