package com.example.FranziManuTomVerena.ToDoList.Controller;
import com.example.FranziManuTomVerena.ToDoList.Entity.Calender;
import com.example.FranziManuTomVerena.ToDoList.Service.CalenderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calender")
public class CalenderController {

    private final CalenderService calenderService;

    public CalenderController(CalenderService calenderService){
        this.calenderService = calenderService;
    }

    @GetMapping
    public List<Calender> findAll(){
        return calenderService.findAll();
    }
}
