package com.example.FranziManuTomVerena.ToDoList.Controller;

import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {
    @GetMapping("/login")
    public String loginPage(){return "login";}
}
