package prog2_projeto1.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import prog2_projeto1.dao.VendedorDAO;
import prog2_projeto1.model.Vendedor;

public class VendedorController {

    VendedorDAO vendedorDAO = new VendedorDAO();
    Logger logger = Logger.getLogger(VendedorController.class);

    public boolean salvar(Vendedor vendedor) {
        try {
            if (vendedorDAO.salvar(vendedor)) {
                logger.info("Vendedor salvo [controller]");
                return true;
            } else {
                logger.info("Erro ao salvar vendedor [controller]");
                return false;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    public boolean alterar(Vendedor vendedor) {
        try {
            if (vendedorDAO.alterar(vendedor)) {
                logger.info("Vendedor alterado [controller]");
                return true;
            } else {
                logger.info("Erro ao alterar vendedor [controller]");
                return false;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    public boolean excluir(Vendedor vendedor) {
        try {
            if (vendedorDAO.excluir(vendedor)) {
                logger.info("Vendedor excluido [controller]");
                return true;
            } else {
                    logger.info("Erro ao excluir vendedor [controller]");
                return false;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    public List<Vendedor> buscarTodos() {
        try {
            List<Vendedor> vendedors = vendedorDAO.buscarTodos();
            if (vendedors != null) {
                logger.info("Vendedor salvo [controller]");
                return vendedors;
            } else {
                logger.info("Erro ao salvar vendedor [controller]");
                return null;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    public Vendedor buscar(int id) {
        try {
            if (vendedorDAO.buscar(id) != null) {
                logger.info("Vendedor encontrado [controller]");
                return vendedorDAO.buscar(id);
            } else {
                logger.info("Erro ao encontrar vendedor [controller]");
                return null;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

}
