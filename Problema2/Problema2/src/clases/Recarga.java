/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

public class Recarga {

    private int idReca;
    private int valor;
    private int saldo;
    private int megas;
    private int idCel;

    public Recarga() {
    }

    public Recarga(int idReca, int valor, int saldo, int megas, int idCel) {
        this.idReca = idReca;
        this.valor = valor;
        this.saldo = saldo;
        this.megas = megas;
        this.idCel = idCel;
    }

    public int getIdReca() {
        return idReca;
    }

    public void setIdReca(int idReca) {
        this.idReca = idReca;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
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

    public int getIdCel() {
        return idCel;
    }

    public void setIdCel(int idCel) {
        this.idCel = idCel;
    }
    
    
}
