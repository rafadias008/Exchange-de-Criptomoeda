
package Controller;

import DAO.Conexao;
import DAO.UsuarioDAO;
import Model.Moedas;
import Model.Usuario;
import View.CompraCripto;
import View.ConsultaExtrato;
import View.ConsultaSaldo;
import View.DepositoUsuario;
import View.Login;
import View.PaginaUser;
import View.SaqueUsuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JOptionPane;

import java.sql.*;

/**
 *
 * @author rafae
 */
public class Controller {
    
    private Connection conn;
    
    private Login login;
    private PaginaUser paUser;
    private DepositoUsuario deposito;
    private SaqueUsuario saque;
    private ConsultaSaldo consulta;
    private ConsultaExtrato consultaExtrato;
    private CompraCripto comprarCripto;
    
    
    public Controller(Login login){
        this.login = login;
    }
    public Controller(DepositoUsuario deposito){
        this.deposito = deposito;       
    }
    public Controller(SaqueUsuario saque){
        this.saque = saque;   
    }
    public Controller(ConsultaSaldo consulta){
        this.consulta = consulta;
    }
    public Controller(ConsultaExtrato consultaExtrato){
        this.consultaExtrato = consultaExtrato;
    }
    

    public Controller(PaginaUser paUser) {
        this.paUser = paUser;
    }

    public Controller(CompraCripto comprarCripto) {
        this.comprarCripto = comprarCripto;
    }
    
    
    public void btLogin(){
       
        Usuario user = new Usuario(null,login.getLoginCPF().getText(),
                              login.getLoginSenha().getText(),0);
        
        Conexao conexao = new Conexao();
        
        try{
            Connection conn  = conexao.getConnection();
            System.out.println("conectou");
            UsuarioDAO dao = new UsuarioDAO(conn);
            System.out.println("criou dao");
            ResultSet res = dao.consultarLogin(user);
            System.out.println("resultado");
            
            if(res.next()){
                PaginaUser PU = new PaginaUser();
                
                String nome = res.getString("nome");
                String cpf = res.getString("cpf");
                String senha = res.getString("senha");
                
                
                PU.setVisible(true);
                
                PU.getInforUser().setText("Nome: " +nome +
                                              "\n\nCPF: " + cpf);
                
                    
            } else {
                JOptionPane.showMessageDialog(login, "Login não efetuado!");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(login, "Erro de conexão!");
        }
    }
    
    public void btDeposito(){
        
        double valorDeposito = Double.parseDouble(deposito.getTxtValorDeposito().
                                                    getText());
        
        Usuario user = new Usuario(null,deposito.getTxtCPF().getText(),
                              null,valorDeposito);
        
        Conexao conexao = new Conexao();
        
        try{
            Connection conn  = conexao.getConnection();
            System.out.println("conectou");
            UsuarioDAO dao = new UsuarioDAO(conn);
            System.out.println("criou dao");
            dao.Deposito(user);
            System.out.println("Funcionou");
            
                
            NumberFormat formatter = NumberFormat.getIntegerInstance(new Locale("pt", "BR"));
            String saldoFormatado = formatter.format(user.getReal());
            
            JOptionPane.showMessageDialog(deposito, "Saldo atual: R$ "+
                        saldoFormatado,"Aviso",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(deposito, "Erro de conexão!"
                               ,"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void btSaque(){
    
        double valorSaque = Double.parseDouble(saque.getTxtValorSaque().
                                                    getText());
        
        Usuario user = new Usuario(null,saque.getTxtCPF().getText(),
                              null,valorSaque);
        
        Conexao conexao = new Conexao();
        
        try{
            Connection conn  = conexao.getConnection();
            System.out.println("conectou");
            UsuarioDAO dao = new UsuarioDAO(conn);
            System.out.println("criou dao");
            dao.Saque(user);
            
                
            NumberFormat formatter = NumberFormat.getIntegerInstance(new Locale("pt", "BR"));
            String saldoFormatado = formatter.format(user.getReal());
            
            JOptionPane.showMessageDialog(deposito, "Saldo atual: R$ "+
                        saldoFormatado,"Aviso",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(deposito, "Erro de conexão!"
                               ,"Erro",JOptionPane.ERROR_MESSAGE);
        }
 
    }
    
    public void btConsultarSaldo(){
        
        Usuario user = new Usuario(null,consulta.getTxtCPF().getText(),
                              consulta.getTxtSenha().getText());
        
        Conexao conexao = new Conexao();
        
        try{
            Connection conn  = conexao.getConnection();
            System.out.println("conectou");
            UsuarioDAO dao = new UsuarioDAO(conn);
            System.out.println("criou dao");
            ResultSet res = dao.consultarLogin(user);
            System.out.println("resultado");
            
            
            if(res.next()){
                
                String nome = res.getString("nome");
                String cpf = res.getString("cpf");
                String senha = res.getString("senha");
                
                double saldoReal = dao.saldoAtual(user);
                double saldoBit = dao.saldoAtualBitcoin(user);
                double saldoEthe = dao.saldoAtualEthereum(user);
                double saldoRipple = dao.saldoAtualRipple(user);
                
                
                JOptionPane.showMessageDialog(consulta, "NOME: "+nome+
                    "\nCPF: " + cpf + "\n\nReal: " + saldoReal+ "\nBitcoin: "+ saldoBit +
                    "\nEthereum: "+saldoEthe+"\nRipple: " + saldoRipple);
                    
            } else {
                JOptionPane.showMessageDialog(login, "Usuário não encontrado");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(login, "Erro de conexão!");
        }
    }
    
    public void btConsultaExtrato(){
        
        Usuario user = new Usuario(null,consultaExtrato.getTxtCPF().getText(),
                              consultaExtrato.getTxtSenha().getText());
        
        Conexao conexao = new Conexao();
        
        try{
            Connection conn  = conexao.getConnection();
            System.out.println("conectou");
            UsuarioDAO dao = new UsuarioDAO(conn);
            System.out.println("criou dao");
            ResultSet res = dao.consultarLogin(user);
            System.out.println("resultado");
            
            
            if(res.next()){
                
                String nome = res.getString("nome");
                String cpf = res.getString("cpf");
                String senha = res.getString("senha");
                
                consultaExtrato.getExibeInformacoes().setText("Nome: " + nome + "\n"
                                + "CPF: " + cpf);
                
                String extrato = dao.Extrato(user);
                consultaExtrato.getExibeExtrato().setText(extrato);
                
                
            } else {
                JOptionPane.showMessageDialog(login, "Usuário não encontrado");
            }
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(login, "Erro de conexão!");
        }

    }
    
    public void consultarMoedas() {
        try {
            Conexao conexao = new Conexao();
            Connection conn = conexao.getConnection();

            String sql = "select * from moedas;";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultado = statement.executeQuery();

            StringBuilder string = new StringBuilder();

            while (resultado.next()) {
                string.append("").append(resultado.getString("nome").toUpperCase())
                      .append("     Valor: R$ ").append(resultado.getDouble("valor"))
                      .append("   Taxa de Compra: ").append(resultado.getDouble("txcompra"))
                      .append("%\n");
            }

            comprarCripto.getTxtMoedas().setText(string.toString());

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void comprarMoeda(){
        
        String combo = (String) comprarCripto.getComboBox().getSelectedItem();
        
        double quantidadeReais = Double.parseDouble(comprarCripto.getTxtQuantidadeReais().getText());
        
        Usuario user = new Usuario(null,comprarCripto.getTxtCpf().getText(),
                              comprarCripto.getTxtSenha().getText());
        
        Moedas moeda = new Moedas(combo,quantidadeReais);
        
        
        
        Conexao conexao = new Conexao();
        
        try{
            Connection conn  = conexao.getConnection();
            System.out.println("conectou");
            UsuarioDAO dao = new UsuarioDAO(conn);
            System.out.println("criou dao");
            ResultSet res = dao.consultarLogin(user);
            
            if(res.next()){
                
                String nome = res.getString("nome");
                String cpf = res.getString("cpf");
                String senha = res.getString("senha");
                
                
                
                if (dao.saldoAtual(user) - moeda.getValor() < 0){
                   
                    JOptionPane.showMessageDialog(comprarCripto,"Saldo insufiente");
                    return;
                }
                
                double valorMoeda = dao.valorMoeda(moeda);
                double txCompra = dao.valorTxCompra(moeda);
                
                
                
                
                double calculoTaxa = moeda.getValor() * txCompra;
                double valorComprado = moeda.getValor() - calculoTaxa;
                double calculoCriptos = valorComprado / valorMoeda;
                
                
                
                System.out.println("Reais: " + valorComprado);
                System.out.println("Cripto: " + calculoCriptos);
                System.out.println("Taxa: " + calculoTaxa);
                
                String sql = "update carteira set "+combo+" = ? where cpf = ?";
        
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setDouble(1, calculoCriptos);
                statement.setString(2, comprarCripto.getTxtCpf().getText());
                statement.execute();
                conn.close();
                
                    
            } else {
                JOptionPane.showMessageDialog(comprarCripto, "Usuário não encontrado");
            }
                        
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(comprarCripto, "Erro de conexão!");
        }
        
    }
}

