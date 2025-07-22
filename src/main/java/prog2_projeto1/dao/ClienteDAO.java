package prog2_projeto1.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import prog2_projeto1.DBConnection;
import prog2_projeto1.model.Cliente;

public class ClienteDAO {
    Logger logger = Logger.getLogger(ClienteDAO.class);

    public boolean salvar(Cliente modelo) throws SQLException {
        logger.info("--- Início do método DAO Salvar ---");

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String insertcliente = "INSERT INTO cliente " +
                    "(nome, cpf, rg, endereco, telefone, email, data_cadastro, referencia_comercial, data_nascimento)" +
                    "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement1 = connection.prepareStatement(insertcliente);
            preparedStatement1.setString(1, modelo.getNome());
            preparedStatement1.setString(2, modelo.getCpf());
            preparedStatement1.setString(3, modelo.getRg());
            preparedStatement1.setString(4, modelo.getEndereco());
            preparedStatement1.setString(5, modelo.getTelefone());
            preparedStatement1.setString(6, modelo.getEmail());
            preparedStatement1.setDate(7, (Date) modelo.getData_cadastro());
            preparedStatement1.setString(8, modelo.getReferencia_comercial());
            preparedStatement1.setDate(9, modelo.getData_nascimento());
            logger.info("String insert Cliente preparada: " + preparedStatement1);
            int resultado = preparedStatement1.executeUpdate();

            if (resultado > 0) {
                logger.info("Inseriu Cliente: " + resultado);
                logger.info("--- Fim do método DAO Salvar ---");
                return true;
            } else {
                logger.info("Retorno menor que zero " + resultado);
                logger.info("--- Fim do método DAO Salvar ---");
                return false;

            }
        } catch (Exception e) {
            logger.error("Ocorreu um erro ao tentar salvar: " + e.getMessage());
            logger.error("--- Fim do método DAO Salvar ---");
            return false;
        }
    }

    public boolean alterar(Cliente modelo) throws SQLException {
        logger.info("--- Início do método DAO Alterar ---");

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String updatePessoa = "update cliente set nome = ?, cpf = ?, rg = ?, endereco = ?, telefone = ?, email = ?, data_cadastro = ?, referencia_comercial = ?, data_nascimento = ? where id = ?";

            PreparedStatement preparedStatement1 = connection.prepareStatement(updatePessoa);
            preparedStatement1.setString(1, modelo.getNome());
            preparedStatement1.setString(2, modelo.getCpf());
            preparedStatement1.setString(3, modelo.getRg());
            preparedStatement1.setString(4, modelo.getEndereco());
            preparedStatement1.setString(5, modelo.getTelefone());
            preparedStatement1.setString(6, modelo.getEmail());
            preparedStatement1.setDate(7, (Date) modelo.getData_cadastro());
            preparedStatement1.setString(8, modelo.getReferencia_comercial());
            preparedStatement1.setDate(9, modelo.getData_nascimento());
            preparedStatement1.setInt(10, modelo.getId());

            logger.info("String update cliente preparada: " + preparedStatement1);
            int resultadocliente = preparedStatement1.executeUpdate();

            if (resultadocliente > 0) {
                logger.info("Retorno maior que zero: " + resultadocliente);
                logger.info("--- Fim do método DAO Alterar ---");
                return true;
            } else {
                logger.info("Retorno menor que zero ");
                logger.info("--- Fim do método DAO Alterar ---");
                return false;

            }
        } catch (Exception e) {
            logger.error("Ocorreu um erro ao tentar alterar: " + e.getMessage());
            logger.error("--- Fim do método DAO Alterar ---");
            return false;
        }
    }

    public boolean excluir(Cliente modelo) throws SQLException {
        logger.info("--- Início do método DAO Excluir ---");

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String insertPessoa = "delete from cliente where id = ?";
            PreparedStatement preparedStatement1 = connection.prepareStatement(insertPessoa);
            preparedStatement1.setInt(1, modelo.getId());
            logger.info("String delete cliente preparada: " + preparedStatement1);
            int resultadocliente = preparedStatement1.executeUpdate();

            if (resultadocliente > 0) {
                logger.info("Retorno maior que zero " + resultadocliente);
                logger.info("--- Fim do método DAO Excluir ---");
                return true;
            } else {
                logger.info("Retorno menor que zero " + resultadocliente);
                logger.info("--- Fim do método DAO Excluir ---");
                return false;

            }
        } catch (Exception e) {
            logger.error("Ocorreu um erro ao tentar excluir: " + e.getMessage());
            logger.error("--- Fim do método DAO Excluir ---");
            return false;
        }
    }

    public boolean buscar(Cliente modelo) throws SQLException {

        return false;
    }

    public List<Cliente> buscarTodos() throws SQLException {
        try {
            logger.info("--- Início do método DAO Buscar Todos ---");

            Connection connection = DBConnection.getInstance().getConnection();

            String consulta = "select * from cliente";
            List<Cliente> lista = new ArrayList<Cliente>();
            Cliente cliente;

            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            ResultSet resultSet = preparedStatement.executeQuery();
            logger.info("Consulta executada: " + preparedStatement);

            while (resultSet.next()) {
                cliente = new Cliente();
                cliente.setId(resultSet.getInt("id"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setCpf(resultSet.getString("cpf"));
                cliente.setRg(resultSet.getString("rg"));
                cliente.setEndereco(resultSet.getString("endereco"));
                cliente.setTelefone(resultSet.getString("telefone"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setData_cadastro(resultSet.getDate("data_cadastro"));
                cliente.setReferencia_comercial(resultSet.getString("referencia_comercial"));
                cliente.setData_nascimento(resultSet.getDate("data_nascimento"));

                lista.add(cliente);
            }

            logger.info("Quantidade de registros pesquisados: " + lista.size());
            logger.info("--- Fim do método DAO Buscar Todos ---");

            return lista;
        } catch (SQLException e) {
            logger.error("Ocorreu um erro ao tentar buscar todos: " + e.getMessage());
            return null;
        }
    }

    public Cliente buscar(int id) throws SQLException {
        try {
            logger.info("--- Início do método DAO Buscar por Id ---");

            Connection connection = DBConnection.getInstance().getConnection();

            String consulta = "select * from cliente where id = ?";
            Cliente cliente = new Cliente();

            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            logger.info("Consulta executada: " + preparedStatement);

            while (resultSet.next()) {
                cliente = new Cliente();
                cliente.setId(resultSet.getInt("id"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setCpf(resultSet.getString("cpf"));
                cliente.setRg(resultSet.getString("rg"));
                cliente.setEndereco("endereco");
                cliente.setTelefone(resultSet.getString("telefone"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setData_cadastro(resultSet.getDate("data_cadastro"));
                cliente.setReferencia_comercial(resultSet.getString("referencia_comercial"));
                cliente.setData_nascimento(resultSet.getDate("data_nascimento"));
            }

            logger.info("--- Fim do método DAO Buscar por Id ---");

            return cliente;
        } catch (SQLException e) {
            logger.error("Ocorreu um erro ao tentar buscar: " + e.getMessage());
            return null;
        }
    }
}
