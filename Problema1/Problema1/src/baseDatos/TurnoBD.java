package baseDatos;

import clases.Turno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TurnoBD {

    public boolean existeTurno(int idTurn) {
        String sql = "SELECT COUNT(*) FROM Turno WHERE idTurn = ?";
        try (Connection conn = ConexionBD.getConnection(); 
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, idTurn);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void agregarTurno(Turno turno) {
        String sql = "INSERT INTO Turno (anden, dia, hora, idVehi) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, turno.getAnden());
            pstmt.setObject(2, turno.getDia());
            pstmt.setObject(3, turno.getHora());
            pstmt.setInt(4, turno.getIdVehi());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
