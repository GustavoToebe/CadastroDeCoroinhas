package dev.gustavo.cadastrodecoroinhas.Mapper;

import dev.gustavo.cadastrodecoroinhas.DTO.PessoaDTO;
import dev.gustavo.cadastrodecoroinhas.Model.PessoaModel;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Component
public class PessoaMapper {

    public PessoaModel map(PessoaDTO pessoaDTO){
        PessoaModel pessoaModel = new PessoaModel();
        pessoaModel.setId(pessoaDTO.getId());
        pessoaModel.setNome(pessoaDTO.getNome());
        pessoaModel.setCpf(pessoaDTO.getCpf());
        pessoaModel.setCidade(pessoaDTO.getCidade());
        pessoaModel.setTempoetapa(pessoaDTO.getTempoetapa());
        pessoaModel.setCompromisso(pessoaDTO.getCompromisso());

        return  pessoaModel;
    }

    public PessoaDTO map(PessoaModel pessoaModel){
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setId(pessoaModel.getId());
        pessoaDTO.setNome(pessoaModel.getNome());
        pessoaDTO.setCpf(pessoaModel.getCpf());
        pessoaDTO.setCidade(pessoaModel.getCidade());
        pessoaDTO.setTempoetapa(pessoaModel.getTempoetapa());
        pessoaDTO.setCompromisso(pessoaModel.getCompromisso());

        return pessoaDTO;

    }
}
