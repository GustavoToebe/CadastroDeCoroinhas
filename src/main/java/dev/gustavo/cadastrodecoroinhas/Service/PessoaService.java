package dev.gustavo.cadastrodecoroinhas.Service;

import dev.gustavo.cadastrodecoroinhas.DTO.PessoaDTO;
import dev.gustavo.cadastrodecoroinhas.Mapper.PessoaMapper;
import dev.gustavo.cadastrodecoroinhas.Model.PessoaModel;
import dev.gustavo.cadastrodecoroinhas.Repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper;

    public PessoaService(PessoaRepository pessoaRepository, PessoaMapper pessoaMapper) {
        this.pessoaRepository = pessoaRepository;
        this.pessoaMapper = pessoaMapper;
    }

    public List<PessoaDTO> listarPessoa(){
        List<PessoaModel> pessoaModelList =  pessoaRepository.findAll();
        return pessoaModelList.stream().map(pessoaMapper::map).collect(Collectors.toList());
    }

    public PessoaDTO getbyidpessoa(Long id){
        Optional<PessoaModel> pessoaporid = pessoaRepository.findById(id);
        return pessoaporid.map(pessoaMapper::map).orElse(null);
    }

    public PessoaDTO salvar(PessoaDTO pessoaDTO){
        PessoaModel pessoaModel = pessoaMapper.map(pessoaDTO);
        pessoaModel = pessoaRepository.save(pessoaModel);
        return pessoaMapper.map(pessoaModel);
    }

    public PessoaDTO editar(Long id, PessoaDTO pessoaDTO){
        Optional<PessoaModel> pessoaExistente = pessoaRepository.findById(id);
        if (pessoaExistente.isPresent()){
            PessoaModel pessoaModelAtualizada = pessoaMapper.map(pessoaDTO);
            pessoaModelAtualizada.setId(pessoaDTO.getId());
            PessoaModel pessoaModel = pessoaRepository.save(pessoaModelAtualizada);
            return pessoaMapper.map(pessoaModel);
        }

        return null;
    }


    public void deletarbyid(Long id){
        pessoaRepository.deleteById(id);
    }

}
