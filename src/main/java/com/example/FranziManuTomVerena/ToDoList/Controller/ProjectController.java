package com.example.FranziManuTomVerena.ToDoList.Controller;


import com.example.FranziManuTomVerena.ToDoList.Entity.ProjectEntity;
import com.example.FranziManuTomVerena.ToDoList.Repository.ProjectRepository;
import com.example.FranziManuTomVerena.ToDoList.Repository.UserRepository;
import com.example.FranziManuTomVerena.ToDoList.Service.ProjectService;
import com.example.FranziManuTomVerena.ToDoList.Service.UserService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Project")
public class ProjectController {

    private ProjectRepository projectRepository;
    private ProjectService projectService;
    private UserRepository userRepository;
    private UserService userService;

    public ProjectController(ProjectRepository projectRepository, ProjectService projectService, UserRepository userRepository, UserService userService) {
        this.projectRepository = projectRepository;
        this.projectService = projectService;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/newProject")
    public ProjectEntity newProject(Model model) {

        return new ProjectEntity();
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveNewProject(@RequestBody ProjectEntity projectEntity) {
        ProjectEntity savedNewProject = ProjectEntity.builder()
                .projectName(projectEntity.getProjectName())
                .projectDescription(projectEntity.getProjectDescription())
                .projectCategory(projectEntity.getProjectCategory())
                //.projectType(projectEntity.getProjectType())
                .projectStartDate(projectEntity.getProjectStartDate())
                .projectEndDate(projectEntity.getProjectEndDate())
                //.projectTime(projectEntity.getProjectTime())
                .build();

        projectRepository.save(savedNewProject);

        projectEntity.setProjectName(projectEntity.getProjectName());
        return ResponseEntity.ok("Project saved successfully");
    }

    @GetMapping("/show")
    public List<ProjectEntity> showAllProjects() {


        return projectRepository.findAll();
    }

}

