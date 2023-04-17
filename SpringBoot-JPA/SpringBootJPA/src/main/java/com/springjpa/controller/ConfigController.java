package com.springjpa.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Value("${welcome.message}")// getting message from application.properties
    private String welcomeMessage;

    @GetMapping("/")
    public String message(){
        System.out.println("message");
        return welcomeMessage;
    }
}
