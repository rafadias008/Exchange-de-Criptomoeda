
package Controller;

import DAO.AdministradorDAO;
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
import View.venderCripto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JOptionPane;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.text.DecimalFormat;

/**
 *
 * @author rafae
 */
public class Controller {
    
    private Connection conn;
    
    //paginas views usadas na controller
    private Login login;
    private PaginaUser paUser;
    private DepositoUsuario deposito;
    private SaqueUsuario saque;
    private ConsultaSaldo consulta;
    private ConsultaExtrato consultaExtrato;
    private CompraCripto comprarCripto;
    private venderCripto venderCripto;
    
    //contrutores das paginas que foram usadas
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
    public Controller(venderCripto venderCripto){
        this.venderCripto = venderCripto;
    }
    public Controller(PaginaUser paUser) {
        this.paUser = paUser;
    }
    public Controller(CompraCripto comprarCripto) {
        this.comprarCripto = comprarCripto;
    }
    
    // Obter a data e hora atual
    LocalDateTime dataHoraAtual = LocalDateTime.now();

    // Formatar a data e hora
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    String dataHoraFormatada = dataHoraAtual.format(formatter);

    
    
    //metodo de realizar o login do usuario
    public void btLogin(){
        
        //instancia do objeto usuario para uso do metodo
        Usuario user = new Usuario(null,login.getLoginCPF().getText(),
                              login.getLoginSenha().getText());
        
        //instacia o objeto conexão para realizar a conexão ao banco de dados
        Conexao conexao = new Conexao();
        
        try{
            //conecta ao banco de dados
            Connection conn  = conexao.getConnection();
            
            //cria a DAO
            UsuarioDAO dao = new UsuarioDAO(conn);
            
            //retorna o resultado do resultset do metodo que busca o usuario no 
            //banco de dados
            ResultSet res = dao.consultarLogin(user);
            
            //verifica se o usuario digitado existe no banco de dados
            //para realizar o login
            if(res.next()){
                //instancia a view de uso do usuario
                PaginaUser PU = new PaginaUser();
                
                String nome = res.getString("nome");
                String cpf = res.getString("cpf");
                String senha = res.getString("senha");
                
                //inicia a view de uso do usuario caso as informações estejam corretas
                PU.setVisible(true);
                
                PU.getInforUser().setText("Nome: " +nome +
                                              "\nCPF: " + cpf);
                
                //caso não encontre o usuario no banco de dados , informa a mensagem
                //de usuario não encontrado
            } else {
                
                JOptionPane.showMessageDialog(login, "Usuário ou senha incorreta!",
                        "Aviso",JOptionPane.INFORMATION_MESSAGE);
                
                Login logi = new Login();
                logi.setVisible(true);
            }
         //caso ocorra algum problema com a conexão, sera exibida a mensagem abaixo
        }catch(SQLException e){
            JOptionPane.showMessageDialog(login, "Erro de conexão!");
        }
    }
    
    //metodo para realizar depositos na conta do usuario
    public void btDeposito(){
        
        //tranformo o valor digitado pelo usuario em double para realizar a trasação
        double valorDeposito = Double.parseDouble(deposito.getTxtValorDeposito().
                                                    getText());
        
        
        //instancia o objeto user
        Usuario user = new Usuario(null,deposito.getTxtCPF().getText(),
                              null,valorDeposito);
        
        //instancia o objeto conexao
        Conexao conexao = new Conexao();
        
        try{
            //conecta ao banco de dados
            Connection conn  = conexao.getConnection();
            //instancia a DAO do usuario
            UsuarioDAO dao = new UsuarioDAO(conn);
            
            //retorna um resultset para consultar o cpf do usuario para realizar 
            //o deposito no cpf informado
            ResultSet res = dao.consultarCPF(user);
            
            
            //verifica no banco de dados do resultset se o cpf informado existe
            if(res.next()){
                //realiza a soma dos valores para ter o saldo futuro
                double saldoFuturo = dao.saldoAtual(user) + valorDeposito;
                //metodo usado para realizar o deposito no banco de dados e atualizar
                //o saldo do usuario
                dao.Deposito(user);
                
            
                //formata o saldo para imprimir na tela um popup do saldo atual
                //pos operação de deposito
                NumberFormat formatter = NumberFormat.getIntegerInstance(new Locale("pt", "BR"));
                String saldoFormatado = formatter.format(saldoFuturo);
                
                //cria o popup para mostrar o saldo pos deposito.
                JOptionPane.showMessageDialog(deposito, "Saldo atual: R$ "+
                        saldoFormatado,"Aviso",JOptionPane.INFORMATION_MESSAGE);
                
                //caso cpf informado seja invalido, a operação não sera executada,
                //e informara um popup de cpf incorreto
            } else{
                JOptionPane.showMessageDialog(deposito, "CPF invalido!");
            }
            
            
           //caso houva um erro de conexão com o banco de dados ,ira informar 
           //a mensagem abaixo
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(deposito, e
                               ,"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //metodo utilizado para realizar o sague do usuario
    public void btSaque(){
        
        //transforma o valor inserido pelo usuario em double para realizar as 
        //operação de saque
        double valorSaque = Double.parseDouble(saque.getTxtValorSaque().
                                                    getText());
        
        //instancia o objeto user
        Usuario user = new Usuario(null,saque.getTxtCPF().getText(),
                              saque.getTxtSenha().getText(),valorSaque);
        
        //instancia o objeto conexão
        Conexao conexao = new Conexao();
        
        try{
            //conecta ao banco de dados
            Connection conn  = conexao.getConnection();
            
            //cria a DAO 
            UsuarioDAO dao = new UsuarioDAO(conn);
            //Realiza um resultset do metodo para consultar o usuario no banco de dados
            ResultSet res = dao.consultarLogin(user);
            
            //verifica se o cpf e senha inseridos existe no banco de dados ,
            //assim concluindo a operação
            if(res.next()){
                //realiza a subtração dos valores
                double saldoFuturo = dao.saldoAtual(user) - valorSaque;
                
                //verifica se o saldo ficara a baixo de 0, caso fique abaixo de 0
                //retornara uma mensagem de saldo insuficiente
                if(saldoFuturo < 0){
                    JOptionPane.showMessageDialog(saque, "Saldo insuficiente");
                    return;
                }
                
                //realiza a operação de saque do usuario 
                dao.Saque(user);

                //formata o valor para informar um popup do saldo que ficou apos
                //a operação de saque
                NumberFormat formatter = NumberFormat.getIntegerInstance(new Locale("pt", "BR"));
                String saldoFormatado = formatter.format(saldoFuturo);
                
                //cria o popup do saldo
                JOptionPane.showMessageDialog(deposito, "Saldo atual: R$ "+
                        saldoFormatado,"Aviso",JOptionPane.INFORMATION_MESSAGE);
                
                //caso a senha ou usuario estejam incorretos , não realizara a 
                //operação, informando tambem um popup de usuario ou senha incorreta
            } else{
                JOptionPane.showMessageDialog(saque, "Usuário ou senha incorreto!");
            }
          //caso a conexão ao banco de dados não seja realizada, ira informar 
          //uma mensagem de erro de conexao para o usuario
        }catch(SQLException e){
            JOptionPane.showMessageDialog(deposito, "Erro de conexão!"
                               ,"Erro",JOptionPane.ERROR_MESSAGE);
        }
 
    }
    
    
    //metodo utilizado para consultar o saldo do usuario
    public void btConsultarSaldo(){
        
        //instancia o objeto user
        Usuario user = new Usuario(null,consulta.getTxtCPF().getText(),
                              consulta.getTxtSenha().getText());
        
        //instancia o objeto conexão
        Conexao conexao = new Conexao();

        try{
            //conecta ao banco de dados
            Connection conn  = conexao.getConnection();
            //cria a dao
            UsuarioDAO dao = new UsuarioDAO(conn);
            //realiza um resultset no banco de dados para consultar o usuario no 
            //banco de dados 
            ResultSet res = dao.consultarLogin(user);
            
            //confere no banco de dados se o usuario é existente
            if(res.next()){
                
                //informações a serem impressas no popup do saldo
                String nome = res.getString("nome");
                String cpf = res.getString("cpf");
                
                //cria um mapa(dicionario) onde armazenara os saldos do usuario
                Map<String, Double> saldos = dao.saldoAtualMoedas(user);
                
                //instancia a objeto da classe StringBuilder para informações basicas
                //do usuario , logo em seguida realiza a adição das strings ao objeto
                //saldoStr
                StringBuilder saldoStr = new StringBuilder();
                saldoStr.append("NOME: ").append(nome)
                        .append("\nCPF: ").append(cpf)
                        .append("\n");

                //instancia o objeto de formação e criar o formatador para 3 casas decimais
                DecimalFormat df = new DecimalFormat("#.###");
                
                //intera pela o map saldos e retorna o conjunto de todas as entradas
                //do map , onde cada entrada é um par chave-valor(String,Double)
                for (Map.Entry<String, Double> entry : saldos.entrySet()) {
                    
                    saldoStr.append("\n").append(entry.getKey().toUpperCase())
                            .append(": ").append(df.format(entry.getValue()));
                }
                
                //cria um popup para informar o saldo do usuario , contendo todas
                //as informações basicas do usuario e saldo total de todas as moedas
                JOptionPane.showMessageDialog(consulta, saldoStr.toString());
                
                //caso o cpf ou senha informados seja invalido, ira informar um popup
            } else {
                JOptionPane.showMessageDialog(consulta, "Usuário não encontrado");
            }
            //se a conexão ao banco de dados falhar, cria um popup informando o erro de conexao
        }catch(SQLException e){
            JOptionPane.showMessageDialog(consulta, "Erro de conexão!");
        }
    }
    
    // Método para consultar extrato
    public void btConsultaExtrato() {
        // Cria um objeto Usuario 
        Usuario user = new Usuario(null, consultaExtrato.getTxtCPF().getText(),
                                   consultaExtrato.getTxtSenha().getText());

        // Cria uma nova instância da classe Conexao
        Conexao conexao = new Conexao();

        try {
            //cria uma conexão com o banco de dados
            Connection conn = conexao.getConnection();

            //cria uma nova instância da classe UsuarioDAO
            UsuarioDAO dao = new UsuarioDAO(conn);

            //executa o método consultarLogin 
            ResultSet res = dao.consultarLogin(user);

            //verifica se a consulta retornou algum resultado
            if (res.next()) {
               
                String nome = res.getString("nome");
                String cpf = res.getString("cpf");
                String senha = res.getString("senha");

                //define o texto de um componente da interface para exibir as informações do usuário
                consultaExtrato.getExibeInformacoes().setText("Nome: " + nome + "\n"
                                                              + "CPF: " + cpf);

                //chama o método Extrato para obter os extratos do usuario
                String extrato = dao.Extrato(user);

                //define o texto de um componente da interface para exibir o extrato do usuário
                consultaExtrato.getExibeExtrato().setText(extrato);
            } else {
                //se o usuário não for encontrado, exibe uma mensagem de erro
                JOptionPane.showMessageDialog(login, "Usuário não encontrado");
            }
        } catch (SQLException e) {
            //exibe uma mensagem de erro de conexão, caso ocorra uma conexão com o banco de dados
            JOptionPane.showMessageDialog(login, "Erro de conexão!");
        }
    }

    
    public void consultarMoedas() {
        try {
            //instancia um objeto conexão
            Conexao conexao = new Conexao();
            //cria a conexão com o banco de dados
            Connection conn = conexao.getConnection();
            
            //string paraa ser usada no sql
            String sql = "select * from moedas;";
            //prepara a instrução sql
            PreparedStatement statement = conn.prepareStatement(sql);
            //executa a instrução sql
            ResultSet resultado = statement.executeQuery();
            
            //instancia o objeto da classe StringBuild
            StringBuilder string = new StringBuilder();
            
            //intera sobre o resultado do resultado e realiza uma adição a string
            //onde esta sendo armazenada todos as informações das moedas
            while (resultado.next()) {
                string.append("").append(resultado.getString("nome").toUpperCase())
                      .append("     Valor: R$ ").append(resultado.getDouble("valor"))
                      .append("   Taxa de Compra: ").append(resultado.getDouble("txcompra"))
                      .append("%\n");
            }
            
            //altera o texto do componente na view para escrever as informações das moedas
            comprarCripto.getTxtMoedas().setText(string.toString());
            
            //encerra a conexão
            conn.close();
        } catch (SQLException e) {
            //informa no terminal uma possivel exceção
            e.printStackTrace();
        }
    }
    
    //metodo para realizar compra de criptomoedas
    public void comprarMoeda(){
        
        //converte o valor em reais que esta em Txt para double
        double quantidadeReais = Double.parseDouble(comprarCripto.getTxtQuantidadeReais().getText());
        
        //instancia o objeto user 
        Usuario user = new Usuario(null,comprarCripto.getTxtCpf().getText(),
                              comprarCripto.getTxtSenha().getText(),
                              comprarCripto.getTxtNomeCripto().getText().toLowerCase());
        
        //instancia o objeto moeda da classe moeda
        Moedas moeda = new Moedas(comprarCripto.getTxtNomeCripto().getText().toLowerCase(),
                                  quantidadeReais);
        
        //instancia o objeto conexão
        Conexao conexao = new Conexao();
              
        try{
            //cria a conexão ao banco de dados
            Connection conn  = conexao.getConnection();
            
            //instancia a dao
            UsuarioDAO dao = new UsuarioDAO(conn);
            
            //realiza o resultset com as informações inseridas do usuario
            ResultSet res = dao.consultarLogin(user);
            
            
            //realiza uma verificação para ver se o usuario e senha informados
            //existem no banco de dados
            if(res.next()){
                
                //verifica se o saldo ira ficar negativo com o valor inserido 
                //caso valor fique negativo a operação não sera realizada
                if (dao.saldoAtual(user) - moeda.getValor() < 0){
                   
                    JOptionPane.showMessageDialog(comprarCripto,"Saldo insufiente");
                    return;
                }
                
                //cria um atributo onde armazena o valor da moeda, pelo metodo da dao
                double valorMoeda = dao.valorMoeda(moeda);
                //cria um atributo onde armazena a taxa de compra da moeda
                double txCompra = dao.valorTxCompra(moeda);
                
                //calculos das taxas e valores a ser comprado de criptomoedas
                double calculoTaxa = moeda.getValor() * txCompra;
                double valorComprado = moeda.getValor() - calculoTaxa;
                double calculoCriptos = valorComprado / valorMoeda;
               
                //realiza a subtração do valor atual do saldo com o de compra
                double saldoRestante = dao.saldoAtual(user) - moeda.getValor();
                
                //string sql para atualizar no banco de dados
                String sql1 = "update carteira set reais = ? where cpf = ?";
                
                //preapara a instrução sql
                PreparedStatement statement1 = conn.prepareStatement(sql1);
                //substitui o valor da indexação indicada por ? na string sql,
                //na ordem informada nos parametros no valor de indice.
                statement1.setDouble(1, saldoRestante);
                statement1.setString(2, comprarCripto.getTxtCpf().getText());
                
                //executa a instrução sql
                statement1.execute();
                
                //atributo para somar o saldo da criptomoeda 
                double saldo = dao.saldoCripto(user) + calculoCriptos;
                
                
                //string para instrução do banco de dados, onde atualiza o saldo da moeda
                String sql = "update carteira set "+comprarCripto.getTxtNomeCripto().getText()+
                             " = ? where cpf = ?";
                
                //prepara a instrução sql
                PreparedStatement statement = conn.prepareStatement(sql);
                //substitui o valor da indexação indicada por ? na string sql,
                //na ordem informada nos parametros no valor de indice.
                statement.setDouble(1, saldo);
                statement.setString(2, comprarCripto.getTxtCpf().getText());
                //executa a instrução sql
                statement.execute();
                
                //string onde cria o extrato da compra da criptomoeda
                String sql2 = "INSERT INTO public.extrato(\n" +
        "	data, tipodeoperacao, valor, moeda,taxa, real , bitcoin, ethereum, ripple, cpf)\n" +
        "	VALUES (?, ?, ?, ?, ?,? ,?, ?, ?, ?); ";
                
                //prepara a instrução sql
                PreparedStatement statement2 = conn.prepareStatement(sql2);
                
                //substitui o valor da indexação indicada por ? na string sql,
                //na ordem informada nos parametros no valor de indice.
                statement2.setString(1,dataHoraFormatada);
                statement2.setString(2, "+");
                statement2.setDouble(3,calculoCriptos);
                statement2.setString(4,moeda.getCripto().toUpperCase());
                statement2.setDouble(5,calculoTaxa);
                statement2.setDouble(6,saldoRestante);
                statement2.setDouble(7,dao.saldoAtualBitcoin(user));
                statement2.setDouble(8,dao.saldoAtualEthereum(user));
                statement2.setDouble(9,dao.saldoAtualRipple(user));
                statement2.setString(10,user.getCpf());
                
                //executa a instrução sql
                statement2.execute();
               //fecha a conexão com o banco de dados
                conn.close();
                
                //cria um popup onde informa a quantidade em reais comprada de criptomoedas
                //, valor da taxa, aquantidade comprada de criptomoedas e o nome da moeda
                JOptionPane.showMessageDialog(comprarCripto,"Compra Realizada com Sucesso\n\n"
                        + "Criptomoeda: " + comprarCripto.getTxtNomeCripto().getText()+"\n"
                        + "\nValor em Reais: R$ " + moeda.getValor() + "\nTaxa: " + calculoTaxa
                        + "\nQuantidade comprada: " + calculoCriptos);
                
                //caso o cpf e senha informados estejam incorretos ira exibir um popup
                //onde informa que o cpf ou senha esta incorreto
            } else {
                JOptionPane.showMessageDialog(comprarCripto, "Usuário ou senha incorreta!");
            }
           //caso ocorra um erro de conexão, ira informar um popup com a mensagem             
        }catch(SQLException e){
            JOptionPane.showMessageDialog(comprarCripto, "Erro de conexão!");
        }
        
    }
    
    //metodo onde consulta as moedas existentes
    public void consultarMoedasVendas() {
        try {
            //cria a conexão com o banco
            Conexao conexao = new Conexao();
            Connection conn = conexao.getConnection();
            
            //string para instrução sql
            String sql = "select * from moedas;";
            //prepara a instrução sql
            PreparedStatement statement = conn.prepareStatement(sql);
            //executa instrução sql
            ResultSet resultado = statement.executeQuery();
            
            //instancia o objeto da classe StringBuilder para armazenar a string
            //contendo as informações das moedas
            StringBuilder string = new StringBuilder();
            
            //intera sobre o resultado do resultset e faz uma adição a string
            // com as informações das moedas
            while (resultado.next()) {
                string.append("").append(resultado.getString("nome").toUpperCase())
                      .append("     Valor: R$ ").append(resultado.getDouble("valor"))
                      .append("   Taxa de Compra: ").append(resultado.getDouble("txcompra"))
                      .append("%\n");
            }
            
            //altera o texto de um objeto da view para escrever a string que foi
            //construida com as informações da moedas
            venderCripto.getTxtMoedas().setText(string.toString());
            
            //encerra a conexão
            conn.close();
        } catch (SQLException e) {
            //informa uma exceção no terminal caso ocorra
            e.printStackTrace();
        }
    }
    
    public void venderCriptomoeda(){
        
        //tranforma em double o valor inserido em um componente txt da view
        double quantidadeCripto = Double.parseDouble(venderCripto.getTxtQuantidadeCripto().getText());
        
        //instancia e cria o objeto user
        Usuario user = new Usuario(null,venderCripto.getTxtCpf().getText(),
                              venderCripto.getTxtSenha().getText(),
                              venderCripto.getTxtNomeCripto().getText().toLowerCase());
        
        //instancia e cria o objeto moeda
        Moedas moeda = new Moedas(venderCripto.getTxtNomeCripto().getText().toLowerCase(),
                                  quantidadeCripto);
        
        //instancia e cria a conexao
        Conexao conexao = new Conexao();
              
        try{
            
            //cria a conexão com o banco de dados
            Connection conn  = conexao.getConnection();
            //cria a dao
            UsuarioDAO dao = new UsuarioDAO(conn);
            //realiza um resultset para consultar o usuario
            ResultSet res = dao.consultarLogin(user);
            
            
            //intera pelo o resultado do resultset e verifica se o cpf e senha
            //existem no banco de dados
            if(res.next()){
                
                //verifica se o saldo da criptomoeda inserida não ficara negativo
                //caso fique negativa a operação não sera realizada
                if (dao.saldoCripto(user) - moeda.getValor() < 0){
                   
                    JOptionPane.showMessageDialog(venderCripto,"Saldo insufiente");
                    return;
                }
                
                //atributos onde armazena o valor e taxa da moeda consultado pela dao
                double valorMoeda = dao.valorMoeda(moeda);
                double txVenda = dao.valorTxVenda(moeda);
                
                //calcula a taxa e a quantidade em reais a ser recebida pela venda das cripto
                double valorReais = quantidadeCripto * valorMoeda;
                double calculoTxVenda = valorReais * txVenda;
                double valorAReceber = valorReais - calculoTxVenda;
               
                //atributo onde armazenara o saldo futuro da conta apos a venda das criptomoedas
                double saldoRestante = dao.saldoAtual(user) + valorAReceber;
                
                //String onde ira atualizar o saldo em reais do usuario
                String sql1 = "update carteira set reais = ? where cpf = ?";
                
                //prepara a instrução sql
                PreparedStatement statement1 = conn.prepareStatement(sql1);
                
                //substitui o valor da indexação indicada por ? na string sql,
                //na ordem informada nos parametros no valor de indice.
                statement1.setDouble(1, saldoRestante);
                statement1.setString(2, venderCripto.getTxtCpf().getText());
                //executa a instrução sql
                statement1.execute();
             
                
                //atributo onde faz a subtração do saldo da cripto com a quantidade vendida
                double saldo = dao.saldoCripto(user) - quantidadeCripto;
                
               
                //String que sera executada no banco de dados para atualizar o saldo da cripto
                String sql = "update carteira set "+venderCripto.getTxtNomeCripto().getText()+
                             " = ? where cpf = ?";
                
                //prepara a instrução sql
                PreparedStatement statement = conn.prepareStatement(sql);
                
                //substitui o valor da indexação indicada por ? na string sql,
                //na ordem informada nos parametros no valor de indice.
                statement.setDouble(1, saldo);
                statement.setString(2, venderCripto.getTxtCpf().getText());
                //executa a instrução sql
                statement.execute();
                
                //String onde cria o extrato da trasação
                String sql2 = "INSERT INTO public.extrato(\n" +
        "	data, tipodeoperacao, valor, moeda,taxa, real , bitcoin, ethereum, ripple, cpf)\n" +
        "	VALUES (?, ?, ?, ?, ?,? ,?, ?, ?, ?); ";
                
                //prepara a instrução sql
                PreparedStatement statement2 = conn.prepareStatement(sql2);
                //substitui o valor da indexação indicada por ? na string sql,
                //na ordem informada nos parametros no valor de indice.
                statement2.setString(1,dataHoraFormatada);
                statement2.setString(2, "-");
                statement2.setDouble(3,saldo);
                statement2.setString(4,venderCripto.getTxtNomeCripto().getText());
                statement2.setDouble(5,calculoTxVenda);
                statement2.setDouble(6,saldoRestante);
                statement2.setDouble(7,dao.saldoAtualBitcoin(user));
                statement2.setDouble(8,dao.saldoAtualEthereum(user));
                statement2.setDouble(9,dao.saldoAtualRipple(user));
                statement2.setString(10,user.getCpf());
                //executa a instrução sql
                statement2.execute();
                //encerra a conexão 
                conn.close();
                    
                //cria um popup onde informara a quantidade de criptomoedas em reais 
                //a taxa de venda , e a quantidade de criptomoedas vendida
                JOptionPane.showMessageDialog(venderCripto,"Compra Realizada com Sucesso\n\n"
                        + "Criptomoeda: " + venderCripto.getTxtNomeCripto().getText()+"\n"
                        + "\nQuantidade em criptomoeda: R$ " + moeda.getValor() + 
                          "\nTaxa: " + calculoTxVenda
                        + "\nValor recebido: R$ " + valorReais);
                
                //caso as informações do usuario forem inseridas incorretas
                //informara um popup de cpf ou senha incorreta
            } else {
                JOptionPane.showMessageDialog(venderCripto, "CPF ou senha incorreta!");
            }
          //caso a conexão não seja realizada , informara um popup de erro de conexão
        }catch(SQLException e){
           
            JOptionPane.showMessageDialog(venderCripto, "Erro de conexão!");
        }
        
    }
    //metodo para atualizar a cotação das moedas
    public void atualizarCotacao() {
        try {
            //instancia um objeto de conexao
            Conexao conexao = new Conexao();
            //cria a conexão com o banco de dados
            Connection conn = conexao.getConnection();
            //cria a dao de adm
            AdministradorDAO dao = new AdministradorDAO(conn);
            //executa o metodo da dao adm
            dao.atualizarCotacao();
            
            //cria um popup informando que a cotação das moedas foram atualizadas
            JOptionPane.showMessageDialog(null, "Cotação atualizada com sucesso!");
            
            //caso ocorra algum erro, exibira a mensagem abaixo
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar a cotação: " + e.getMessage());
        }
    }   
}

