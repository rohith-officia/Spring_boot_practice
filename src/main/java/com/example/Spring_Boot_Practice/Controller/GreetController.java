package com.example.Spring_Boot_Practice.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class GreetController {

    @GetMapping("/greet") //http://localhost:8080/greet
    public String greet(){
        return "Hi !";
    }

    @GetMapping("/greet2") //http://localhost:8080/greet2?name=zara
    public String greet2(@RequestParam String name){
        return "Hi " + name + "!";
    }

    @GetMapping("greet3/{name}") //http://localhost:8080/greet3/zara
    public String greet3(@PathVariable String name){
        return "Hi " + name + "!";
    }
}
