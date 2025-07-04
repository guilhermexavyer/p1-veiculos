package prog2_projeto1.controller;

import java.util.List;

import org.apache.log4j.Logger;

import prog2_projeto1.dao.ClienteDAO;
import prog2_projeto1.model.Cliente;

public class ClienteController {

    ClienteDAO clienteDAO = new ClienteDAO();
    Logger logger = Logger.getLogger(ClienteController.class);

    public boolean salvar(Cliente cliente) {
        try {
            if (clienteDAO.salvar(cliente)) {
                logger.info("Cliente salvo no controller!");
                return true;
            } else {
                logger.info("Erro ao salvar cliente no controller!");
                return false;
            }
        } catch (Exception e) {
            logger.error("Erro no salvar do controller: " + e.getMessage());
            return false;
        }
    }

    public boolean alterar(Cliente cliente) {
        try {
            if (clienteDAO.alterar(cliente)) {
                logger.info("Cliente alterado no controller!");
                return true;
            } else {
                logger.info("Erro ao alterar cliente no controller!");
                return false;
            }
        } catch (Exception e) {
            logger.error("Erro no alterar do controller: " + e.getMessage());
            return false;
        }
    }

    public boolean excluir(Cliente cliente) {
        try {
            if (clienteDAO.excluir(cliente)) {
                logger.info("Cliente excluído no controller!");
                return true;
            } else {
                logger.info("Erro ao excluir cliente no controller!");
                return false;
            }
        } catch (Exception e) {
            logger.error("Erro no excluir do controller: " + e.getMessage());
            return false;
        }
    }

    public List<Cliente> buscarTodos() {
        try {
            List<Cliente> clientes = clienteDAO.buscarTodos();
            if (clientes != null) {
                logger.info("Clientes encontrados no controller!");
                return clientes;
            } else {
                logger.info("Nenhum cliente encontrado no controller!");
                return null;
            }
        } catch (Exception e) {
            logger.error("Erro no buscarTodos do controller: " + e.getMessage());
            return null;
        }
    }

    public Cliente buscar(int id) {
        try {
            Cliente cliente = clienteDAO.buscar(id);
            if (cliente != null) {
                logger.info("Cliente encontrado no controller!");
                return cliente;
            } else {
                logger.info("Cliente não encontrado no controller!");
                return null;
            }
        } catch (Exception e) {
            logger.error("Erro no buscar por ID do controller: " + e.getMessage());
            return null;
        }
    }
}
