package prog2_projeto1.model;
import java.sql.Date;

public class Cliente extends PessoaFisica implements IMetodos {

    private String referencia_comercial;
    private Date data_nascimento;
    
    public Cliente() {
    }

    public Cliente(String referencia_comercial, Date data_nascimento) {
        this.referencia_comercial = referencia_comercial;
        this.data_nascimento = data_nascimento;
    }

    public String getReferencia_comercial() {
        return referencia_comercial;
    }

    public void setReferencia_comercial(String referencia_comercial) {
        this.referencia_comercial = referencia_comercial;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
  
}