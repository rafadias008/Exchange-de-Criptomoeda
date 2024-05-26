package Controller; // Define o pacote onde esta classe está localizada

// Importa as classes necessárias
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
import java.text.DecimalFormat;
import java.util.Map;

public class ControllerADM {

    // Declara as variáveis para diferentes views
    private LoginADM loginADM;
    private CadastroInvest CadInvest;
    private DeletaInvest DelInvest;
    private CadastroCripto CadCripto;
    private DeletarCripto DelCripto;
    private ConsultaSaldoADM ConsultSaldo;
    private Extrato consultExtrato;
    private PaginaADM pgADM;

    // Construtores para inicializar as variáveis de view
    public ControllerADM(PaginaADM pgADM) {
        this.pgADM = pgADM;
    }

    public ControllerADM(ConsultaSaldoADM ConsultSaldo) {
        this.ConsultSaldo = ConsultSaldo;
    }

    public ControllerADM(LoginADM loginADM) {
        this.loginADM = loginADM;
    }

    public ControllerADM(CadastroInvest CadInvest) {
        this.CadInvest = CadInvest;
    }

    public ControllerADM(DeletaInvest DelInvest) {
        this.DelInvest = DelInvest;
    }

    public ControllerADM(CadastroCripto CadCripto) {
        this.CadCripto = CadCripto;
    }

    public ControllerADM(DeletarCripto DelCripto) {
        this.DelCripto = DelCripto;
    }

    public ControllerADM(Extrato consultExtrato) {
        this.consultExtrato = consultExtrato;
    }

    // Método para realizar o login do administrador
    public void btLoginADM() {
        // Cria um objeto Administrador com os dados do login
        Administrador userADM = new Administrador(null, loginADM.getLoginCPF().getText(),
                loginADM.getLoginSenha().getText());

        // Cria uma conexão com o banco de dados
        Conexao conexao = new Conexao();

        try {
            Connection conn = conexao.getConnection(); // Obtém a conexão
            System.out.println("conectou");
            AdministradorDAO dao = new AdministradorDAO(conn); // Cria um objeto DAO para administrador
            System.out.println("criou dao");
            ResultSet res = dao.consultarLoginADM(userADM); // Consulta o login do administrador
            System.out.println("resultado");

            if (res.next()) { // Se o login for bem-sucedido
                PaginaADM PA = new PaginaADM();

                // Obtém os dados do administrador
                String nome = res.getString("nome");
                String cpf = res.getString("cpf");
                String senha = res.getString("senha");

                PA.setVisible(true); // Torna a página de administrador visível
                PA.setLocationRelativeTo(null); // Centraliza a janela
            } else {
                JOptionPane.showMessageDialog(loginADM, "Login não efetuado!"); // Exibe mensagem de erro
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(loginADM, "Erro de conexão!"); // Exibe mensagem de erro de conexão
        }
    }

    // Método para criar um novo investidor
    public void btCreatedInvest() {
        Usuario user = new Usuario(CadInvest.getTxtNome().getText(), CadInvest.getTxtCpf().getText(),
                CadInvest.getTxtSenha().getText(), 0);

        Conexao conexao = new Conexao();

        boolean hasError = false; // Flag para verificar se houve erro

        try {
            Connection conn = conexao.getConnection(); // Obtém a conexão
            System.out.println("conectou");

            // Verifica se o CPF tem 11 dígitos
            try {
                if (CadInvest.getTxtCpf().getText().length() != 11) {
                    throw new IllegalArgumentException("CPF inválido. Deve conter exatamente 11 dígitos.");
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Exceção: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "CPF inválido. Deve conter exatamente 11 dígitos.", "Erro", JOptionPane.ERROR_MESSAGE);
                hasError = true;
            }

            // Verifica se o CPF contém apenas números
            try {
                Long.parseLong(CadInvest.getTxtCpf().getText());
            } catch (NumberFormatException e) {
                System.err.println("Exceção: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "CPF inválido, Digite apenas números!", "Erro", JOptionPane.ERROR_MESSAGE);
                hasError = true;
            }

            // Verifica se a senha tem 6 dígitos
            try {
                if (CadInvest.getTxtSenha().getText().length() != 6) {
                    throw new IllegalArgumentException("Senha Inválida. Deve conter exatamente 6 dígitos.");
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Exceção: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Senha Inválida, deve conter 6 dígitos", "Erro", JOptionPane.ERROR_MESSAGE);
                hasError = true;
            }

            // Verifica se a senha contém apenas números
            try {
                Long.parseLong(CadInvest.getTxtSenha().getText());
            } catch (NumberFormatException e) {
                System.err.println("Exceção: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Senha inválida, somente números!", "Erro", JOptionPane.ERROR_MESSAGE);
                hasError = true;
            }

            if (!hasError) { // Se não houver erro
                try {
                    AdministradorDAO dao = new AdministradorDAO(conn); // Cria um objeto DAO para administrador
                    System.out.println("criou dao");
                    dao.createdInvest(user); // Cria o investidor

                    JOptionPane.showMessageDialog(CadInvest, "Investidor Criado"); // Exibe mensagem de sucesso
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(CadInvest, "CPF já existente!"); // Exibe mensagem de erro
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(CadInvest, e); // Exibe mensagem de erro de conexão
        }
    }

    // Método para deletar um investidor
    public void btDeletarInvest() {
        Usuario user = new Usuario(null, DelInvest.getTxtCpf().getText(), null, 0);

        Conexao conexao = new Conexao();

        try {
            Connection conn = conexao.getConnection(); // Obtém a conexão
            System.out.println("conectou");

            try {
                AdministradorDAO dao = new AdministradorDAO(conn); // Cria um objeto DAO para administrador
                System.out.println("criou dao");
                dao.deletarInvest(user); // Deleta o investidor

                JOptionPane.showMessageDialog(CadInvest, "Investidor Deletado!"); // Exibe mensagem de sucesso
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(CadInvest, "CPF inválido"); // Exibe mensagem de erro
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(CadInvest, "Erro de conexão!"); // Exibe mensagem de erro de conexão
        }
    }

    // Método para cadastrar uma nova criptomoeda
    public void btCadastrarCripto() {
        double valor = Double.parseDouble(CadCripto.getTxtValorMoeda().getText());
        double txCompra = Double.parseDouble(CadCripto.getTxtTaxaCompra().getText());
        double txVenda = Double.parseDouble(CadCripto.getTxtTaxaVenda().getText());

        Moedas moeda = new Moedas(CadCripto.getTxtNomeCripto().getText().toLowerCase(), valor, txCompra, txVenda);

        Conexao conexao = new Conexao();

        try {
            Connection conn = conexao.getConnection(); // Obtém a conexão
            System.out.println("conectou");
            AdministradorDAO dao = new AdministradorDAO(conn); // Cria um objeto DAO para administrador
            System.out.println("criou dao");
            dao.criarCripto(moeda); // Cria a criptomoeda

            JOptionPane.showMessageDialog(CadCripto, "Criptomoeda criada!"); // Exibe mensagem de sucesso
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(CadCripto, e); // Exibe mensagem de erro
            System.out.println(e);
        }
    }

    // Método para deletar uma criptomoeda
    public void btDeletarCripto() {
        Moedas moeda = new Moedas(DelCripto.getTxtNomeCripto().getText(), 0);

        Conexao conexao = new Conexao();

        try {
            Connection conn = conexao.getConnection(); // Obtém a conexão
            System.out.println("conectou");
            AdministradorDAO dao = new AdministradorDAO(conn); // Cria um objeto DAO para administrador
            System.out.println("criou dao");
            dao.DeletarCripto(moeda); // Deleta a criptomoeda

            JOptionPane.showMessageDialog(DelCripto, "Criptomoeda deletada!"); // Exibe mensagem de sucesso
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(DelCripto, "Criptomoeda não encontrada!"); // Exibe mensagem de erro
            System.out.println(e);
        }
    }

    // Método para consultar o saldo de um usuário
    public void btConsultarSaldo() {
        Usuario user = new Usuario(null, ConsultSaldo.getTxtCpf().getText(), null);

        Conexao conexao = new Conexao();

        try {
            Connection conn = conexao.getConnection(); // Obtém a conexão
            System.out.println("conectou");
            UsuarioDAO dao = new UsuarioDAO(conn); // Cria um objeto DAO para usuário
            System.out.println("criou dao");
            AdministradorDAO dao2 = new AdministradorDAO(conn); // Cria um objeto DAO para administrador
            ResultSet res = dao2.consultarUsuario(user); // Consulta o usuário
            System.out.println("resultado");

            if (res.next()) { // Se o usuário for encontrado
                String nome = res.getString("nome");
                String cpf = res.getString("cpf");

                Map<String, Double> saldos = dao.saldoAtualMoedas(user); // Obtém o saldo das moedas

                StringBuilder saldoStr = new StringBuilder();
                saldoStr.append("NOME: ").append(nome)
                        .append("\nCPF: ").append(cpf)
                        .append("\n");

                // Formata o saldo para 3 casas decimais
                DecimalFormat df = new DecimalFormat("#.###");

                for (Map.Entry<String, Double> entry : saldos.entrySet()) {
                    saldoStr.append("\n").append(entry.getKey()).append(": ").append(df.format(entry.getValue()));
                }

                JOptionPane.showMessageDialog(ConsultSaldo, saldoStr.toString()); // Exibe o saldo
            } else {
                JOptionPane.showMessageDialog(ConsultSaldo, "Usuário não encontrado"); // Exibe mensagem de erro
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(ConsultSaldo, "Erro de conexão!"); // Exibe mensagem de erro de conexão
        }
    }

    // Método para consultar o extrato de um usuário
    public void btConsultExtrato() {
        Usuario user = new Usuario(null, consultExtrato.getTxtCpf().getText(), null);

        Conexao conexao = new Conexao();

        try {
            Connection conn = conexao.getConnection(); // Obtém a conexão
            System.out.println("conectou");
            UsuarioDAO dao = new UsuarioDAO(conn); // Cria um objeto DAO para usuário
            System.out.println("criou dao");
            AdministradorDAO dao2 = new AdministradorDAO(conn); // Cria um objeto DAO para administrador
            ResultSet res = dao2.consultarUsuario(user); // Consulta o usuário
            System.out.println("resultado");

            if (res.next()) { // Se o usuário for encontrado
                String nome = res.getString("nome");
                String cpf = res.getString("cpf");

                consultExtrato.getExibeInformacoes().setText("Nome: " + nome + "\n"
                        + "CPF: " + cpf);

                String extrato = dao.Extrato(user); // Obtém o extrato
                consultExtrato.getExibeExtrato().setText(extrato); // Exibe o extrato
            } else {
                JOptionPane.showMessageDialog(consultExtrato, "Usuário não encontrado"); // Exibe mensagem de erro
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(consultExtrato, "Erro de conexão!"); // Exibe mensagem de erro de conexão
        }
    }

    // Método para atualizar a cotação das moedas
    public void atualizarCotacao() {
        try {
            Conexao conexao = new Conexao();
            Connection conn = conexao.getConnection(); // Obtém a conexão
            AdministradorDAO dao = new AdministradorDAO(conn); // Cria um objeto DAO para administrador
            dao.atualizarCotacao(); // Atualiza a cotação
            JOptionPane.showMessageDialog(null, "Cotação atualizada com sucesso!"); // Exibe mensagem de sucesso
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar a cotação: " + e.getMessage()); // Exibe mensagem de erro
        }
    }
}
