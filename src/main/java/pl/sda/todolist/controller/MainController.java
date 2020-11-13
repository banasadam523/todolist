package pl.sda.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.sda.todolist.dto.ToDoDTO;
import pl.sda.todolist.entity.ToDo;
import pl.sda.todolist.mapper.ToDoDTOMapper;
import pl.sda.todolist.service.ToDoService;
import pl.sda.todolist.service.UserService;

import java.util.Date;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private ToDoService todoService;


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home(Model model) {


        List<ToDo> todos = todoService.getAllToDos();
        List<ToDo> completed = todoService.getAllFinished();

        List<ToDoDTO> dtos = ToDoDTOMapper.mapEntityToDto(todos);
        List<ToDoDTO> completedDtos = ToDoDTOMapper.mapEntityToDto(completed);

        model.addAttribute("todos", dtos);
        model.addAttribute("completed", completedDtos);
        return "index";
    }


    @PostMapping("/")
    public String completeTodo(@RequestParam("id") Long id){


        //ustawia status jako zakończony

        todoService.finishToDo(id);

        return "redirect:/";
    }
    @RequestMapping(value = "/todos/add", method = RequestMethod.POST)
    public String createTodo(@ModelAttribute("Todo") @Validated ToDoDTO toDoDTO,
                             BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "/createTodo";
        }

        //toDoDTO.setTodoUserEmail(userService.getLoggedInUserEmail());
        toDoDTO.setStartDate(new Date());
        todoService.save(toDoDTO);


        return "redirect:/";
    }
}
