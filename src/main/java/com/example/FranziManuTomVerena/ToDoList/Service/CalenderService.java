package com.example.FranziManuTomVerena.ToDoList.Service;

import org.springframework.stereotype.Service;

@Service
public class CalenderService {
    private final TicketRepository ticketRepository;

    public CalenderService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }
    public Ticket addTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }
    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long id){
        return ticketRepository.findById(id);
    }
}
