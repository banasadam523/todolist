package pl.sda.todolist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.todolist.entity.ToDo;
import pl.sda.todolist.entity.User;

import java.util.List;


@Repository
public interface ToDoRepository extends JpaRepository<ToDo,Long> {
    ToDo getById(long id);
    List<ToDo> getAllByFinishedAndUserId(boolean finished, Long Id);


}
