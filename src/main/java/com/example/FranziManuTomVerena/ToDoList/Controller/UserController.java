package com.example.FranziManuTomVerena.ToDoList.Controller;


import com.example.FranziManuTomVerena.ToDoList.Entity.UserDTO;
import com.example.FranziManuTomVerena.ToDoList.Entity.UserEntity;
import com.example.FranziManuTomVerena.ToDoList.Repository.UserRepository;
import com.example.FranziManuTomVerena.ToDoList.Service.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/byUsername")
    public UserDTO getUserByUsername(String username) {
        return userService.getByUsername(username);
    }

    @PostMapping
    public void createUser() {

    }



}
