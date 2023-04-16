package com.springbootbasic.controller;

import com.springbootbasic.entity.User;
import org.springframework.web.bind.annotation.*;

/*@Controller
@ResponseBody*/
@RestController
public class BasicController {

    @RequestMapping("/")
    public String basic(){
        return"Basic";
    }

//    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @GetMapping("user")
    public User saveUser(){
        User user = new User();
        user.setId("1");
        user.setName("reddy");
        user.setEmail("reddy@gmail.com");

        return user;
    }

    @GetMapping("/{id}/{id1}")
    public  String pathVariable(@PathVariable String id,@PathVariable("id1") String name){

        return"The PathVariable is:"+id +"name is:"+name;
    }

    @GetMapping("/requestParam")//http://localhost:8009/requestParam?name=praveen&emailId=reddy@gmail.com
                                   //http://localhost:8009/requestParam?name=praveen
    public  String requestParam(@RequestParam String name,
                                @RequestParam(name = "email",required = false, defaultValue = "") String emailId){
        return "Name is:"+name+ "And EmailId is:"+emailId;
    }
}
