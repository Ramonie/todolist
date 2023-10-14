package martins.ramonie.todolist.task;

import jakarta.servlet.http.HttpServletRequest;
import martins.ramonie.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;
    @PostMapping("/")
    public ResponseEntity create(@RequestBody TaskModel taskModel, HttpServletRequest request){
        var idUser = request.getAttribute("idUser");
        taskModel.setIduser((UUID) idUser);
        var currentDate = LocalDateTime.now();
        if( currentDate.isAfter(taskModel.getStartAt())|| currentDate.isAfter(taskModel.getEndAt()) ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A data de inicio / data de término deve ser maior que a atual");

        }
        if( taskModel.getStartAt().isAfter(taskModel.getEndAt()  )){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A data de inicio / data de ininio deve ser menor que a de termino");

        }
        var task = this.taskRepository.save(taskModel);
        return ResponseEntity.status(HttpStatus.OK).body(task);

    }


    @GetMapping("/")
    public List<TaskModel> list(HttpServletRequest request){
        var idUser = request.getAttribute("idUser");
        var tasks = this.taskRepository.findByIduser((UUID) idUser);
        return tasks;


    }
    //http://localhost:8080/tasks/id
    @PutMapping("/{id}")
    public TaskModel update(@RequestBody TaskModel taskModel, HttpServletRequest request, @PathVariable UUID id){
        var idUser = request.getAttribute("idUser");
        System.out.println(idUser);
        taskModel.setIduser((UUID) idUser);
        taskModel.setId(id);
        return this.taskRepository.save(taskModel);
    }

}
