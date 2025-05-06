/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import baseDatos.CelularBD;
import clases.Celular;

public class CelularLogica {
    private CelularBD celularBD;

    public CelularLogica() {
        this.celularBD = new CelularBD();
    }

    public void agregarCelular(Celular celular) {
        celularBD.agregarCelular(celular);
    }

    public int obtenerIdPorNumero(String numero) {
        return celularBD.obtenerIdPorNumero(numero);
    }

    public Celular obtenerCelularPorNumero(String numero) {
        return celularBD.obtenerCelularPorNumero(numero);
    }

    public void actualizarCelular(Celular celular) {
        celularBD.actualizarCelular(celular);
    }
}