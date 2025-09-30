package dev.gustavo.cadastrodecoroinhas.Service;

import dev.gustavo.cadastrodecoroinhas.Model.PessoaModel;
import dev.gustavo.cadastrodecoroinhas.Repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<PessoaModel> listarPessoa(){
        return pessoaRepository.findAll();
    }

    public Optional<PessoaModel> getbyidpessoa(Long id){
        return pessoaRepository.findById(id);
        //Optional<PessoaModel> optionalPessoaModel = pessoaRepository.findById(id);
        //return optionalPessoaModel.orElse(null);
    }

    public PessoaModel salvar(PessoaModel pessoaModel){
        return pessoaRepository.save(pessoaModel);
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
