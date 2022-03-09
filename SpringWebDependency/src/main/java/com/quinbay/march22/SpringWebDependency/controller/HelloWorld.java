package com.quinbay.march22.SpringWebDependency.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class HelloWorld {
    @GetMapping("/greet")
    public String greet(){
        return "Hello";
    }
}

