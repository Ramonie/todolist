package martins.ramonie.todolist.user;


import at.favre.lib.crypto.bcrypt.BCrypt;
import martins.ramonie.todolist.model.UserModel;
import martins.ramonie.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity create(@RequestBody UserModel userModel){
    var user = this.userRepository.findByUsername(userModel.getUsername());
    if (user != null){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");
    }
    var passwordHashred = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());
    userModel.setPassword(passwordHashred);
    var userCreated = this.userRepository.save(userModel);
    return ResponseEntity.status(HttpStatus.OK).body(userCreated);
    }



}
