/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import baseDatos.RecargaBD;
import clases.Celular;
import clases.Recarga;

public class RecargaLogica {
    private RecargaBD recargaBD;
    private CelularLogica celularLogica;

    public RecargaLogica() {
        this.recargaBD = new RecargaBD();
        this.celularLogica = new CelularLogica();
    }

    public void realizarRecarga(String numero, int valor, String tipoDistribucion) {
        Celular celular = celularLogica.obtenerCelularPorNumero(numero);
        if (celular == null) {
            throw new IllegalArgumentException("Celular no encontrado.");
        }
        if (celular.getEstado() != 1) {
            throw new IllegalStateException("El celular no está activo para recargar.");
        }

        int saldo = 0;
        int megas = 0;
        if ("5GBporDolar".equals(tipoDistribucion)) {
            saldo = valor * 100; // Suponiendo centavos por dólar
            megas = valor * 5 * 1024; // 5 GB por dólar en MB
        } else if ("2_3Saldo_1_3Megas".equals(tipoDistribucion)) {
            saldo = (int) (valor * 100 * 2.0 / 3.0); // 2/3 del valor en centavos
            megas = (int) ((valor * 1.0 / 3.0) * 5 * 1024); // 1/3 del valor en MB (5 GB por dólar)
        }

        celular.setSaldo(celular.getSaldo() + saldo);
        celular.setMegas(celular.getMegas() + megas);
        celularLogica.actualizarCelular(celular);

        Recarga recarga = new Recarga(0, valor, saldo, megas, celular.getIdCel());
        recargaBD.agregarRecarga(recarga);
    }
}
