/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author rafae
 */
public class UsuarioDAO {
    
    private Connection conn;
    
    public UsuarioDAO(Connection conn){
        this.conn = conn;
    }
    
    public double saldoAtual(Usuario user)throws SQLException{
        
        String sql = "select real from usuarios where cpf = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,user.getCpf());
        ResultSet res = statement.executeQuery();
        
        double valorAtual = 0;
        if (res.next()){
            valorAtual = res.getDouble("real");
        } 
        
        return valorAtual;
    }
    
    public ResultSet consultarLogin(Usuario user) throws SQLException{

        
        String sql =  "select * from usuarios where cpf = ? and senha = ?";
        
        System.out.println(sql);
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, user.getCpf());
        statement.setString(2,user.getSenha());
        statement.execute();
        ResultSet resultado = statement.executeQuery();
        return resultado;
        
    }
    
    public void Deposito(Usuario user) throws SQLException{
        
        double valorAtual = saldoAtual(user);
        double valorFuturo = valorAtual + user.getReal();
        
        String sql = "update carteira set real = ? from usuarios where usuarios.cpf = ? and carteira.id = usuarios.id";
        
        System.out.println(sql);
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1,valorFuturo);
        statement.setString(2, user.getCpf());
        statement.execute();
        conn.close();
        
    }
    
    public void Saque(Usuario user) throws SQLException{
        
        double valorAtual = saldoAtual(user);
        double valorFuturo = valorAtual - user.getReal();
        
        String sql = "update usuarios set real = ? where cpf = ?";
        
        System.out.println(sql);
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1,valorFuturo);
        statement.setString(2, user.getCpf());
        statement.execute();
        conn.close();
        
    }
    
    
    
}
