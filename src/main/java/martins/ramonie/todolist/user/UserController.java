package martins.ramonie.todolist.user;


import martins.ramonie.todolist.model.UserModel;
import org.springframework.web.bind.annotation.*;

/**
 * MODIFICADOR
 * PUBLIC
 * PRIVATE
 * PROTECTED
*/
@RestController
@RequestMapping("/users")
public class UserController {
    private UserModel userModel;

    /**
     * MÉTODOS DE ACESSO DO HTTP:
     * GET - BUSCAR INFORMAÇÃO
     * POST - ADICIONAR UMA INFORMAÇÃO/DADO
     * PUT - ALTERAR UMA INFORMAÇÃO/DADO
     * DELET - REMOVER UMA INFORMAÇÃO/DADO
     * PATCH - ALTERA SOMENTE UMA PARTE DA INFORMAÇÃO/DADO
     */
@PostMapping("/")
    public void create(@RequestBody UserModel userModel){
    System.out.println(userModel.getUsername());

    }



}
