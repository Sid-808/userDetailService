package com.springSecurity.userDetails.controller;

import com.springSecurity.userDetails.entity.User;
import com.springSecurity.userDetails.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    //Register
    @GetMapping("/register")
    public String register(){
        return "registerUser";
    }

    //Form data to database
    @PostMapping("/saveUser")
    public String saveUserDetails(
            @ModelAttribute User user,
            Model model
            )
    {
        Integer id = userService.saveUser(user);
        String message = "User sabed with id: " + id;
        model.addAttribute("msg",message);
        return "registerUser";
    }


}
