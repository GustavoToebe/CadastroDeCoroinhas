package dev.gustavo.cadastrodecoroinhas.Controller;

import dev.gustavo.cadastrodecoroinhas.DTO.PessoaDTO;
import dev.gustavo.cadastrodecoroinhas.Mapper.PessoaMapper;
import dev.gustavo.cadastrodecoroinhas.Model.PessoaModel;
import dev.gustavo.cadastrodecoroinhas.Repository.PessoaRepository;
import dev.gustavo.cadastrodecoroinhas.Service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    //Injeção de dependência
    private final PessoaService pessoaService;
    private final PessoaMapper pessoaMapper;
    private final PessoaRepository pessoaRepository;

    // Contrutor para inicializar a dependência
    public PessoaController(PessoaService pessoaService, PessoaMapper pessoaMapper, PessoaRepository pessoaRepository) {
        this.pessoaService = pessoaService;
        this.pessoaMapper = pessoaMapper;
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping("/boasvindaspessoa")
    public String boasVindas(){
        return "Boas vindas pessoa";
    }

    @GetMapping("/getall")
    public List<PessoaDTO> listarPessoa(){
        return pessoaService.listarPessoa();
    }

    @GetMapping("/{id}")
    public Optional<PessoaModel> getbyid(@PathVariable Long id){
        return pessoaService.getbyidpessoa(id);
    }

    @PostMapping("/salvar")
    public PessoaDTO salvar(@RequestBody PessoaDTO pessoaDTO){
        return  pessoaService.salvar(pessoaDTO);
    }

    @PutMapping("/editar")
    public PessoaModel editar(@PathVariable Long id, @RequestBody PessoaModel pessoaModel){
        return pessoaService.editar(id, pessoaModel);
    }



    @DeleteMapping("/{id}")
    public String deletarbyid(@PathVariable Long id ){
        pessoaService.deletarbyid(id);
        return "Pessoa deletada com sucesso";

    }

}
