package prog2_projeto1.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import prog2_projeto1.dao.VendaVeiculoDAO;
import prog2_projeto1.model.VendaVeiculo;

public class VendaVeiculoController {

    VendaVeiculoDAO vendaVeiculoDAO = new VendaVeiculoDAO();
    Logger logger = Logger.getLogger(VendaVeiculoController.class);

    public boolean salvar(VendaVeiculo vendaVeiculo) {
        try {
            if (vendaVeiculoDAO.salvar(vendaVeiculo)) {
                logger.info("Venda Veiculo salvo [controller]");
                return true;
            } else {
                logger.info("Erro ao salvar veículo [controller]");
                return false;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    public boolean alterar(VendaVeiculo vendaVeiculo) {
        try {
            if (vendaVeiculoDAO.alterar(vendaVeiculo)) {
                logger.info("Venda Veiculo alterado [controller]");
                return true;
            } else {
                logger.info("Erro ao alterar veículo [controller]");
                return false;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    public boolean excluir(VendaVeiculo vendaVeiculo) {
        try {
            if (vendaVeiculoDAO.excluir(vendaVeiculo)) {
                logger.info("Venda Veiculo excluido [controller]");
                return true;
            } else {
                logger.info("Erro ao excluir veículo [controller]");
                return false;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    public List<VendaVeiculo> buscarTodos() {
        try {
            List<VendaVeiculo> vendaVeiculos = vendaVeiculoDAO.buscarTodos();
            if (vendaVeiculos != null) {
                logger.info("Venda Veiculo salvo [controller]");
                return vendaVeiculos;
            } else {
                logger.info("Erro ao salvar veículo [controller]");
                return null;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    public VendaVeiculo buscar(int id) {
        try {
            if (vendaVeiculoDAO.buscar(id) != null) {
                logger.info("Venda Veiculo encontrado [controller]");
                return vendaVeiculoDAO.buscar(id);
            } else {
                logger.info("Erro ao encontrar veículo [controller]");
                return null;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return null;
        }
    }
public List<VendaVeiculo> buscarPorPeriodo(Date dataInicio, Date dataFim) {
    try {
        return vendaVeiculoDAO.buscarPorPeriodo(dataInicio, dataFim);
    } catch (SQLException e) {
        logger.error(e.getMessage());
        return null;
    }
}
}
