/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import clases.Celular;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CelularBD {
    public void agregarCelular(Celular celular) {
        String sql = "INSERT INTO Celular (numero, estado, saldo, megas, idClie) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, celular.getNumero());
            pstmt.setInt(2, celular.getEstado());
            pstmt.setInt(3, celular.getSaldo());
            pstmt.setInt(4, celular.getMegas());
            pstmt.setInt(5, celular.getIdClie());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int obtenerIdPorNumero(String numero) {
        String sql = "SELECT idCel FROM Celular WHERE numero = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, numero);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("idCel");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public Celular obtenerCelularPorNumero(String numero) {
        String sql = "SELECT * FROM Celular WHERE numero = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, numero);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Celular(
                    rs.getInt("idCel"),
                    rs.getString("numero"),
                    rs.getInt("estado"),
                    rs.getInt("saldo"),
                    rs.getInt("megas"),
                    rs.getInt("idClie")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void actualizarCelular(Celular celular) {
        String sql = "UPDATE Celular SET estado = ?, saldo = ?, megas = ? WHERE idCel = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, celular.getEstado());
            pstmt.setInt(2, celular.getSaldo());
            pstmt.setInt(3, celular.getMegas());
            pstmt.setInt(4, celular.getIdCel());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
