package pl.sda.todolist.mapper;

import pl.sda.todolist.dto.ToDoDTO;
import pl.sda.todolist.entity.ToDo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ToDoDTOMapper {
    public static ToDo mapDTOToEntity(ToDoDTO dto) {

        ToDo toDo = new ToDo();
        toDo.setId(dto.getId());
        toDo.setName(dto.getName());
        toDo.setDescription(dto.getDescription());
        toDo.setStartDate(dto.getStartDate());
        toDo.setFinishDate(dto.getFinishDate());
        toDo.isFinished(dto.isStatus());

        return toDo;

    }

    public static ToDoDTO mapEntityToDto(ToDo entity) {

        ToDoDTO dto = new ToDoDTO(entity.getName());
        dto.setId(entity.getId());

       // DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        dto.setStartDate(entity.getStartDate());
        dto.setFinishDate(entity.getFinishDate());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.isFinished());
        return dto;
    }

    public static List<ToDoDTO> mapEntityToDto(List<ToDo> entities) {

        List<ToDoDTO> dtos = new ArrayList<>();

        for (ToDo todo : entities) {
            dtos.add(mapEntityToDto(todo));
        }

        return dtos;
    }
}
