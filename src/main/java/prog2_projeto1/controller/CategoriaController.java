package prog2_projeto1.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import prog2_projeto1.dao.CategoriaDAO;
import prog2_projeto1.model.Categoria;


public class CategoriaController {

    CategoriaDAO CategoriaDAO = new CategoriaDAO();
    Logger logger = Logger.getLogger(CategoriaController.class);

    public boolean salvar(Categoria categoria) {
        try {
            if (CategoriaDAO.salvar(categoria)) {
                logger.info("Categoria salvo no controller!");
                return true;
            } else {
                logger.info("Erro ao salvar Categoria no controller!");
                return false;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    public boolean alterar(Categoria categoria) {
        try {
            if (CategoriaDAO.alterar(categoria)) {
                logger.info("Categoria alterado no controller!");
                return true;
            } else {
                logger.info("Erro ao alterar Categoria no controller!");
                return false;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    public boolean excluir(Categoria categoria) {
        try {
            if (CategoriaDAO.excluir(categoria)) {
                logger.info("Categoria excluido no controller!");
                return true;
            } else {
                logger.info("Erro ao excluir Categoria no controller!");
                return false;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    public List<Categoria> buscarTodos() {
        try {
            List<Categoria> categorias = CategoriaDAO.buscarTodos();
            if (categorias != null) {
                logger.info("Categoria salvo no controller!");
                return categorias;
            } else {
                logger.info("Erro ao salvar Categoria no controller!");
                return null;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    public Categoria buscar(int id) {
        try {
            if (CategoriaDAO.buscar(id) != null) {
                logger.info("Categoria encontrado no controller!");
                return CategoriaDAO.buscar(id);
            } else {
                logger.info("Erro ao encontrar Categoria no controller!");
                return null;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

}
