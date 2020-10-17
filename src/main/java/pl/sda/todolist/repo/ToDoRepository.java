package pl.sda.todolist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.todolist.entity.ToDo;

import java.util.List;

//? CZY POTRZEBA?
@Repository
public interface ToDoRepository extends JpaRepository<ToDo,Long> {
    ToDo getById(long id);
    List<ToDo> getAll();
    List<ToDo> getAllByFinished(boolean finished);


}
