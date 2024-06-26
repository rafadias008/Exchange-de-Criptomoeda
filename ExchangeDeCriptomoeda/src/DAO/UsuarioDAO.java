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
import java.util.HashMap;
import java.util.Map;
import java.sql.ResultSetMetaData;



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
    
    public Map<String, Double> saldoAtualMoedas(Usuario user) throws SQLException {
    String sql = "select * from carteira where cpf = ?";
    
    PreparedStatement statement = conn.prepareStatement(sql);
    statement.setString(1, user.getCpf());
    ResultSet res = statement.executeQuery();
    
    Map<String, Double> saldoMap = new HashMap<>();
    if (res.next()) {
        ResultSetMetaData metaData = res.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = metaData.getColumnName(i);
            if (!columnName.equalsIgnoreCase("cpf")) { // Ignora a coluna CPF
                saldoMap.put(columnName, res.getDouble(columnName));
                }
            }
        } 
        return saldoMap;
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
    
    public ResultSet consultarCPF(Usuario user) throws SQLException{

        
        String sql =  "select * from usuarios where cpf = ?";
        
        System.out.println(sql);
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, user.getCpf());
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
    
    public String Extrato(Usuario user) throws SQLException {
    String sql = "SELECT * FROM public.extrato where cpf = ?";
    PreparedStatement statement = conn.prepareStatement(sql);
    statement.setString(1, user.getCpf());
    ResultSet res = statement.executeQuery();

    StringBuilder extrato = new StringBuilder();

    // Obter o saldo de todas as moedas do cliente
    Map<String, Double> saldoMoedas = saldoAtualTodasMoedas(user);
    double saldoTotalReais = saldoAtual(user);

    // Imprimir o extrato
    while (res.next()) {
        String linha = res.getString("data") + "  " + res.getString("tipodeoperacao") +
                "  " + res.getString("valor") + "  " + res.getString("moeda") +
                "  " + "TX: " + res.getString("taxa") +
                "  " + "R$: " + res.getString("real") + "  ";

        for (Map.Entry<String, Double> entry : saldoMoedas.entrySet()) {
            linha += entry.getKey().toUpperCase() + ": " + entry.getValue() + " ";
        }

        extrato.append(linha).append("\n\n");
    }

    // Adicionar o saldo total de todas as moedas
    extrato.append("\nSaldo Total: R$ ").append(saldoTotalReais);
    for (Map.Entry<String, Double> entry : saldoMoedas.entrySet()) {
        if (!entry.getKey().equalsIgnoreCase("reais")) {
            extrato.append(", ").append(entry.getKey().toUpperCase()).append(": ").append(entry.getValue());
        }
    }

    return extrato.toString();
}

    private Map<String, Double> saldoAtualTodasMoedas(Usuario user) throws SQLException {
    Map<String, Double> saldoMoedas = new HashMap<>();

    String sql = "SELECT * FROM carteira WHERE cpf = ?";
    PreparedStatement statement = conn.prepareStatement(sql);
    statement.setString(1, user.getCpf());
    ResultSet res = statement.executeQuery();

    while (res.next()) {
        saldoMoedas.put("reais", res.getDouble("reais"));

        ResultSetMetaData metaData = res.getMetaData();
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            String columnName = metaData.getColumnName(i);
            if (!columnName.equalsIgnoreCase("cpf") && !columnName.equalsIgnoreCase("reais")) {
                saldoMoedas.put(columnName, res.getDouble(columnName));
            }
        }
    }

    return saldoMoedas;
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
    
    

}
