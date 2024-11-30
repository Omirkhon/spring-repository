package com.example.catsgram.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    @GetMapping("/hello")
    public String helloPage() {
        return "Hello world";
    }
}
