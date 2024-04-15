package com.example.caraucbackend.controllers;

import com.example.caraucbackend.entities.User;
import com.example.caraucbackend.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {



    @Autowired
    private UserServices userServices;


    @GetMapping("/login")
    @ResponseBody
    private User userLoginToPage(@RequestBody User user){
        return userServices.login(user);
    }



}
