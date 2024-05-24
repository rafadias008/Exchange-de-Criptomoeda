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
   private double valor,txVenda,txCompra;

    public Moedas(String cripto, double valor) {
        this.cripto = cripto;
        this.valor = valor;
    }

    public Moedas(String cripto, double valor, double txCompra, double txVenda) {
        this.cripto = cripto;
        this.valor = valor;
        this.txVenda = txVenda;
        this.txCompra = txCompra;
    }

    
    
    
    public double getTxVenda() {
        return txVenda;
    }

    public void setTxVenda(double txVenda) {
        this.txVenda = txVenda;
    }

    public double getTxCompra() {
        return txCompra;
    }

    public void setTxCompra(double txCompra) {
        this.txCompra = txCompra;
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
