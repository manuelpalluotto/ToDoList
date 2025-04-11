package com.example.FranziManuTomVerena.ToDoList.Controller;

import com.example.FranziManuTomVerena.ToDoList.Entity.TicketEntity;
import com.example.FranziManuTomVerena.ToDoList.Service.TicketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/all")
    public List<TicketEntity> getAllTickets() {
        return ticketService.findAll();
    }

    @GetMapping("/byUserId")
    public Optional<List<TicketEntity>> getByUserId(@RequestBody String userId) {
        return ticketService.getTicketsByUserId(userId);
    }
}
