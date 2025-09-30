package com.example.Spring_Boot_Practice.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    @GetMapping("/greet")
    public String greet(){
        return "Hi!";
    }

    @GetMapping("/greet2")
    public String greet2(@RequestParam String name){
        return "Hi" + name + "!";
    }
}
