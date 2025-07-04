package prog2_projeto1.dao;

import java.sql.Connection;
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

    public boolean salvar(Cliente cliente) {
        logger.info("--- Início do método DAO Salvar ---");

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String sql = "INSERT INTO Cliente (nome, cpf, rg, telefone, referencia_comercial, data_nascimento) " +
                         "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getRg());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getReferenciaComercial());
            stmt.setDate(6, java.sql.Date.valueOf(cliente.getDataNascimento()));

            int resultado = stmt.executeUpdate();

            logger.info("Cliente inserido: " + resultado);
            return resultado > 0;

        } catch (Exception e) {
            logger.error("Erro ao salvar cliente: " + e.getMessage());
            return false;
        }
    }

    public boolean alterar(Cliente cliente) {
        logger.info("--- Início do método DAO Alterar ---");

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String sql = "UPDATE Cliente SET nome = ?, cpf = ?, rg = ?, telefone = ?, referencia_comercial = ?, data_nascimento = ? WHERE id = ?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getRg());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getReferenciaComercial());
            stmt.setDate(6, java.sql.Date.valueOf(cliente.getDataNascimento()));
            stmt.setInt(7, cliente.getId());

            int resultado = stmt.executeUpdate();

            logger.info("Cliente atualizado: " + resultado);
            return resultado > 0;

        } catch (Exception e) {
            logger.error("Erro ao alterar cliente: " + e.getMessage());
            return false;
        }
    }

    public boolean excluir(Cliente cliente) {
        logger.info("--- Início do método DAO Excluir ---");

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String sql = "DELETE FROM Cliente WHERE id = ?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cliente.getId());

            int resultado = stmt.executeUpdate();

            logger.info("Cliente excluído: " + resultado);
            return resultado > 0;

        } catch (Exception e) {
            logger.error("Erro ao excluir cliente: " + e.getMessage());
            return false;
        }
    }

    public Cliente buscar(int id) {
        logger.info("--- Início do método DAO Buscar por ID ---");

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String sql = "SELECT * FROM Cliente WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Cliente cliente = mapearCliente(rs);
                logger.info("Cliente encontrado.");
                return cliente;
            }

        } catch (Exception e) {
            logger.error("Erro ao buscar cliente: " + e.getMessage());
        }

        return null;
    }

    public List<Cliente> buscarTodos() {
        logger.info("--- Início do método DAO Buscar Todos ---");

        List<Cliente> lista = new ArrayList<>();

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String sql = "SELECT * FROM Cliente";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                lista.add(mapearCliente(rs));
            }

            logger.info("Total de clientes encontrados: " + lista.size());

        } catch (Exception e) {
            logger.error("Erro ao buscar todos os clientes: " + e.getMessage());
        }

        return lista;
    }

    private Cliente mapearCliente(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();

        cliente.setId(rs.getInt("id"));
        cliente.setNome(rs.getString("nome"));
        cliente.setCpf(rs.getString("cpf"));
        cliente.setRg(rs.getString("rg"));
        cliente.setTelefone(rs.getString("telefone"));
        cliente.setReferenciaComercial(rs.getString("referencia_comercial"));

        java.sql.Date dataSql = rs.getDate("data_nascimento");
        if (dataSql != null) {
            cliente.setDataNascimento(dataSql.toLocalDate());
        }

        return cliente;
    }
}