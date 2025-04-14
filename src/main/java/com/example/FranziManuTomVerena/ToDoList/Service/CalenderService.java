package com.example.FranziManuTomVerena.ToDoList.Service;

import com.example.FranziManuTomVerena.ToDoList.Entity.Calender;
import com.example.FranziManuTomVerena.ToDoList.Repository.CalenderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalenderService {
    private final CalenderRepository calenderRepository;

    public CalenderService(CalenderRepository calenderRepository) {
        this.calenderRepository = calenderRepository;
    }

    public List<Calender> findAll() {
        return calenderRepository.findAll();
    }
}
