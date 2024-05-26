/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model; // Declara que esta interface faz parte do pacote 'Model'

// Declaração da interface 'TaxaMoedas'
public interface TaxaMoedas {
    
    // Método para obter a taxa de venda
    double getTxVenda();

    // Método para definir a taxa de venda
    void setTxVenda(double txVenda);

    // Método para obter a taxa de compra
    double getTxCompra();

    // Método para definir a taxa de compra
    void setTxCompra(double txCompra);
}
