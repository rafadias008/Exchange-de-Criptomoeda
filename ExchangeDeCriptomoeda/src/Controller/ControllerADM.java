
package Controller;


import DAO.AdministradorDAO;
import Model.Administrador;
import View.LoginADM;
import DAO.Conexao;
import DAO.UsuarioDAO;
import Model.Moedas;
import Model.Usuario;
import View.CadastroCripto;
import View.CadastroInvest;
import View.ConsultaSaldoADM;
import View.DeletaInvest;
import View.DeletarCripto;
import View.Extrato;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import View.PaginaADM;


public class ControllerADM {
    
    private LoginADM loginADM;
    
    private CadastroInvest CadInvest;
    private DeletaInvest DelInvest;
    private CadastroCripto CadCripto;
    private DeletarCripto DelCripto;
    private ConsultaSaldoADM ConsultSaldo;
    private Extrato consultExtrato;
    

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
    
    public ControllerADM(Extrato consultExtrato){
        this.consultExtrato = consultExtrato;
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
                PA.setLocationRelativeTo(null);
                
                
            } else {
                JOptionPane.showMessageDialog(loginADM, "Login não efetuado!");

                
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(loginADM, "Erro de conexão!");
        }
    }
    
    public void btCreatedInvest(){
        
        Usuario user = new Usuario(CadInvest.getTxtNome().getText(),CadInvest.getTxtCpf().getText(),
                              CadInvest.getTxtSenha().getText(),0);
        
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
                              null,0);
        
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
        
        double valor = Double.parseDouble(CadCripto.getTxtValorMoeda().getText());
        double txCompra = Double.parseDouble(CadCripto.getTxtTaxaCompra().getText());
        double txVenda =  Double.parseDouble(CadCripto.getTxtTaxaVenda().getText());
        
        Moedas moeda = new Moedas(CadCripto.getTxtNomeCripto().getText(),valor,txCompra,txVenda);
        
        Conexao conexao = new Conexao();
        
        try{
            Connection conn  = conexao.getConnection();
            System.out.println("conectou");
            AdministradorDAO dao = new AdministradorDAO(conn);
            System.out.println("criou dao");
            dao.criarCripto(moeda);
            
            
            JOptionPane.showMessageDialog(CadCripto, "Criptomoeda criada!");
                
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(CadCripto, "Erro de conexão!");
            
            System.out.println(e);
        }
    }
    
    public void btDeletarCripto(){
        
        Moedas moeda = new Moedas(DelCripto.getTxtNomeCripto().getText(),0);
        
        Conexao conexao = new Conexao();
        
        try{
            Connection conn  = conexao.getConnection();
            System.out.println("conectou");
            AdministradorDAO dao = new AdministradorDAO(conn);
            System.out.println("criou dao");
            dao.DeletarCripto(moeda);
            
            
            JOptionPane.showMessageDialog(DelCripto, "Criptomoeda deletada!");
                
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(DelCripto, "Erro de conexão!");
            
            System.out.println(e);
        }
        
    }
    
    public void btConsultarSaldo(){
        
        Usuario user = new Usuario(null,ConsultSaldo.getTxtCpf().getText(),
                              null);
        
        Conexao conexao = new Conexao();
        
        try{
            Connection conn  = conexao.getConnection();
            System.out.println("conectou");
            UsuarioDAO dao = new UsuarioDAO(conn);
            System.out.println("criou dao");
            AdministradorDAO dao2 = new AdministradorDAO(conn);
            ResultSet res = dao2.consultarUsuario(user);
            System.out.println("resultado");
            
            
            if(res.next()){
                
                String nome = res.getString("nome");
                String cpf = res.getString("cpf");
                String senha = res.getString("senha");
                
                double saldoReal = dao.saldoAtual(user);
                double saldoBit = dao.saldoAtualBitcoin(user);
                double saldoEthe = dao.saldoAtualEthereum(user);
                double saldoRipple = dao.saldoAtualRipple(user);
                
                
                JOptionPane.showMessageDialog(ConsultSaldo, "NOME: "+nome+
                    "\nCPF: " + cpf + "\n\nReal: " + saldoReal+ "\nBitcoin: "+ saldoBit +
                    "\nEthereum: "+saldoEthe+"\nRipple: " + saldoRipple);
                    
            } else {
                JOptionPane.showMessageDialog(ConsultSaldo, "Usuário não encontrado");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(ConsultSaldo, "Erro de conexão!");
        }
    }
    
    public void btConsultExtrato(){
        Usuario user = new Usuario(null,consultExtrato.getTxtCpf().getText(),
                              null);
        
        Conexao conexao = new Conexao();
        
        try{
            Connection conn  = conexao.getConnection();
            System.out.println("conectou");
            UsuarioDAO dao = new UsuarioDAO(conn);
            System.out.println("criou dao");
            AdministradorDAO dao2 = new AdministradorDAO(conn);
            ResultSet res = dao2.consultarUsuario(user);
            System.out.println("resultado");
            
            
            
            if(res.next()){
                
                String nome = res.getString("nome");
                String cpf = res.getString("cpf");
                String senha = res.getString("senha");
                
                consultExtrato.getExibeInformacoes().setText("Nome: "+ nome +"\n"
                                + "CPF: " + cpf);
                
                String extrato = dao.Extrato(user);
                consultExtrato.getExibeExtrato().setText(extrato);
                
                
            } else {
                JOptionPane.showMessageDialog(consultExtrato, "Usuário não encontrado");
            }
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(consultExtrato, "Erro de conexão!");
        }

    }
    
}
