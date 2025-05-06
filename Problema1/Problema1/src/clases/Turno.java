/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {

    private int idTurn;
    private int anden;
    private LocalDate dia;
    private LocalTime hora;
    private int idVehi;

    public Turno() {
    }

    public Turno(int idTurn, int anden, LocalDate dia, LocalTime hora, int idVehi) {
        this.idTurn = idTurn;
        this.anden = anden;
        this.dia = dia;
        this.hora = hora;
        this.idVehi = idVehi;
    }

    public int getIdTurn() {
        return idTurn;
    }

    public void setIdTurn(int idTurn) {
        this.idTurn = idTurn;
    }

    public int getAnden() {
        return anden;
    }

    public void setAnden(int anden) {
        this.anden = anden;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getIdVehi() {
        return idVehi;
    }

    public void setIdVehi(int idVehi) {
        this.idVehi = idVehi;
    }
    
    
}
