package com.example.Spring_Boot_Practice.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class GreetController {

    @GetMapping("/greet")
    public String greet(){
        return "Hi !";
    }

    @GetMapping("/greet2")
    public String greet2(@RequestParam String name){
        return "Hi " + name + "!";
    }

    @GetMapping("greet3/{name}")
    public String greet3(@PathVariable String name){
        return "Hi " + name + "!";
    }
}
