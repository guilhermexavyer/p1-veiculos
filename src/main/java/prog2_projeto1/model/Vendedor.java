package prog2_projeto1.model;

public class Vendedor extends PessoaFisica implements IMetodos{

    private double salario;
    private double comissao;
    
    public Vendedor() {
    }

    public Vendedor(double salario, double comissao) {
        this.salario = salario;
        this.comissao = comissao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }


    
}