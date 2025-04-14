package com.example.FranziManuTomVerena.ToDoList.Service;

import com.example.FranziManuTomVerena.ToDoList.Entity.UserDTO;
import com.example.FranziManuTomVerena.ToDoList.Entity.UserEntity;
import com.example.FranziManuTomVerena.ToDoList.Repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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

    public ResponseEntity saveUser(@RequestBody UserEntity user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());

        UserEntity savedUser = UserEntity.builder()
                .username(user.getUsername())
                .password(encodedPassword)
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .isVerified(false)
                .build();

        userRepository.save(savedUser);

        return ResponseEntity.ok().build();
    }

}
