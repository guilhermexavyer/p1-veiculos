package prog2_projeto1.model;

public class Categoria extends EntidadeBase implements IMetodos {
    private int id;
    private String descricao;

    public Categoria(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    

    @Override
    public String toString() {
        return descricao;
    }


    public Categoria() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }  
}
