package prog2_projeto1.model;
import java.time.LocalDate;

public class VendaVeiculo extends EntidadeBase implements IMetodos {
    private int id;
    private LocalDate data_venda;
    private double valor_desconto;
    private double valor_final;
    private Veiculo veiculo;
    private Vendedor vendedor;
    private Cliente cliente;
    
    
    public VendaVeiculo() {
    }


    public VendaVeiculo(int id, LocalDate data_venda, double valor_desconto, double valor_final, Veiculo veiculo,
            Vendedor vendedor, Cliente cliente) {
        this.id = id;
        this.data_venda = data_venda;
        this.valor_desconto = valor_desconto;
        this.valor_final = valor_final;
        this.veiculo = veiculo;
        this.vendedor = vendedor;
        this.cliente = cliente;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public LocalDate getData_venda() {
        return data_venda;
    }


    public void setData_venda(LocalDate data_venda) {
        this.data_venda = data_venda;
    }


    public double getValor_desconto() {
        return valor_desconto;
    }


    public void setValor_desconto(double valor_desconto) {
        this.valor_desconto = valor_desconto;
    }


    public double getValor_final() {
        return valor_final;
    }


    public void setValor_final(double valor_final) {
        this.valor_final = valor_final;
    }


    public Veiculo getVeiculo() {
        return veiculo;
    }


    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }


    public Vendedor getVendedor() {
        return vendedor;
    }


    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }


    public Cliente getCliente() {
        return cliente;
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


}