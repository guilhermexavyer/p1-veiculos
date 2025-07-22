package prog2_projeto1.controller;

import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import prog2_projeto1.dao.ClienteDAO;
import prog2_projeto1.model.Cliente;


public class ClienteController {

    ClienteDAO ClienteDAO = new ClienteDAO();
    Logger logger = Logger.getLogger(ClienteController.class);

    public boolean salvar(Cliente cliente) {
        try {
            if (ClienteDAO.salvar(cliente)) {
                logger.info("Cliente salvo no controller!");
                return true;
            } else {
                logger.info("Erro ao salvar Cliente no controller!");
                return false;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    public boolean alterar(Cliente cliente) {
        try {
            if (ClienteDAO.alterar(cliente)) {
                logger.info("Cliente alterado no controller!");
                return true;
            } else {
                logger.info("Erro ao alterar Cliente no controller!");
                return false;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    public boolean excluir(Cliente cliente) {
        try {
            if (ClienteDAO.excluir(cliente)) {
                logger.info("Cliente excluido no controller!");
                return true;
            } else {
                logger.info("Erro ao excluir Cliente no controller!");
                return false;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    public List<Cliente> buscarTodos() {
        try {
            List<Cliente> clientes = ClienteDAO.buscarTodos();
            if (clientes != null) {
                logger.info("Cliente salvo no controller!");
                return clientes;
            } else {
                logger.info("Erro ao salvar Cliente no controller!");
                return null;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    public Cliente buscar(int id) {
        try {
            if (ClienteDAO.buscar(id) != null) {
                logger.info("Cliente encontrado no controller!");
                return ClienteDAO.buscar(id);
            } else {
                logger.info("Erro ao encontrar Cliente no controller!");
                return null;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return null;
        }
    }
}
