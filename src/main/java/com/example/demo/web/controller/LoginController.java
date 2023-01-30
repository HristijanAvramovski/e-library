package com.example.demo.web.controller;

import com.example.demo.model.User;
import com.example.demo.model.exceptions.InvalidUsernameOrPasswordException;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/login")
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String login(){
        return "login";
    }

    @PostMapping("/login1")
    public String login1(HttpServletRequest req, Model model){
        User user;
        try{
            user = this.userService.login(req.getParameter("username"),
                    req.getParameter("password"));
            req.getSession().setAttribute("user", user);
            return "redirect:/books/paginate/1";
        }
        catch (InvalidUsernameOrPasswordException exception) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return "login";
        }


    }
}
