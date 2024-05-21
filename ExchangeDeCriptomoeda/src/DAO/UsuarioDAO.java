/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Moedas;
import Model.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;



public class UsuarioDAO {
    
    private Connection conn;
    
    public UsuarioDAO(Connection conn){
        this.conn = conn;
    }
    
    public double saldoAtual(Usuario user)throws SQLException{
        
        String sql = "select * from carteira where cpf = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,user.getCpf());
        ResultSet res = statement.executeQuery();
        
        double valorAtualReal = 0;
        if (res.next()){
            valorAtualReal = res.getDouble("reais");  
        } 
        return valorAtualReal;
    }
    
    public double saldoAtualBitcoin(Usuario user)throws SQLException{
        
        String sql = "select * from carteira where cpf = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,user.getCpf());
        ResultSet res = statement.executeQuery();
        
        double valorAtualBitcoin = 0;
        if (res.next()){
            valorAtualBitcoin = res.getDouble("bitcoin");  
        } 
        return valorAtualBitcoin;
    }
    
    public double saldoAtualRipple(Usuario user)throws SQLException{
        
        String sql = "select * from carteira where cpf = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,user.getCpf());
        ResultSet res = statement.executeQuery();
        
        double valorAtualRipple = 0;
        if (res.next()){
            valorAtualRipple = res.getDouble("ripple");  
        } 
        return valorAtualRipple;   
    }
    
    public double saldoAtualEthereum(Usuario user)throws SQLException{
        
        String sql = "select * from carteira where cpf = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,user.getCpf());
        ResultSet res = statement.executeQuery();
        
        double valorAtualEthereum = 0;
        if (res.next()){
            valorAtualEthereum = res.getDouble("ethereum");  
        } 
        return valorAtualEthereum;
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
        
        String sql = "update carteira set reais = ? where cpf = ?";
        
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
        
        String sql = "update carteira set reais = ? where cpf = ?";
        
        System.out.println(sql);
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1,valorFuturo);
        statement.setString(2, user.getCpf());
        statement.execute();
        conn.close();
        
    }
    
    public String Extrato(Usuario user) throws SQLException{
        
        String sql = "SELECT * FROM public.extrato where cpf = ?";
        
        System.out.println(sql);
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,user.getCpf());
        ResultSet res = statement.executeQuery();
        
        StringBuilder extrato = new StringBuilder();
        
        while (res.next()) {
            String linha = res.getString("data") + "  " + res.getString("tipodeoperacao")+
                    "  " + res.getString("valor") + "  " + res.getString("moeda")+
                    "  " + "CT: " + res.getString("ct") + "  " + "TX: " +  res.getString("taxa") + 
                    "  " + "R$: " +res.getString("real") + "  " +" BTC: "+ res.getString("bitcoin")+
                    "  " +"ETH: "+ res.getString("ethereum") + "  " +"XRP: "+ res.getString("ripple");
            extrato.append(linha).append("\n\n");
        }

        return extrato.toString();
         
    }
    
    

}
