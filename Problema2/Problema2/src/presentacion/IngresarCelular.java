/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import logica.ClienteLogica;
import logica.CelularLogica;
import clases.Cliente;
import clases.Celular;
import javax.swing.*;
import java.awt.*;

public class IngresarCelular extends JFrame {
    private JTextField txtCedula, txtNombres, txtApellidos, txtNumero, txtEstado;
    private JButton btnGuardar, btnCancelar;

    private ClienteLogica clienteLogica;
    private CelularLogica celularLogica;

    public IngresarCelular() {
        setTitle("Ingresar Nuevo Celular");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        clienteLogica = new ClienteLogica();
        celularLogica = new CelularLogica();

        JPanel mainPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        mainPanel.add(new JLabel("Cédula:"));
        txtCedula = new JTextField(15);
        mainPanel.add(txtCedula);

        mainPanel.add(new JLabel("Nombres:"));
        txtNombres = new JTextField(15);
        mainPanel.add(txtNombres);

        mainPanel.add(new JLabel("Apellidos:"));
        txtApellidos = new JTextField(15);
        mainPanel.add(txtApellidos);

        mainPanel.add(new JLabel("Número:"));
        txtNumero = new JTextField(15);
        mainPanel.add(txtNumero);

        mainPanel.add(new JLabel("Estado (1=Activo, 0=Inactivo):"));
        txtEstado = new JTextField(15);
        mainPanel.add(txtEstado);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");
        buttonPanel.add(btnGuardar);
        buttonPanel.add(btnCancelar);

        btnGuardar.addActionListener(e -> {
            try {
                String cedula = txtCedula.getText();
                String nombres = txtNombres.getText();
                String apellidos =txtApellidos.getText();
                String numero = txtNumero.getText();
                int estado = Integer.parseInt(txtEstado.getText());

                Cliente cliente = new Cliente(0, cedula, nombres, apellidos);
                clienteLogica.agregarCliente(cliente);
                int idClie = clienteLogica.obtenerIdPorCedula(cedula);
                if (idClie == -1) {
                    throw new IllegalStateException("No se pudo obtener el ID del cliente.");
                }

                Celular celular = new Celular(0, numero, estado, 0, 0, idClie);
                celularLogica.agregarCelular(celular);

                JOptionPane.showMessageDialog(this, "Celular ingresado con éxito.");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        btnCancelar.addActionListener(e -> dispose());

        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
