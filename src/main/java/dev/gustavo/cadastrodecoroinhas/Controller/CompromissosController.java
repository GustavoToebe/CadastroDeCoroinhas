package dev.gustavo.cadastrodecoroinhas.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compromissos")
public class CompromissosController {

    @GetMapping("/boasvindascompromissos")
    public String boasVindas(){
        return "Boas vindas compromissos";
    }

    @PostMapping("/adicionar")
    public String pessoaCriada(){
        return "pessoa criada";
    }

}
