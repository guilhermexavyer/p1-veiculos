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
import prog2_projeto1.model.Vendedor;

public class VendedorDAO {
    Logger logger = Logger.getLogger(VendedorDAO.class);

    public boolean salvar(Vendedor modelo) throws SQLException {
        logger.info("--- Início do método DAO Salvar ---");

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String insertVendedor = "INSERT INTO vendedor " +
                                "(data_cadastro, nome, cpf, rg, endereco, telefone, email, salario, comissao) " +
                                "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement1 = connection.prepareStatement(insertVendedor);
            preparedStatement1.setDate(1, (Date) modelo.getData_cadastro());
            preparedStatement1.setString(2, modelo.getNome());
            preparedStatement1.setString(3, modelo.getCpf());
            preparedStatement1.setString(4, modelo.getRg());
            preparedStatement1.setString(5, modelo.getEndereco());
            preparedStatement1.setString(6, modelo.getTelefone());
            preparedStatement1.setString(7, modelo.getEmail());
            preparedStatement1.setDouble(8, modelo.getSalario());
            preparedStatement1.setDouble(9, modelo.getComissao());
            logger.info("String insert Veículo preparada: " + preparedStatement1);
            int resultado = preparedStatement1.executeUpdate();

            if (resultado > 0) {
                logger.info("Inseriu Veículo: " + resultado);
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

    public boolean alterar(Vendedor modelo) throws SQLException {
        logger.info("--- Início do método DAO Alterar ---");

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String updatePessoa = "update vendedor set data_cadastro = ?, nome = ?, cpf = ?, rg = ?, endereco = ?, telefone = ?, email = ?, salario = ?, comissao = ? where id = ?";

            PreparedStatement preparedStatement1 = connection.prepareStatement(updatePessoa);
            preparedStatement1.setDate(1, (Date) modelo.getData_cadastro());
            preparedStatement1.setString(2, modelo.getNome());
            preparedStatement1.setString(3, modelo.getCpf());
            preparedStatement1.setString(4, modelo.getRg());
            preparedStatement1.setString(5, modelo.getEndereco());
            preparedStatement1.setString(6, modelo.getTelefone());
            preparedStatement1.setString(7, modelo.getEmail());
            preparedStatement1.setDouble(8, modelo.getSalario());
            preparedStatement1.setDouble(9, modelo.getComissao());
            preparedStatement1.setInt(10, modelo.getId());
            
            logger.info("String update veículo preparada: " + preparedStatement1);
            int resultadoVendedor = preparedStatement1.executeUpdate();

            if (resultadoVendedor > 0) {
                logger.info("Retorno maior que zero: " + resultadoVendedor);
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

    public boolean excluir(Vendedor modelo) throws SQLException {
        logger.info("--- Início do método DAO Excluir ---");

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String insertPessoa = "delete from vendedor where id = ?";
            PreparedStatement preparedStatement1 = connection.prepareStatement(insertPessoa);
            preparedStatement1.setInt(1, modelo.getId());
            logger.info("String delete veículo preparada: " + preparedStatement1);
            int resultadoVendedor = preparedStatement1.executeUpdate();

            if (resultadoVendedor > 0) {
                logger.info("Retorno maior que zero " + resultadoVendedor);
                logger.info("--- Fim do método DAO Excluir ---");
                return true;
            } else {
                logger.info("Retorno menor que zero " + resultadoVendedor);
                logger.info("--- Fim do método DAO Excluir ---");
                return false;

            }
        } catch (Exception e) {
            logger.error("Ocorreu um erro ao tentar excluir: " + e.getMessage());
            logger.error("--- Fim do método DAO Excluir ---");
            return false;
        }
    }

    public boolean buscar(Vendedor modelo) throws SQLException {
        return false;
    }

    public List<Vendedor> buscarTodos() throws SQLException {
        try {
            logger.info("--- Início do método DAO Buscar Todos ---");

            Connection connection = DBConnection.getInstance().getConnection();

            String consulta = "select * from vendedor";
            List<Vendedor> lista = new ArrayList<Vendedor>();
            Vendedor vendedor;

            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            ResultSet resultSet = preparedStatement.executeQuery();
            logger.info("Consulta executada: " + preparedStatement);

            while (resultSet.next()) {
                vendedor = new Vendedor();
                vendedor.setId(resultSet.getInt("id"));
                vendedor.setData_cadastro(resultSet.getDate("data_cadastro"));
                vendedor.setNome(resultSet.getString("nome"));
                vendedor.setCpf(resultSet.getString("cpf"));
                vendedor.setRg(resultSet.getString("rg"));
                vendedor.setEndereco(resultSet.getString("endereco"));
                vendedor.setTelefone(resultSet.getString("telefone"));
                vendedor.setEmail(resultSet.getString("email"));
                vendedor.setSalario(resultSet.getDouble("salario"));
                vendedor.setComissao(resultSet.getDouble("comissao"));
                lista.add(vendedor);
            }

            logger.info("Quantidade de registros pesquisados: " + lista.size());
            logger.info("--- Fim do método DAO Buscar Todos ---");

            return lista;
        } catch (SQLException e) {
            logger.error("Ocorreu um erro ao tentar buscar todos: " + e.getMessage());
            return null;
        }
    }

    public Vendedor buscar(int id) throws SQLException {
        try {
            logger.info("--- Início do método DAO Buscar por Id ---");

            Connection connection = DBConnection.getInstance().getConnection();

            String consulta = "select * from vendedor where id = ?";
            Vendedor vendedor = new Vendedor();

            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            logger.info("Consulta executada: " + preparedStatement);

            while (resultSet.next()) {
                vendedor.setId(resultSet.getInt("id"));
                vendedor.setData_cadastro(resultSet.getDate("data_cadastro"));
                vendedor.setNome(resultSet.getString("nome"));
                vendedor.setCpf(resultSet.getString("cpf"));
                vendedor.setRg(resultSet.getString("rg"));
                vendedor.setEndereco(resultSet.getString("endereco"));
                vendedor.setTelefone(resultSet.getString("telefone"));
                vendedor.setEmail(resultSet.getString("email"));
                vendedor.setSalario(resultSet.getDouble("salario"));
                vendedor.setComissao(resultSet.getDouble("comissao"));
            }

            logger.info("--- Fim do método DAO Buscar por Id ---");

            return vendedor;
        } catch (SQLException e) {
            logger.error("Ocorreu um erro ao tentar buscar: " + e.getMessage());
            return null;
        }
    }
}
