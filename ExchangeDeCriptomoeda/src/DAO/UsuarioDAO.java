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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class UsuarioDAO {
    
    private Connection conn;
    
    public UsuarioDAO(Connection conn){
        this.conn = conn;
    }
    
    // Obter a data e hora atual
    LocalDateTime dataHoraAtual = LocalDateTime.now();

    // Formatar a data e hora
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    String dataHoraFormatada = dataHoraAtual.format(formatter);
    
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
        
        
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1,valorFuturo);
        statement.setString(2, user.getCpf());
        statement.execute();
        
        String sql2 = "INSERT INTO public.extrato(\n" +
"	data, tipodeoperacao, valor, moeda, real , bitcoin, ethereum, ripple, cpf)\n" +
"	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?); ";
        
        PreparedStatement statement2 = conn.prepareStatement(sql2);
        statement2.setString(1,dataHoraFormatada);
        statement2.setString(2, "+");
        statement2.setDouble(3,user.getReal());
        statement2.setString(4,"REAIS");
        statement2.setDouble(5,saldoAtual(user));
        statement2.setDouble(6,saldoAtualBitcoin(user));
        statement2.setDouble(7,saldoAtualEthereum(user));
        statement2.setDouble(8,saldoAtualRipple(user));
        statement2.setString(9,user.getCpf());
        statement2.execute();
        conn.close();
        
        
        
        
    }
    
    public void Saque(Usuario user) throws SQLException{
        
        double valorAtual = saldoAtual(user);
        double valorFuturo = valorAtual - user.getReal();
        
        String sql = "update carteira set reais = ? where cpf = ?";
        
        
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1,valorFuturo);
        statement.setString(2, user.getCpf());
        statement.execute();
        
        String sql2 = "INSERT INTO public.extrato(\n" +
"	data, tipodeoperacao, valor, moeda, real , bitcoin, ethereum, ripple, cpf)\n" +
"	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?); ";
        
        PreparedStatement statement2 = conn.prepareStatement(sql2);
        statement2.setString(1,dataHoraFormatada);
        statement2.setString(2, "-");
        statement2.setDouble(3,user.getReal());
        statement2.setString(4,"REAIS");
        statement2.setDouble(5,saldoAtual(user));
        statement2.setDouble(6,saldoAtualBitcoin(user));
        statement2.setDouble(7,saldoAtualEthereum(user));
        statement2.setDouble(8,saldoAtualRipple(user));
        statement2.setString(9,user.getCpf());
        statement2.execute();
        conn.close();
        
    }
    
    public String Extrato(Usuario user) throws SQLException{
        
        String sql = "SELECT * FROM public.extrato where cpf = ?";
        
        
        
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
    
    public Double valorMoeda(Moedas moeda) throws SQLException{
        
        String sql = "SELECT valor FROM public.moedas where nome=?";
        
       
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,moeda.getCripto());
        ResultSet res =  statement.executeQuery();
        
        double valorMoeda = 0;
        if (res.next()){
            valorMoeda = res.getDouble("valor");  
        } 
        return valorMoeda;
    }
    
    public Double valorTxCompra(Moedas moeda) throws SQLException{
        
        String sql = "SELECT txcompra FROM public.moedas where nome=?";
        
        
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,moeda.getCripto());
        ResultSet res =  statement.executeQuery();
        
        double valorTxCompra = 0;
        if (res.next()){
            valorTxCompra = res.getDouble("txcompra");  
        } 
        return valorTxCompra;
    }
    
    public Double valorTxVenda(Moedas moeda) throws SQLException{
        
        String sql = "SELECT txvenda FROM public.moedas where nome=?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,moeda.getCripto());
        ResultSet res =  statement.executeQuery();
        
        double valorTxVenda = 0;
        if (res.next()){
            valorTxVenda = res.getDouble("txvenda");  
        } 
        return valorTxVenda;
    }
    
    public Double saldoCripto(Usuario user) throws SQLException{
        
        String sql = "SELECT * FROM carteira where cpf = ?";
        
        
        PreparedStatement statement = conn.prepareStatement(sql);
        //statement.setString(1,user.getCripto());
        statement.setString(1,user.getCpf());
        ResultSet res =  statement.executeQuery();
        
        double saldoCripto = 0;
        if (res.next()){
            
            saldoCripto = res.getDouble(user.getCripto());  
        } 
        return saldoCripto;
    }
    
    public void atualizarCotacao() throws SQLException {
        String sql = "SELECT * FROM moedas";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet resultado = statement.executeQuery();

        while (resultado.next()) {
            String nomeMoeda = resultado.getString("nome");
            double valorMoeda = resultado.getDouble("valor");

            double novoValorMoeda = valorMoeda * 0.95; // -5%

            sql = "UPDATE moedas SET valor = ? WHERE nome = ?";
            statement = conn.prepareStatement(sql);
            statement.setDouble(1, novoValorMoeda);
            statement.setString(2, nomeMoeda);
            statement.executeUpdate();
        }

    }
    
    

}
