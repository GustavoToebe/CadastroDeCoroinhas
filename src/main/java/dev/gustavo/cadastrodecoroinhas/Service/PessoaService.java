package dev.gustavo.cadastrodecoroinhas.Service;

import dev.gustavo.cadastrodecoroinhas.DTO.PessoaDTO;
import dev.gustavo.cadastrodecoroinhas.Mapper.PessoaMapper;
import dev.gustavo.cadastrodecoroinhas.Model.PessoaModel;
import dev.gustavo.cadastrodecoroinhas.Repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        List<PessoaDTO> pessoaDTOList = new ArrayList<>();

        for (PessoaModel pessoaModel : pessoaModelList ){
            PessoaDTO pessoaDTO = pessoaMapper.map(pessoaModel);
            pessoaDTOList.add(pessoaDTO);
        }

        return pessoaDTOList;
    }

    public Optional<PessoaModel> getbyidpessoa(Long id){
        return pessoaRepository.findById(id);
        //Optional<PessoaModel> optionalPessoaModel = pessoaRepository.findById(id);
        //return optionalPessoaModel.orElse(null);
    }

    public PessoaDTO salvar(PessoaDTO pessoaDTO){
        PessoaModel pessoaModel = pessoaMapper.map(pessoaDTO);
        pessoaModel = pessoaRepository.save(pessoaModel);
        return pessoaMapper.map(pessoaModel);
    }

    public PessoaModel editar(Long id, PessoaModel pessoaModelAtualizado){
        if (pessoaRepository.existsById(id)){
                pessoaModelAtualizado.setId(id);
                return pessoaRepository.save(pessoaModelAtualizado);
        }
        return null;
    }


    public void deletarbyid(Long id){
        pessoaRepository.deleteById(id);
    }

}
