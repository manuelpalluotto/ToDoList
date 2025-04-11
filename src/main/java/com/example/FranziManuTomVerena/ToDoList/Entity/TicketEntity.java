package com.example.FranziManuTomVerena.ToDoList.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Table(name = "tickets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "char(36)")
    private String id;

    private String title;

    private LocalDateTime expiryDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
