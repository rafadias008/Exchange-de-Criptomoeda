
package Controller;

import DAO.Conexao;
import DAO.UsuarioDAO;
import Model.Usuario;
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

/**
 *
 * @author rafae
 */
public class Controller {
    
    private Login login;
    private DepositoUsuario deposito;
    private SaqueUsuario saque;
    
    public Controller(Login login){
        this.login = login;
    }
    public Controller(DepositoUsuario deposito){
        this.deposito = deposito;       
    }
    public Controller(SaqueUsuario saque){
        this.saque = saque;   
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
}