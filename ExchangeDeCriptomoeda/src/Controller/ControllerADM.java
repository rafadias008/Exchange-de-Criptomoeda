/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import DAO.AdministradorDAO;
import Model.Administrador;
import View.LoginADM;
import DAO.Conexao;
import Model.Usuario;
import View.CadastroCripto;
import View.CadastroInvest;
import View.ConsultaSaldoADM;
import View.DeletaInvest;
import View.DeletarCripto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import View.PaginaADM;

/**
 *
 * @author rafae
 */
public class ControllerADM {
    
    public LoginADM loginADM;
    
    public CadastroInvest CadInvest;
    public DeletaInvest DelInvest;
    public CadastroCripto CadCripto;
    public DeletarCripto DelCripto;
    public ConsultaSaldoADM ConsultSaldo;

    public ControllerADM(ConsultaSaldoADM ConsultSaldo) {
        this.ConsultSaldo = ConsultSaldo;
    }
    
    public ControllerADM(LoginADM loginADM){
        this.loginADM = loginADM;     
    }
    
    public ControllerADM(CadastroInvest CadInvest){
        this.CadInvest = CadInvest;
    }
    
    public ControllerADM(DeletaInvest DelInvest){
        this.DelInvest = DelInvest;
    }
    
    public ControllerADM(CadastroCripto CadCripto){
        this.CadCripto = CadCripto;
    }
    
    public ControllerADM(DeletarCripto DelCripto){
        this.DelCripto = DelCripto;
    }
    
    public void btLoginADM(){
        
        Administrador userADM = new Administrador(null,loginADM.getLoginCPF().getText(),
                              loginADM.getLoginSenha().getText());
        
        Conexao conexao = new Conexao();
        
        try{
            Connection conn  = conexao.getConnection();
            System.out.println("conectou");
            AdministradorDAO dao = new AdministradorDAO(conn);
            System.out.println("criou dao");
            ResultSet res = dao.consultarLoginADM(userADM);
            System.out.println("resultado");
            
            if(res.next()){
                 
                PaginaADM PA = new PaginaADM();
                
                String nome = res.getString("nome");
                String cpf = res.getString("cpf");
                String senha = res.getString("senha");
                
                
                PA.setVisible(true);
                
                
            } else {
                JOptionPane.showMessageDialog(loginADM, "Login não efetuado!");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(loginADM, "Erro de conexão!");
        }
    }
    
    public void btCreatedInvest(){
        
        Usuario user = new Usuario(CadInvest.getTxtNome().getText(),CadInvest.getTxtCpf().getText(),
                              CadInvest.getTxtSenha().getText());
        
        Conexao conexao = new Conexao();
        
        try{
            Connection conn  = conexao.getConnection();
            System.out.println("conectou");
            AdministradorDAO dao = new AdministradorDAO(conn);
            System.out.println("criou dao");
            dao.createdInvest(user);
            
            
            JOptionPane.showMessageDialog(CadInvest, "Investidor Criado");
                
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(CadInvest, "Erro de conexão!");
        }
    
    }
    
    public void btDeletarInvest(){
        
        Usuario user = new Usuario(null,DelInvest.getTxtCpf().getText(),
                              null);
        
        Conexao conexao = new Conexao();
        
        try{
            Connection conn  = conexao.getConnection();
            System.out.println("conectou");
            AdministradorDAO dao = new AdministradorDAO(conn);
            System.out.println("criou dao");
            dao.deletarInvest(user);
            
            
            JOptionPane.showMessageDialog(CadInvest, "Investidor Deletado!");
                
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(CadInvest, "Erro de conexão!");
        }
    }
    
    public void btCadastrarCripto(){
        
        Usuario user = new Usuario(CadCripto.getTxtNomeCripto().getText());
        
        Conexao conexao = new Conexao();
        
        try{
            Connection conn  = conexao.getConnection();
            System.out.println("conectou");
            AdministradorDAO dao = new AdministradorDAO(conn);
            System.out.println("criou dao");
            dao.criarCripto(user);
            
            
            JOptionPane.showMessageDialog(CadCripto, "Criptomoeda criada!");
                
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(CadCripto, "Erro de conexão!");
            
            System.out.println(e);
        }
    }
    
    public void btDeletarCripto(){
        
        Usuario user = new Usuario(DelCripto.getTxtNomeCripto().getText());
        
        Conexao conexao = new Conexao();
        
        try{
            Connection conn  = conexao.getConnection();
            System.out.println("conectou");
            AdministradorDAO dao = new AdministradorDAO(conn);
            System.out.println("criou dao");
            dao.DeletarCripto(user);
            
            
            JOptionPane.showMessageDialog(DelCripto, "Criptomoeda deletada!");
                
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(DelCripto, "Erro de conexão!");
            
            System.out.println(e);
        }
        
        
        
    }
}
