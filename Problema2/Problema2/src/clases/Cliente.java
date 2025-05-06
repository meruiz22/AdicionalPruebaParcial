/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

public class Cliente {

    private int idClie;
    private int cedula;
    private int nombres;
    private int apellidos;

    public Cliente() {
    }

    public Cliente(int idClie, int cedula, int nombres, int apellidos) {
        this.idClie = idClie;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public int getIdClie() {
        return idClie;
    }

    public void setIdClie(int idClie) {
        this.idClie = idClie;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getNombres() {
        return nombres;
    }

    public void setNombres(int nombres) {
        this.nombres = nombres;
    }

    public int getApellidos() {
        return apellidos;
    }

    public void setApellidos(int apellidos) {
        this.apellidos = apellidos;
    }
    
    
}
