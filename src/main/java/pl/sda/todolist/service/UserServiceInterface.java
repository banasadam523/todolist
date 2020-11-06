package pl.sda.todolist.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.sda.todolist.dto.UserRegistrationDto;
import pl.sda.todolist.entity.User;

public interface UserServiceInterface extends UserDetailsService {
    User save(UserRegistrationDto userRegistrationDto);
}
