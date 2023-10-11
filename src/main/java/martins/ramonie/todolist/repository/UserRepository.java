package martins.ramonie.todolist.repository;

import martins.ramonie.todolist.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository  extends JpaRepository<UserModel, UUID> {
}
