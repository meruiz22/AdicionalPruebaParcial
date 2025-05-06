package baseDatos;

import clases.Vehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VehiculoBD {
    public boolean existeVehiculo(String placa) {
        String sql = "SELECT COUNT(*) FROM Vehiculo WHERE placa = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, placa);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int obtenerIdPorPlaca(String placa) {
        String sql = "SELECT idVehi FROM Vehiculo WHERE placa = ?";
        try (Connection conn = ConexionBD.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, placa);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("idVehi");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Retorna -1 si no se encuentra
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        String sql = "INSERT INTO Vehiculo (placa, marca, estado, idProp) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, vehiculo.getPlaca());
            pstmt.setString(2, vehiculo.getMarca());
            pstmt.setString(3, vehiculo.getEstado());
            pstmt.setInt(4, vehiculo.getIdProp());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}