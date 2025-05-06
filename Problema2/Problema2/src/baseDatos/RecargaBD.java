/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import clases.Recarga;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RecargaBD {
    public void agregarRecarga(Recarga recarga) {
        String sql = "INSERT INTO Recargas (valor, saldo, megas, idCel) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, recarga.getValor());
            pstmt.setInt(2, recarga.getSaldo());
            pstmt.setInt(3, recarga.getMegas());
            pstmt.setInt(4, recarga.getIdCel());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
