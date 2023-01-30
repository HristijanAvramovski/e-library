package com.example.demo.web.controller;

import com.example.demo.model.enumeration.Role;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
@CrossOrigin
public class RegisterController {
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public String registerPage(){
        return "register.html";
    }
    @PostMapping("/save")
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String repeatPassword,
                           @RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam Role role){
       userService.register(username, password, repeatPassword, name, surname, role);
        return "redirect:/login";
   }

}
