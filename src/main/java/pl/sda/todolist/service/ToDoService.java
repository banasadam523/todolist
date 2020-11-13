package pl.sda.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.sda.todolist.dto.ToDoDTO;
import pl.sda.todolist.entity.ToDo;
import pl.sda.todolist.entity.User;
import pl.sda.todolist.mapper.ToDoDTOMapper;
import pl.sda.todolist.repo.ToDoRepository;
import pl.sda.todolist.repo.UserRepository;
import java.util.Date;
import java.util.List;


@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    private UserRepository userRepository;

    public void save(ToDoDTO toDoDTO){
        ToDo toDo;
        toDo = ToDoDTOMapper.mapDTOToEntity(toDoDTO);
        toDo.setUser(getCurrentUser());
        toDoRepository.save(toDo);
    }



    public List<ToDo> getAllFinished(){

        return toDoRepository.getAllByFinishedAndUserId(true, getCurrentUser().getId());
    }

    public List<ToDo> getAllToDos(){

        return toDoRepository.getAllByFinishedAndUserId(false, getCurrentUser().getId());
    }

    public void finishToDo(Long id) {
        ToDo todo = toDoRepository.getById(id);

        if (todo != null) {
            todo.setFinished(true);
            todo.setFinishDate(new Date());
            toDoRepository.save(todo);
        }
        return;

    }

    private User getCurrentUser() {
        return userRepository.findByEmail(getCurrentUserEmail());
    }


  public String getCurrentUserEmail() {
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      if (!(authentication instanceof AnonymousAuthenticationToken)) {
          // In SpringSecurityContext 'UserName' is an unique email given by user during registration
          String currentUserName = authentication.getName();
          return currentUserName;
      }
      return "";


  }

}
