package com.example.FranziManuTomVerena.ToDoList.Service;

import com.example.FranziManuTomVerena.ToDoList.Entity.TicketEntity;
import com.example.FranziManuTomVerena.ToDoList.Repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<TicketEntity> findAll() {
        return ticketRepository.findAll();
    }

    public Optional<List<TicketEntity>> getTicketsByUserId(String userId) {
        List<TicketEntity> tickets = ticketRepository.findByUserId(userId)
                .stream()
                .map(ticketEntity -> new TicketEntity())
                .toList();
        return Optional.ofNullable(tickets);

        //Optional.ofNullable wrapped eine Liste in ein Optional,
        //so kann die Liste null sein ohne Exception
        //.get() kann auf eine Optional Liste nicht angewendet
        //werden, weil .get() ein Argument erwartet, weil
        //.get() eine Methode der Liste selbst ist
    }
}
