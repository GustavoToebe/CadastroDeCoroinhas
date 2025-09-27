package dev.gustavo.cadastrodecoroinhas.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class PessoaController {

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Boas vindas";
    }

}
