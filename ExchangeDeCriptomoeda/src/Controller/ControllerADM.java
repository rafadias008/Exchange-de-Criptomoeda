/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import DAO.AdministradorDAO;
import Model.Administrador;
import View.LoginADM;
import DAO.Conexao;
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
    
    public ControllerADM(LoginADM loginADM){
        this.loginADM = loginADM;
        
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
}
