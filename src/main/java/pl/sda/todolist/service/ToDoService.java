package pl.sda.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.todolist.dto.ToDoDTO;
import pl.sda.todolist.entity.ToDo;
import pl.sda.todolist.repo.ToDoRepository;

import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;


    public void addToDo(ToDo toDo){
        toDoRepository.save(toDo);
    }

    public List<ToDoDTO> getAllToDos(){

    }
}
