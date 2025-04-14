package com.example.FranziManuTomVerena.ToDoList.Repository;

import com.example.FranziManuTomVerena.ToDoList.Entity.CalenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CalenderRepository extends JpaRepository<CalenderEntity, UUID> {
}
