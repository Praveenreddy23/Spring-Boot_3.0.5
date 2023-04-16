package com.devtool;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ToolController {
    @GetMapping(path="/tool")
    @ResponseBody
    public String tool(){
        String fName = "Da";
        String lName = "Dinga";


        System.out.println("DEV-Tools");

        return"<h1>Developer tool  Add firstName and lastName is: "+(fName+lName)+"<h1>";
    }
}
