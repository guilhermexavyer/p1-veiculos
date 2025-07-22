package prog2_projeto1.model;

import java.util.List;

public interface IMetodos {

interface Metodos {
    boolean salvar();
    boolean alterar();
    boolean excluir();
    Object buscar();
    List<Object> buscarTodos();
}
}
