package martins.ramonie.todolist.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/primeira")
// http://localhost:8080/primeiraRota ---
public class Controller {

    /**
     * MÉTODOS DE ACESSO DO HTTP:
     * GET - BUSCAR INFORMAÇÃO
     * POST - ADICIONAR UMA INFORMAÇÃO/DADO
     * PUT - ALTERAR UMA INFORMAÇÃO/DADO
     * DELET - REMOVER UMA INFORMAÇÃO/DADO
     * PATCH - ALTERA SOMENTE UMA PARTE DA INFORMAÇÃO/DADO
     */

    @GetMapping("/")
    //MÉTODO (FUNCIONALIDADE) DE UMA CLASSE
    public String mensagem(){
        return "Funcionou";
    }

}
