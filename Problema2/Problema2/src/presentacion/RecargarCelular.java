/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import logica.RecargaLogica;
import javax.swing.*;
import java.awt.*;

public class RecargarCelular extends JFrame {
    private JTextField txtNumero, txtValor;
    private JButton btnRecargar, btnCancelar;
    private String tipoDistribucion;

    private RecargaLogica recargaLogica;

    public RecargarCelular(String tipoDistribucion) {
        this.tipoDistribucion = tipoDistribucion;
        setTitle("Realizar Recarga - " + (tipoDistribucion.equals("5GBporDolar") ? "5GB por Dólar" : "2/3 Saldo 1/3 Megas"));
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        recargaLogica = new RecargaLogica();

        JPanel mainPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        mainPanel.add(new JLabel("Número de Celular:"));
        txtNumero = new JTextField(15);
        mainPanel.add(txtNumero);

        mainPanel.add(new JLabel("Valor de la Recarga (dólares):"));
        txtValor = new JTextField(15);
        mainPanel.add(txtValor);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        btnRecargar = new JButton("Recargar");
        btnCancelar = new JButton("Cancelar");
        buttonPanel.add(btnRecargar);
        buttonPanel.add(btnCancelar);

        btnRecargar.addActionListener(e -> {
            try {
                String numero = txtNumero.getText();
                int valor = Integer.parseInt(txtValor.getText());
                recargaLogica.realizarRecarga(numero, valor, tipoDistribucion);
                JOptionPane.showMessageDialog(this, "Recarga realizada con éxito.");
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