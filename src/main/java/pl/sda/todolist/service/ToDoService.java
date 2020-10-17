package pl.sda.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.todolist.dto.ToDoDTO;
import pl.sda.todolist.entity.ToDo;
import pl.sda.todolist.mapper.ToDoDTOMapper;
import pl.sda.todolist.repo.ToDoRepository;

import java.text.ParseException;
import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public void save(ToDoDTO toDoDTO){

        ToDo toDo = ToDoDTOMapper.mapDTOToEntity(toDoDTO);
        toDoRepository.save(toDo);
    }


    public ToDo addNewToDo(String name) {
        ToDo todo = new ToDo(name, false);
        return toDoRepository.save(todo);
    }

//    public List<ToDo> getAllToDos(){
//       return toDoRepository.getAll();
//    }

    public List<ToDo> getAllFinished(){
        return toDoRepository.getAllByFinished(true);
    }

    public List<ToDo> getAllToDos(){
        return toDoRepository.getAllByFinished(false);
    }
    public void finishToDo(Long id) {
        ToDo todo = toDoRepository.getById(id);

        if (todo != null) {
            todo.setFinished(true);
            toDoRepository.save(todo);
        }
        //TODO what if user sent bad id? Is this return correct?
        return;

    }
}
