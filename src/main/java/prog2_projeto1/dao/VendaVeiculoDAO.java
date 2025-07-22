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
import prog2_projeto1.model.VendaVeiculo;

public class VendaVeiculoDAO {
    Logger logger = Logger.getLogger(VendaVeiculoDAO.class);

    public boolean salvar(VendaVeiculo modelo) throws SQLException {
        logger.info("--- Início do método DAO Salvar ---");

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String insertVendaVeiculo = "INSERT INTO venda_veiculo " +
                    "(data_venda, valor_desconto, valor_final, veiculo_id, vendedor_id, cliente_id) " +
                    "values (?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement1 = connection.prepareStatement(insertVendaVeiculo);
            preparedStatement1.setDate(1, Date.valueOf(modelo.getData_venda()));
            preparedStatement1.setDouble(2, modelo.getValor_desconto());
            preparedStatement1.setDouble(3, modelo.getValor_final());
            preparedStatement1.setInt(4, modelo.getVeiculo().getId());
            preparedStatement1.setInt(5, modelo.getVendedor().getId());
            preparedStatement1.setInt(6, modelo.getCliente().getId());
            logger.info("String insert Venda Veiculo preparada: " + preparedStatement1);
            int resultado = preparedStatement1.executeUpdate();

            if (resultado > 0) {
                logger.info("Inseriu Venda Veiculo: " + resultado);
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

    public boolean alterar(VendaVeiculo modelo) throws SQLException {
        logger.info("--- Início do método DAO Alterar ---");

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String updatePessoa = "update venda_veiculo set data_venda = ?, valor_desconto = ?, valor_final = ?, veiculo_id = ?, vendedor_id = ?, cliente_id = ? where id = ?";

            PreparedStatement preparedStatement1 = connection.prepareStatement(updatePessoa);
            preparedStatement1.setDate(1, Date.valueOf(modelo.getData_venda()));
            preparedStatement1.setDouble(2, modelo.getValor_desconto());
            preparedStatement1.setDouble(3, modelo.getValor_final());
            preparedStatement1.setInt(4, modelo.getVeiculo().getId());
            preparedStatement1.setInt(5, modelo.getVendedor().getId());
            preparedStatement1.setInt(6, modelo.getCliente().getId());
            preparedStatement1.setInt(7, modelo.getId());

            logger.info("String update veículo preparada: " + preparedStatement1);
            int resultadoVendaVeiculo = preparedStatement1.executeUpdate();

            if (resultadoVendaVeiculo > 0) {
                logger.info("Retorno maior que zero: " + resultadoVendaVeiculo);
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

    public boolean excluir(VendaVeiculo modelo) throws SQLException {
        logger.info("--- Início do método DAO Excluir ---");

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String insertPessoa = "delete from venda_veiculo where id = ?";
            PreparedStatement preparedStatement1 = connection.prepareStatement(insertPessoa);
            preparedStatement1.setInt(1, modelo.getId());
            logger.info("String delete veículo preparada: " + preparedStatement1);
            int resultadoVendaVeiculo = preparedStatement1.executeUpdate();

            if (resultadoVendaVeiculo > 0) {
                logger.info("Retorno maior que zero " + resultadoVendaVeiculo);
                logger.info("--- Fim do método DAO Excluir ---");
                return true;
            } else {
                logger.info("Retorno menor que zero " + resultadoVendaVeiculo);
                logger.info("--- Fim do método DAO Excluir ---");
                return false;

            }
        } catch (Exception e) {
            logger.error("Ocorreu um erro ao tentar excluir: " + e.getMessage());
            logger.error("--- Fim do método DAO Excluir ---");
            return false;
        }
    }

    public boolean buscar(VendaVeiculo modelo) throws SQLException {

        return false;
    }

    public List<VendaVeiculo> buscarTodos() throws SQLException {
        try {
            logger.info("--- Início do método DAO Buscar Todos ---");

            Connection connection = DBConnection.getInstance().getConnection();

            String consulta = "select * from venda_veiculo";
            List<VendaVeiculo> lista = new ArrayList<VendaVeiculo>();
            VendaVeiculo vendaVeiculo;

            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            ResultSet resultSet = preparedStatement.executeQuery();
            logger.info("Consulta executada: " + preparedStatement);

            while (resultSet.next()) {
                vendaVeiculo = new VendaVeiculo();
                vendaVeiculo.setId(resultSet.getInt("id"));
                vendaVeiculo.setData_venda(resultSet.getDate("data_venda").toLocalDate());
                vendaVeiculo.setValor_desconto(resultSet.getDouble("valor_desconto"));
                vendaVeiculo.setValor_final(resultSet.getDouble("valor_final"));
                vendaVeiculo.setVeiculo(new VeiculoDAO().buscar(resultSet.getInt("veiculo_id")));
                vendaVeiculo.setVendedor(new VendedorDAO().buscar(resultSet.getInt("vendedor_id")));
                vendaVeiculo.setCliente(new ClienteDAO().buscar(resultSet.getInt("cliente_id")));
                lista.add(vendaVeiculo);
            }

            logger.info("Quantidade de registros pesquisados: " + lista.size());
            logger.info("--- Fim do método DAO Buscar Todos ---");

            return lista;
        } catch (SQLException e) {
            logger.error("Ocorreu um erro ao tentar buscar todos: " + e.getMessage());
            return null;
        }
    }

    public VendaVeiculo buscar(int id) throws SQLException {
        try {
            logger.info("--- Início do método DAO Buscar por Id ---");

            Connection connection = DBConnection.getInstance().getConnection();

            String consulta = "select * from venda_veiculo where id = ?";
            VendaVeiculo vendaVeiculo = new VendaVeiculo();

            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            logger.info("Consulta executada: " + preparedStatement);

            while (resultSet.next()) {
                vendaVeiculo = new VendaVeiculo();
                vendaVeiculo.setId(resultSet.getInt("id"));
                vendaVeiculo.setData_venda(resultSet.getDate("data_venda").toLocalDate());
                vendaVeiculo.setValor_desconto(resultSet.getDouble("valor_desconto"));
                vendaVeiculo.setValor_final(resultSet.getDouble("valor_final"));
                vendaVeiculo.setVeiculo(new VeiculoDAO().buscar(resultSet.getInt("veiculo_id")));
                vendaVeiculo.setVendedor(new VendedorDAO().buscar(resultSet.getInt("vendedor_id")));
                vendaVeiculo.setCliente(new ClienteDAO().buscar(resultSet.getInt("cliente_id")));
            }

            logger.info("--- Fim do método DAO Buscar por Id ---");

            return vendaVeiculo;
        } catch (SQLException e) {
            logger.error("Ocorreu um erro ao tentar buscar: " + e.getMessage());
            return null;
        }
    }
    public List<VendaVeiculo> buscarPorPeriodo(java.sql.Date dataInicio, java.sql.Date dataFim) throws SQLException {
    logger.info("--- Início do método DAO Buscar por Período ---");
    List<VendaVeiculo> lista = new ArrayList<>();
    try {
        Connection connection = DBConnection.getInstance().getConnection();
        String consulta = "SELECT * FROM venda_veiculo WHERE data_venda BETWEEN ? AND ?";
        PreparedStatement preparedStatement = connection.prepareStatement(consulta);
        preparedStatement.setDate(1, dataInicio);
        preparedStatement.setDate(2, dataFim);
        ResultSet resultSet = preparedStatement.executeQuery();
        logger.info("Consulta executada: " + preparedStatement);

        while (resultSet.next()) {
            VendaVeiculo vendaVeiculo = new VendaVeiculo();
            vendaVeiculo.setId(resultSet.getInt("id"));
            vendaVeiculo.setData_venda(resultSet.getDate("data_venda").toLocalDate());
            vendaVeiculo.setValor_desconto(resultSet.getDouble("valor_desconto"));
            vendaVeiculo.setValor_final(resultSet.getDouble("valor_final"));
            vendaVeiculo.setVeiculo(new VeiculoDAO().buscar(resultSet.getInt("veiculo_id")));
            vendaVeiculo.setVendedor(new VendedorDAO().buscar(resultSet.getInt("vendedor_id")));
            vendaVeiculo.setCliente(new ClienteDAO().buscar(resultSet.getInt("cliente_id")));
            lista.add(vendaVeiculo);
        }
    } catch (SQLException e) {
        logger.error("Ocorreu um erro ao tentar buscar por período: " + e.getMessage());
        return null;
    }
    logger.info("--- Fim do método DAO Buscar por Período ---");
    return lista;
}
}
