package logica;

import baseDatos.ConexionBD;
import baseDatos.TurnoBD;
import clases.Turno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class TurnoLogica {
    private TurnoBD turnoBD;

    public TurnoLogica() {
        this.turnoBD = new TurnoBD();
    }

    public boolean existeTurno(int idTurn) {
        return turnoBD.existeTurno(idTurn);
    }

    public boolean validarTurnoUnicoPorDia(int idVehi, LocalDate dia) {
        String sql = "SELECT COUNT(*) FROM Turno WHERE idVehi = ? AND dia = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idVehi);
            pstmt.setObject(2, dia);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) == 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean validarAndenDisponible(int anden, LocalDate dia, LocalTime hora) {
        String sql = "SELECT COUNT(*) FROM Turno WHERE anden = ? AND dia = ? AND hora = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, anden);
            pstmt.setObject(2, dia);
            pstmt.setObject(3, hora);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) == 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void agregarTurno(Turno turno) {
        if (!existeTurno(turno.getIdTurn()) &&
            validarTurnoUnicoPorDia(turno.getIdVehi(), turno.getDia()) &&
            validarAndenDisponible(turno.getAnden(), turno.getDia(), turno.getHora())) {
            turnoBD.agregarTurno(turno);
        } else {
            throw new IllegalStateException("No se puede agregar el turno: ya existe un turno con ID " + turno.getIdTurn() +
                                           " o el vehículo tiene un turno este día o el andén está ocupado.");
        }
    }
}