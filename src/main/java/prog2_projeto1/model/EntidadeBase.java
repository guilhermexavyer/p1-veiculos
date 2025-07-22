package prog2_projeto1.model;

import java.util.Date;

public abstract class EntidadeBase{
    private int id;
    private Date data_cadastro;

    public EntidadeBase() {
    }

    public EntidadeBase(int id, Date data_cadastro) {
        this.id = id;
        this.data_cadastro = data_cadastro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }
    
    public boolean validaId() {
        return true;
    }

    public boolean validaData() {
        return true;
    }

}
