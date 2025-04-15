package com.example.FranziManuTomVerena.ToDoList.Authorization;

import com.example.FranziManuTomVerena.ToDoList.Entity.UserEntity;
import com.example.FranziManuTomVerena.ToDoList.Repository.UserRepository;
import com.example.FranziManuTomVerena.ToDoList.Service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody UserEntity user) {
        userService.saveUser(user);
        return ResponseEntity.ok("User erfolgreich registriert");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
