/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presentacion;

import javax.swing.*;
import java.awt.*;

public class MenuRecargas extends JFrame {
    private JButton btnIngresarCelular;
    private JButton btnRecarga5GB;
    private JButton btnRecarga2_3;
    private JButton btnSalir;

    public MenuRecargas() {
        setTitle("Menú de Recargas");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelBotones = new JPanel(new GridLayout(4, 1, 10, 10));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        btnIngresarCelular = new JButton("Ingresar Nuevo Celular");
        btnRecarga5GB = new JButton("Recarga 5GB por Dólar");
        btnRecarga2_3 = new JButton("Recarga 2/3 Saldo 1/3 Megas");
        btnSalir = new JButton("Salir");

        btnIngresarCelular.addActionListener(e -> new IngresarCelular());
        btnRecarga5GB.addActionListener(e -> new RecargarCelular("5GBporDolar"));
        btnRecarga2_3.addActionListener(e -> new RecargarCelular("2_3Saldo_1_3Megas"));
        btnSalir.addActionListener(e -> System.exit(0));

        panelBotones.add(btnIngresarCelular);
        panelBotones.add(btnRecarga5GB);
        panelBotones.add(btnRecarga2_3);
        panelBotones.add(btnSalir);

        add(panelBotones, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuRecargas();
    }
}
