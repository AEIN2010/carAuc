package com.example.caraucbackend.controllers;

import com.example.caraucbackend.DTOs.GeneralResponse;
import com.example.caraucbackend.entities.User;
import com.example.caraucbackend.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
public class UserController {



    @Autowired
    private UserServices userServices;



    @GetMapping("/login/{username}/{password}")
    @ResponseBody
    private GeneralResponse userLoginTo(@PathVariable String username, @PathVariable String password){
        return userServices.login(username, password);
    }


    @PostMapping("/add")
    @ResponseBody
    private GeneralResponse addNewUser(@RequestBody User user){
        return userServices.addNewUser(user);
    }


}
