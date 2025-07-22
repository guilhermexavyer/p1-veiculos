package prog2_projeto1.model;

public class Veiculo extends EntidadeBase implements IMetodos{
    
    private int id;
    private String nome;
    private int ano;
    private String modelo;
    private String cor;
    private String placa;
    private boolean unico_dono;
    private Double valor;
    private Categoria categoria;
    
    public Veiculo() {
    
}

    public Veiculo(int id, String nome, int ano, String modelo, String cor, String placa, boolean unico_dono, Double valor, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
        this.unico_dono = unico_dono;
        this.valor= valor;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public boolean isUnico_dono() {
        return unico_dono;
    }

    public void setUnico_dono(boolean unico_dono) {
        this.unico_dono = unico_dono;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}