package martins.ramonie.todolist.task;

import jakarta.servlet.http.HttpServletRequest;
import martins.ramonie.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;
    @PostMapping("/")
    public TaskModel create(@RequestBody TaskModel taskModel, HttpServletRequest request){
        System.out.println("Chegou no controller " + request.getAttribute("idUser"));
        var idUser = request.getAttribute("idUser");
        taskModel.setIduser((UUID) idUser);
        var task = this.taskRepository.save(taskModel);
        return task;

    }
}
