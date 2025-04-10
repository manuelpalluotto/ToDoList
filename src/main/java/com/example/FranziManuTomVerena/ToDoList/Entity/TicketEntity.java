package com.example.FranziManuTomVerena.ToDoList.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "char(36)")

    private Long id;

    private String title;

    private LocalDate startDate;

    private LocalDate endDate;
}
