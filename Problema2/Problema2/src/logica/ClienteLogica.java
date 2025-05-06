/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import baseDatos.ClienteBD;
import clases.Cliente;

public class ClienteLogica {
    private ClienteBD clienteBD;

    public ClienteLogica() {
        this.clienteBD = new ClienteBD();
    }

    public void agregarCliente(Cliente cliente) {
        clienteBD.agregarCliente(cliente);
    }

    public int obtenerIdPorCedula(String cedula) {
        return clienteBD.obtenerIdPorCedula(cedula);
    }
}
