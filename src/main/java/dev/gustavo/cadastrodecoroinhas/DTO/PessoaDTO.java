package dev.gustavo.cadastrodecoroinhas.DTO;

import dev.gustavo.cadastrodecoroinhas.Model.CompromissosModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

    private Long id;
    private String nome;
    private String cpf;
    private Integer idade;
    private String cidade;
    private Integer tempoetapa;
    private CompromissosModel compromisso;


}
