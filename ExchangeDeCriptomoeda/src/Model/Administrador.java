/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model; // Declara que esta classe faz parte do pacote 'Model'

// Define a classe 'Administrador'
public class Administrador {
    // Atributos privados da classe com valores padrão
    private String nome = "Administrador";
    private String cpf = "00000000000";
    private String senha = "009922";

    // Construtor da classe que inicializa os atributos com os valores fornecidos
    public Administrador(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    // Métodos get e set 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
