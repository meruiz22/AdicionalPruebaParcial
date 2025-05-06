/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

public class Celular {

    private int idCel;
    private String numero;
    private int estado;
    private int saldo;
    private int megas;
    private int idClie;

    public Celular() {
    }

    public Celular(int idCel, String numero, int estado, int saldo, int megas, int idClie) {
        this.idCel = idCel;
        this.numero = numero;
        this.estado = estado;
        this.saldo = saldo;
        this.megas = megas;
        this.idClie = idClie;
    }

    public int getIdCel() {
        return idCel;
    }

    public void setIdCel(int idCel) {
        this.idCel = idCel;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getMegas() {
        return megas;
    }

    public void setMegas(int megas) {
        this.megas = megas;
    }

    public int getIdClie() {
        return idClie;
    }

    public void setIdClie(int idClie) {
        this.idClie = idClie;
    }
    
    

}
