package dev.gustavo.cadastrodecoroinhas.Controller;

import dev.gustavo.cadastrodecoroinhas.Model.PessoaModel;
import dev.gustavo.cadastrodecoroinhas.Service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    //Injeção de dependência
    private final PessoaService pessoaService;
    // Contrutor para inicializar a dependência
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/boasvindaspessoa")
    public String boasVindas(){
        return "Boas vindas pessoa";
    }

    @GetMapping("/getall")
    public List<PessoaModel> listarPessoa(){
        return pessoaService.listarPessoa();
    }

    @GetMapping("/{id}")
    public Optional<PessoaModel> getbyid(@PathVariable Long id){
        return pessoaService.getbyidpessoa(id);
    }

    @PostMapping("/salvar")
    public PessoaModel salvar(@RequestBody PessoaModel pessoa){
        return pessoaService.salvar(pessoa);
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
