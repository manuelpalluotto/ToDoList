package com.example.FranziManuTomVerena.ToDoList.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@Entity
@Table(name = "Projects")
@AllArgsConstructor
@NoArgsConstructor
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "char(36)")
    private String id;

    private String projectName;

    private String projectDescription;

    private String projectStatus;

    private String projectCategory;

    // private String projectType;

    private String projectStartDate;

    private String projectEndDate;

    // private String projectTime;

    @OneToMany(mappedBy = "id")
    private List<UserEntity> userEntity = new ArrayList<>();

     @OneToMany(mappedBy = "id")
    private List<TicketEntity> tickets = new ArrayList<>();     // Tickets noch nicht existent.

}
