/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Usuario {
    
    private String nome, cpf,senha,cripto;
    private double real;

    public Usuario() {
    }
    
    
    public Usuario(String nome, String cpf, String senha,double real) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.real = real;
    }

    public Usuario(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public Usuario(String nome, String cpf, String senha, String cripto) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.cripto = cripto;
    }
    
    

    public Usuario(String cripto) {
        this.cripto = cripto;
    }
    
    

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

    public String getCripto() {
        return cripto;
    }

    public void setCripto(String cripto) {
        this.cripto = cripto;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }
    
    
    
    
    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + '}';
    }
    
    
}
