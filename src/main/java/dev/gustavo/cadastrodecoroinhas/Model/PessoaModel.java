package dev.gustavo.cadastrodecoroinhas.Model;

//jakarta.persistence = vem do JPA

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_pessoa")
@NoArgsConstructor // Construtor sem argumentos
@AllArgsConstructor // Construtor com todos os argumentos
@Data // Todos os gets e sets
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String cpf;
    private Integer idade;
    private String cidade;
    private Integer tempoetapa;

    //Muitos para um
    @ManyToOne  // Uma pessoa tem um unico compromisso
    @JoinColumn(name = "compromisso_id") //FK do comprimisso
    private CompromissosModel compromisso;

}
