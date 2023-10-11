package martins.ramonie.todolist.repository;

import martins.ramonie.todolist.task.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository  extends JpaRepository <TaskModel, UUID>{
}
