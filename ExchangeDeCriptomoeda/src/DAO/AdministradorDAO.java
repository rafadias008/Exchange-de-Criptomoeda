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
    
    public void createdInvest(Usuario usuario)throws SQLException{
        
        String sql = """
                     INSERT INTO public.usuarios(
                     \tnome,senha,cpf)
                     \tVALUES (?, ?, ?) ;
                     \t
                     insert into carteira (cpf) 
                     \tvalues (?);""";
        
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,usuario.getNome());
        statement.setString(2,usuario.getSenha());
        statement.setString(3, usuario.getCpf());
        statement.setString(4,usuario.getCpf());
        
        statement.execute();
        conn.close();
         
    }
    
    public void deletarInvest(Usuario usuario) throws SQLException{
        
        String sql ="DELETE FROM carteira\n" +
                    "WHERE cpf IN (\n" +
                    "   SELECT usuarios.cpf\n" +
                    "   FROM carteira \n" +
                    "   INNER JOIN usuarios ON usuarios.cpf = carteira.cpf\n" +
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
        
        String sql = "alter table carteira add "+usuario.getCripto() +" double precision not null default 0";
        
        System.out.println(sql);
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
    
    public void DeletarCripto(Usuario usuario) throws SQLException{
        
        String sql = "alter table carteira drop column "+usuario.getCripto();
        
        System.out.println(sql);
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
}
