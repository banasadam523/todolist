package pl.sda.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.todolist.dto.ToDoDTO;

@Controller
public class ToDoController {

    @GetMapping("/main")
    public String main(Model model){
        ToDo Todo
    }


}
