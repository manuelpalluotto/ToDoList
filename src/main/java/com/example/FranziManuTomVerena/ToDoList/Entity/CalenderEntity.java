package com.example.FranziManuTomVerena.ToDoList.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "calender")
public class CalenderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "char(36)")
    private String id;

    @OneToMany(mappedBy = "calender")
    private List<TicketEntity> tickets;

    private LocalDateTime start;

    private LocalDateTime finish;
}
