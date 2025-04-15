package com.example.FranziManuTomVerena.ToDoList.Service;


import com.example.FranziManuTomVerena.ToDoList.Entity.UserEntity;
import com.example.FranziManuTomVerena.ToDoList.Repository.UserRepository;
import io.github.cdimascio.dotenv.Dotenv;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@SpringBootTest
@Transactional
public class UserServiceTest {

    @BeforeAll
    static void loadEnv() {
        Dotenv dotenv = Dotenv.load();
        System.setProperty("DATABASE_URL", Objects.requireNonNull(dotenv.get("DATABASE_URL")));
        System.setProperty("DATABASE_USERNAME", Objects.requireNonNull(dotenv.get("DATABASE_USERNAME")));
        System.setProperty("DATABASE_PASSWORD", Objects.requireNonNull(dotenv.get("DATABASE_PASSWORD")));
    }

    @Autowired
    private UserRepository userRepository;

    @Test
    public void getAllUsersTestSuccess() {
        List<UserEntity> allUsers = userRepository.findAll();
        assertThat(allUsers).isEmpty();

        UserEntity user = new UserEntity();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setEmail("admin@admin.com");
        user.setFirstName("admin");
        user.setLastName("admin");
        userRepository.save(user);

        allUsers = userRepository.findAll();
        assertThat(allUsers.size()).isEqualTo(1);

        UserEntity user2 = new UserEntity();
        user2.setUsername("admin2");
        user2.setPassword("admin2");
        user2.setEmail("admin2@admin.com");
        user2.setFirstName("admin2");
        user2.setLastName("admin2");
        userRepository.save(user2);

        allUsers = userRepository.findAll();
        assertThat(allUsers.size()).isEqualTo(2);
    }

    @Test
    public void getByUsernameTestSuccess() {
        List<UserEntity> allUsers = userRepository.findAll();
        assertThat(allUsers).isEmpty();
        UserEntity user = new UserEntity();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setEmail("admin@admin.com");
        user.setFirstName("admin");
        user.setLastName("admin");
        userRepository.save(user);
        List<UserEntity> newAllUsers = new ArrayList<>();
        newAllUsers = userRepository.findAll();
        assertThat(newAllUsers.size()).isEqualTo(1);
        UserEntity newUser = newAllUsers.get(0);
        assertThat(newUser.getUsername()).isEqualTo(user.getUsername());

    }

    @Test
    public void saveUserTestSuccess() {
        List<UserEntity> allUsers = userRepository.findAll();
        assertThat(allUsers).isEmpty();
        UserEntity user = new UserEntity();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setEmail("admin@admin.com");
        user.setFirstName("admin");
        user.setLastName("admin");
        userRepository.save(user);
        allUsers = userRepository.findAll();
        assertThat(allUsers.size()).isEqualTo(1);
    }
}
