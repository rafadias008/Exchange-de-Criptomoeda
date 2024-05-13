/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Administrador;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rafae
 */
public class AdministradorDAO {
    
    private Connection conn;
    
    public AdministradorDAO(Connection conn){
        this.conn = conn;
    }
    
    public ResultSet consultarLoginADM(Administrador admin) throws SQLException{

        
        String sql =  "select * from administrador where cpf = ? and senha = ?";
        
        System.out.println(sql);
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,admin.getCpf());
        statement.setString(2,admin.getSenha());
        statement.execute();
        ResultSet resultado = statement.executeQuery();
        return resultado;
        
    }
    
    //funcionando
    public void createdInvest(Usuario usuario)throws SQLException{
        
        String sql = """
                     INSERT INTO public.usuarios(
                     \tnome, cpf, senha)
                     \tVALUES (?, ?, ?) ;
                     \t
                     insert into carteira (real,bitcoin,ethereum,ripple) 
                     \tvalues (0,0,0,0);""";
        
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,usuario.getNome());
        statement.setString(2, usuario.getCpf());
        statement.setString(3,usuario.getSenha());
        statement.execute();
        conn.close();
         
    }
    
    public void deletarInvest(Usuario usuario) throws SQLException{
        
        String sql ="DELETE FROM carteira\n" +
                    "WHERE id IN (\n" +
                    "   SELECT usuarios.id\n" +
                    "   FROM carteira \n" +
                    "   INNER JOIN usuarios ON usuarios.id = carteira.id\n" +
                    "   WHERE usuarios.cpf = ?);\n" +
                    "   \n" +
                    "delete from usuarios where cpf = ?;";
        
        System.out.println(sql);
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getCpf());
        statement.setString(2, usuario.getCpf());
        statement.execute();
        conn.close();
    }
    
    public void criarCripto(Usuario usuario) throws SQLException{
        
        String sql = "alter table usuarios add "+usuario.getCripto() +" double precision not null default 0";
        
        System.out.println(sql);
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
    
    public void DeletarCripto(Usuario usuario) throws SQLException{
        
        String sql = "alter table usuarios drop column "+usuario.getCripto();
        
        System.out.println(sql);
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
}
