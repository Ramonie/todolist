package martins.ramonie.todolist.task;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "tb_tasks")
public class TaskModel {
    /**
     * ID
     * USUÁRIO(ID_USUARIO)
     * DESCRIÇÃO
     * TITULO
     * DATA DE INICIO
     * DATA DE TÉRMINO
     * PRIORIDADE
     */
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private  String descricao;
    @Column(length = 50)
    private String titulo;
    private LocalDateTime  startAt;
    private LocalDateTime endAt;
    private String prioridade;
    private  UUID iduser;
    @CreationTimestamp
    private LocalDateTime createdAt;

}
