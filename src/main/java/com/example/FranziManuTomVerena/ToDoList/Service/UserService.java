package com.example.FranziManuTomVerena.ToDoList.Service;

import com.example.FranziManuTomVerena.ToDoList.Entity.UserDTO;
import com.example.FranziManuTomVerena.ToDoList.Entity.UserEntity;
import com.example.FranziManuTomVerena.ToDoList.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream() //äquivalent zu js .map
                .map(entity -> (
                        new UserDTO(entity)
                ))
                .filter(entity -> entity.getId() != null)
                .toList();
    }

    public UserDTO getByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
