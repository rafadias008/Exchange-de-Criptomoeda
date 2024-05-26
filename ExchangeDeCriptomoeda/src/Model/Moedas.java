/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model; // Declara que esta classe faz parte do pacote 'Model'

// A classe 'Moedas' implementa a interface 'TaxaMoedas'
public class Moedas implements TaxaMoedas {
   // Atributos privados da classe 'Moedas'
   private String cripto; // Nome da criptomoeda
   private double valor; // Valor da criptomoeda
   private double txVenda; // Taxa de venda
   private double txCompra; // Taxa de compra

   // Construtor que inicializa 'cripto' e 'valor'
    public Moedas(String cripto, double valor) {
        this.cripto = cripto;
        this.valor = valor;
    }

   // Construtor que inicializa todos os atributos
    public Moedas(String cripto, double valor, double txCompra, double txVenda) {
        this.cripto = cripto;
        this.valor = valor;
        this.txVenda = txVenda;
        this.txCompra = txCompra;
    }

    // Métodos get e set para acessar e modificar os atributos
    @Override
    public double getTxVenda() {
        return txVenda;
    }

    @Override
    public void setTxVenda(double txVenda) {
        this.txVenda = txVenda;
    }

    @Override
    public double getTxCompra() {
        return txCompra;
    }

    @Override
    public void setTxCompra(double txCompra) {
        this.txCompra = txCompra;
    }

    // Métodos get e set para 'cripto' e 'valor'
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

    // Método toString para representação em formato de string do objeto 'Moedas'
    @Override
    public String toString() {
        return "Moedas{" + "cripto=" + cripto + ", valor=" + valor + '}';
    }
}
