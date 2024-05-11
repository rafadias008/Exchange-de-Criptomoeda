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
        
        String sql = "insert into usuarios(nome,cpf,senha) values (?,?,?)";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,usuario.getNome());
        statement.setString(2, usuario.getCpf());
        statement.setString(3,usuario.getSenha());
        statement.execute();
        conn.close();
         
    }
}
