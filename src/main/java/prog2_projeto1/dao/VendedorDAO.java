package prog2_projeto1.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import prog2_projeto1.DBConnection;
import prog2_projeto1.model.Vendedor;

public class VendedorDAO {
    Logger logger = Logger.getLogger(VendedorDAO.class);

    public boolean salvar(Vendedor v) {
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            String sql = "INSERT INTO Vendedor (nome, cpf, salario, telefone) VALUES (?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, v.getNome());
            stmt.setString(2, v.getCpf());
            stmt.setString(3, v.getSalario());
            stmt.setString(4, v.getTelefone());

            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            logger.error("Erro ao salvar vendedor: " + e.getMessage());
            return false;
        }
    }

    public boolean alterar(Vendedor v) {
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            String sql = "UPDATE Vendedor SET nome = ?, cpf = ?, salario = ?, telefone = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, v.getNome());
            stmt.setString(2, v.getCpf());
            stmt.setString(3, v.getSalario());
            stmt.setString(4, v.getTelefone());
            stmt.setInt(5, v.getId());

            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            logger.error("Erro ao alterar vendedor: " + e.getMessage());
            return false;
        }
    }

    public boolean excluir(Vendedor v) {
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            String sql = "DELETE FROM Vendedor WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, v.getId());

            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            logger.error("Erro ao excluir vendedor: " + e.getMessage());
            return false;
        }
    }

    public List<Vendedor> buscarTodos() {
        List<Vendedor> lista = new ArrayList<>();

        try {
            Connection conn = DBConnection.getInstance().getConnection();
            String sql = "SELECT * FROM Vendedor";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Vendedor v = new Vendedor();
                v.setId(rs.getInt("id"));
                v.setNome(rs.getString("nome"));
                v.setCpf(rs.getString("cpf"));
                v.setSalario(rs.getString("salario"));
                v.setTelefone(rs.getString("telefone"));
                lista.add(v);
            }

        } catch (Exception e) {
            logger.error("Erro ao buscar todos os vendedores: " + e.getMessage());
        }

        return lista;
    }

    public Vendedor buscar(int id) {
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            String sql = "SELECT * FROM Vendedor WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Vendedor v = new Vendedor();
                v.setId(rs.getInt("id"));
                v.setNome(rs.getString("nome"));
                v.setCpf(rs.getString("cpf"));
                v.setSalario(rs.getString("salario"));
                v.setTelefone(rs.getString("telefone"));
                return v;
            }

        } catch (Exception e) {
            logger.error("Erro ao buscar vendedor: " + e.getMessage());
        }

        return null;
    }
}