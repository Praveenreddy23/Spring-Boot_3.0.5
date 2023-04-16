package com.example.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @GetMapping(path="/")
    public String index(){
        System.out.println("Home page");
        return "index";
    }
    @RequestMapping(path="/index")
    public String index1(){
        System.out.println("Index1");
        return "home";
    }
}
