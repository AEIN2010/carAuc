package com.example.caraucbackend.controllers;

import com.example.caraucbackend.DTOs.GeneralResponse;
import com.example.caraucbackend.entities.User;
import com.example.caraucbackend.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {



    @Autowired
    private UserServices userServices;


    @GetMapping("/login")
    @ResponseBody
    private GeneralResponse userLoginToPage(@RequestBody User user){
        return userServices.login(user);
    }


    @PostMapping("/add")
    @ResponseBody
    private User addNewUser(@RequestBody User user){
        return userServices.addNewUser(user);
    }


}
