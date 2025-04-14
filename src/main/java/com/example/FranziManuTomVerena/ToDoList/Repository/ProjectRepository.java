package com.example.FranziManuTomVerena.ToDoList.Repository;

import com.example.FranziManuTomVerena.ToDoList.Entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
}
