package pl.sda.todolist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.todolist.entity.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo,Long> {
}
