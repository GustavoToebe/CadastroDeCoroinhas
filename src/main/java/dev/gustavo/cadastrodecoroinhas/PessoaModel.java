package dev.gustavo.cadastrodecoroinhas;

//jakarta.persistence = vem do JPA

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_pessoa")
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer idade;
    private String Cidade;

    @ManyToOne // Uma pessoa tem um unico compromisso
    @JoinColumn(name = "lista_compromisso_id")
    private CompromissosModel compromisso;

    public PessoaModel() {
    }

    public PessoaModel(String nome, Integer idade, String cidade) {
        this.nome = nome;
        this.idade = idade;
        Cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompromissosModel getCompromisso() {
        return compromisso;
    }

    public void setCompromisso(CompromissosModel compromisso) {
        this.compromisso = compromisso;
    }
}
