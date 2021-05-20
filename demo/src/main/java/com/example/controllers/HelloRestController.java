package com.example.controllers;

import com.example.entities.Greetings;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    @GetMapping("/rest")
    public Greetings greet(@RequestParam(required = false,
            defaultValue = "World") String name) {
        return new Greetings(String.format("Hello %s!", name)); // string format is cool
    }
}
