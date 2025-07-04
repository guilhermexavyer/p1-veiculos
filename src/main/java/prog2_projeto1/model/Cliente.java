package prog2_projeto1.model;

import java.time.LocalDate;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String rg;
    private String telefone;
    private String referenciaComercial;
    private LocalDate dataNascimento;

    // Getters e setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getRg() { return rg; }
    public void setRg(String rg) { this.rg = rg; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getReferenciaComercial() { return referenciaComercial; }
    public void setReferenciaComercial(String referenciaComercial) { this.referenciaComercial = referenciaComercial; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
}
