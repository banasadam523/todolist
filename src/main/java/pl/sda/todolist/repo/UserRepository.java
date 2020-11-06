package pl.sda.todolist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.todolist.dto.UserRegistrationDto;
import pl.sda.todolist.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
