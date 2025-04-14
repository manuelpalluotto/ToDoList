package com.example.FranziManuTomVerena.ToDoList.Repository;

import com.example.FranziManuTomVerena.ToDoList.Entity.UserDTO;
import com.example.FranziManuTomVerena.ToDoList.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserDTO> findByUsername(String username);
}
