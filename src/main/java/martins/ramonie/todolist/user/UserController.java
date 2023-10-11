package martins.ramonie.todolist.user;


import martins.ramonie.todolist.model.UserModel;
import martins.ramonie.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private UserRepository userRepository;

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
    public UserModel create(@RequestBody UserModel userModel){
    var userCreated = this.userRepository.save(userModel);
    return userCreated;
    }



}
