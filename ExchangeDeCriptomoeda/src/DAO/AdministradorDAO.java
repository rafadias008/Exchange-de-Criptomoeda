/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO; 
import Model.Administrador; 
import Model.Moedas; 
import Model.Usuario; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException;


public class AdministradorDAO {
    
    private Connection conn; // variável para  onexão com o banco de dados
    
    public AdministradorDAO(Connection conn){
        this.conn = conn; // Inicializa a variável com a conexão passada como argumento
    }
    
    public ResultSet consultarLoginADM(Administrador admin) throws SQLException{
        // define a consulta SQL para selecionar um administrador pelo CPF e senha
        String sql =  "select * from administrador where cpf = ? and senha = ?";
        
        // prepara a instrução SQL com a conexão
        PreparedStatement statement = conn.prepareStatement(sql);
        // define os valores dos parâmetros na consulta
        statement.setString(1, admin.getCpf());
        statement.setString(2, admin.getSenha());
        statement.execute(); // executa a instrução SQL
        // executa a consulta e retorna os resultados
        ResultSet resultado = statement.executeQuery();
        return resultado;
    }
    
    public void createdInvest(Usuario usuario) throws SQLException{
        // define a instrução SQL para inserir um novo usuário e criar uma carteira para ele
        String sql = """
                     INSERT INTO public.usuarios(
                     \tnome,senha,cpf)
                     \tVALUES (?, ?, ?) ;
                     \t
                     insert into carteira (cpf) 
                     \tvalues (?);""";
        
        // prepara a instrução SQL com a conexão
        PreparedStatement statement = conn.prepareStatement(sql);
        // define os valores dos parâmetros na instrução SQL
        statement.setString(1, usuario.getNome());
        statement.setString(2, usuario.getSenha());
        statement.setString(3, usuario.getCpf());
        statement.setString(4, usuario.getCpf());
        
        statement.execute(); // Executa a instrução SQL
        conn.close(); // Fecha a conexão com o banco de dados
    }
    
    public void deletarInvest(Usuario usuario) throws SQLException{
        // Define a instrução SQL para deletar um usuário e sua carteira associada
        String sql = "DELETE FROM carteira\n" +
                    "WHERE cpf IN (\n" +
                    "   SELECT usuarios.cpf\n" +
                    "   FROM carteira \n" +
                    "   INNER JOIN usuarios ON usuarios.cpf = carteira.cpf\n" +
                    "   WHERE usuarios.cpf = ?);\n" +
                    "   \n" +
                    "delete from usuarios where cpf = ?;";
        
        // Prepara a instrução SQL com a conexão
        PreparedStatement statement = conn.prepareStatement(sql);
        // Define os valores dos parâmetros na instrução SQL
        statement.setString(1, usuario.getCpf());
        statement.setString(2, usuario.getCpf());
        statement.execute(); // Executa a instrução SQL
        conn.close(); // Fecha a conexão com o banco de dados
    }
    
    public void criarCripto(Moedas moeda) throws SQLException{    
        // Define a instrução SQL para adicionar uma nova coluna de criptomoeda na tabela carteira e inserir uma nova moeda
        String sql = "alter table carteira add "+moeda.getCripto() +" double precision not null default 0;\n" +
                        "\n" +
                        "INSERT INTO public.moedas(\n" +
                        "	nome, valor,txcompra,txvenda)\n" +
                        "	VALUES (?,?,?,?);";
        
        // Calcula as taxas de compra e venda
        double txCompra = moeda.getTxCompra() / 100;
        double txVenda = moeda.getTxVenda() / 100;
        
        // Prepara a instrução SQL com a conexão
        PreparedStatement statement = conn.prepareStatement(sql);
        // Define os valores dos parâmetros na instrução SQL
        statement.setString(1, moeda.getCripto());
        statement.setDouble(2, moeda.getValor());
        statement.setDouble(3, txCompra);
        statement.setDouble(4, txVenda);
        statement.execute(); // Executa a instrução SQL
        conn.close(); // Fecha a conexão com o banco de dados
    }
    
    public void DeletarCripto(Moedas moeda) throws SQLException{
        // Define a instrução SQL para remover uma coluna de criptomoeda da tabela carteira e deletar a moeda
        String sql = "alter table carteira drop column "+moeda.getCripto()+";"+
                "\ndelete from moedas where nome = ?;";
        
        // Prepara a instrução SQL com a conexão
        PreparedStatement statement = conn.prepareStatement(sql);
        // Define o valor do parâmetro na instrução SQL
        statement.setString(1, moeda.getCripto());
        statement.execute(); // Executa a instrução SQL
        conn.close(); // Fecha a conexão com o banco de dados
    }
    
    public ResultSet consultarUsuario(Usuario user) throws SQLException{
        // Define a consulta SQL para selecionar um usuário pelo CPF
        String sql =  "select * from usuarios where cpf = ?";
        
        // Prepara a instrução SQL com a conexão
        PreparedStatement statement = conn.prepareStatement(sql);
        // Define o valor do parâmetro na consulta
        statement.setString(1, user.getCpf());
        statement.execute(); // Executa a instrução SQL
        // Executa a consulta e retorna os resultados
        ResultSet resultado = statement.executeQuery();
        return resultado;
    }
    
    public void atualizarCotacao() throws SQLException {
        // Define a instrução SQL para selecionar todas as moedas
        String sql = "SELECT * FROM moedas";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet resultado = statement.executeQuery(); // Executa a consulta e obtém os resultados

        // Itera sobre cada moeda no resultado
        while (resultado.next()) {
            String nomeMoeda = resultado.getString("nome"); // Obtém o nome da moeda
            double valorMoeda = resultado.getDouble("valor"); // Obtém o valor da moeda

            double novoValorMoeda = valorMoeda * 0.95; // Calcula o novo valor da moeda com uma redução de 5%

            // Define a instrução SQL para atualizar o valor da moeda
            sql = "UPDATE moedas SET valor = ? WHERE nome = ?";
            statement = conn.prepareStatement(sql);
            // Define os valores dos parâmetros na instrução SQL
            statement.setDouble(1, novoValorMoeda);
            statement.setString(2, nomeMoeda);
            statement.executeUpdate(); // Executa a atualização
        }
    }
}
