package pl.sda.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.sda.todolist.dto.ToDoDTO;
import pl.sda.todolist.entity.ToDo;
import pl.sda.todolist.mapper.ToDoDTOMapper;
import pl.sda.todolist.service.ToDoService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ToDoController {

    @Autowired
    private ToDoService todoService;

    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public String todos(Model model) {

        List<ToDo> todos = todoService.getAllToDos();
       List<ToDo> completed = todoService.getAllFinished();

        List<ToDoDTO> dtos = ToDoDTOMapper.mapEntityToDto(todos);
        List<ToDoDTO> completedDtos = ToDoDTOMapper.mapEntityToDto(completed);

        model.addAttribute("todos", dtos);
        model.addAttribute("completed", completedDtos);

        return "todos";
    }

    @RequestMapping(value = "/todos/add", method = RequestMethod.GET)
    public String createQuiz(Model model) {

        model.addAttribute("addTodo", new ToDoDTO());

        return "/createTodo";
    }

    @RequestMapping(value = "/todos/add", method = RequestMethod.POST)
    public String createTodo(@ModelAttribute("Todo") @Validated ToDoDTO toDoDTO, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "/createTodo";
        }


        todoService.save(toDoDTO);


        return "redirect:/todos";
    }





//    @ResponseBody
//    @RequestMapping(value = "/todos/{name}", method = RequestMethod.POST)
//    public ResponseEntity<?> addTodos(@PathVariable("name") String name) {
//
//        Todo todo = todoService.addTodo(name);
//
//        TodoDto dto = TodoMapper.mapEntityToDto(todo);
//
//        return ResponseEntity.ok(dto);
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/todos/{id}", method = RequestMethod.PUT, produces = MediaType.TEXT_PLAIN_VALUE)
//    public String updateComplated(@PathVariable("id") Long id) {
//
//        todoService.completeTodo(id);
//
//        return "200 OK";
//    }


}
