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
import pl.sda.todolist.entity.User;
import pl.sda.todolist.mapper.ToDoDTOMapper;
import pl.sda.todolist.service.ToDoService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ToDoController {

    @Autowired
    private ToDoService todoService;


    @RequestMapping(value = "/todos/add", method = RequestMethod.GET)
    public String createTodo(Model model) {

        model.addAttribute("addTodo", new ToDoDTO());

        return "/createTodo";
    }




}
