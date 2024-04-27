package com.example.caraucbackend.services;


import com.example.caraucbackend.DTOs.GeneralResponse;
import com.example.caraucbackend.DTOs.ResponseBody;
import com.example.caraucbackend.repos.UserRepo;
import com.example.caraucbackend.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class UserServices {

    private final UserRepo userRepo;

    public GeneralResponse login(User user){
        return new GeneralResponse(
                HttpStatus.ACCEPTED,
                "car found",
                LocalDate.now(),
                LocalTime.now(),
                new ResponseBody<>( userRepo.findUserByUsernameIsAndPasswordIs(user.getUsername(), user.getPassword()))
        );
    }


    public boolean userExists(String username){

        return userRepo.findUserByUsernameIs(username) != null;
    }


    public User getUserByUserName(String username){
        return userRepo.findUserByUsernameIs(username);
    }


    public User updateUser(User user){
        return userRepo.save(user);
    }

    public User addNewUser(User user) {
        return userRepo.save(user);
    }
}
