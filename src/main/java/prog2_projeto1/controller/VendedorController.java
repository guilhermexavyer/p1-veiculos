package prog2_projeto1.controller;

import java.util.List;

import org.apache.log4j.Logger;

import prog2_projeto1.dao.VendedorDAO;
import prog2_projeto1.model.Vendedor;

public class VendedorController {

    VendedorDAO dao = new VendedorDAO();
    Logger logger = Logger.getLogger(VendedorController.class);

    public boolean salvar(Vendedor v) {
        return dao.salvar(v);
    }

    public boolean alterar(Vendedor v) {
        return dao.alterar(v);
    }

    public boolean excluir(Vendedor v) {
        return dao.excluir(v);
    }

    public List<Vendedor> buscarTodos() {
        return dao.buscarTodos();
    }

    public Vendedor buscar(int id) {
        return dao.buscar(id);
    }
}