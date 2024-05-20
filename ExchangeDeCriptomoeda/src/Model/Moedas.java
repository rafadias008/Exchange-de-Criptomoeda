/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author rafae
 */
public class Moedas {
   private String cripto;
   private double valor;

    public Moedas(String cripto, double valor) {
        this.cripto = cripto;
        this.valor = valor;
    }
   
   

    public String getCripto() {
        return cripto;
    }

    public void setCripto(String cripto) {
        this.cripto = cripto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Moedas{" + "cripto=" + cripto + ", valor=" + valor + '}';
    }
   
   
}
