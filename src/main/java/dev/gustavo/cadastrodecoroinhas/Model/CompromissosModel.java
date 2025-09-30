package dev.gustavo.cadastrodecoroinhas.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_compromissos")
@NoArgsConstructor // Construtor sem argumentos
@AllArgsConstructor // Construtor com todos os argumentos
@Data // Todos os gets e sets
public class CompromissosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private Date data;

    //Um para muitos
    @OneToMany(mappedBy = "compromisso") // Um comprisso pode ter várias pessoas
    @JsonIgnore
    private List<PessoaModel> participantes;

}
