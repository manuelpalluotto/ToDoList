//package com.example.FranziManuTomVerena.ToDoList.Controller;
//import com.example.FranziManuTomVerena.ToDoList.Service.CalenderService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/tickets")
//public class CalenderController {
//
//    private final CalenderService calenderService;
//
//    public CalenderController(CalenderService calenderService){
//        this.calenderService = calenderService;
//    }
//
//    @PostMapping
//    public Ticket createTicket(@RequestBody Ticket ticket){
//        return calenderService.addTicket(ticket);
//    }
//    @GetMapping
//    public List<Ticket> getAllTickets(){
//        return calenderService.getAllTickets();
//    }
//}
