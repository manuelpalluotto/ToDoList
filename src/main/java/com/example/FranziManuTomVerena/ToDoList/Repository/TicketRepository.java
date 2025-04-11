package com.example.FranziManuTomVerena.ToDoList.Repository;

import com.example.FranziManuTomVerena.ToDoList.Entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, UUID> {

    List<TicketEntity> findByUserId(String userId);

}
