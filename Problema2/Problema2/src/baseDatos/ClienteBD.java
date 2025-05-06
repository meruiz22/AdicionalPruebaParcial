/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import clases.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteBD {
    public void agregarCliente(Cliente cliente) {
        String sql = "INSERT INTO Cliente (cedula, nombres, apellidos) VALUES (?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cliente.getCedula());
            pstmt.setString(2, cliente.getNombres());
            pstmt.setString(3, cliente.getApellidos());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int obtenerIdPorCedula(String cedula) {
        String sql = "SELECT idClie FROM Cliente WHERE cedula = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cedula);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("idClie");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
