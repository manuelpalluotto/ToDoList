package com.example.FranziManuTomVerena.ToDoList.Controller;


import com.example.FranziManuTomVerena.ToDoList.Entity.UserDTO;
import com.example.FranziManuTomVerena.ToDoList.Entity.UserEntity;
import com.example.FranziManuTomVerena.ToDoList.Service.UserService;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Objects;

@SpringBootTest
public class UserControllerTest {
    @BeforeAll
    static void loadEnv() {
        Dotenv dotenv = Dotenv.load();
        System.setProperty("DATABASE_URL", Objects.requireNonNull(dotenv.get("DATABASE_URL")));
        System.setProperty("DATABASE_USERNAME", Objects.requireNonNull(dotenv.get("DATABASE_USERNAME")));
        System.setProperty("DATABASE_PASSWORD", Objects.requireNonNull(dotenv.get("DATABASE_PASSWORD")));
    }

    @Autowired
    UserService userService;

    @Test
    public void getAllUserTestSuccess() {
        List<UserDTO> users = userService.getAllUsers();
        assertThat(users).isEmpty();

        UserEntity user = new UserEntity();
        user.setFirstName("Test");
        user.setLastName("Test");
        user.setEmail("test@test.com");
        user.setPassword("password");

        userService.saveUser(user);
        users = userService.getAllUsers();
        assertThat(users).hasSize(1);

        UserEntity user2 = new UserEntity();
        user2.setFirstName("Test2");
        user2.setLastName("Test2");
        user2.setEmail("test2@test.com");
        user2.setPassword("password2");
        userService.saveUser(user2);
        assertThat(userService.getAllUsers()).hasSize(2);
    }

    @Test
    public void getUserByUsernameTestSuccess() {
        List<UserDTO> users = userService.getAllUsers();
        assertThat(users).isEmpty();

        UserEntity user = new UserEntity();
        user.setFirstName("Test");
        user.setLastName("Test");
        user.setEmail("test@test.com");
        user.setPassword("password");
        userService.saveUser(user);

    }

    @Test
    public void saveUserTestSuccess() {

    }
}
