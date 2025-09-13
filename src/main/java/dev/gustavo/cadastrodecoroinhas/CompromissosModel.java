package dev.gustavo.cadastrodecoroinhas;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_compromissos")
public class CompromissosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private Date data;

    @OneToMany(mappedBy = "compromisso") // Um comprisso pode ter várias pessoas
    private List<PessoaModel> pessoaModel;

    public CompromissosModel() {
    }

    public CompromissosModel(Long id, String titulo, Date data) {
        this.id = id;
        this.titulo = titulo;
        this.data = data;
    }

    public List<PessoaModel> getPessoaModel() {
        return pessoaModel;
    }

    public void setPessoaModel(List<PessoaModel> pessoaModel) {
        this.pessoaModel = pessoaModel;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
