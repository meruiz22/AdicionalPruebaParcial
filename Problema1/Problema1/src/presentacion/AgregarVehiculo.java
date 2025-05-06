package presentacion;

import logica.VehiculoLogica;
import logica.PropietarioLogica;
import clases.Vehiculo;
import javax.swing.*;
import java.awt.*;

public class AgregarVehiculo extends JFrame {
    private JTextField txtPlaca, txtMarca, txtEstado, txtCedulaPropietario;
    private JButton btnGuardar, btnCancelar;

    private VehiculoLogica vehiculoLogica;
    private PropietarioLogica propietarioLogica;

    public AgregarVehiculo() {
        setTitle("Agregar Vehículo");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        vehiculoLogica = new VehiculoLogica();
        propietarioLogica = new PropietarioLogica();

        // Panel principal con GridLayout
        JPanel mainPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        mainPanel.add(new JLabel("Placa:"));
        txtPlaca = new JTextField(15);
        mainPanel.add(txtPlaca);

        mainPanel.add(new JLabel("Marca:"));
        txtMarca = new JTextField(15);
        mainPanel.add(txtMarca);

        mainPanel.add(new JLabel("Estado:"));
        txtEstado = new JTextField(15);
        mainPanel.add(txtEstado);

        mainPanel.add(new JLabel("Cédula del Propietario:"));
        txtCedulaPropietario = new JTextField(15);
        mainPanel.add(txtCedulaPropietario);

        // Panel para botones
        JPanel buttonPanel = new JPanel(new FlowLayout());
        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");
        buttonPanel.add(btnGuardar);
        buttonPanel.add(btnCancelar);

        // Acción del botón Guardar
        btnGuardar.addActionListener(e -> {
            try {
                String placa = txtPlaca.getText();
                String marca = txtMarca.getText();
                String estado = txtEstado.getText();
                String cedulaPropietario = txtCedulaPropietario.getText();

                int idProp = propietarioLogica.obtenerIdPorCedula(cedulaPropietario);
                if (idProp == -1) {
                    throw new IllegalArgumentException("No existe un propietario con la cédula: " + cedulaPropietario);
                }

                Vehiculo vehiculo = new Vehiculo(0, placa, marca, estado, idProp);
                vehiculoLogica.agregarVehiculo(vehiculo);

                JOptionPane.showMessageDialog(this, "Vehículo agregado con éxito.");
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