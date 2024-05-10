/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author rafae
 */
public class UsuarioDAO {
    
    private Connection conn;
    
    public UsuarioDAO(Connection conn){
        this.conn = conn;
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
    
//    public void createdUser(Usuario user) throws SQLException{
//        
//        String sql = "insert into usuarios (nome,cpf,senha) values (?,?,?)";
//        
//        System.out.println(sql);
//        
//        PreparedStatement statement = conn.prepareStatement(sql);
//        statement.setString(1,user.get());
//        statement.setString(2, user.getUsuario());
//        statement.execute();
//        conn.close();
//    }
}
